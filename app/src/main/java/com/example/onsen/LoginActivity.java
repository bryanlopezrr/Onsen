package com.example.onsen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    EditText tEmail, tPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tEmail = findViewById(R.id.editTextEmail);
        tPassword = findViewById(R.id.editTextPassword);

    }

    public void login(View view){

        if( TextUtils.isEmpty(tPassword.getText()) &&  TextUtils.isEmpty(tEmail.getText())) {
            tEmail.setError( "Email is required" );
            tPassword.setError("Password is required");
        }
        else if( TextUtils.isEmpty(tEmail.getText())){
            tEmail.setError( "Email is required" );

        }
        else if( TextUtils.isEmpty(tPassword.getText())) {
            tPassword.setError("Password is required");
        }
        else{
            ParseUser.logInInBackground(tEmail.getText().toString(), tPassword.getText().toString(), new LogInCallback() {
                @Override
                public void done(ParseUser parseUser, ParseException e) {
                    if (parseUser != null) {
                        Toast.makeText(LoginActivity.this, "Sucessful Login - Welcome back" + tEmail.getText().toString() + "!", Toast.LENGTH_LONG).show();
                    } else {
                        ParseUser.logOut();
                        Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }

    public void signUp(View view){
        Intent intent = new Intent( LoginActivity.this, SignUpActivity.class);
        startActivity(intent);
    }

}
