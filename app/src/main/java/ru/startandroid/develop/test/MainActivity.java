package ru.startandroid.develop.test;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_level);
        LvLactivity lvLactivity2 =new LvLactivity();
        Button level1 = findViewById(R.id.level1);
        level1.setOnClickListener(
                (v) -> {
                    this.changeActivity();
                }
        );
        Button level2 = findViewById(R.id.level2);
        level2.setOnClickListener(

                (v) -> {
                this.changeActivity2();
    }
        );
        Button levelfromserver=findViewById(R.id.levelfromserver);
        levelfromserver.setOnClickListener(
                v -> {
                    this.changeActivityToLvLServer();
                }
        );
        Button level3 = findViewById(R.id.level3);
        level3.setOnClickListener(

                (v) -> {
                    this.changeActivity3();
                }
        );
        Button level4 = findViewById(R.id.level4);
        level4.setOnClickListener(

                (v) -> {
                    this.changeActivity4();
                }
        );
        Button level5 = findViewById(R.id.level5);
        level5.setOnClickListener(

                (v) -> {
                    this.changeActivity5();
                }
        );
        Button level6 = findViewById(R.id.level6);
        level6.setOnClickListener(

                (v) -> {
                    this.changeActivity6();
                }
        );
        Button UsersLvL = findViewById(R.id.userslvl);
        UsersLvL.setOnClickListener(

                (v) -> {
                    this.changeActivityToUsersLvL();
                }
        );


    }

    public void changeActivity() {
        Intent myIntent = new Intent(this, LvLactivity.class);
        startActivity(myIntent);
    }
    public void changeActivity2() {
        Intent myIntent2 = new Intent(this, LvLactivity2.class);
        startActivity(myIntent2);
    }
    public void changeActivityToLvLServer() {
        Intent myIntentForLVLFromServer = new Intent(this, TestLvLFromServerActivity.class);
        startActivity(myIntentForLVLFromServer);
    }
    public void changeActivity3() {
        Intent myIntent3 = new Intent(this, LvLactivity3.class);
        startActivity(myIntent3);
    }
    public void changeActivity4() {
        Intent myIntent4 = new Intent(this, LvLactivity4.class);
        startActivity(myIntent4);
    }
    public void changeActivity5() {
        Intent myIntent5 = new Intent(this, LvLactivity5.class);
        startActivity(myIntent5);
    }
    public void changeActivity6() {
        Intent myIntent6 = new Intent(this, LvLactivity6.class);
        startActivity(myIntent6);
    }
    public void changeActivityToUsersLvL() {
        Intent myIntentUsersLvL = new Intent(this, UsersLvLActivity.class);
        startActivity(myIntentUsersLvL);
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



