package com.hksapps.nations;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hksapps.nations.SvgLoaders.LoadSvgs;

import java.util.List;

/**
 * Created by Pranav on 26-11-2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<NationObject> nationslist;
    private Context context;

    public RecyclerViewAdapter(List<NationObject> nationslist,Context context) {
        super();

        Log.d("Testing adapter","In constructor of RecyclerViewAdapter");


        this.nationslist = nationslist;
        this.context = context;

        Log.d("Testing nationlist",nationslist.get(0).getCountry());

    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_ui, parent, false);

        return new RecyclerViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {


NationObject nationObject = nationslist.get(position);

holder.country.setText(nationObject.getCountry());
//Picasso.with(context).load(nationObject.getImageUrl().toString()).resize(500,400).into(holder.flag);

        LoadSvgs svgs = new LoadSvgs();
        svgs.LoadImages(nationObject.getImageUrl(),holder.flag,context);

        Log.d("Testing image Url",nationObject.getImageUrl());



//holder.flag.setImageResource();

    }

    @Override
    public int getItemCount() {
        return nationslist.size();
    }
}
