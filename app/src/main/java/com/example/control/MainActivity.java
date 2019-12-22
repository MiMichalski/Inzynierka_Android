package com.example.control;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class MainActivity extends AppCompatActivity{

    public static boolean hasAdminRights = false;
    public static String message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread recServerThread = new Thread(new ServerListener(getApplicationContext()));
        recServerThread.start();

    }

    public void commandOpen(View view){
        ConnectionSend.sendWidth("100");
    }

    public void commandClose(View view){
        ConnectionSend.sendWidth("0");
    }

    public void commandPercent(View view){
        //sendMsg();
    }

    public void commandMode(View view){
        ConnectionSend.sendMsg("mode", "1", "client");
    }

    public void commandSettings(View view){
        if(hasAdminRights == true){
            Intent intent = new Intent(this, ConfigActivity.class);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

    }


}
