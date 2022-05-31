package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText emailText, passText;
    Button login;
    int c=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailText = findViewById(R.id.lemail);
        passText = findViewById(R.id.lpass);
        login = findViewById(R.id.btnLogin);

        String regMail = getIntent().getStringExtra("email");
        String regPass = getIntent().getStringExtra("password");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailText.getText().toString();
                String pass = passText.getText().toString();

                if (regMail.equals(email) && regPass.equals(pass)) {
                    Intent intent = new Intent(Login.this, Welcome.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_LONG).show();

                c--;
                if(c==0)
                {
                    Toast.makeText(getBaseContext(), "Attempts", Toast.LENGTH_LONG).show();
                    login.setEnabled(false);

                }
            }
        });


    }
}