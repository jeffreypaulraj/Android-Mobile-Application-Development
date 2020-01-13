package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
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

public class MainActivity extends AppCompatActivity {

    String zipcode;
    AsyncThread myThread;
    TextView mainTemperatureText;
    Button enterZipCodeButton;
    EditText enterZipCodeField;
    Double mainTemperature;
    Switch HourlyDailySwitch;
    boolean isHourly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTemperatureText = findViewById(R.id.id_mainTempText);
        enterZipCodeButton = findViewById(R.id.id_enterZipCodeButton);
        enterZipCodeField = findViewById(R.id.id_zipCodeEnter);
        HourlyDailySwitch = findViewById(R.id.id_hourlyDailySwitch);

        isHourly = false;
        HourlyDailySwitch.setChecked(true);
        HourlyDailySwitch.setText("Daily");
        enterZipCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HourlyDailySwitch.setChecked(true);
                zipcode = enterZipCodeField.getText().toString();
                myThread = new AsyncThread();
                myThread.execute(zipcode);

            }
        });

        HourlyDailySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isHourly){
                    HourlyDailySwitch.setText("Hourly");
                }
                else{
                    HourlyDailySwitch.setText("Daily");
                }
                isHourly = isChecked;
            }
        });


    }

    public class AsyncThread extends AsyncTask<String, Void, JSONObject> {

        @Override
        protected JSONObject doInBackground(String... strings) {
            String zipcodeSync = strings[0];
            try {
                URL apiURL = new URL("http://api.openweathermap.org/data/2.5/forecast?zip=" + zipcodeSync + "&APPID=5a115e37dbb80b0aa57cae664d0ff4fa");
                URLConnection apiConnection = apiURL.openConnection();
                InputStream apiInputStream = apiConnection.getInputStream();
                BufferedReader apiBufferedReader = new BufferedReader(new InputStreamReader(apiInputStream));
                String receiveInfo = "";
                String line = "";
                while((line = apiBufferedReader.readLine()) != null){
                    receiveInfo+=line;
                }
                JSONObject weatherObject = new JSONObject(receiveInfo);
                return weatherObject;
            } catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(JSONObject objectOne) {

            try {
                JSONObject weatherInfo = objectOne;
                JSONObject mainInfo = weatherInfo.getJSONArray("list").getJSONObject(0).getJSONObject("main");
                System.out.println("main info: " + mainInfo);
                mainTemperature = mainInfo.getDouble("temp");
                mainTemperatureText.setText("Temperature: " + mainTemperature);
                System.out.println(objectOne);

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
