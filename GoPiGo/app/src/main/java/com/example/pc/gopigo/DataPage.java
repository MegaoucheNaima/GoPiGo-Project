package com.example.pc.gopigo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 27/12/2016.
 */

public class DataPage extends Activity {

    private ProgressDialog pDialog;

    JSONParser jsonParser = new JSONParser();
    EditText editText;
    EditText editText2;

    String String_name = editText.getText().toString();
    String Int_Part = editText2.getText().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_activity);

        editText = (EditText) findViewById(R.id.Name);
        editText2 = (EditText) findViewById(R.id.part_nr);

    }

    public void Send(View view) {
        new Create_Part().execute();
    }

    class Create_Part extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            //String String_name = editText.getText().toString();
            //String Int_Part = editText2.getText().toString();

            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("Name", String_name));
            params.add(new BasicNameValuePair("part_nr", Int_Part));

            JSONObject json = jsonParser.makeHttpRequest("RaspberryPi_IP/db_create.php", "POST", params);

            try {
                int success = json.getInt("success");

                if (success == 1) {
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(DataPage.this);
            pDialog.setMessage("Sending part to the database...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }
        protected void onPostExecute(String file_url){
            pDialog.dismiss();
        }
    }
}
