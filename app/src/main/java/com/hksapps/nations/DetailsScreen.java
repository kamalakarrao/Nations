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

        String  country_text =  getIntent().getStringExtra("country");
        String  population_text =  getIntent().getStringExtra("population");
        String  region_text =  getIntent().getStringExtra("region");
        String  subregion_text =  getIntent().getStringExtra("subregion");
        String  capital_text =  getIntent().getStringExtra("capital");
        String  flag_text =  getIntent().getStringExtra("flag");


        population.setText(population_text);
        country.setText(country_text);
        capital.setText(capital_text);

    }
}
