package com.example.brexx.notifyme;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Created by bRexx on 5/29/2017.
 */

public class HomeActivity extends AppCompatActivity {

    private String TAG = HomeActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private String listurl = AppConstants.IP_SET+"noticelist.php";
    private ListView listView;

    Button pin_btn,refresh_home;
    ArrayList<HashMap<String, String>> noticeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        noticeList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.notice_list);
        LoginPrefManager.getInstance(getApplicationContext()).putLoginStatus("true");
        String login_info = LoginPrefManager.getInstance(getApplication()).getLoginID();
        TextView login_inf =(TextView)findViewById(R.id.login_info);
        login_inf.setText(login_info);
        new GetNotice().execute();

        pin_btn=(Button)findViewById(R.id.pin_button);
        pin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomeActivity.this,PinnedActivity.class);
                startActivity(i);
            }
        });

        refresh_home=(Button)findViewById(R.id.home_button);
        refresh_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
            }
        });

    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mymenu = getMenuInflater();
        mymenu.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about_us:
                Toast.makeText(this,"Developed by. Notify-Me Team",Toast.LENGTH_LONG).show();
                break;

            case R.id.notes:
                Intent intent = new Intent(HomeActivity.this,NoteActivity.class);
                startActivity(intent);
                break;

            case R.id.logout:
                LoginPrefManager.getInstance(getApplicationContext()).ClearLogin();
                Intent j=new Intent(HomeActivity.this,MainActivity.class);
                startActivity(j);
                finish();
                break;

            case R.id.exit:
                finish();
                break;
        }
        return false;
    }


    // Async Task to access the web
    private class GetNotice extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(HomeActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            HttpHandler httpHandler = new HttpHandler();
            String jsonStr = httpHandler.makeServiceCall(listurl);
            Log.e(TAG, "Response from url:" + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    // Getting JSON Array node
                    JSONArray notice = jsonObj.getJSONArray("notice");
                    // looping through All Contacts
                    for (int i = 0; i < notice.length(); i++) {
                        JSONObject c = notice.getJSONObject(i);

                        String id = c.getString("id");
                        String date = c.getString("date");
                        String subject = c.getString("subject");
                        String body = c.getString("body");
                        String sender = c.getString("sender");

                        // tmp hash map for single contact
                        HashMap<String, String> notices = new HashMap<>();

                        // adding each child node to HashMap key => value
                        notices.put("id", id);
                        notices.put("date", date);
                        notices.put("subject", subject);
                        notices.put("body", body);
                        notices.put("sender",sender);

                        // adding notice to notice list
                        noticeList.add(notices);
                    }
                }    catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Json parsing error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            final ListAdapter adapter = new SimpleAdapter(HomeActivity.this, noticeList,R.layout.list_item,
                    new String[]{"date", "subject"},
                    new int[]{R.id.dateView,R.id.subjectView});

            listView.setAdapter(adapter);
          listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selected_subject= noticeList.get(position).get("subject");
                String selected_date = noticeList.get(position).get("date");
                String selected_body= noticeList.get(position).get("body");
                String selected_sender= noticeList.get(position).get("sender");
                Intent intent =new Intent(HomeActivity.this,Detail.class);
                intent.putExtra("detail_subject",selected_subject);
                intent.putExtra("detail_date",selected_date);
                intent.putExtra("detail_body",selected_body);
                intent.putExtra("detail_sender",selected_sender);
                HomeActivity.this.startActivity(intent);
            }
        });
    }
        }

    @Override
    public void onBackPressed() {

        super.onBackPressed();

    }
}
