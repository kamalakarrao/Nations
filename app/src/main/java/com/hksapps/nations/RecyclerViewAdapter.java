package com.hksapps.nations;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hksapps.nations.SvgLoaders.LoadSvgs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pranav on 26-11-2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>  {

    private ArrayList<NationObject> mArrayList;
    private ArrayList<NationObject> mFilteredList;
    private List<NationObject> nationslist;
    private Context context;

    public RecyclerViewAdapter(List<NationObject> nationslist, Context context) {
        super();

        Log.d("Testing adapter", "In constructor of RecyclerViewAdapter");

        mArrayList = (ArrayList<NationObject>) nationslist;
        mFilteredList = (ArrayList<NationObject>) nationslist;
        this.nationslist = nationslist;
        this.context = context;

//        Log.d("Testing nationlist", nationslist.get(0).getCountry());

    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_ui, parent, false);

        return new RecyclerViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {


      //  NationObject nationObject = mFilteredList.get(position);

        holder.linear_Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                NationObject nationObject = nationslist.get(position);
                Intent i = new Intent(context,DetailsScreen.class);
                    i.putExtra("country",nationObject.getCountry());
                    i.putExtra("capital",nationObject.getCapital());
                    i.putExtra("flag",nationObject.getImageUrl());
                    i.putExtra("region",nationObject.getRegion());
                    i.putExtra("subregion",nationObject.getSubregion());
                    i.putExtra("population",nationObject.getPopulation());
                    i.putExtra("callingcode",nationObject.getCallingCode());
                    i.putExtra("latlng",nationObject.getLat_long());
                    i.putExtra("timezone",nationObject.getTimezone());
                    i.putExtra("language",nationObject.getLanguage());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);


             /*   NationObject object = nationslist.get(position);
                Intent intent = new Intent(context, DetailsScreen.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST",(Serializable)object);
                intent.putExtra("BUNDLE",args);
                context.startActivity(intent);*/

             //   Toast.makeText(context, nationslist.get(position).getCapital(),Toast.LENGTH_SHORT).show();

            }
        });

    holder.country.setText(nationslist.get(position).getCountry());
//Picasso.with(context).load(nationObject.getImageUrl().toString()).resize(500,400).into(holder.flag);

    LoadSvgs svgs = new LoadSvgs();
    svgs.LoadImages(nationslist.get(position).getImageUrl(), holder.flag, context);

    Log.d("Testing image Url", nationslist.get(position).getImageUrl());


}

    @Override
    public int getItemCount() {
        return nationslist.size();
    }
//holder.flag.setImageResource();



  /*


    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    mFilteredList = mArrayList;
                } else {

                    ArrayList<NationObject> filteredList = new ArrayList<>();

                    filteredList.clear();
                    for (NationObject androidVersion : mArrayList) {

                    //    if (androidVersion.getCountry().toLowerCase().contains(charString.toLowerCase())) {
                            if(charString.toLowerCase().equals(androidVersion.getCountry().toLowerCase())){
Log.d("added_1",androidVersion.getCountry());
                            filteredList.add(androidVersion);
                        }
                    }

                    mFilteredList = (ArrayList<NationObject>) filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<NationObject>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }*/




    public void filterList(ArrayList<NationObject> filterdNames) {
        this.nationslist = filterdNames;
        notifyDataSetChanged();
    }

}
