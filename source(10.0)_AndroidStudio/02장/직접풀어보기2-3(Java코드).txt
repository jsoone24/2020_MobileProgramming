package com.cookandroid.fourbutton;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnNate, btn911, btnGal, btnEnd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNate = (Button) findViewById(R.id.btnNate);
        btn911 = (Button) findViewById(R.id.btn911);
        btnGal = (Button) findViewById(R.id.btnGal);
        btnEnd = (Button) findViewById(R.id.btnEnd);

        btnNate.setBackgroundColor(Color.GRAY);
        btn911.setBackgroundColor(Color.GREEN);
        btnGal.setBackgroundColor(Color.RED);
        btnEnd.setBackgroundColor(Color.YELLOW);

        btnNate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri
                        .parse("http://m.nate.com"));
                startActivity(mIntent);

            }
        });

        btn911.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri
                        .parse("tel:/911"));
                startActivity(mIntent);

            }
        });

        btnGal.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri
                        .parse("content://media/internal/images/media"));
                startActivity(mIntent);

            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                finish();

            }
        });
    }
}
