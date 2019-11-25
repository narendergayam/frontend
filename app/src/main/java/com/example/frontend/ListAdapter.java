package com.example.frontend;

import android.content.Context;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    Context c;
    LayoutInflater li;
    JSONArray jsonArray;

    public ListAdapter(Context c, JSONArray jsonArray) {
        this.c = c;
        this.JSONArray = jsonArray;
    }

    @Override
    public int getCount() {
        return jsonArray.length();
    }

    @Override
    public Object getItem(int position) {
        try {
            return jsonArray.getJSONObject(position);
        }
        catch (JSONException e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (li == null)
        {
            li = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }


        if(view == null)
        {
            view = li.inflate(R.layout.listadapter,parent,false);
        }

        TextView fname  = view.findViewById(R.id.fname);
        txtnm.setText(repositories.get(i).getRepositoryname());

        return view;
    }
}