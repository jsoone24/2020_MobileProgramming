package com.cookandroid.self6_2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart, btnStop;
        final ViewFlipper vFlipper;

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);

        vFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);

        vFlipper.setFlipInterval(1000);

        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vFlipper.startFlipping();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vFlipper.stopFlipping();
            }
        });
    }

}
