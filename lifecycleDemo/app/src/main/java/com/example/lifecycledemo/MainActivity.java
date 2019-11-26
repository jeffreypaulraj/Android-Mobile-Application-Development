package com.example.lifecycledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    int counter =0;
    public static final String KEY = "abc123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("TAG", "Create");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                textView.setText("" + counter);
            }
        });

        if(savedInstanceState!= null) {
            counter = savedInstanceState.getInt(KEY);
            textView.setText("" + counter);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "Stop");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "Resume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "Pause");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
        outState.putInt(KEY,counter);
    }
}
