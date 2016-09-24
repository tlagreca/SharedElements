package com.thomasjamesdev.thomas.sharedelementanimation;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.ChangeImageTransform;
import android.transition.Explode;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateList();
        setupLayout();
    }


    //Dummy Data
    private void populateList() {
        personList = new ArrayList<>();
        personList.add(new Person("Dean", "Martin", "24 Somewhere st Newtown", "1800444444"));
        personList.add(new Person("Frank", "Sinatra", "24 Someplace st McDonaldtown", "1800555555"));
        personList.add(new Person("Nat King", "Cole", "24 Somestreet st Stanmore", "1800366666"));
        personList.add(new Person("Nina", "Simone", "24 Someother st Lewisham", "1800777777"));
        personList.add(new Person("Ella", "FitzGerald", "18 Sesame st Petersham", "1800777888"));

    }
    private void setupLayout(){

        //Setting up RecyclerView.
        RecyclerView recList = (RecyclerView) findViewById(R.id.RecView);
        recList.setHasFixedSize(true);
        //Set the layout manager
        recList.setLayoutManager(new LinearLayoutManager(this));
        //Set the adapter.
        PersonAdapter personAdapter = new PersonAdapter(this, personList);
        recList.setAdapter(personAdapter);
    }

}
