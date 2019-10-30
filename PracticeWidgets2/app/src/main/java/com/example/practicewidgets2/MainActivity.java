package com.example.practicewidgets2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    RadioGroup radioGroup;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toast = Toast.makeText(this, "toast", Toast.LENGTH_SHORT);

        radioGroup = findViewById(R.id.id_radioGroup);
        image = findViewById(R.id.imageView);
        image.setImageResource(R.drawable.spongebobicon);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.spongeBobButton){
                    image.setImageResource(R.drawable.spongebob);
                    toast = Toast.makeText(MainActivity.this, "You have selected Spongebob!", Toast.LENGTH_SHORT);
                }
                if(checkedId == R.id.patrickButton){
                    image.setImageResource(R.drawable.patrick);
                    toast = Toast.makeText(MainActivity.this, "You have selected Patrick!", Toast.LENGTH_SHORT);
                }
                if(checkedId == R.id.squidwardButton){
                    image.setImageResource(R.drawable.squidward);
                    toast = Toast.makeText(MainActivity.this, "You have selected Squidward!", Toast.LENGTH_SHORT);
                }
                toast.show();

            }
        });
    }
}
