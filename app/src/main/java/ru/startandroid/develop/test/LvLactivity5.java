package ru.startandroid.develop.test;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import ru.startandroid.develop.test.models.LevelMany;


public class LvLactivity5 extends Activity {
    private TextView idTextView;
    private TextView taskTextView;
    private TextView questiontypeTextView;
    private TextView lessonTextView;
    private TextView variant1;
    private TextView variant2;
    private TextView variant3;
    private TextView variant4;
    private TextView variant5;
    private TextView variant6;
    private Button   answerButton;
    private Handler h;
    private int levelNumber = 5;
    private LinearLayout linearLayout;
    private ObjectMapper jsonConverter = new ObjectMapper();

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    protected void onCreate(Bundle savedInstanceState) {
        h=new Handler();
        final LevelMany levelmany;
        try {
            levelmany = getTestLevelFromResources(getLevelNumber());

        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Test level load from resources error");
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_activity);
        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        taskTextView = new TextView(this);
        taskTextView.setText(levelmany.task);
        taskTextView.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)
        );
        variant1 = new TextView(this);
        variant1.setText(levelmany.variant1);
        variant1.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)
        );
        variant2 = new TextView(this);
        variant2.setText(levelmany.variant2);
        variant2.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)
        );
        variant3 = new TextView(this);
        variant3.setText(levelmany.variant3);
        variant3.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)
        );
        variant4 = new TextView(this);
        variant4.setText(levelmany.variant4);
        variant4.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)
        );
        variant5 = new TextView(this);
        variant5.setText(levelmany.variant5);
        variant5.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)
        );
        variant6 = new TextView(this);
        variant6.setText(levelmany.variant6);
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
                if (levelmany.answerString.equals(editText.getText().toString())) {
                    Toast.makeText(getApplicationContext(),
                            "Правильно",
                            Toast.LENGTH_SHORT).show();
                    h.postDelayed(ChangeActivity6,3000);
                } else {

                    Toast.makeText(getApplicationContext(),
                            "Неправильно",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });


        Button go_to_choose_level =findViewById(R.id.go_to_choose_level);
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
    public void changeActivity6() {
        Intent myIntent6 = new Intent(this, LvLactivity6.class);
        startActivity(myIntent6);
        finish();
    }
    Runnable ChangeActivity6 = new Runnable() {
        public void run() {
            changeActivity6();
        }
    };





    private LevelMany getTestLevelFromResources(int levelNumber) throws IOException {
        levelNumber=getLevelNumber();
        if (levelNumber == 5) {
            return jsonConverter.readValue(
                    getResources().openRawResource(R.raw.test5),
                    LevelMany.class
            );
        } else if (levelNumber == 6) {
            return jsonConverter.readValue(
                    getResources().openRawResource(R.raw.test6),
                    LevelMany.class
            );
        } else {
            throw new IllegalArgumentException("Нет такого уровня");
        }
    }



    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

}



