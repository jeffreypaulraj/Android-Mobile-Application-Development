package com.example.finaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    int selectId = 0;
    Button runButton;
    Button launchButton;
    View mainView;
    TextView nameText;
    String passText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.id_radioGroup);
        runButton = findViewById(R.id.id_runButton);
        launchButton = findViewById(R.id.id_launchButton);
        mainView = findViewById(R.id.id_mainView);
        nameText = findViewById(R.id.id_nameText);

        passText = "Nothing Selected";
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectId = checkedId;
                if(checkedId == R.id.id_toastButton){
                    passText = "Toast Button Selected";
                }
                else if(checkedId == R.id.id_changeColorButton){
                    passText = "Change Color Button Selected";
                }
                else if(checkedId == R.id.id_uppercaseButton){
                    passText = "Uppercase Button Selected";
                }
                else{
                    passText = "Nothing Selected";
                }
            }
        });

        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectId == R.id.id_toastButton){
                    Toast selectToast = Toast.makeText(MainActivity.this, "Toast Selected", Toast.LENGTH_SHORT);
                    selectToast.show();
                }
                else if(selectId == R.id.id_changeColorButton){
                    int rand = (int)(Math.random()*3);
                    if(rand == 0){
                        mainView.setBackgroundColor(Color.GREEN);
                    }
                    else if(rand == 1){
                        mainView.setBackgroundColor(Color.BLUE);
                    }
                    else{
                        mainView.setBackgroundColor(Color.RED);
                    }
                }
                else if (selectId == R.id.id_uppercaseButton){
                    nameText.setText(nameText.getText().toString().toUpperCase());
                }
            }
        });

        launchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
                newActivityIntent.putExtra("PASSVALUE",passText);
                startActivity(newActivityIntent);
            }
        });

    }
}
