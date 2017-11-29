package com.hksapps.nations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

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
        String callingCode_text =  getIntent().getStringExtra("callingcode");
        String latlng_text =  getIntent().getStringExtra("latlng");
        String timezone_text =  getIntent().getStringExtra("timezone");
        String language_text =  getIntent().getStringExtra("language");

        Toast.makeText(this, language_text, Toast.LENGTH_SHORT).show();
        population.setText(population_text);
        country.setText(country_text);
        capital.setText(capital_text);

    }
}
