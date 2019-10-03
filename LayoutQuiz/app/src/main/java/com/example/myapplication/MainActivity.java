package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonOne;
    Button buttonTwo;
    TextView textViewOne;
    TextView textViewTwo;
    boolean buttonOnePressed;
    boolean buttonTwoPressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonOne = findViewById(R.id.id_buttonOne);
        buttonTwo = findViewById(R.id.id_buttonTwo);
        textViewOne = findViewById(R.id.id_textViewOne);
        textViewTwo = findViewById(R.id.id_textViewTwo);
        buttonOnePressed= false;
        buttonTwoPressed = false;
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonOnePressed){
                    textViewOne.setText("Clicked");
                }
                else{
                    textViewOne.setText("Not Clicked");
                }
                buttonOnePressed = !buttonOnePressed;
            }
        });
        buttonTwo.setOnClickListener(this);
    }

    public void onClick(View v){
        if(buttonTwoPressed){
            textViewTwo.setText("Clicked");
        }
        else{
            textViewTwo.setText("Not Clicked");
        }
        buttonTwoPressed = !buttonTwoPressed;
    }
    }


