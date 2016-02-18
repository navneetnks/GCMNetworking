package com.sqldexter.gcmnetworking;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.sqldexter.gcmnetworking.model.ApiDataObject;
import com.sqldexter.gcmnetworking.model.Truck;

import org.json.JSONObject;

import java.io.InputStream;

public class Bidding extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = Bidding.class.getSimpleName();
    private ProgressBar mNetworkProgressBar;
    private TextView textViewApiData, textViewPostId, textViewPickupDate,textViewprefRoute,
    textViewLowestRate,textViewHighestRate,textViewBid;
    private Button buttonUpdate ;
    LinearLayout ll;
    private RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bidding);
        rl = (RelativeLayout) findViewById(R.id.rl);
        rl.setVisibility(View.INVISIBLE);
        mNetworkProgressBar = (ProgressBar) findViewById(R.id.networkProgressBar);
        new AsyncHttpTask().execute("https://jsonblob.com/api/jsonBlob/569a05b3e4b01190df49b82f");
//        textViewApiData=(TextView)findViewById(R.id.apiDataTextView);
        textViewPostId = (TextView) findViewById(R.id.textViewPostId);
        textViewPickupDate = (TextView) findViewById(R.id.textViewPickupDate);
        textViewprefRoute = (TextView) findViewById(R.id.textViewprefRoute);
        textViewLowestRate = (TextView) findViewById(R.id.textViewLowestRate);
        textViewHighestRate = (TextView) findViewById(R.id.textViewHighestRate);
        textViewBid = (TextView) findViewById(R.id.textViewBid);
        buttonUpdate=(Button)findViewById(R.id.buttonUpdate);
        ll = (LinearLayout) findViewById(R.id.llVehicle);
        FloatingActionButton booked = (FloatingActionButton) findViewById(R.id.fab);
        booked.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fab) {
            startActivity(new Intent(this, BookedActivity.class));
        }
    }



    public class AsyncHttpTask extends AsyncTask<String, Void, JSONObject> {

        @Override
        protected JSONObject doInBackground(String... params) {
            InputStream responseStream = HelperUtility.hitURL(params[0], "GET", "application/json");
            JSONObject jsonObject = null;
            try {
                String responseText = HelperUtility.convertIStoString(responseStream);
                jsonObject = new JSONObject(responseText);
            } catch (Exception e) {
                Log.e(TAG, "Exception at parsing response. Message=" + e.getLocalizedMessage());
                e.printStackTrace();
            }
            return jsonObject;
        }


        @Override
        protected void onPostExecute(JSONObject result) {
            mNetworkProgressBar.setVisibility(View.GONE);
//            textViewApiData.setText(result.toString());
            ApiDataObject apiDataObject = new Gson().fromJson(result.toString(), ApiDataObject.class);
            textViewPostId.setText("" + apiDataObject.getId());
            textViewPickupDate.setText(apiDataObject.getTrucker_request().getPickup_date());
            Log.d(TAG, "nav test" + new Gson().toJson(apiDataObject));
            for(Truck truck:apiDataObject.getTrucks()){
                TextView tv=new TextView(getBaseContext());
                tv.setText(truck.getTruck_number());
                tv.setTextColor(Color.BLACK);
                ll.addView(tv);
            }
            textViewprefRoute.setText(apiDataObject.getRoute_start()+" to "+apiDataObject.getRoute_end());
            textViewLowestRate.setText(""+apiDataObject.getBooking_price());
            textViewHighestRate.setText(""+apiDataObject.getLoad().getQuoted_price());
            textViewBid.setText(""+apiDataObject.getTrucker_request().getQuoted_price());

            rl.setVisibility(View.VISIBLE);
            Log.d(TAG, "result=" + result);
        }
    }

}

