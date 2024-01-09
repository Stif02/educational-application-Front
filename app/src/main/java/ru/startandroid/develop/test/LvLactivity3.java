package ru.startandroid.develop.test;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import ru.startandroid.develop.test.models.LevelPic;

public class LvLactivity3 extends Activity {
    private TextView idTextView;
    private TextView taskTextView;
    private TextView questiontypeTextView;
    private TextView lessonTextView;
    private ImageButton variant1Button;
    private ImageButton variant2Button;
    private ImageButton variant3Button;
    LinearLayout.LayoutParams lParams1;
    LinearLayout.LayoutParams lParams2;
    private Handler h;
    private int levelNumber = 3;
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
        final LevelPic levelpic;
        try {
            levelpic = getTestLevelFromResources(getLevelNumber());

        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Test level load from resources error");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_activity);
        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        taskTextView = new TextView(this);
        taskTextView.setText(levelpic.task);
        taskTextView.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)
        );


        variant1Button = new ImageButton(this) ;
      //  Uri uri = Uri.parse("android.resource://ru.startandroid.develop.test/drawable/sin");
        Uri uri = Uri.parse(levelpic.variant1);
        variant1Button.setImageURI(uri);
        variant1Button.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)
        );
        variant2Button = new ImageButton(this);
        Uri uri2 = Uri.parse(levelpic.variant2);
        variant2Button.setImageURI(uri2);
        variant2Button.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)
        );
        variant3Button = new ImageButton(this);
        Uri uri3 = Uri.parse(levelpic.variant3);
        variant3Button.setImageURI(uri3);
        variant3Button.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)
        );
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 250);
        variant1Button.setScaleType(ImageView.ScaleType.FIT_XY);
        variant2Button.setScaleType(ImageView.ScaleType.FIT_XY);
        variant3Button.setScaleType(ImageView.ScaleType.FIT_XY);

       variant1Button.setLayoutParams(layoutParams);
       variant2Button.setLayoutParams(layoutParams);
       variant3Button.setLayoutParams(layoutParams);
        linearLayout.addView(taskTextView);
        linearLayout.addView(variant1Button);
        linearLayout.addView(variant2Button);
        linearLayout.addView(variant3Button);
        variant1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (levelpic.answerString.equals("1")) {
                    Toast.makeText(getApplicationContext(),
                            "Правильно",
                            Toast.LENGTH_SHORT).show();
                    h.postDelayed(ChangeActivity4,3000);
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
                if (levelpic.answerString.equals("2")) {
                    Toast.makeText(getApplicationContext(),
                            "Правильно",
                            Toast.LENGTH_SHORT).show();
                    h.postDelayed(ChangeActivity4,3000);
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
                if (levelpic.answerString.equals("3")) {
                    Toast.makeText(getApplicationContext(),
                            "Правильно",
                            Toast.LENGTH_SHORT).show();
                    h.postDelayed(ChangeActivity4,3000);
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
    public void changeActivity4() {
        Intent myIntent4 = new Intent(this, LvLactivity4.class);
        startActivity(myIntent4);
        finish();
    }
    Runnable ChangeActivity4 = new Runnable() {
        public void run() {
            changeActivity4();
        }
    };





    private LevelPic getTestLevelFromResources(int levelNumber) throws IOException {
        levelNumber=getLevelNumber();
        if (levelNumber == 3) {
            return jsonConverter.readValue(
                    getResources().openRawResource(R.raw.test3),
                    LevelPic.class
            );
        } else if (levelNumber == 4) {
            return jsonConverter.readValue(
                    getResources().openRawResource(R.raw.test4),
                    LevelPic.class
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



