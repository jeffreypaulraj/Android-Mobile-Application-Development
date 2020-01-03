package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    URL apiURL;
    URLConnection apiConnection;
    InputStream apiInputStream;
    BufferedReader apiBufferedReader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            apiURL = new URL("http://api.openweathermap.org/data/2.5/forecast?id=524901&APPID=5a115e37dbb80b0aa57cae664d0ff4fa");
        } catch (MalformedURLException e) {
            e.printStackTrace();

        }
        try {
            apiConnection = apiURL.openConnection();
            apiInputStream = apiConnection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();

        }


        apiBufferedReader = new BufferedReader(new InputStreamReader(apiInputStream));

            String apiString = null;
            try {
                apiString = apiBufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("API: " +  apiString);


    }

}
