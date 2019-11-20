package com.example.orientationpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Spinner spinner;
    Button removeButton;
    ArrayList<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.id_textView);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            spinner = findViewById(R.id.id_spinner);
            removeButton = findViewById(R.id.id_removeButton);
            list = new ArrayList<>();
            list.add("Bob");
            list.add("Bot");
            list.add("Boa");
            list.add("Boy");

            final ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, list);
            spinner.setAdapter(listAdapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    textView.setText(list.get(position));
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    textView.setText("All Elements Removed");
                }
            });

            removeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.clear();
                    listAdapter.notifyDataSetChanged();
                }
            });
        }
    }
}
