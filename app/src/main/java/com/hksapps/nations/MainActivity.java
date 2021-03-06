package com.hksapps.nations;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<NationObject> mDataset;
    private static final String JSON_URL = "https://restcountries.eu/rest/v2/all";
    private RecyclerViewAdapter mAdapter;
    private ImageView no_internet;

    //private SharedPreferences p;
    private RecyclerView listRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        no_internet = (ImageView) findViewById(R.id.no_internet);
        listRecyclerview = (RecyclerView) findViewById(R.id.list_recycler_view);


        no_internet.setVisibility(View.GONE);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Refreshing!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                sendRequest();
            }
        });


        sendRequest();


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


if(mDataset!=null) {
    filter(newText);
}

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



        return super.onOptionsItemSelected(item);
    }


    private void sendRequest() {


        StringRequest stringRequest = new StringRequest(JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //success - parse JSON


                        listRecyclerview.setHasFixedSize(true);
                        listRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));


                        no_internet.setVisibility(View.GONE);
                        listRecyclerview.setVisibility(View.VISIBLE);



                        JsonParse pj = new JsonParse(response);
                        pj.parseJSON();
                        mDataset = pj.getNations();


                        mAdapter = new RecyclerViewAdapter(mDataset, getApplicationContext());


                        listRecyclerview.setAdapter(mAdapter);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(MainActivity.this, "Please Connect to Internet", Toast.LENGTH_SHORT).show();

                        no_internet.setVisibility(View.VISIBLE);
                        listRecyclerview.setVisibility(View.GONE);


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
            if (s.getCountry().toLowerCase().startsWith(text.toLowerCase()) || s.getCapital().toLowerCase().startsWith(text.toLowerCase())) {
                //adding the element to filtered list
                filterdNames.add(s);
            }
        }

        //calling a method of the adapter class and passing the filtered list
        mAdapter.filterList(filterdNames);
    }


}

