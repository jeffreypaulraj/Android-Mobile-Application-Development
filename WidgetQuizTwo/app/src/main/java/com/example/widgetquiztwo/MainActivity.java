package com.example.widgetquiztwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup buttonGroup;
    Button playButton;
    ImageView image;
    TextView totalText;
    TextView resultText;
    int sum;
    boolean checked;
    int cpuNum;
    int userNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGroup = findViewById(R.id.id_groupButtons);
        playButton = findViewById(R.id.id_playButton);
        image = findViewById(R.id.id_imageView);
        totalText = findViewById(R.id.id_totalText);
        resultText = findViewById(R.id.id_resultText);
        image.setImageResource(R.drawable.cpuselection);
        checked = false;
        cpuNum = 0;
        sum = 0;
        userNum = 0;

        buttonGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checked = true;
                image.setImageResource(R.drawable.cpuselection);
                totalText.setText("Total");
                resultText.setText("Result");
                if(checkedId == R.id.id_oneButton){
                    userNum = 1;
                }
                else{
                    userNum = 2;
                }
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checked == false){
                    Toast toast = Toast.makeText(MainActivity.this, "You Have Not Selected Anything!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    cpuNum = (int)(Math.random()*2)+1;
                    System.out.println(cpuNum);
                    if(cpuNum == 1){
                        image.setImageResource(R.drawable.oneimage);
                    }
                    else if(cpuNum == 2){
                        image.setImageResource(R.drawable.twoimage);
                    }
                    sum = cpuNum + userNum;
                    totalText.setText("Total is " + sum);
                    if(sum%2 == 0){
                        resultText.setText("You Won!");
                    }
                    else{
                        resultText.setText("The CPU Won!");
                    }
                }
            }
        });
    }
}
