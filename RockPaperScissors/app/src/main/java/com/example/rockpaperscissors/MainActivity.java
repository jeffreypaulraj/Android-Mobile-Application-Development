package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup volumeGroup;
    RadioGroup RPSGroup;
    ImageView CPUMove;
    TextView scoreText;
    TextView resultText;
    Button playButton;
    int userSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userSelected = 0;

        volumeGroup = findViewById(R.id.volumeGroup);
        RPSGroup = findViewById(R.id.RPSGroup);
        CPUMove = findViewById(R.id.computerMoveImage);
        scoreText = findViewById(R.id.scoreText);
        resultText = findViewById(R.id.resultText);
        playButton = findViewById(R.id.playButton);

        volumeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.hundredButton){
                    Toast toast = Toast.makeText(MainActivity.this, "Warning! High Volumes Can Damage Your Hearing!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        RPSGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rockButton){
                    userSelected = 1;
                }
                else if(checkedId == R.id.paperButton){
                    userSelected = 2;
                }
                else if(checkedId == R.id.scissorButton){
                    userSelected = 3;
                }
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  if()
            }
        });



    }
}
