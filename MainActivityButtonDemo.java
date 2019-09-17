package com.example.buttondemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityButtonDemo extends AppCompatActivity {
//This is a test
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.id_button);
    }

    public void onClickGo(View view){
        button.setText("Clicked");
    }
}
