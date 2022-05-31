package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText email, pass;
    Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.Semail);
        pass = findViewById(R.id.Spass);
        btnSignup = findViewById(R.id.btnSign);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = email.getText().toString();
                String password = pass.getText().toString();

                if (isValid(password)) {
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    intent.putExtra("email", mail);
                    intent.putExtra("password", password);
                    startActivity(intent);
                } else
                    Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_LONG).show();
            }
        });
    }

    public boolean isValid(String password) {
        Pattern lowercase = Pattern.compile(".*[a-z.*]+");
        Pattern uppercase = Pattern.compile(".*[A-Z.*]+");
        Pattern number = Pattern.compile(".*[0-9.*]+");
        Pattern special = Pattern.compile(".*[^a-zA-Z0-9]+.*");

        Matcher lowmatch = lowercase.matcher(password);
        Matcher upmatch = uppercase.matcher(password);
        Matcher nummatch = number.matcher(password);
        Matcher spmatch = special.matcher(password);

        if (lowmatch.find() && upmatch.find() && nummatch.find() && spmatch.find() && password.length() > 8)
            return true;
         else
            return false;
    }
}