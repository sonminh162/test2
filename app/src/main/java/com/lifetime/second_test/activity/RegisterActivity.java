package com.lifetime.second_test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.lifetime.second_test.R;

public class RegisterActivity extends AppCompatActivity {

    TextView signUpButton;
    TextView signIn;
    TextView userName;
    TextView password;
    TextView emailAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrollable_register);

        signIn = findViewById(R.id.sign_in_text);
        signUpButton = findViewById(R.id.button_sign_up);
        userName = findViewById(R.id.full_name_value);
        password = findViewById(R.id.password_value_am2);
        emailAddress = findViewById(R.id.email_address_value_sign_in);

//        final String emailAddressForIntent = emailAddress.getText().toString();
//        final String passwordForIntent = password.getText().toString();

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateSimple()) {
                    saveDataToIntent(emailAddress.getText().toString(), password.getText().toString(), LoginActivity.RESULT);
                }
            }
        });
    }

    public boolean validateSimple() {
        boolean flag = true;
        String user = emailAddress.getText().toString();
        String passwordCheck = password.getText().toString();
        if (user.isEmpty()) {
            if (passwordCheck.isEmpty()) {
                Toast.makeText(this, "user and password not empty!", Toast.LENGTH_SHORT).show();
                flag = false;
            } else {
                Toast.makeText(this, "user not empty!", Toast.LENGTH_SHORT).show();
                flag = false;
            }
        } else {
            if (passwordCheck.isEmpty()) {
                Toast.makeText(this, "password not empty", Toast.LENGTH_SHORT).show();
                flag = false;
            }
        }
        return flag;
    }

    private void saveDataToIntent(String emailAddressForIntent, String passwordForIntent, int resultCode) {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("EmailAddress", emailAddressForIntent);
        bundle.putString("Password", passwordForIntent);
        intent.putExtra("RegisteredData", bundle);
        setResult(resultCode, intent);
        finish();
    }
}
