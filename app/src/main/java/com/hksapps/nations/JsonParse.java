package com.hksapps.nations;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pranav on 26-11-2017.
 */
public class JsonParse {

    //Declare the arrays of fields you require
    public static String[] countries;
    public static String[] imageUrls;
    public static String[] capital;
    public static String[] region;
    public static String[] population;
    public static String[] lat_long;
    public static String[] subregion;
    public static String[] timezone;
    public static String[] language;
    public static String[] callingCode;
    public static String[] area;
    public static String[] nativename;
    public static String[] numericCode;
    public static String[] currencies;
    public static String[] borders;

    private JSONArray nations = null;


    List<NationObject> AllNations;


    private String json;

    public JsonParse(String json) {

        this.json = json;
    }

    protected void parseJSON() {
        JSONObject jsonObject = null;

        try {

            nations = new JSONArray(json);


            countries = new String[nations.length()];
            imageUrls = new String[nations.length()];
            capital = new String[nations.length()];
            region = new String[nations.length()];
            population = new String[nations.length()];
            lat_long = new String[nations.length()];
            subregion = new String[nations.length()];
            timezone = new String[nations.length()];
            language = new String[nations.length()];
            callingCode = new String[nations.length()];
            area = new String[nations.length()];
            nativename = new String[nations.length()];
            numericCode = new String[nations.length()];
            currencies = new String[nations.length()];
            borders = new String[nations.length()];


            AllNations = new ArrayList<NationObject>();


            for (int i = 0; i < nations.length(); i++) {
                NationObject nationObject = new NationObject();


                //  JSONArray array = nations.getJSONArray(0);

                jsonObject = nations.getJSONObject(i);


                countries[i] = jsonObject.getString("name");
                imageUrls[i] = jsonObject.getString("flag");
                capital[i] = jsonObject.getString("capital");
                region[i] = jsonObject.getString("region");
                population[i] = jsonObject.getString("population");
                subregion[i] = jsonObject.getString("subregion");
              /*  if(jsonObject.has("callingCodes")){
                    Log.e("countrycode",jsonObject.getJSONArray("callingCodes").getString(0)) ;

                }*/

                area[i] = jsonObject.optString("area");
                nativename[i] = jsonObject.optString("nativeName");
                numericCode[i] = jsonObject.optString("numericCode");

                currencies[i] = jsonObject.getJSONArray("currencies").getJSONObject(0).optString("code") + "Ajju_Selena_Kuttan" + jsonObject.getJSONArray("currencies").getJSONObject(0).optString("name") + "Ajju_Selena_Kuttan" + jsonObject.getJSONArray("currencies").getJSONObject(0).optString("symbol");


                callingCode[i] = jsonObject.getJSONArray("callingCodes").getString(0);
                timezone[i] = jsonObject.getJSONArray("timezones").getString(0);

                lat_long[i] = jsonObject.getJSONArray("latlng").optString(0) + "$" + jsonObject.getJSONArray("latlng").optString(1);

                Log.e("lat long", lat_long[i]);


                //   language[i] = jsonObject.getJSONArray("languages").getJSONObject(0).getString("name");
                JSONArray js = jsonObject.getJSONArray("languages");
                String lang = "";
                for (int k = 0; k < js.length(); k++) {

                    String temp = js.getJSONObject(k).getString("name");


                    lang = lang + temp + "$";
                }

                language[i] = lang;


                JSONArray borders_array = jsonObject.getJSONArray("borders");
                String bdrs = "";
                for (int k = 0; k < borders_array.length(); k++) {

                    String temp_bdrs = borders_array.optString(k);

                    bdrs = bdrs + temp_bdrs + "$";
                }
                borders[i] = bdrs;

                nationObject.setCountry(countries[i]);
                nationObject.setimageUrl(imageUrls[i]);
                nationObject.setCapital(capital[i]);
                nationObject.setRegion(region[i]);
                nationObject.setPopulation(population[i]);
                nationObject.setSubregion(subregion[i]);
                nationObject.setCallingCode(callingCode[i]);
                nationObject.setLat_long(lat_long[i]);
                nationObject.setTimezone(timezone[i]);
                nationObject.setLanguage(language[i]);
                nationObject.setNativename(nativename[i]);
                nationObject.setNumeric_code(numericCode[i]);
                nationObject.setCurrencies(currencies[i]);
                nationObject.setArea(area[i]);
                nationObject.setBorders(borders[i]);
                AllNations.add(nationObject);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    List<NationObject> getNations() {
        //function to return the final populated list
        return AllNations;
    }


}