package com.hksapps.nations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hksapps.nations.SvgLoaders.LoadSvgs;

public class DetailsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_screen);

        TextView population = (TextView) findViewById(R.id.population_xml);
        TextView country = (TextView) findViewById(R.id.country_xml);
        TextView region = (TextView) findViewById(R.id.region_xml);
        TextView subregion = (TextView) findViewById(R.id.subregion_xml);
        ImageView flag = (ImageView) findViewById(R.id.flag_img);
        TextView capital = (TextView) findViewById(R.id.capital_xml);
        TextView calling__code = (TextView) findViewById(R.id.callingcode_xml);
        TextView lat_lng_coordinates = (TextView) findViewById(R.id.latlng_xml);
        TextView timezone = (TextView) findViewById(R.id.timezone_xml);
        TextView area = (TextView) findViewById(R.id.area_xml);
        TextView numeric_code = (TextView) findViewById(R.id.numericcode_xml);
        TextView currencies = (TextView) findViewById(R.id.currencies_xml);
        TextView native_name = (TextView) findViewById(R.id.nativename_xml);
        TextView borders = (TextView) findViewById(R.id.borders_xml);
        TextView languages = (TextView) findViewById(R.id.languages_xml);

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
        population.setText(population_text);
        country.setText(country_text);
        capital.setText(capital_text);
        region.setText(region_text);
        subregion.setText(subregion_text);
        calling__code.setText(callingCode_text);
        lat_lng_coordinates.setText(latlng_text);
        timezone.setText(timezone_text);
        languages.setText(language_text);
        area.setText(area_text);
        numeric_code.setText(numericcode_text);
        currencies.setText(currencies_text);
        native_name.setText(nativename_text);
        borders.setText(borders_text);

        LoadSvgs svgs = new LoadSvgs();
        svgs.LoadImages(flag_text,flag,this);


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
