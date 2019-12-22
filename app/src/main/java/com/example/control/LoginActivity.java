package com.example.control;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class LoginActivity extends AppCompatActivity {

    private EditText password;
    public static String messageF = "Niepoprawne hasło!";
    public static String messageP = "Zalogowano";
    public static String messageA = "Logowanie";

    public static boolean newMsg = false;
    public static String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        MainActivity.context = getApplicationContext();
        password = findViewById(R.id.editText);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*0.8), (int)(height*0.4));

    }


    public void commandLogin(View view){
        ConnectionSend.sendPassword(password.getText().toString());
        Toast.makeText(getApplicationContext(), messageA, Toast.LENGTH_SHORT).show();
    }

    public void loginFailed(){
        Toast.makeText(this, messageF, Toast.LENGTH_SHORT).show();
    }

    public void loginSuccess(){
        Toast.makeText(this, messageP, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ConfigActivity.class);
        startActivity(intent);
        MainActivity.hasAdminRights = true;
    }
}
