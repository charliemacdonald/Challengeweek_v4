package com.ipmedt4.challengeweek_v2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Loginscherm extends ActionBarActivity implements View.OnClickListener {


        private EditText user, pass;
        private Button mSubmit, mRegister;

        // Progress Dialog
        private ProgressDialog pDialog;

        // JSON parser class
        JSONParser jsonParser = new JSONParser();
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String username = "username";
    public static final String password = "password";
    SharedPreferences sharedpreferences;



    //testing on Emulator:
        private static final String LOGIN_URL = "http://charlenemacdonald.com/login.php";

        //testing from a real server:
        //private static final String LOGIN_URL = "http://www.yourdomain.com/webservice/login.php";

        //JSON element ids from repsonse of php script:
        private static final String TAG_SUCCESS = "success";
        private static final String TAG_MESSAGE = "message";

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginscherm);
    }
        @Override
        protected void onResume() {
            sharedpreferences = getSharedPreferences(MyPREFERENCES,
                    Context.MODE_PRIVATE);
            if (sharedpreferences.contains(username)) {
                if (sharedpreferences.contains(password)) {
                    Intent i = new Intent(Loginscherm.this, Beginscherm.class);
                    startActivity(i);
                }
            }
            super.onResume();


            //setup input fields
            user = (EditText) findViewById(R.id.emailveld);
            pass = (EditText) findViewById(R.id.wachtwoordveld);

            //setup buttons
            mSubmit = (Button) findViewById(R.id.aanmeldknop);
            mRegister = (Button) findViewById(R.id.aanmeldknop);

            //register listeners
            mSubmit.setOnClickListener(this);
            mRegister.setOnClickListener(this);


        }
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch (v.getId()) {
                case R.id.aanmeldknop:
                    new AttemptLogin().execute();
                    break;


                default:
                    break;
            }
        }

        class AttemptLogin extends AsyncTask<String, String, String> {


             boolean failure = false;

             @Override
             protected void onPreExecute() {
             super.onPreExecute();
             pDialog = new ProgressDialog(Loginscherm.this);
             pDialog.setMessage("Inloggen");
             pDialog.setIndeterminate(false);
             pDialog.setCancelable(true);
             pDialog.show();
             }

             @Override
             protected String doInBackground(String... args) {
             // TODO Auto-generated method stub
             // Check for success tag
             int success;
             String username = user.getText().toString();
             String password = pass.getText().toString();
             try {
             // Building Parameters
             List<NameValuePair> params = new ArrayList<NameValuePair>();
             params.add(new BasicNameValuePair("username", username));
             params.add(new BasicNameValuePair("password", password));

             Log.d("request!", "starting");
             // getting product details by making HTTP request
             JSONObject json = jsonParser.makeHttpRequest(
             LOGIN_URL, "POST", params);

             // check your log for json response
             Log.d("Login attempt", json.toString());

             // json success tag
             success = json.getInt(TAG_SUCCESS);
             if (success == 1) {
                 SharedPreferences.Editor editor = sharedpreferences.edit();
                 String u = user.getText().toString();
                 String p = pass.getText().toString();
                 editor.putString(String.valueOf(user), u);
                 editor.putString(String.valueOf(pass), p);
                 editor.commit();
                 Intent i = new Intent(Loginscherm.this, Beginscherm.class);
                 startActivity(i);

             Log.d("Login Successful!", json.toString());

          
             return json.getString(TAG_MESSAGE);

             } else {
             Log.d("Login Failure!", json.getString(TAG_MESSAGE));
             return json.getString(TAG_MESSAGE);

             }
             } catch (JSONException e) {
             e.printStackTrace();
             }

             return null;

             }
             /**
              * After completing background task Dismiss the progress dialog
             */
            protected void onPostExecute(String file_url) {
                // dismiss the dialog once product deleted
                pDialog.dismiss();
                if (file_url != null){
                    Toast.makeText(Loginscherm.this, file_url, Toast.LENGTH_LONG).show();
                }

            }

        }

    }



