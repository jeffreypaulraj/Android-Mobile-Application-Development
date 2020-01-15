package com.example.weatherapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    String zipcode;
    AsyncThread myThread;
    TextView mainTemperatureText;
    Button enterZipCodeButton;
    EditText enterZipCodeField;
    Double mainTemperature;
    Switch HourlyDailySwitch;
    ListView weatherListView;
    TextView mainDateTimeText;
    TextView cityText;
    TextView mainDescriptionText;
    ImageView mainImage;
    boolean isHourly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTemperatureText = findViewById(R.id.id_mainTempText);
        enterZipCodeButton = findViewById(R.id.id_enterZipCodeButton);
        enterZipCodeField = findViewById(R.id.id_zipCodeEnter);
        HourlyDailySwitch = findViewById(R.id.id_hourlyDailySwitch);
        weatherListView = findViewById(R.id.id_weatherListView);
        mainDateTimeText = findViewById(R.id.id_mainDateTimeText);
        cityText = findViewById(R.id.id_cityText);
        mainDescriptionText = findViewById(R.id.id_mainDescriptionText);
        mainImage = findViewById(R.id.imageView);

        HourlyDailySwitch.setVisibility(View.INVISIBLE);

        isHourly = false;
        HourlyDailySwitch.setChecked(true);
        HourlyDailySwitch.setText("Daily");
        enterZipCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HourlyDailySwitch.setVisibility(View.VISIBLE);
                HourlyDailySwitch.setChecked(true);
                zipcode = enterZipCodeField.getText().toString();
                myThread = new AsyncThread();
                myThread.execute(zipcode);

            }
        });

        HourlyDailySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isHourly = isChecked;
                if(isHourly){
                    HourlyDailySwitch.setText("Hourly");
                }
                else{
                    HourlyDailySwitch.setText("Daily");
                }
                zipcode = enterZipCodeField.getText().toString();
                myThread = new AsyncThread();
                myThread.execute(zipcode);
            }
        });


    }

    public class AsyncThread extends AsyncTask<String, Void, ArrayList<JSONObject>> {

        @Override
        protected ArrayList<JSONObject> doInBackground(String... strings) {
            String zipcodeSync = strings[0];
            ArrayList<JSONObject> list = new ArrayList<>();
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
                list.add(weatherObject);

                URL currentURL = new URL("http://api.openweathermap.org/data/2.5/weather?zip=" + zipcodeSync + "&APPID=5a115e37dbb80b0aa57cae664d0ff4fa");
                URLConnection currentConnection = currentURL.openConnection();
                InputStream currentInputStream = currentConnection.getInputStream();
                BufferedReader currentBufferedReader = new BufferedReader(new InputStreamReader(currentInputStream));
                String currentReceiveInfo = "";
                String currentline = "";
                while((currentline = currentBufferedReader.readLine()) != null){
                    currentReceiveInfo+=currentline;
                }
                JSONObject currentWeatherObject = new JSONObject(currentReceiveInfo);
                list.add(currentWeatherObject);


                return list;
            } catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<JSONObject> list) {

            try {
                JSONObject weatherInfo = list.get(0);
                JSONObject current = list.get(1);
                mainTemperature = current.getJSONObject("main").getDouble("temp");
                String urlStart = "http://openweathermap.org/img/wn/";

                mainTemperature = mainTemperature*9/5 -459.67;
                mainTemperature = Math.round(mainTemperature*100.0)/100.0;
                mainTemperatureText.setText(""+ mainTemperature + " °F");
                if(isHourly){
                    mainDateTimeText.setText(new SimpleDateFormat( "hh:mm:ss a zzz").format(new java.util.Date()));
                }
                else{
                    mainDateTimeText.setText(new SimpleDateFormat("EEEE, MMMM d, yyyy").format(new java.util.Date()));
                }
                cityText.setText(current.getString("name").toUpperCase());
                mainDescriptionText.setText(current.getJSONArray("weather").getJSONObject(0).getString("description").toUpperCase());
                Picasso.get().load(urlStart + current.getJSONArray("weather").getJSONObject(0).getString("icon") + ".png").into(mainImage);



                ArrayList<WeatherEvent> weatherList = new ArrayList<>();

                JSONObject dayZero = weatherInfo.getJSONArray("list").getJSONObject(0);

                JSONObject dayOne = weatherInfo.getJSONArray("list").getJSONObject(8);
                JSONObject dayTwo = weatherInfo.getJSONArray("list").getJSONObject(16);
                JSONObject dayThree = weatherInfo.getJSONArray("list").getJSONObject(24);
                JSONObject dayFour = weatherInfo.getJSONArray("list").getJSONObject(32);

                JSONObject timeOne = weatherInfo.getJSONArray("list").getJSONObject(1);
                JSONObject timeTwo = weatherInfo.getJSONArray("list").getJSONObject(2);
                JSONObject timeThree = weatherInfo.getJSONArray("list").getJSONObject(3);
                JSONObject timeFour = weatherInfo.getJSONArray("list").getJSONObject(4);



                weatherList.add(new WeatherEvent(dayZero.getJSONObject("main").getDouble("temp_min"), dayZero.getJSONObject("main").getDouble("temp_max"), dayZero.getString("dt_txt"),dayZero.getJSONArray("weather").getJSONObject(0).getString("description"), urlStart + dayZero.getJSONArray("weather").getJSONObject(0).getString("icon") + ".png"));
                if(isHourly){
                    weatherList.add(new WeatherEvent(timeOne.getJSONObject("main").getDouble("temp_min"), timeOne.getJSONObject("main").getDouble("temp_max"), timeOne.getString("dt_txt"),timeFour.getJSONArray("weather").getJSONObject(0).getString("description"), urlStart + timeOne.getJSONArray("weather").getJSONObject(0).getString("icon") + ".png" ));
                    weatherList.add(new WeatherEvent(timeTwo.getJSONObject("main").getDouble("temp_min"), timeTwo.getJSONObject("main").getDouble("temp_max"), timeTwo.getString("dt_txt"),timeFour.getJSONArray("weather").getJSONObject(0).getString("description"), urlStart + timeTwo.getJSONArray("weather").getJSONObject(0).getString("icon") + ".png" ));
                    weatherList.add(new WeatherEvent(timeThree.getJSONObject("main").getDouble("temp_min"), timeThree.getJSONObject("main").getDouble("temp_max"), timeThree.getString("dt_txt"),timeFour.getJSONArray("weather").getJSONObject(0).getString("description"), urlStart + timeThree.getJSONArray("weather").getJSONObject(0).getString("icon") + ".png"));
                    weatherList.add(new WeatherEvent(timeFour.getJSONObject("main").getDouble("temp_min"), timeFour.getJSONObject("main").getDouble("temp_max"), timeFour.getString("dt_txt"),timeFour.getJSONArray("weather").getJSONObject(0).getString("description"), urlStart + timeFour.getJSONArray("weather").getJSONObject(0).getString("icon") + ".png" ));
                }
                else {
                    weatherList.add(new WeatherEvent(dayOne.getJSONObject("main").getDouble("temp_min"), dayOne.getJSONObject("main").getDouble("temp_max"), dayOne.getString("dt_txt"),dayOne.getJSONArray("weather").getJSONObject(0).getString("description"), urlStart + dayOne.getJSONArray("weather").getJSONObject(0).getString("icon") + ".png" ));
                    weatherList.add(new WeatherEvent(dayTwo.getJSONObject("main").getDouble("temp_min"), dayTwo.getJSONObject("main").getDouble("temp_max"), dayTwo.getString("dt_txt"),dayTwo.getJSONArray("weather").getJSONObject(0).getString("description"), urlStart + dayTwo.getJSONArray("weather").getJSONObject(0).getString("icon") + ".png" ));
                    weatherList.add(new WeatherEvent(dayThree.getJSONObject("main").getDouble("temp_min"), dayThree.getJSONObject("main").getDouble("temp_max"), dayThree.getString("dt_txt"),dayThree.getJSONArray("weather").getJSONObject(0).getString("description"), urlStart + dayThree.getJSONArray("weather").getJSONObject(0).getString("icon") + ".png"));
                    weatherList.add(new WeatherEvent(dayFour.getJSONObject("main").getDouble("temp_min"), dayFour.getJSONObject("main").getDouble("temp_max"), dayFour.getString("dt_txt"),dayFour.getJSONArray("weather").getJSONObject(0).getString("description"), urlStart + dayFour.getJSONArray("weather").getJSONObject(0).getString("icon") + ".png"));
                }
                CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, R.layout.adapter_custom, weatherList);
                weatherListView.setAdapter(customAdapter);


            }catch(Exception e){
                e.printStackTrace();
            }


        }
        public class WeatherEvent{

            String image;
            double lowTemp;
            double highTemp;
            String dateTime;
            String description;

            public WeatherEvent(double lowTemp, double highTemp, String dateTime, String description, String image){
                this.image = image;
                this.lowTemp = lowTemp;
                this.highTemp = highTemp;
                this.dateTime = dateTime;
                this.description = description;
            }

            public String getImage() {
                return image;
            }

            public double getLowTemp() {
                return lowTemp;
            }

            public double getHighTemp() {
                return highTemp;
            }

            public String getDateTime() {
                return dateTime;
            }

            public String getDescription() {
                return description;
            }

        }

        public class CustomAdapter extends ArrayAdapter<WeatherEvent>{

            List<WeatherEvent> arrayList;
            Context parentContext;
            int xmlResource;
            public CustomAdapter(@NonNull Context context, int resource, @NonNull List<WeatherEvent> objects){
                super(context, resource, objects);
                arrayList = objects;
                parentContext = context;
                xmlResource = resource;
            }

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater layoutInflater = (LayoutInflater) parentContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                View view = layoutInflater.inflate(R.layout.adapter_custom, null);

                ImageView imageView = view.findViewById(R.id.id_adapter_imageView);
                TextView dateTimeText = view.findViewById(R.id.id_adapter_dateTime);
                TextView highTempText = view.findViewById(R.id.id_adapter_highTemp);
                TextView lowTempText = view.findViewById(R.id.id_adapter_lowTemp);
                TextView descriptionText = view.findViewById(R.id.id_adapter_descriptionText);

                Picasso.get().load(arrayList.get(position).getImage()).into(imageView);
                dateTimeText.setText(arrayList.get(position).getDateTime());
                highTempText.setText("High: " + kelvinToFahrenHeit(arrayList.get(position).getHighTemp()) + " °F");
                lowTempText.setText("Low: " + kelvinToFahrenHeit(arrayList.get(position).getLowTemp()) + " °F");
                descriptionText.setText(arrayList.get(position).getDescription().toUpperCase());

                return view;
            }

            public double kelvinToFahrenHeit(double kelvin){
                return Math.round((kelvin*9/5 - 459.67)*100.0)/100.0;
            }
        }
    }
}
