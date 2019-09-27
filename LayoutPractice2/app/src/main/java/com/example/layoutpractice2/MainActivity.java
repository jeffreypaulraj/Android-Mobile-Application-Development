package com.example.layoutpractice2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//Practice Project One

 /*   Button ButtonOne;
    Button ButtonTwo;
    Button ButtonThree;
    Button ButtonFour;
    Button ButtonFive;
    TextView TextViewOne;
    TextView TextViewTwo;
    TextView TextViewThree;
    TextView TextViewFour;
    TextView TextViewFive;
    boolean clickOne;
    boolean clickTwo;
    boolean clickThree;
    boolean clickFour;
    boolean clickFive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practiceprojectone);



        ButtonOne = findViewById(R.id.id_button1);
        ButtonTwo = findViewById(R.id.id_button2);
        ButtonThree = findViewById(R.id.id_button3);
        ButtonFour = findViewById(R.id.id_button4);
        ButtonFive = findViewById(R.id.id_button5);

        TextViewOne = findViewById(R.id.id_textView1);
        TextViewTwo = findViewById(R.id.id_textView2);
        TextViewThree = findViewById(R.id.id_textView3);
        TextViewFour = findViewById(R.id.id_textView4);
        TextViewFive = findViewById(R.id.id_textView5);

        clickOne = true;
        clickTwo = true;
        clickThree = true;
        clickFour = true;
        clickFive = true;
        ButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickOne){
                    TextViewOne.setText("ON");
                }
                else{
                    TextViewOne.setText("OFF");
                }
                clickOne = !clickOne;
            }
        });

        ButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickTwo){
                    TextViewTwo.setText("ON");
                }
                else{
                    TextViewTwo.setText("OFF");
                }
                clickTwo = !clickTwo;
            }
        });

        ButtonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickThree){
                    TextViewThree.setText("ON");
                }
                else{
                    TextViewThree.setText("OFF");
                }
                clickThree = !clickThree;
            }
        });

        ButtonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickFour){
                    TextViewFour.setText("ON");
                }
                else{
                    TextViewFour.setText("OFF");
                }
                clickFour = !clickFour;
            }
        });
        ButtonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickFive){
                    TextViewFive.setText("ON");
                }
                else{
                    TextViewFive.setText("OFF");
                }
                clickFive = !clickFive;
            }
        });
    }

}
*/
    Button Red;
    Button Blue;
    Button Green;
    Button Cyan;
    Button Gray;
    Button Magenta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practiceprojectone);
        Red = findViewById(R.id.id_red);
        Blue = findViewById(R.id.id_blue);
        Green = findViewById(R.id.id_green);
        Cyan = findViewById(R.id.id_cyan);
        Gray = findViewById(R.id.id_gray);
        Magenta = findViewById(R.id.id_magenta);

        Red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cyan.setBackgroundColor(Color.RED);
                Gray.setBackgroundColor(Color.RED);
                Magenta.setBackgroundColor(Color.RED);
            }
        });
        Blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cyan.setBackgroundColor(Color.BLUE);
                Gray.setBackgroundColor(Color.BLUE);
                Magenta.setBackgroundColor(Color.BLUE);
            }
        });
        Green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cyan.setBackgroundColor(Color.GREEN);
                Gray.setBackgroundColor(Color.GREEN);
                Magenta.setBackgroundColor(Color.GREEN);
            }
        });
    }
}