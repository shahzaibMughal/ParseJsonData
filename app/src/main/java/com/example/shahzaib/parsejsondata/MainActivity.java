package com.example.shahzaib.parsejsondata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String jsonString = " " +
            "{" +
                "\"screenSize\":5.2, " +
                "\"rooted\":false," +
                "\"company\":\"motorola\"," + "" +
                "\"features\":" +
                "{" +
                    "\"hardwareFeatures\":[\"Front Camera\",\"Back Camera\",\"Multi Touch\"]," +
                    "\"color\":\"black\"" +
                "}" +
            "}";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("1234",jsonString);

        try {

            JSONObject jsonObject = new JSONObject(jsonString);
            String mobileCompany = jsonObject.getString("company");
            double screenSize = jsonObject.getDouble("screenSize");
            boolean isRooted = jsonObject.getBoolean("rooted");
            String color = jsonObject.getJSONObject("features").getString("color");

            ArrayList<String> stringArrayList = new ArrayList<>();
            for(int i=0; i<jsonObject.getJSONObject("features").getJSONArray("hardwareFeatures").length(); i++)
            {
                stringArrayList.add((String) jsonObject.getJSONObject("features").getJSONArray("hardwareFeatures").get(i));
            }





            Log.i("1234","mobile Company    = "+mobileCompany);
            Log.i("1234","Screen Size       = "+screenSize);
            Log.i("1234","isRooted          = "+isRooted);
            Log.i("1234","color             = "+color);
            Log.i("1234","Features....");
            for(int i=0; i<stringArrayList.size(); i++)
            {
                Log.i("1234","Feature "+i+" = "+stringArrayList.get(i));
            }




        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
