package com.example.jsondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView =findViewById(R.id.id_textView);

        JSONObject schoolInfo = new JSONObject();
        try {
            schoolInfo.put("name", "Jeffrey Paulraj");
            schoolInfo.put("grade", "Junior");
            schoolInfo.put("ID", "10017106");
        }catch(JSONException e){
            textView.setText("Error");
        }

        textView.setText(schoolInfo.toString());
    }
}
