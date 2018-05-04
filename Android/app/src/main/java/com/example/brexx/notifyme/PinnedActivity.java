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
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bRexx on 7/1/2017.
 */

public class PinnedActivity extends AppCompatActivity {

    private String TAG = PinnedActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private String pinned_url = AppConstants.IP_SET + "pinnedlist.php";
    private ListView list_View;
    private ListAdapter adapter;
    Button refresh_pinned;


    ArrayList<HashMap<String, String>> pinnedList, searchData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pinned_activity);

        pinnedList = new ArrayList<>();
        list_View = (ListView) findViewById(R.id.pinned_notice_list);
        new GetNotice().execute();

        refresh_pinned = (Button) findViewById(R.id.pinned_button);
        refresh_pinned.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
    }

    // Async Task to access the web
    private class GetNotice extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(PinnedActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            HttpHandler httpHandler = new HttpHandler();
            String jsonStr = httpHandler.makeServiceCall(pinned_url);
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
                        pinnedList.add(notices);
                    }
                } catch (final JSONException e) {
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
            final ListAdapter adapter = new SimpleAdapter(PinnedActivity.this, pinnedList, R.layout.list_item,
                    new String[]{"date", "subject"},
                    new int[]{R.id.dateView, R.id.subjectView});

            list_View.setAdapter(adapter);
//
            list_View.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String selected_subject = pinnedList.get(position).get("subject");
                    String selected_date = pinnedList.get(position).get("date");
                    String selected_body = pinnedList.get(position).get("body");
                    String selected_sender= pinnedList.get(position).get("sender");
                    Intent intent = new Intent(PinnedActivity.this, Detail.class);
                    intent.putExtra("detail_subject", selected_subject);
                    intent.putExtra("detail_date", selected_date);
                    intent.putExtra("detail_body", selected_body);
                    intent.putExtra("detail_sender",selected_sender);
                    PinnedActivity.this.startActivity(intent);
                    //Toast.makeText(PinnedActivity.this,"it works",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

//-----------------------------     SEARCH  -----------------
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_search_list,menu);
//        MenuItem search_item=menu.findItem(R.id.item_search);
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search_item);
//        searchData=new ArrayList<>();
//        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
//            @Override
//            public boolean onClose() {
//                ListAdapter listAdapter=new ListAdapter (pinnedList,PinnedActivity.this);
//
//                return false;
//            }
//        });
//
//  searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//@Override
//public boolean onQueryTextSubmit(String query) {
//    ArrayList<String> templist = new ArrayList<String>();
//    searchData.clear();
//    if(query.equals("")){
//        searchData=data;
//
//    }
//    for (String temp : englishWords){
//        if (temp.toLowerCase().contains(query.toLowerCase())){
//            templist.add(temp);
//            for(int i=0;i<=englishWords.size()-1;i++){
//                if(data.get(i).getEnglish().contains(temp)) {
//                    searchData.add(data.get(i));
//                }}
//        }
//    }
//    Log.e("TAG",query);
//
//
//    ListEnglishLanguageAdapter listAdapter=new ListEnglishLanguageAdapter(searchData,ContentInListView.this);
//    recyclerView.setAdapter(listAdapter);
//    return true;
//
//}
//
//    @Override
//    public boolean onQueryTextChange(String newText) {
//        if(newText.equals("")) {
//            ListEnglishLanguageAdapter listAdapter = new ListEnglishLanguageAdapter(data, ContentInListView.this);
//            recyclerView.setAdapter(listAdapter);}
//        return false;
//
//    }
//});
//
//        return super.onCreateOptionsMenu(menu);}
////
//
//}
