package com.example.myactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button colorButton;
    Button notColorButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colorButton = findViewById(R.id.id_ColorButton);
        notColorButton = findViewById(R.id.id_NotColorButton);
        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //colorButton.setText("HI");
                ((Button)v).setText("HI");
            }
        });
    }

    public void colorChange(View view){
        int i = (int)(Math.random()*3);

        String color = "";
        if(i == 0){
            color = "Red";
            colorButton.setBackgroundColor(Color.RED);
        }
        else if(i == 1){
            color = "Blue";
            colorButton.setBackgroundColor(Color.BLUE);
        }
        else{
            color = "Green";
            colorButton.setBackgroundColor(Color.GREEN);
        }
        colorButton.setText(color);
    }

    public void swapText(View view){

        CharSequence text1 = colorButton.getText();
        CharSequence text2 = notColorButton.getText();

        colorButton.setText(text2);
        notColorButton.setText(text1);

    }
}
