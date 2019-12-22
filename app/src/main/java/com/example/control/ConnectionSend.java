package com.example.control;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionSend extends AsyncTask<String, Void, Void> {

    Socket s;
    PrintWriter pw;

    public static void sendMsg(String command, String parm, String tag){

        String message = command + "," + parm + "," + tag;
        ConnectionSend connectionSend = new ConnectionSend();
        connectionSend.execute(message);
    }
    public static void sendWidth(String perc){
        String message = "set," + perc;
        ConnectionSend connectionSend = new ConnectionSend();
        connectionSend.execute(message);
    }

    public static void sendPassword(String pass){
        String message = "login," + pass;
        ConnectionSend connectionSend = new ConnectionSend();
        connectionSend.execute(message);
    }

    public static void handshake(){
        String message = "IsItYou?";
        ConnectionSend connectionSend = new ConnectionSend();
        connectionSend.execute(message);
    }


    @Override
    protected Void doInBackground(String... strings) {

        String message = strings[0];
        try {
            s = new Socket("192.168.4.1", 8080);
            pw = new PrintWriter(s.getOutputStream());
            pw.write(" " + message);
            pw.flush();
            pw.close();
            s.close();

        }catch (IOException e){
            e.printStackTrace();
        }
        return null;

    }
}

