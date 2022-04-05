package com.example.clientside;

import android.os.AsyncTask;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends AsyncTask<String, Void, String> {

    Socket s;
    PrintWriter pw;
    private BufferedReader in;
    String response;
    TextView returnedString;

    public Client(TextView txt) {
        this.returnedString = txt;
    }


    @Override
    protected String doInBackground(String... voids) {
        String message = voids[0];

        try {
            s = new Socket("10.0.2.2", Integer.parseInt("65432"));
            //sending data
            pw = new PrintWriter(s.getOutputStream());
            pw.write(message);
            pw.flush();
            //////////

            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            response= in.readLine();
            // System.out.println(response);

            pw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    @Override
    protected void onPostExecute(String s) {
        returnedString.setText(s);
    }
}
