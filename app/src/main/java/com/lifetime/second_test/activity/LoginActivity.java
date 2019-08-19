package com.lifetime.second_test.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.lifetime.second_test.R;

public class LoginActivity extends AppCompatActivity {

    TextView signUpLink;
    TextView forgotButton;
    TextView email;
    TextView password;
    TextView signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        customActionBar();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrollable_login);

        signUpLink = findViewById(R.id.sign_up_text_clickable);
        signInButton = findViewById(R.id.button_sign_in);
        email = findViewById(R.id.email_address_value_sign_in);
        password = findViewById(R.id.password_input);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("RegisteredData");
        final String emailAddressReceived = bundle.getString("EmailAddress");
        final String passwordReceived = bundle.getString("Password");

        email.setText(emailAddressReceived);
        password.setText(passwordReceived);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean emailValid = email.getText().toString().equals(emailAddressReceived);
                boolean passwordValid = password.getText().toString().equals(passwordReceived);
                if (emailValid && passwordValid) {
                    Intent intent = new Intent(LoginActivity.this, NewFeedActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signUpLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
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

    private void customActionBar() {
        //make translucent statusBar on kitkat devices
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        //make fully Android Transparent Status bar
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
}
