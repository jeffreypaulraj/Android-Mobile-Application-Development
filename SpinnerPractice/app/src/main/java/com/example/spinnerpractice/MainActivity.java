package com.example.spinnerpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner prefixSpinner;
    EditText nameEditText;
    Button addListingButton;
    TextView currentListing;
    Spinner namesSpinner;
    ArrayList<String> prefixList;
    ArrayList<String> namesList;
    String currentPrefix;
    CharSequence currentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefixSpinner = findViewById(R.id.id_prefixSpinner);
        nameEditText = findViewById(R.id.id_insertNameText);
        addListingButton = findViewById(R.id.id_addListingButton);
        currentListing = findViewById(R.id.id_inputText);
        namesSpinner = findViewById(R.id.id_addressBookSpinner);
        prefixList = new ArrayList<>();
        namesList = new ArrayList<>();
        currentPrefix = "";
        currentName = "";

        prefixList.add("Mr. ");
        prefixList.add("Mrs. ");
        prefixList.add("Dr. ");

        ArrayAdapter<String> prefixAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, prefixList);
        prefixSpinner.setAdapter(prefixAdapter);

        final ArrayAdapter<String> nameAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, namesList);
        namesSpinner.setAdapter(nameAdapter);

        prefixSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentPrefix = prefixList.get(position);
                currentListing.setText(currentPrefix + currentName);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                currentListing.setText(currentPrefix + s);
                currentName = s;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                currentListing.setText(currentPrefix + s);
                currentName = s;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        addListingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namesList.add(currentPrefix + currentName);
                nameAdapter.notifyDataSetChanged();
            }
        });

    }
}
