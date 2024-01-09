package ru.startandroid.develop.test;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;



public class UsersLvLActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userslvl);
        //LvLactivity UsersLvLActivity =new LvLactivity();
        Button level_qsoof = findViewById(R.id.level_qsoof);
        level_qsoof.setOnClickListener(
                (v) -> {
                    this.changeActivity();
                }
        );
        Button level_qsootp = findViewById(R.id.level_qsootp);
        level_qsootp.setOnClickListener(

                (v) -> {
                    this.changeActivity2();
                }
        );
        Button level_qwra = findViewById(R.id.level_qwra);
        level_qwra.setOnClickListener(

                (v) -> {
                    this.changeActivity3();
                }
        );


    }

    public void changeActivity() {
        Intent myIntent = new Intent(this, QSOOFActivity.class);
        startActivity(myIntent);
    }
    public void changeActivity2() {
        Intent myIntent2 = new Intent(this, QSOOTPActivity.class);
        startActivity(myIntent2);
    }

    public void changeActivity3() {
        Intent myIntent3 = new Intent(this, QWRAActivity.class);
        startActivity(myIntent3);
    }


}
