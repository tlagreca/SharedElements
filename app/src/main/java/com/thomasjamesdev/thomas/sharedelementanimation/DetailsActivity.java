package com.thomasjamesdev.thomas.sharedelementanimation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by Thomas on 22/09/2016.
 */

public class DetailsActivity extends Activity {

    TextView tvFirstName, tvLastName, tvAddress, tvPhone;

    //Remember to add the new activity to the manifest.

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //Find the view items
        tvFirstName = (TextView)findViewById(R.id.txt_first_name_details);
        tvLastName = (TextView)findViewById(R.id.txt_last_name);
        tvAddress = (TextView)findViewById(R.id.txt_address);
        tvPhone = (TextView)findViewById(R.id.txt_phone);

        //Get the intent that started the activity
        Intent intent = getIntent();

        //Set extras to the textViews.
        tvFirstName.setText(intent.getStringExtra("firstName"));
        tvLastName.setText(intent.getStringExtra("lastName"));
        tvAddress.setText(intent.getStringExtra("address"));
        tvPhone.setText(intent.getStringExtra("phone"));

    }
}
