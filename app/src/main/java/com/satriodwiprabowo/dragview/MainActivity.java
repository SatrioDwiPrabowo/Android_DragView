package com.satriodwiprabowo.dragview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends  AppCompatActivity implements View.OnTouchListener {
    float dX;
    float dY;
    int akukudupiye;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            final View dragView = findViewById(R.id.draggable_view);
            dragView.setOnTouchListener(this);
        }

        @Override
        public boolean onTouch(View view, MotionEvent event) {
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    dX = view.getX() - event.getRawX();
                    dY = view.getY() - event.getRawY();
                    akukudupiye = MotionEvent.ACTION_DOWN;
                    break;

                case MotionEvent.ACTION_MOVE:
                    view.setY(event.getRawY() + dY);
                    view.setX(event.getRawX() + dX);
                    akukudupiye = MotionEvent.ACTION_MOVE;
                    break;

                case MotionEvent.ACTION_UP:
                    if (akukudupiye == MotionEvent.ACTION_DOWN)
                        Toast.makeText(MainActivity.this, "Clicked!", Toast.LENGTH_SHORT).show();
                    break;

                default:
                    return false;
            }
            return true;
        }
}
