package com.hksapps.nations;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hksapps.nations.SvgLoaders.LoadSvgs;

import java.util.Locale;

public class DetailsScreen extends AppCompatActivity {

    String Latitude,Longitude;

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

        Button map = (Button) findViewById(R.id.map);

        Intent i = getIntent();

        String country_text = getIntent().getStringExtra("country");

        setTitle(country_text);

        String population_text = getIntent().getStringExtra("population");
        String region_text = getIntent().getStringExtra("region");
        String subregion_text = getIntent().getStringExtra("subregion");
        String capital_text = getIntent().getStringExtra("capital");
        String flag_text = getIntent().getStringExtra("flag");
        String callingCode_text = getIntent().getStringExtra("callingcode");


        String latlng_text_all = getIntent().getStringExtra("latlng").replace("$", ",");
        String latlng_text = "";
        if (latlng_text_all.length() > 2 && latlng_text_all.contains(",")) {
            String[] latlng_array = latlng_text_all.split(",");


Latitude = latlng_array[0];
Longitude = latlng_array[1];
            latlng_text = "Lat: " + latlng_array[0] + "\n" + "Lng: " + latlng_array[1];
        }

        String timezone_text = getIntent().getStringExtra("timezone");


        String language_text_all = getIntent().getStringExtra("language");
        String language_text = "";
        if (language_text_all.length() > 2 && language_text_all.contains("$")) {
            String language_text_1 = language_text_all.substring(0, language_text_all.length() - 1);
            language_text = language_text_1.replace("$", " ,\n") + ".";
        }

        String area_text = getIntent().getStringExtra("area");
        String numericcode_text = getIntent().getStringExtra("numericcode");

        String currencies_text_all = getIntent().getStringExtra("currencies");
        String currencies_text = "";
        if (currencies_text_all.length() > 5 && currencies_text_all.contains("Ajju_Selena_Kuttan")) {
            String[] currenciesArray = currencies_text_all.split("Ajju_Selena_Kuttan");

            currencies_text = "Code: " + currenciesArray[0] + "\n" + "Name: " + currenciesArray[1] + "\n" + "Symbol: " + currenciesArray[2];
        }

        String nativename_text = getIntent().getStringExtra("nativename");
        String borders_text_all = getIntent().getStringExtra("borders");

        String borders_text = "";
        if (borders_text_all.length() > 2 && borders_text_all.contains("$")) {
            String borders_text_1 = borders_text_all.substring(0, borders_text_all.length() - 1);
            borders_text = borders_text_1.replace("$", " ,") + ".";
        }

        //  Toast.makeText(this, latlng_text, Toast.LENGTH_SHORT).show();
        population.setText(population_text);
        country.setText(country_text);
        capital.setText(capital_text);
        if (region_text.equals("") || region_text == null) {
            region.setText("Not Available");
        } else {
            region.setText(region_text);
        }


        if (subregion_text.equals("") || subregion_text == null) {
            subregion.setText("Not Available");
        } else {
            subregion.setText(subregion_text);
        }


        if (callingCode_text.equals("") && callingCode_text == null) {

            calling__code.setText("Not Available");
        } else {
            calling__code.setText(callingCode_text);
        }


        if (lat_lng_coordinates.equals("") || lat_lng_coordinates == null) {
            lat_lng_coordinates.setText("Not Available");
        } else {
            lat_lng_coordinates.setText(latlng_text);

        }


        if (timezone_text.equals("") || timezone_text == null) {
            timezone.setText("Not Available");
        } else {
            timezone.setText(timezone_text);
        }


        if (language_text.equals("") || language_text == null) {
            languages.setText("Not Available");

        } else {
            languages.setText(language_text);

        }

        if (area_text.equals("") || area_text == null) {
            area.setText("Not Available");

        } else {
            area.setText(area_text);

        }


        if (numericcode_text.equals("") || numericcode_text == null) {
            numeric_code.setText("Not Available");
        } else {
            numeric_code.setText(numericcode_text);
        }


        if (currencies_text.equals("") && currencies_text == null) {
            currencies.setText("Not Available");
        } else {
            currencies.setText(currencies_text);

        }


        if (nativename_text.equals("") || nativename_text == null) {
            native_name.setText("Not Available");
        } else {
            native_name.setText(nativename_text);
        }


        if (borders_text.equals("") || borders_text == null) {
            borders.setText("Not Available");
        } else {
            borders.setText(borders_text);

        }

        LoadSvgs svgs = new LoadSvgs();
        svgs.LoadImages(flag_text, flag, this);



        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
if(Latitude.length()>0&&Longitude.length()>0){

    String uri = String.format(Locale.ENGLISH, "geo:%f,%f", Double.parseDouble(Latitude), Double.parseDouble(Longitude));
    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
    startActivity(intent);

}
            }
        });



        Log.e("country_text", country_text);
        Log.e("population_text", population_text);
        Log.e("region_text", region_text);
        Log.e("subregion_text", subregion_text);
        Log.e("capital_text", capital_text);
        Log.e("flag_text", flag_text);
        Log.e("callingCode_text", callingCode_text);
        Log.e("latlng_text", latlng_text);
        Log.e("timezone_text", timezone_text);
        Log.e("language_text", language_text);
        Log.e("area_text", area_text);
        Log.e("numericcode_text", numericcode_text);
        Log.e("currencies_text", currencies_text);
        Log.e("nativename_text", nativename_text);
        Log.e("borders_text", borders_text);


    }
}
