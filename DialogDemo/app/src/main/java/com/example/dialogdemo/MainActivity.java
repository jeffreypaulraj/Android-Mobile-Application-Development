package com.example.dialogdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button dialogButton;
    TextView dialogText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialogText = findViewById(R.id.id_dialogText);
        dialogButton = findViewById(R.id.id_dialogButton);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View dialogView = getLayoutInflater().inflate(R.layout.dialog_layout, null);
                final EditText emailField = dialogView.findViewById(R.id.id_dialog_emailField);
                final EditText passwordField = dialogView.findViewById(R.id.id_dialog_passwordField);
                Button loginButton = dialogView.findViewById(R.id.id_dialog_loginbutton);

                loginButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!emailField.getText().toString().isEmpty() && !passwordField.getText().toString().isEmpty()){
                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Fill in Empty Fields", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                builder.setView(dialogView);
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
    }
}
