package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    URL apiURL;
    URLConnection apiConnection;
    InputStream apiInputStream;
    BufferedReader apiBufferedReader;
    String zipcode;
    String receiveInfo;
    AsyncThread myThread;
    TextView mainTemperatureText;
    Button enterZipCodeButton;
    EditText enterZipCodeField;
    Double mainTemperature;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTemperatureText = findViewById(R.id.id_mainTempText);
        enterZipCodeButton = findViewById(R.id.id_enterZipCodeButton);
        enterZipCodeField = findViewById(R.id.id_zipCodeEnter);

        receiveInfo = "";

        enterZipCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zipcode = enterZipCodeField.getText().toString();
                myThread = new AsyncThread();
                myThread.execute(zipcode);
                System.out.println("Thread: " + myThread.toString());

            }
        });



    }

    public class AsyncThread extends AsyncTask<String, Integer, Double> {

        @Override
        protected Double doInBackground(String... strings) {
                zipcode = strings[0];
                System.out.println("zipcode:" + zipcode);
            try {
                apiURL = new URL("http://api.openweathermap.org/data/2.5/forecast?zip=" + zipcode + "&APPID=5a115e37dbb80b0aa57cae664d0ff4fa");
                apiConnection = apiURL.openConnection();
                System.out.println("apiconn:" + apiConnection);
                apiInputStream = apiConnection.getInputStream();

                apiBufferedReader = new BufferedReader(new InputStreamReader(apiInputStream));
                while(apiBufferedReader.readLine() != null){
                    System.out.println("info: " + receiveInfo);
                    receiveInfo+=apiBufferedReader.readLine();
                }

            } catch (Exception e){
                e.printStackTrace();
            }

            System.out.println("mainTemp: " + mainTemperature);
            return mainTemperature;
        }

        @Override
        protected void onPostExecute(Double result) {
            super.onPostExecute(result);
            try {
                System.out.println("receiveInfo:" + receiveInfo);
                JSONObject weatherInfo = new JSONObject(receiveInfo);
                JSONObject mainInfo = weatherInfo.getJSONArray("list").getJSONObject(0);
                System.out.println("Weather: " + weatherInfo.toString());
                mainTemperature = mainInfo.getDouble("temp");
                System.out.println("Temperature: " + mainTemperature);
                mainTemperatureText.setText("Temperature: " + mainTemperature);
            }catch(Exception e){

            }
        }
    }
}
