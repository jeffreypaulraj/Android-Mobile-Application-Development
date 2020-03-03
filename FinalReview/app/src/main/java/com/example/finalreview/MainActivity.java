package com.example.finalreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    EditText editText;
    Spinner spinner;
    ArrayList<String> stringList;
    TextView textView;
    RadioGroup radioGroup;
    static final int NUMBER_CODE = 1234;
    static final String INTENT_CODE = "abc";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.id_imageView);
        imageView.setImageResource(R.drawable.ic_launcher_foreground);
        editText = findViewById(R.id.id_editText);
        textView = findViewById(R.id.id_textView);
        radioGroup = findViewById(R.id.id_radioGroup);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                textView.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        spinner = findViewById(R.id.id_spinner);
        stringList = new ArrayList<>();
        stringList.add("Bobby");
        stringList.add("Jane");
        stringList.add("Sally");
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setText(stringList.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,stringList);
        spinner.setAdapter(listAdapter);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.id_spongeBob){
                    Toast.makeText(MainActivity.this, "Spongebob", Toast.LENGTH_SHORT).show();
                }
                if(i == R.id.id_patrick){
                    Intent mainToNumber = new Intent(MainActivity.this, numberActivity.class);
                    startActivityForResult(mainToNumber, NUMBER_CODE);
                }
            }
        });


    }
}
