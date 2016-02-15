package com.sqldexter.gcmnetworking;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by HOME on 14-02-2016.
 */
public class HelperUtility {
    private static final String TAG = HelperUtility.class.getSimpleName();

    public static InputStream hitURL(String resourceURL, String requestMethod, String contentType) {
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        URL url = null;
        try {
            url = new URL(resourceURL);
            urlConnection = (HttpURLConnection) url.openConnection();

//            optional request header
            urlConnection.setRequestProperty("Content-Type", contentType);
//          optional request header
            urlConnection.setRequestProperty("Accept", contentType);

            urlConnection.setRequestMethod(requestMethod);

            int statusCode = urlConnection.getResponseCode();
            //         200 represents HTTP OK
//        201 represents HTTP Created used in successful reponse for POST, PUT, PATCH
            if (statusCode == 200 || statusCode == 201) {

                inputStream = new BufferedInputStream(urlConnection.getInputStream());
                return inputStream; // Successful

            } else {
//                failed to fetch data
                Log.e(TAG, "Failed to fetch data. Status Code=" + statusCode);
            }
        } catch (Exception e) {
            Log.e(TAG, "Method - hitURL. setRequestMethod Exception message=" + e.getLocalizedMessage());
            e.printStackTrace();
        }

        return inputStream;

    }

    public static String convertIStoString(InputStream is) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        String line = "";
        String result = "";
        while ((line = bufferedReader.readLine()) != null) {
            result += line;
        }
        if (null != is) {
            is.close();
        }
        return result;
    }

    public static void makeCall(Activity activity, String contactNo) {
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

            return;
        }
        activity.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + contactNo)));

    }


}
