package com.example.brexx.notifyme;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

/**
 * Created by bRexx on 7/16/2017.
 */
public class NoteActivity extends AppCompatActivity {
    private String TAG = PinnedActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private String note_url = AppConstants.IP_SET + "notelist.php";
    private ListView listView;
    Button refresh_note;
    ArrayList<HashMap<String, String>> noteList;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        noteList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.note_list);
        LoginPrefManager.getInstance(getApplicationContext()).putLoginStatus("true");
        String login_info = LoginPrefManager.getInstance(getApplication()).getLoginID();
        TextView login_inf =(TextView)findViewById(R.id.login_info1);
        login_inf.setText(login_info);
        new NoteActivity.GetNote().execute();

        refresh_note=(Button)findViewById(R.id.note_button);
        refresh_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });


    }

    private class GetNote extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(NoteActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            HttpHandler httpHandler = new HttpHandler();
            String jsonStr = httpHandler.makeServiceCall(note_url);
            Log.e(TAG, "Response from url:" + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    // Getting JSON Array node
                    JSONArray note = jsonObj.getJSONArray("notes");
                    // looping through All Contacts
                    for (int i = 0; i < note.length(); i++) {
                        JSONObject c = note.getJSONObject(i);

                        String id = c.getString("id");
                        String date = c.getString("date");
                        String subject = c.getString("subject");
                        String files = c.getString("files");
                        String sender = c.getString("sender");

                        // tmp hash map for single contact
                        HashMap<String, String> notes = new HashMap<>();

                        // adding each child node to HashMap key => value
                        notes.put("id", id);
                        notes.put("date", date);
                        notes.put("subject", subject);
                        notes.put("files", files);
                        notes.put("sender",sender);

                        // adding notice to notice list
                        noteList.add(notes);
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
            final ListAdapter adapter = new SimpleAdapter(NoteActivity.this, noteList,R.layout.list_item,
                    new String[]{"date", "subject"},
                    new int[]{R.id.dateView,R.id.subjectView});

            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String selected_subject= noteList.get(position).get("subject");
                    String selected_date = noteList.get(position).get("date");
                    String selected_file= noteList.get(position).get("files");
                    String selected_sender= noteList.get(position).get("sender");
                    Intent intent =new Intent(NoteActivity.this,Detail.class);
                    intent.putExtra("detail_subject",selected_subject);
                    intent.putExtra("detail_date",selected_date);
                    intent.putExtra("detail_body",selected_file);
                    intent.putExtra("detail_sender",selected_sender);
                    NoteActivity.this.startActivity(intent);
                }
            });
        }
    }
}
