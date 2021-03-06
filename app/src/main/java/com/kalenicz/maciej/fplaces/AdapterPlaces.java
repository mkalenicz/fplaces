package com.kalenicz.maciej.fplaces;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.realm.RealmResults;

/**
 * Created by maciej on 24.08.2017.
 */

public class AdapterPlaces extends RecyclerView.Adapter<AdapterPlaces.PlaceHolder> {

    private static final String TAG = "VIVZ";
    private LayoutInflater mInflater;
    private RealmResults<Coordinates> mResults;

    public AdapterPlaces(Context context, RealmResults<Coordinates> results) {
        mInflater = LayoutInflater.from(context);
        update(results);
    }

    public void update(RealmResults<Coordinates> results) {
        mResults = results;
        notifyDataSetChanged();
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
        holder.mTextDescription.setText(coordinates.getDescription());
        holder.mTextCoordinates.setText("Latitude: " + coordinates.getLatitude() + ", Longitude: " + coordinates.getLongitude() + ", Accuracy: " + coordinates.getAccuracy() + ", Altitude: " + coordinates.getAltitude());
        Log.d(TAG, "onBindViewHolder: ");
    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }

    public static class PlaceHolder extends RecyclerView.ViewHolder {

        TextView mTextPlace;
        TextView mTextDescription;
        TextView mTextCoordinates;

        public PlaceHolder(View itemView) {
            super(itemView);
            mTextPlace = (TextView) itemView.findViewById(R.id.name_place_item);
            mTextDescription = (TextView) itemView.findViewById(R.id.description_place_item);
            mTextCoordinates = (TextView) itemView.findViewById(R.id.coordinates_place_item);

        }
    }
}

