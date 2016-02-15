package com.sqldexter.gcmnetworking;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.InputStream;

public class Bidding extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG= Bidding.class.getSimpleName();
    private ProgressBar mNetworkProgressBar;
    private TextView textViewApiData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bidding);
        mNetworkProgressBar =(ProgressBar)findViewById(R.id.networkProgressBar);
        new AsyncHttpTask().execute("https://jsonblob.com/api/jsonBlob/569a05b3e4b01190df49b82f");
        textViewApiData=(TextView)findViewById(R.id.apiDataTextView);
        FloatingActionButton booked=(FloatingActionButton)findViewById(R.id.fab);
        booked.setOnClickListener(this);
        Log.d(TAG,"on create called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "on create onResume");
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.fab){
            startActivity(new Intent(this,BookedActivity.class));
        }
    }

    public class AsyncHttpTask extends AsyncTask<String, Void, JSONObject> {

        @Override
        protected JSONObject doInBackground(String... params) {
            InputStream responseStream=HelperUtility.hitURL(params[0],"GET","application/json");
            JSONObject jsonObject=null;
            try {
                String responseText = HelperUtility.convertIStoString(responseStream);
                jsonObject = new JSONObject(responseText);
            }catch (Exception e){
                Log.e(TAG,"Exception at parsing response. Message="+e.getLocalizedMessage());
                e.printStackTrace();
            }
           return jsonObject;
        }


        @Override
        protected void onPostExecute(JSONObject result) {
            mNetworkProgressBar.setVisibility(View.GONE);
            textViewApiData.setText(result.toString());
            Log.d(TAG,"result="+result);
        }
    }

}
