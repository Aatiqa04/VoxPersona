package com.example.voxpersona;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUpActivity extends AppCompatActivity {

    EditText emailEditText;
    EditText passwordEditText;
    Button signInButton;
    Button createAccountButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        emailEditText=findViewById(R.id.emailid);
        passwordEditText=findViewById(R.id.passwordid);
        signInButton=findViewById(R.id.sign_in);
        createAccountButton=findViewById(R.id.create_acc);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });
    }
    private void signIn()
    {
        String email=emailEditText.getText().toString().trim();
        String password=passwordEditText.getText().toString().trim();
        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this,"Please enter your email.",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this,"Please enter your password.",Toast.LENGTH_SHORT).show();
            return;
        }

        if(isValidEmail(email) && password.length()>=6)
        {
            Toast.makeText(this,"Sign In Successfull.",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
            startActivity(intent);
            finish(); //
        }
        else {
            Toast.makeText(this,"Invalid email or password",Toast.LENGTH_SHORT).show();
        }
    }
    private void createAccount()
    {
        Toast.makeText(this,"Create Account.",Toast.LENGTH_SHORT).show();
    }
    private boolean isValidEmail(CharSequence target)
    {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}