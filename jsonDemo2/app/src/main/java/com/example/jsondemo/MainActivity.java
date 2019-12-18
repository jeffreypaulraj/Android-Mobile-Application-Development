package com.example.jsondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.id_textView);

        JSONObject schoolInfo = new JSONObject();
        try {
            schoolInfo.put("name", "Jeffrey Paulraj");
            schoolInfo.put("grade", "Junior");
            schoolInfo.put("ID", "10017106");
        } catch (JSONException e) {
            textView.setText("Error");
        }

        textView.setText(schoolInfo.toString());
        Log.d("TAG", schoolInfo.toString());

        JSONObject compSciClass = new JSONObject();
        try{
            compSciClass.put("grade","A");
            compSciClass.put("raw score", 98);
            compSciClass.put("course name", "Android Mobile Application Development");
            schoolInfo.put("Computer Science", compSciClass);
        }catch (JSONException e){

        }

        JSONObject physicsClass = new JSONObject();
        try{
            physicsClass.put("grade","A");
            physicsClass.put("raw score", 95);
            physicsClass.put("course name", "AP Physics C");
            schoolInfo.put("Physics", physicsClass);
        }catch (JSONException e){

        }
        textView.setText(schoolInfo.toString());

        try{
            JSONObject findCourse;
            findCourse = schoolInfo.getJSONObject("Physics");
            textView.setText(findCourse.getString("grade"));
        }catch(JSONException e){
        }

    }
}