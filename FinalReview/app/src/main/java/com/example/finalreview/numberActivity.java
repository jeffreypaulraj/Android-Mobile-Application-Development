package com.example.finalreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class numberActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendInfoBack = new Intent();
                sendInfoBack.putExtra(MainActivity.INTENT_CODE, "Pass Successful");
                setResult(RESULT_OK, sendInfoBack);
                finish();
            }
        });
    }
}
