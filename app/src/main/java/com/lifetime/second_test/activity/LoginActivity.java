package com.lifetime.second_test.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lifetime.second_test.R;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    public static final List<String> listMember = new ArrayList<String>();
    public static final int REGISTERED_DATA = 1;
    public static final int RESULT = 1;

    TextView signUpLink;
    TextView forgotButton;
    TextView email;
    TextView password;
    TextView signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrollable_login);

        signUpLink = findViewById(R.id.sign_up_text_clickable);
        signInButton = findViewById(R.id.button_sign_in);
        email = findViewById(R.id.email_address_value_sign_in);
        password = findViewById(R.id.password_input);

        Intent intent = getIntent();
        final Bundle bundle = intent.getBundleExtra("RegisteredData");
        email.setText("");
        password.setText("");

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean userValid;
                String getEmailInput = email.getText().toString();
                String getPasswordInput = password.getText().toString();
                userValid = listMember.contains(getEmailInput + getPasswordInput);

                if (userValid) {
                    Intent intent = new Intent(LoginActivity.this, NewFeedActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        signUpLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intent, REGISTERED_DATA);
            }
        });

        forgotButton = findViewById(R.id.forgot_password);
        forgotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (data == null) {
            return;
        }

        if (requestCode == REGISTERED_DATA) {
            Bundle bundle = data.getBundleExtra("RegisteredData");
            String emailGiveBack = bundle.getString("EmailAddress");
            String passwordGiveBack = bundle.getString("Password");
            listMember.add(emailGiveBack + passwordGiveBack);

            if (resultCode == RESULT) {
                email.setText(emailGiveBack);
                password.setText(passwordGiveBack);
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
