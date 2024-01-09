package ru.startandroid.develop.test;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import ru.startandroid.develop.test.models.Level;


public class LvLactivity2 extends Activity {
    private TextView idTextView;
    private TextView taskTextView;
    private TextView questiontypeTextView;
    private TextView lessonTextView;
    private Button variant1Button;
    private Button variant2Button;
    private Button variant3Button;
    private Button variant4Button;
    private Handler h;
    private int levelNumber = 2;
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
        final Level level;
        try {
            level = getTestLevelFromResources(getLevelNumber());

        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Test level load from resources error");
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_activity);
        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        taskTextView = new TextView(this);
        taskTextView.setText(level.task);
        taskTextView.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)
        );
        variant1Button = new Button(this);

        variant1Button.setText(level.variant1);
        variant1Button.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)
        );
        variant2Button = new Button(this);
        variant2Button.setText(level.variant2);
        variant2Button.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)
        );
        variant3Button = new Button(this);
        variant3Button.setText(level.variant3);
        variant3Button.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)
        );
        variant4Button = new Button(this);
        variant4Button.setText(level.variant4);
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

        variant1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level.answerString.equals("1")) {
                    Toast.makeText(getApplicationContext(),
                            "Правильно",
                            Toast.LENGTH_SHORT).show();
                    h.postDelayed(ChangeActivityToLVLServer,3000);
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
                if (level.answerString.equals("2")) {
                    Toast.makeText(getApplicationContext(),
                            "Правильно",
                            Toast.LENGTH_SHORT).show();
                    h.postDelayed(ChangeActivityToLVLServer,3000);
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
                if (level.answerString.equals("3")) {
                    Toast.makeText(getApplicationContext(),
                            "Правильно",
                            Toast.LENGTH_SHORT).show();
                    h.postDelayed(ChangeActivityToLVLServer,3000);
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
                if (level.answerString.equals("4")) {
                    Toast.makeText(getApplicationContext(),
                            "Правильно",
                            Toast.LENGTH_SHORT).show();
                    h.postDelayed(ChangeActivityToLVLServer,3000);
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
    public void changeActivityToLvLServer() {
        Intent myIntentForLVLFromServer = new Intent(this, TestLvLFromServerActivity.class);
        startActivity(myIntentForLVLFromServer);
        finish();
    }
    Runnable ChangeActivityToLVLServer = new Runnable() {
        public void run() {
            changeActivityToLvLServer();
        }
    };





    private Level getTestLevelFromResources(int levelNumber) throws IOException {
        levelNumber=getLevelNumber();
        if (levelNumber == 1) {
            return jsonConverter.readValue(
                    getResources().openRawResource(R.raw.test),
                    Level.class
            );
        } else if (levelNumber == 2) {
            return jsonConverter.readValue(
                    getResources().openRawResource(R.raw.test2),
                    Level.class
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



