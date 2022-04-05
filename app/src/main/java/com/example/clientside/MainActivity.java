package com.example.clientside;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText stringSent = (EditText) findViewById(R.id.string);
        Button sendBtn = (Button) findViewById(R.id.btnsend);
        TextView returned = (TextView) findViewById(R.id.returned);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Client client = new Client(returned);
                if (stringSent.getText().toString().isEmpty()) {
                    stringSent.setError("Please enter a string");
                }
                client.execute(stringSent.getText().toString());
                stringSent.getText().clear();
            }

        });
    }


}