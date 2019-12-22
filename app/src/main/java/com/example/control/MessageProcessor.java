package com.example.control;

import android.os.Handler;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MessageProcessor {


    public void processMessage(final String message) {
        final ArrayList aList = new ArrayList(Arrays.asList(message.split(",")));
        String command = aList.get(0).toString();
        switch (command) {
            case "ItsMe!":
                break;
            case "login":
                LoginActivity loginActivity = new LoginActivity();
                if (aList.get(1).toString() == "1") {
                    loginActivity.loginSuccess();
                } else {
                    loginActivity.loginFailed();
                }
                break;
            case "pos":
                break;
            default:
                break;
        }
    }

}
