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
    private JSONArray nations = null;


    List<NationObject> AllNations;


    private String json;

    public JsonParse(String json){

        this.json = json;
    }

    protected void parseJSON(){
        JSONObject jsonObject=null;

        try {

            nations = new JSONArray(json);


            countries = new String[nations.length()];
            imageUrls = new String[nations.length()];
            AllNations = new ArrayList<NationObject>();



            for(int i = 0; i< nations.length(); i++){
                NationObject nationObject =  new NationObject();



               //  JSONArray array = nations.getJSONArray(0);

                jsonObject = nations.getJSONObject(i);


                countries[i] = jsonObject.getString("name");
                imageUrls[i] = jsonObject.getString("flag");

                Log.d("first country",countries[0]);


                nationObject.setCountry(countries[i]);
                nationObject.setimageUrl(imageUrls[i]);
                AllNations.add(nationObject);



            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    List<NationObject> getNations()
    {
        //function to return the final populated list
        return AllNations;
    }


}