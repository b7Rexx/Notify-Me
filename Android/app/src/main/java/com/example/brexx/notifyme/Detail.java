package com.example.brexx.notifyme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Detail extends AppCompatActivity {


    TextView textSubject,textDate,textBody,textSender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Intent intent = getIntent();
        String selected_subject = intent.getExtras().getString("detail_subject");
        String selected_date = intent.getExtras().getString("detail_date");
        String selected_body = intent.getExtras().getString("detail_body");
        String select_sender = intent.getExtras().getString("detail_sender");

        textSubject = (TextView) findViewById(R.id.subject_detail);
        textDate = (TextView) findViewById(R.id.date_detail);
        textBody = (TextView) findViewById(R.id.body_detail);
        textSender = (TextView)findViewById(R.id.sender_detail);

        textSubject.setText(selected_subject);
        textDate.setText(selected_date);
        textBody.setText(selected_body);
        textSender.setText(select_sender);
    }
}