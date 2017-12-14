package com.hksapps.nations;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hksapps.nations.SvgLoaders.LoadSvgs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pranav on 26-11-2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>  {


    private List<NationObject> nationslist;
    private final Context context;

    public RecyclerViewAdapter(List<NationObject> nationslist, Context context) {
        super();

    //    Log.d("Testing adapter", "In constructor of RecyclerViewAdapter");


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
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {


      //  NationObject nationObject = mFilteredList.get(position);

        holder.linear_Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                NationObject nationObject = nationslist.get(holder.getAdapterPosition());
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
                    i.putExtra("area",nationObject.getArea());
                    i.putExtra("numericcode",nationObject.getNumeric_code());
                    i.putExtra("nativename",nationObject.getNativename());
                    i.putExtra("currencies",nationObject.getCurrencies());
                    i.putExtra("borders",nationObject.getBorders());

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);



            }
        });

    holder.country.setText(nationslist.get(position).getCountry());
//Picasso.with(context).load(nationObject.getImageUrl().toString()).resize(500,400).into(holder.flag);

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {


                LoadSvgs svgs = new LoadSvgs();
                svgs.LoadImages(nationslist.get(holder.getAdapterPosition()).getImageUrl(), holder.flag, context);
                // Marker value = entery.getValue();

            }
        });



 //   Log.d("Testing image Url", nationslist.get(position).getImageUrl());


}

    @Override
    public int getItemCount() {
        return nationslist.size();
    }




    public void filterList(ArrayList<NationObject> filterdNames) {
        this.nationslist = filterdNames;
        notifyDataSetChanged();
    }

}
