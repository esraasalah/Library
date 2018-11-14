package com.library;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


/**
 * Created by esraa on 12/11/2018.
 */


public class CustomAdapter extends ArrayAdapter {


    Context adapterContx;
    int adapterResource;
    Orders[] adapterOrders;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull Orders[] orders) {
        super(context, resource, orders);

        adapterContx = context;
        adapterResource = resource;
        adapterOrders = orders;


    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return super.getItem(position);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row;
        LayoutInflater inflater = LayoutInflater.from(adapterContx);
        row = inflater.inflate(adapterResource, parent, false);

        TextView email = row.findViewById(R.id.email);
        TextView url = row.findViewById(R.id.url);
//        Orders order = adapterOrders[position];
        Log.i("position", String.valueOf(position));
        if (adapterOrders.length > 0) {

            url.setText(adapterOrders[position].getUrl());
            email.setText(adapterOrders[position].getEmail());
        }

        return row;
    }


}
