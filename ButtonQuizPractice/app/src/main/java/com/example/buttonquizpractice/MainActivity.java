package com.example.buttonquizpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.TooltipCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button color;
    Button swap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        color  = findViewById(R.id.id_color);
        swap = findViewById(R.id.id_swap);
        swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               CharSequence temp = color.getText();
               color.setText(swap.getText());
               swap.setText(temp);
            }
        });
     //   TooltipCompat.setTooltipText(color, "Color");
    }

    public void colorSwitch(View view) {
        String colorString = "";
        int colorInt = (int)(Math.random()*6);

        switch(colorInt){

            case 0:
                colorString = "Red";
                color.setBackgroundColor(Color.RED);
                break;
            case 1:
                colorString = "Sky Blue";
                color.setBackgroundColor(Color.CYAN);
                break;
            case 2:
                colorString = "Yellow";
                color.setBackgroundColor(Color.YELLOW);
                break;
            case 3:
                colorString = "Green";
                color.setBackgroundColor(Color.GREEN);
                break;
            case 4:
                colorString = "Blue";
                color.setBackgroundColor(Color.BLUE);
                break;
            case 5:
                colorString = "Purple";
                color.setBackgroundColor(Color.MAGENTA);
            default:
                colorString = "White";
                color.setBackgroundColor(Color.WHITE);
                break;

        }
        color.setText(colorString);
    }

}
