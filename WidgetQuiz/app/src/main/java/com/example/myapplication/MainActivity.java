package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText enterPassword;
    EditText reEnterPassword;
    Button okButton;
    TextView previouslyUsed;
    Switch matchSwitch;
    ArrayList<String> database;
    String passwordOne;
    String passwordTwo;
    boolean alreadyUsed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterPassword = findViewById(R.id.enterPasswordEdit);
        reEnterPassword = findViewById(R.id.reEnterPasswordEdit);
        okButton = findViewById(R.id.okButton);
        previouslyUsed = findViewById(R.id.databaseText);
        matchSwitch = findViewById(R.id.matchSwitch);

        database = new ArrayList<>();
        passwordOne = "Enter Password Here";
        passwordTwo = "ReEnter Password Here";
        matchSwitch.setEnabled(false);
        alreadyUsed = false;

        database.add("test");
        database.add("123");
        database.add("password");
        database.add("abc");
        enterPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                passwordOne = s.toString();
                checkDatabase();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        reEnterPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                passwordTwo = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(passwordOne);
                System.out.println(passwordTwo);
                if(passwordOne.equals(passwordTwo) && !alreadyUsed){
                    database.add(passwordOne);
                    matchSwitch.setText("Match");
                    matchSwitch.setChecked(true);
                }
                else{
                    matchSwitch.setText("Does Not Match");
                    matchSwitch.setChecked(false);
                }
            }
        });


    }

    public void checkDatabase(){
       int count = 0;
        for(int i = 0; i < database.size(); i++){
            if(database.get(i).equals(passwordOne)){
                count++;
            }
        }

        if(count > 0){
            alreadyUsed = true;
            previouslyUsed.setText("Password Has Already Been Used");
        }
        else{
            alreadyUsed = false;
            previouslyUsed.setText("Password Not Used Previously");
        }

    }
}
