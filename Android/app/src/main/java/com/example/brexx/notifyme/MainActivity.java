package com.example.brexx.notifyme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements CallBAck{

    EditText orgname, orgpass;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        orgname = (EditText) findViewById(R.id.et_orgname);
        orgpass = (EditText) findViewById(R.id.et_orgpass);
        button = (Button) findViewById(R.id.orglogin);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AppConstants.ORGNAME = orgname.getText().toString();
                String org_name = orgname.getText().toString();
                String org_pass = orgpass.getText().toString();
                String type = "login";

                LoginPrefManager.getInstance(getApplicationContext()).putLoginID(org_name);
                LoginPrefManager.getInstance(getApplicationContext()).putLoginPass(org_pass);

                String alter_token = SharedPrefManager.getInstance(getApplicationContext()).getDeviceToken();
                execute(org_name,org_pass,type,alter_token);


            }
        });


        String check = LoginPrefManager.getInstance(getApplicationContext()).getLoginStatus();
        if(check.equals("true")){
            AppConstants.ORGNAME = LoginPrefManager.getInstance(getApplicationContext()).getLoginID();
            AppConstants.ORGPASS = LoginPrefManager.getInstance(getApplicationContext()).getLoginPass();
            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        }

    }

    private void execute(String org_name,String org_pass,String type,String alter_token) {
        BackgroundWorker backgroundWorker = new BackgroundWorker(MainActivity.this,this);
        backgroundWorker.execute(type, org_name, org_pass, alter_token);
    }

    @Override
    public void onSuccess() {
        Intent intent =new Intent(this,HomeActivity.class);
       startActivity(intent);
        finish();
    }
}