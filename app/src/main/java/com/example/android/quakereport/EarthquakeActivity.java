
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
//        ArrayList<Earthquakes> earthquakes = new ArrayList<>();

        // Create a fake list of earthquakes.
        ArrayList<Earthquakes> earthquakes = QueryUtils.extractEarthquakes();

//        earthquakes.add(new Earthquakes(getString(R.string.test),"inn","inn"));
//        earthquakes.add(new Earthquakes("inn","inn","inn"));
//        earthquakes.add(new Earthquakes("inn","inn","inn"));
//        earthquakes.add(new Earthquakes("inn","inn","inn"));
//        earthquakes.add(new Earthquakes("inn","inn","inn"));
//        earthquakes.add(new Earthquakes("inn","inn","inn"));
//        earthquakes.add(new Earthquakes("inn","inn","inn"));
//        earthquakes.add(new Earthquakes("inn","inn","inn"));
//        earthquakes.add(new Earthquakes("inn","inn","inn"));
//        earthquakes.add(new Earthquakes("inn","inn","inn"));
//        earthquakes.add(new Earthquakes("inn","inn","inn"));

        final EarthquakesAdapter adapterEarthquakeList = new EarthquakesAdapter(this, earthquakes);


        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);


        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        assert earthquakeListView != null;
        earthquakeListView.setAdapter(adapterEarthquakeList);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                Earthquakes currentEarthquake = adapterEarthquakeList.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());

                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        })
    ;}
}
