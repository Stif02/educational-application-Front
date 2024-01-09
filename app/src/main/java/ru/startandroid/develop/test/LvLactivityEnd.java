package ru.startandroid.develop.test;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LvLactivityEnd extends Activity {
    private TextView EndTextView;
    private ImageButton variantEndButton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_activity);
        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        variantEndButton = new ImageButton(this);
        Uri uri3 = Uri.parse("android.resource://ru.startandroid.develop.test/drawable/end");
        variantEndButton.setImageURI(uri3);
        variantEndButton.setScaleType(ImageView.ScaleType.FIT_XY);
        variantEndButton.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)
        );
        linearLayout.addView(variantEndButton);
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


}
