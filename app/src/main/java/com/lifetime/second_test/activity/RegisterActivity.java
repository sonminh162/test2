package com.lifetime.second_test.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.lifetime.second_test.R;

public class RegisterActivity extends AppCompatActivity {

    public static final int REGISTERED_DATA = 1;

    TextView signUpButton;
    TextView signIn;
    TextView userName;
    TextView password;
    TextView emailAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        customActionBar();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrollable_register);

        signIn = findViewById(R.id.sign_in_text);
        signUpButton = findViewById(R.id.button_sign_up);
        userName = findViewById(R.id.full_name_value);
        password = findViewById(R.id.password_value_am2);
        emailAddress = findViewById(R.id.email_address_value_sign_in);

        final String emailAddressForIntent = emailAddress.getText().toString();
        final String passwordForIntent = password.getText().toString();

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDataToIntent(emailAddressForIntent, passwordForIntent);
                openDialogShowResult();
            }
        });
    }

    private void saveDataToIntent(String emailAddressForIntent, String passwordForIntent) {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("EmailAddress", emailAddressForIntent);
        bundle.putString("Password", passwordForIntent);
        intent.putExtra("RegisteredData", bundle);
        startActivityForResult(intent,REGISTERED_DATA);
    }

    private void openDialogShowResult() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(R.string.title_dialog);
        alertDialog.setMessage(getResources().getString(R.string.message_dialog));

        alertDialog.setButton(getResources().getString(R.string.next_activity), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        alertDialog.show();
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
