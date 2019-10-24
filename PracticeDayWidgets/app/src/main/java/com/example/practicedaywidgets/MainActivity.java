package com.example.practicedaywidgets;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Switch switchOne;
    Switch switchTwo;
    Switch switchThree;
    TextView colorText;
    EditText verifyEnter;
    Button verifyButton;
    TextView verifyText;
    EditText databaseEnter;
    Button databaseButton;
    TextView databaseText;
    TextView sizeText;
    SeekBar textSizeBar;

    boolean oneChecked;
    boolean twoChecked;
    boolean threeChecked;
    CharSequence emailTextVerify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchOne = findViewById(R.id.id_switch1);
        switchTwo = findViewById(R.id.id_switch2);
        switchThree = findViewById(R.id.id_switch3);
        colorText = findViewById(R.id.id_textView);
        verifyEnter = findViewById(R.id.id_verifyEnter);
        verifyButton = findViewById(R.id.id_verifyButton);
        verifyText = findViewById(R.id.id_verifyTextView);
        databaseEnter = findViewById(R.id.id_databaseEnter);
        databaseButton = findViewById(R.id.id_databaseButton);
        databaseText = findViewById(R.id.id_databaseTextView);
        sizeText = findViewById(R.id.id_textSizeChanger);
        textSizeBar = findViewById(R.id.id_seekBarSizeEditor);

        oneChecked = false;
        twoChecked = false;
        threeChecked = false;

        emailTextVerify = "";

        switchOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                oneChecked = isChecked;
                colorCheckChanger();
            }
        });

        switchTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                twoChecked = isChecked;
                colorCheckChanger();
            }
        });

        switchThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                threeChecked = isChecked;
                colorCheckChanger();
            }
        });

        verifyEnter.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                emailTextVerify = s;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        verifyButton.setOnClickListener(new View.OnClickListener() {
            CharSequence s = emailTextVerify;
            int atIndex = -1;
            boolean com = false;
            @Override
            public void onClick(View v) {

                System.out.println(s);

                for(int i = 0; i < s.length(); i ++){
                    if(s.charAt(i) == '@'){
                        atIndex = i;
                    }
                }
                if(s.length()>=4){
                    if(s.subSequence(s.length() - 4, s.length()).equals(".com")){
                        com = true;
                    }
                }
                if(com && atIndex >= 0){
                    verifyText.setText("Verified");
                }
                else{
                    verifyText.setText("NOt Verified");
                }
            }
        });
    }

    public void colorCheckChanger(){
        if(oneChecked && twoChecked && threeChecked){
            colorText.setTextColor(Color.BLUE);
        }
        else if(oneChecked && !twoChecked && threeChecked){
            colorText.setTextColor(Color.RED);
        }
        else if(!oneChecked && !twoChecked && threeChecked){
            colorText.setTextColor(Color.GREEN);
        }
    }
}
