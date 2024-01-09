package ru.startandroid.develop.test;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ru.startandroid.develop.test.models.QSelectOutOfThreePic;
import ru.startandroid.develop.test.models.QWriteRightAnswer;
import ru.startandroid.develop.test.service.RequestService;

public class QWRAActivity extends AppCompatActivity {
    private Handler h;
    private LinearLayout linearLayout;
    private RequestService requestService = new RequestService();
    ObjectMapper mapper = new ObjectMapper();
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button[] button = new Button[1000];
        Intent[] intent=new Intent[1000];
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_qsootp);
        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        QWRAActivity that = this;
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = (Future<String>) executorService.submit(() -> {
            List<QWriteRightAnswer> qWriteRightAnswerall = that.requestService.getAllQWRA();
            TextView testTextView = new TextView(this);
            testTextView.setText( qWriteRightAnswerall.get(0).getTask());
            linearLayout.addView(testTextView);
            for(int i=0;i<qWriteRightAnswerall.size();i++){
                button[i]=new Button(this);
                int l=i+1;
                button[i].setText("Вопрос "+l);
                button[i].setLayoutParams(
                        new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT)
                );
                linearLayout.addView(button[i]);
                int finalI =l;
                String finalI2=Integer.toString(finalI);
                button[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intent[finalI] = new Intent(QWRAActivity.this, QWRALvlFromServerActivity.class);
                        intent[finalI].putExtra("id", finalI2);
                        startActivity(intent[finalI]);
                        finish();
                    }
                });

            }
        });


        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        Button go_to_choose_level = findViewById(R.id.go_to_choose_level);
        go_to_choose_level.setOnClickListener(
                v -> {
                    this.changeActivity();
                }
        );
    }
    public void changeActivity() {
        Intent MainIntent = new Intent(this, MainActivity.class);
        startActivity(MainIntent);
        finish();
    }

}