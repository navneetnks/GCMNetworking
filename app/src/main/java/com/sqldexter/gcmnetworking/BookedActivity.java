package com.sqldexter.gcmnetworking;

import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BookedActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG=BookedActivity.class.getSimpleName();
    private Button callToButton;
    private String contactNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked);
//        getActionBar().setDisplayHomeAsUpEnabled(true);
        callToButton=(Button)findViewById(R.id.callToButton1);
        contactNum="+919555628797";
        callToButton.setText("Call "+contactNum);
        callToButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.callToButton1) {
            HelperUtility.makeCall(this, contactNum);
            Log.d(TAG,"clicked on callToTextView");
        }
    }
}
