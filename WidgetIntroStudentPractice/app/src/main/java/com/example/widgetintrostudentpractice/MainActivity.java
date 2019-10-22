package com.example.widgetintrostudentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView sliderStatus;
    Switch toggleSeekBar;
    EditText colorInput;
    TextView displayColor;
    Button testButton;
    SeekBar buttonWidthSlider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sliderStatus = findViewById(R.id.id_sliderStatusText);
        toggleSeekBar = findViewById(R.id.id_toggleSeekBarSwitch);
        
    }
}
