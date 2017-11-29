package com.hksapps.nations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
        String area_text =  getIntent().getStringExtra("area");
        String numericcode_text =  getIntent().getStringExtra("numericcode");
        String currencies_text =  getIntent().getStringExtra("currencies");
        String nativename_text =  getIntent().getStringExtra("nativename");
        String borders_text =  getIntent().getStringExtra("borders");

        Toast.makeText(this, latlng_text, Toast.LENGTH_SHORT).show();
        population.setText(currencies_text.replace("Ajju_Selena_Kuttan",","));
        country.setText(nativename_text);
        capital.setText(area_text);


        Log.e("country_text",country_text);
        Log.e("population_text",population_text);
        Log.e("region_text",region_text);
        Log.e("subregion_text",subregion_text);
        Log.e("capital_text",capital_text);
        Log.e("flag_text",flag_text);
        Log.e("callingCode_text",callingCode_text);
        Log.e("latlng_text",latlng_text);
        Log.e("timezone_text",timezone_text);
        Log.e("language_text",language_text);
        Log.e("area_text",area_text);
        Log.e("numericcode_text",numericcode_text);
        Log.e("currencies_text",currencies_text);
        Log.e("nativename_text",nativename_text);
        Log.e("borders_text",borders_text);












    }
}
