package com.kalenicz.maciej.fplaces;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import io.realm.RealmResults;

/**
 * Created by maciej on 24.08.2017.
 */

public class AdapterPlaces extends RecyclerView.Adapter<AdapterPlaces.PlaceHolder> {

    private static final String TAG = "VIVZ";
    private LayoutInflater mInflater;
   // private ArrayList<String>  mPlaces = new ArrayList<>();
//
private RealmResults<Coordinates> mResults;

//    public AdapterPlaces (Context context)
    public AdapterPlaces (Context context, RealmResults<Coordinates> results) {
        mInflater = LayoutInflater.from(context);
       mResults = results;
//        mPlaces = generateValues();
    }

    public static ArrayList<String> generateValues() {
        ArrayList<String> dummyValues = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            dummyValues.add("Item " + i);
        }
        return dummyValues;
    }


    @Override
    public PlaceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_place, parent, false);
        PlaceHolder holder = new PlaceHolder(view);
        Log.d(TAG, "onCreateViewHolder: ");
        return holder;
    }

    @Override
    public void onBindViewHolder(PlaceHolder holder, int position) {

        Coordinates coordinates = mResults.get(position);
        holder.mTextPlace.setText(coordinates.getPlace());
//        holder.mTextPlace.setText(mPlaces.get(position));
        Log.d(TAG, "onBindViewHolder: ");
    }

    @Override
    public int getItemCount() {
return mResults.size();
//        return 100;
    }

    public static class PlaceHolder extends RecyclerView.ViewHolder {

        TextView mTextPlace;
        public PlaceHolder (View itemView) {
            super(itemView);
            mTextPlace = (TextView) itemView.findViewById(R.id.name_place_item);
        }
    }
}

