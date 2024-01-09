package ru.startandroid.develop.test;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ru.startandroid.develop.test.models.QSelectOutOfFour;
import ru.startandroid.develop.test.models.QWriteRightAnswer;
import ru.startandroid.develop.test.service.RequestService;

public class QWRALvlFromServerActivity extends AppCompatActivity {
    private TextView idTextView;
    private TextView taskTextView;
    private TextView questiontypeTextView;
    private TextView lessonTextView;
    private String AnswerString;
    private TextView variant1;
    private TextView variant2;
    private TextView variant3;
    private TextView variant4;
    private TextView variant5;
    private TextView variant6;
    private Button   answerButton;
    private Handler h;
    private LinearLayout linearLayout;
    private RequestService requestService = new RequestService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        h = new Handler();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_activity);
        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        String id =  getIntent().getStringExtra("id");
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        QWRALvlFromServerActivity that = this;
        Future<String> future = executorService.submit(() -> {
            QWriteRightAnswer qWriteRightAnswer = that.requestService.getQWriteRightAnswer(Integer.parseInt(id));
            taskTextView = new TextView(this);
            taskTextView.setText(qWriteRightAnswer.getTask());
            taskTextView.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT)
            );
            variant1 = new TextView(this);
            variant1.setText("1:"+qWriteRightAnswer.getVariant1());
            variant1.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT)
            );
            variant2 = new TextView(this);
            variant2.setText("2:"+qWriteRightAnswer.getVariant2());
            variant2.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT)
            );
            variant3 = new TextView(this);
            variant3.setText("3:"+qWriteRightAnswer.getVariant3());
            variant3.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT)
            );
            variant4 = new TextView(this);
            variant4.setText("4:"+qWriteRightAnswer.getVariant4());
            variant4.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT)
            );
            variant5 = new TextView(this);
            variant5.setText("5:"+qWriteRightAnswer.getVariant5());
            variant5.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT)
            );
            variant6 = new TextView(this);
            variant6.setText("6:"+qWriteRightAnswer.getVariant6());
            variant6.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT)
            );
            EditText editText = new EditText(this);
            variant6.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT)
            );
            editText.setHint("Введите ответ в порядке возрастания ");
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
            answerButton = new Button(this);
            answerButton.setText("Ответ");
            answerButton.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT)
            );

            linearLayout.addView(taskTextView);
            linearLayout.addView(variant1);
            linearLayout.addView(variant2);
            linearLayout.addView(variant3);
            linearLayout.addView(variant4);
            linearLayout.addView(variant5);
            linearLayout.addView(variant6);
            linearLayout.addView(editText);
            linearLayout.addView(answerButton);
            answerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (qWriteRightAnswer.getAnswerString().equals(editText.getText().toString())) {
                        Toast.makeText(getApplicationContext(),
                                "Правильно",
                                Toast.LENGTH_SHORT).show();
                        h.postDelayed(ChangeActivity3,3000);
                    } else {

                        Toast.makeText(getApplicationContext(),
                                "Неправильно",
                                Toast.LENGTH_SHORT).show();
                    }
                }

            });
            return qWriteRightAnswer.getAnswerString();

        });
        try {
            future.get();
            AnswerString = future.get();
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

    public void changeActivity3() {
        Intent myIntent3 = new Intent(this, QWRAActivity.class);
        startActivity(myIntent3);
        finish();
    }

    Runnable ChangeActivity3 = new Runnable() {
        public void run() {
            changeActivity3();
        }
    };


}
