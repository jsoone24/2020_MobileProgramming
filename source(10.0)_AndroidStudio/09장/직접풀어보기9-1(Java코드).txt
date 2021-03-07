package com.cookandroid.self9_1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);

            paint.setStrokeWidth(30);
            canvas.drawLine(30, 30, 300, 30, paint);

            paint.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawLine(30, 80, 300, 80, paint);

            RectF rectF = new RectF();

            rectF.set(60, 120, 60 + 200, 100 + 100);
            canvas.drawOval(rectF, paint);

            rectF.set(60, 170, 60 + 100, 170 + 100);
            canvas.drawArc(rectF, 40, 110, true, paint);

            paint.setColor(Color.BLUE);
            rectF.set(60, 280, 60 + 100, 280 + 100);
            canvas.drawRect(rectF, paint);

            paint.setColor(Color.argb(0x88, 0xff, 0x00, 0x00));
            rectF.set(90, 310, 90 + 100, 310 + 100);
            canvas.drawRect(rectF, paint);

        }
    }

}
