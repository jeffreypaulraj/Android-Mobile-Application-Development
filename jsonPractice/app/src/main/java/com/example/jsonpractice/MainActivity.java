package com.example.jsonpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONObject spongeBobShow = new JSONObject();
        JSONObject spongeBob = new JSONObject();
        JSONObject squidward = new JSONObject();
        JSONObject mrKrabs = new JSONObject();
        JSONObject patrick = new JSONObject();
        JSONObject settings = new JSONObject();
        JSONObject krustyKrab = new JSONObject();

    }
}
