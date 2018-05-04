package com.example.brexx.notifyme;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by bRexx on 5/29/2017.
 */

public class BackgroundWorker extends AsyncTask<String,Void,String> {
    Context context;
    private CallBAck listener;
    AlertDialog alertDialog;

    BackgroundWorker(Context ctx,CallBAck listener){
        context=ctx;

        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String login_url = AppConstants.IP_SET + "login.php";
        if (type.equals("login")) {
            try {
                String org_name = params[1];
                String org_pass = params[2];
                String alter_token = params[3];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("org_name", "UTF-8") + "=" + URLEncoder.encode(org_name, "UTF-8") + "&"
                        + URLEncoder.encode("org_pass", "UTF-8") + "=" + URLEncoder.encode(org_pass, "UTF-8") + "&"
                        + URLEncoder.encode("alterorg", "UTF-8") + "=" + URLEncoder.encode(alter_token, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @Override
    protected void onPreExecute() {
        alertDialog =new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String aVoid) {
        alertDialog.setMessage(aVoid);
        alertDialog.show();

        if(aVoid.equals("success")) {
            listener.onSuccess();
            Toast.makeText(context, "Welcome",Toast.LENGTH_SHORT).show();


        }
        else
        {
            Toast.makeText(context,"Failed to Login",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
