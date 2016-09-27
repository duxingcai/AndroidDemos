package com.example.duduxing.item30;
//简单图形绘制,编程绘制简单图形。

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class DrawingGraphicsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GraphicsView(this));
    }

    class GraphicsView extends View {
        private Paint paint;

        public GraphicsView(Context context) {
            super(context);
            paint = new Paint();
        }

        @SuppressLint("DrawAllocation")
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawColor(Color.WHITE);

            paint.setColor(Color.RED);
            paint.setStrokeWidth(10);
            canvas.drawLine(150, 50, 300, 300, paint);

            paint.setColor(Color.GREEN);
            canvas.drawRect(150, 400, 600, 800, paint);

            paint.setColor(Color.BLUE);
            canvas.drawCircle(350, 1100, 200, paint);
        }
    }
}
