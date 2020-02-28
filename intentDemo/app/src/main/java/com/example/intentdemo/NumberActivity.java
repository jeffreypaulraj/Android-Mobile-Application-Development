package com.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NumberActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        Toast.makeText(this, getIntent().getStringExtra("TEST"),Toast.LENGTH_SHORT).show();

        button = findViewById(R.id.id_enterButton);
        editText = findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendInfoBack = new Intent();
                sendInfoBack.putExtra(MainActivity.INTENT_CODE, editText.getText().toString());
                setResult(RESULT_OK, sendInfoBack);
                finish();
            }
        });
    }
}
