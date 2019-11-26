package com.example.widgetintrostudentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CompoundButton;
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
        colorInput = findViewById(R.id.id_colorEditText);
        displayColor = findViewById(R.id.id_colorTextView);
        testButton = findViewById(R.id.id_testButton);
        buttonWidthSlider = findViewById(R.id.id_seekBarButtonWidth);

        buttonWidthSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                testButton.setWidth(i*5);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        toggleSeekBar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    buttonWidthSlider.setEnabled(false);
                    sliderStatus.setText("Turn On Slider");
                }
                else{
                    buttonWidthSlider.setEnabled(true);
                    sliderStatus.setText("Turn Off Slider");
                }
            }
        });

        colorInput.addTextChangedListener(new TextWatcher() {
           CharSequence charSequence = "";
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence a, int i, int i1, int i2) {

                charSequence = a;
                if(charSequence == "red" || charSequence == "Red"){
                    displayColor.setTextColor(Color.RED);
                }
                else if(charSequence == "blue" || charSequence == "Blue"){
                    displayColor.setTextColor(Color.BLUE);
                }
                else if(charSequence == "green" || charSequence == "Green"){
                    displayColor.setTextColor(Color.GREEN);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(charSequence == "red" || charSequence == "Red"){
                    displayColor.setTextColor(Color.RED);
                }
                else if(charSequence == "blue" || charSequence == "Blue"){
                    displayColor.setTextColor(Color.BLUE);
                }
                else if(charSequence == "green" || charSequence == "Green"){
                    displayColor.setTextColor(Color.GREEN);
                }
            }
        });

    }
}
