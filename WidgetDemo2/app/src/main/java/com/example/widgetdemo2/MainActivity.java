package com.example.widgetdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    TextView textView;
    ImageView rightImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        radioGroup = findViewById(R.id.radioGroup);
        rightImage = findViewById(R.id.imageView);
        rightImage.setImageResource(R.drawable.darthvader);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButtonA){
                    textView.setText("Selected A");
                }
                if(checkedId == R.id.radioButtonB){
                    textView.setText("Selected B");
                }
                if(checkedId == R.id.radioButtonC){
                    textView.setText("Selected C");

                    Toast myToast = Toast.makeText(MainActivity.this, "C is the best", Toast.LENGTH_SHORT);
                    myToast.show();
                }
            }
        });

    }
}
