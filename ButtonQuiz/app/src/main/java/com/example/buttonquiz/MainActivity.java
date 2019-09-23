package com.example.buttonquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;

public class MainActivity extends AppCompatActivity {

    Button RedButton;
    Button BlueButton;
    Button ChangeSizeButton;
    int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RedButton = findViewById(R.id.id_RED);
        BlueButton = findViewById(R.id.id_BLUE);
        ChangeSizeButton = findViewById(R.id.id_ChangeSize);
        size = 15;
        RedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedButton.setTextColor(Color.RED);
            }
        });
        BlueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlueButton.setTextColor(Color.BLUE);
                RedButton.setText(BlueButton.getText());
            }
        });
        ChangeSizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size++;
                ChangeSizeButton.setTextSize(COMPLEX_UNIT_DIP, size);
            }
        });

    }


}
