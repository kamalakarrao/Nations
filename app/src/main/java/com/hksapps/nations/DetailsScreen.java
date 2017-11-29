package com.hksapps.nations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_screen);

        TextView population = (TextView) findViewById(R.id.population);
        TextView country = (TextView) findViewById(R.id.country_detail);
        TextView capital = (TextView) findViewById(R.id.capital);

        Intent i = getIntent();

        NationObject countryDetails = (NationObject) getIntent().getSerializableExtra("mylist");


        population.setText(countryDetails.getPopulation().toString());
        country.setText(countryDetails.getCountry().toString());
        capital.setText(countryDetails.getCapital().toString());

    }
}
