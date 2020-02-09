package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email, password;
    Button button;

    String getEmail, getPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.editEmail);
        password = findViewById(R.id.editPassword);
        button = findViewById(R.id.editButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEmail = email.getText().toString();
                getPassword = password.getText().toString();

                boolean length = true;
                boolean letter = true;
                boolean twoDigit = true;
                boolean oneUpper = true;

                if(password.length() < 10 ) {
                    length = false;
                } else {
                    char c;
                    int digitCount = 0;
                    int upperCase = 0;
                    for (int i = 0; i < getPassword.length(); i++) {
                        c = getPassword.charAt(i);
                        if (!Character.isLetterOrDigit(c)) {
                            letter = false;
                        } else if (Character.isDigit(c)) {
                            digitCount++;
                        } else if (Character.isUpperCase(c)) {
                            upperCase++;
                        }
                    }
                    if (digitCount < 2) {
                        twoDigit = false;
                    }
                    if (upperCase < 1) {
                        oneUpper = false;
                    }
                }
                    if(getPassword.equals("") || getEmail.equals("")) {
                        Toast.makeText(MainActivity.this, "Please Enter Username and password", Toast.LENGTH_SHORT).show();
                    } else {
                        if(length == true && letter == true && twoDigit == true && oneUpper == true) {
                            Toast.makeText(MainActivity.this, "Ah-ha You are logged in", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Please make sure your password have atleast 1 Uppercase and 2 digits and more than 10 characters.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

        });


    }
}
