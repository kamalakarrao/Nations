package com.hksapps.nations;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<NationObject> mDataset;
    public static final String JSON_URL = "https://restcountries.eu/rest/v2/all";
    private RecyclerViewAdapter mAdapter;

private SharedPreferences p;
    private RecyclerView listRecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         p = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);


        //  ImageView img = (ImageView) findViewById(R.id.img);




        //  Picasso.with(MainActivity.this).load("").resize(500,400).into(img);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Refreshing!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                sendRequest();
               // startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

        Log.d("Starting to fetch data","303");

        sendRequest();


        Log.d("Done fetching data","403");

      //  Log.d("list Test",mDataset.get(0).getCountry());





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);

        searchView.setQueryHint("Search for Country or Capital ");

       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {



              //    mAdapter.getFilter().filter(newText);

                filter(newText.toString());


                return true;
            }
        });
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }




    private void sendRequest(){


        StringRequest stringRequest = new StringRequest(JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //success - parse JSON


                        p.edit().putString("jsondata", response).commit();

                        listRecyclerview = (RecyclerView) findViewById(R.id.list_recycler_view);
                        listRecyclerview.setHasFixedSize(true);
                        listRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));


                        Log.d("fetched data",response.substring(0,6000));


                        JsonParse pj = new JsonParse(response);
                        pj.parseJSON();
                        mDataset = pj.getNations();

                   //     Log.d("Response Test",mDataset.get(0).getCountry());

                        mAdapter = new RecyclerViewAdapter(mDataset,getApplicationContext());


                      listRecyclerview.setAdapter(mAdapter);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String jData = p.getString("jsondata", "");
                        if(jData.length()<=0){




                            Toast.makeText(MainActivity.this, "Please Connect to Internet", Toast.LENGTH_SHORT).show();
                        }else {

                            listRecyclerview = (RecyclerView) findViewById(R.id.list_recycler_view);
                            listRecyclerview.setHasFixedSize(true);
                            listRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

                            Toast.makeText(MainActivity.this, "Offline Mode!", Toast.LENGTH_SHORT).show();

                            JsonParse pj = new JsonParse(jData);
                            pj.parseJSON();
                            mDataset = pj.getNations();

                            //     Log.d("Response Test",mDataset.get(0).getCountry());

                            mAdapter = new RecyclerViewAdapter(mDataset,getApplicationContext());


                            listRecyclerview.setAdapter(mAdapter);


                        }

                    }
                });
//The following lines add the request to the volley queue
//These are very important
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }



    private void filter(String text) {
        //new array list that will hold the filtered data
        ArrayList<NationObject> filterdNames = new ArrayList<>();

        //looping through existing elements
        for (NationObject s : mDataset) {
            //if the existing elements contains the search input
            if (s.getCountry().toLowerCase().startsWith(text.toLowerCase())||s.getCapital().toLowerCase().startsWith(text.toLowerCase())) {
                //adding the element to filtered list
                filterdNames.add(s);
            }
        }

        //calling a method of the adapter class and passing the filtered list
        mAdapter.filterList(filterdNames);
    }




}

