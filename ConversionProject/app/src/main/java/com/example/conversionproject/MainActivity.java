package com.example.conversionproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    TextView outputText;
    EditText inputEdit;
    Spinner inputSpinner;
    Spinner outputSpinner;

    ArrayList<String> inputList;
    List<String> outputList;

    boolean emptyField;
    String selectedInput;
    String selectedOutput;
    double currentNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        outputText = findViewById(R.id.id_answerText);
        inputEdit = findViewById(R.id.id_inputEditText);
        inputSpinner = findViewById(R.id.id_firstSpinner);
        outputSpinner = findViewById(R.id.id_answerSpinner);

        inputList = new ArrayList<>();
        outputList = new ArrayList<>();

        inputList.add("Miles");
        outputList.add("Mesons");
        inputList.add("Mesons");
        outputList.add("Quarks");
        inputList.add("Quarks");
        outputList.add("Gluons");
        inputList.add("Gluons");
        outputList.add("Hadrons");
        emptyField = true;
        selectedInput = inputList.get(0);
        selectedOutput = outputList.get(0);
        currentNum = 0;
        final Toast errorToast = Toast.makeText(MainActivity.this , "Input A Value to Convert!", Toast.LENGTH_SHORT);

        ArrayAdapter<String> inputAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, inputList);
        ArrayAdapter<String> outputAdapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item, outputList);

        inputSpinner.setAdapter(inputAdapter);
        outputSpinner.setAdapter(outputAdapter);

        inputEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               emptyField = (charSequence.length() == 0);
               currentNum = Double.parseDouble(charSequence.toString());
               conversionFactor();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        inputSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedInput = inputList.get(i);
                if(emptyField){
                    errorToast.show();
                }
                else{
                    conversionFactor();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        outputSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedOutput = outputList.get(i);
                if(emptyField){
                    errorToast.show();
                }
                else{
                    conversionFactor();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    public void conversionFactor(){
       double conversionRate = 1;
       if(selectedOutput.equals("Mesons")){
           conversionRate*=520;
       }
       else if(selectedOutput.equals("Quarks")){
           conversionRate*=(520*63);
       }
       else if(selectedOutput.equals("Gluons")){
           conversionRate*=(520*63*25);
       }
       else if(selectedOutput.equals("Hadrons")){
           conversionRate*=(520*63*25*7);
       }

        if(selectedInput.equals("Gluons")){
            conversionRate/=7;
        }
        else if(selectedInput.equals("Quarks")){
            conversionRate/=(7*25);
        }
        else if(selectedInput.equals("Mesons")){
            conversionRate/=(7*63*25);
        }
        else if(selectedInput.equals("Miles")){
            conversionRate/=(520*63*25*7);
        }
        outputText.setText("" + currentNum*conversionRate);
    }
}
