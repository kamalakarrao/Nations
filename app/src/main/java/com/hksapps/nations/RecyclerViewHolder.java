package com.hksapps.nations;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {


    public TextView country;
    public ImageView flag;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        country = (TextView) itemView.findViewById(R.id.country);
        flag = (ImageView) itemView.findViewById(R.id.flag);

    }

}
