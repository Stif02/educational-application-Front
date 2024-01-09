package ru.startandroid.develop.test;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ru.startandroid.develop.test.models.QSelectOutOfFour;
import ru.startandroid.develop.test.models.QSelectOutOfThreePic;
import ru.startandroid.develop.test.service.RequestService;

public class QSOOTPLvlFromServerActivity extends AppCompatActivity {
    private TextView idTextView;
    private TextView taskTextView;
    private String AnswerString;
    private ImageButton variant1Button;
    private ImageButton variant2Button;
    private ImageButton variant3Button;
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
        QSOOTPLvlFromServerActivity that = this;
        Future<String> future = executorService.submit(() -> {
            QSelectOutOfThreePic qSelectOutOfThreePic = that.requestService.getQSelectOutOfThreePic(Integer.parseInt(id));
            taskTextView = new TextView(this);
            taskTextView.setText(qSelectOutOfThreePic.getTask());
            taskTextView.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT)
            );
            variant1Button = new ImageButton(this);
            Picasso.with(variant1Button.getContext()).load(qSelectOutOfThreePic.getVariant1()).into(variant1Button);
            variant1Button.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT)
            );

            variant2Button = new ImageButton(this);
            Glide.with(variant2Button.getContext()).load(qSelectOutOfThreePic.getVariant2()).into(variant2Button);
            variant2Button.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT)
            );
            //Picasso.with(this).load(qSelectOutOfThreePic.getVariant2()).into(variant2Button);
            variant3Button = new ImageButton(this);
            variant3Button.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT)
            );
            Picasso.with(this).load(qSelectOutOfThreePic.getVariant3()).into(variant3Button);
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
            return qSelectOutOfThreePic.getAnswerString();

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
        Intent myIntent3 = new Intent(this, QSOOTPActivity.class);
        startActivity(myIntent3);
        finish();
    }

    Runnable ChangeActivity3 = new Runnable() {
        public void run() {
            changeActivity3();
        }
    };


}