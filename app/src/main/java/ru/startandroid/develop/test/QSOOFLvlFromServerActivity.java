package ru.startandroid.develop.test;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ru.startandroid.develop.test.models.QSelectOutOfFour;
import ru.startandroid.develop.test.service.RequestService;

public class QSOOFLvlFromServerActivity extends AppCompatActivity {
    private TextView idTextView;
    private TextView taskTextView;
    private TextView questiontypeTextView;
    private TextView lessonTextView;
    private String AnswerString;
    private Button variant1Button;
    private Button variant2Button;
    private Button variant3Button;
    private Button variant4Button;
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
        QSOOFLvlFromServerActivity that = this;
        Future<String> future = executorService.submit(() -> {
            QSelectOutOfFour qSelectOutOfFour2 = that.requestService.getQSelectOutOfFour(Integer.parseInt(id));
            taskTextView = new TextView(this);
            taskTextView.setText(qSelectOutOfFour2.getTask());
            taskTextView.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT)
            );
            variant1Button = new Button(this);

            variant1Button.setText(qSelectOutOfFour2.getVariant1());
            variant1Button.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT)
            );
            variant2Button = new Button(this);
            variant2Button.setText(qSelectOutOfFour2.getVariant2());
            variant2Button.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT)
            );
            variant3Button = new Button(this);
            variant3Button.setText(qSelectOutOfFour2.getVariant3());
            variant3Button.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT)
            );
            variant4Button = new Button(this);
            variant4Button.setText(qSelectOutOfFour2.getVariant4());
            variant4Button.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT)
            );


            linearLayout.addView(taskTextView);
            linearLayout.addView(variant1Button);
            linearLayout.addView(variant2Button);
            linearLayout.addView(variant3Button);
            linearLayout.addView(variant4Button);
            return qSelectOutOfFour2.getAnswerString();

        });
        try {
            future.get();
            AnswerString = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        variant1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AnswerString.equals("1")) {
                    Toast.makeText(getApplicationContext(),
                            "Правильно",
                            Toast.LENGTH_SHORT).show();
                    h.postDelayed(ChangeActivity3, 3000);
                } else {

                    Toast.makeText(getApplicationContext(),
                            "Неправильно",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });
        variant2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AnswerString.equals("2")) {
                    Toast.makeText(getApplicationContext(),
                            "Правильно",
                            Toast.LENGTH_SHORT).show();
                    h.postDelayed(ChangeActivity3, 3000);
                } else {

                    Toast.makeText(getApplicationContext(),
                            "Неправильно",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        variant3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AnswerString.equals("3")) {
                    Toast.makeText(getApplicationContext(),
                            "Правильно",
                            Toast.LENGTH_SHORT).show();
                    h.postDelayed(ChangeActivity3, 3000);
                } else {

                    Toast.makeText(getApplicationContext(),
                            "Неправильно",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        variant4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AnswerString.equals("4")) {
                    Toast.makeText(getApplicationContext(),
                            "Правильно",
                            Toast.LENGTH_SHORT).show();
                    h.postDelayed(ChangeActivity3, 3000);
                } else {

                    Toast.makeText(getApplicationContext(),
                            "Неправильно",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });
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
        Intent myIntent3 = new Intent(this, QSOOFActivity.class);
        startActivity(myIntent3);
        finish();
    }

    Runnable ChangeActivity3 = new Runnable() {
        public void run() {
            changeActivity3();
        }
    };


}

