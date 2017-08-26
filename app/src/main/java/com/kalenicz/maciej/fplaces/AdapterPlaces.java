package com.kalenicz.maciej.fplaces;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmResults;




public class AdapterPlaces extends RecyclerView.Adapter<AdapterPlaces.ViewHolder> {

    Context context;
    ArrayList<String> coordinatesList;


    public AdapterPlaces(Context context, ArrayList<String> coordinatesList) {

        this.context = context;
        this.coordinatesList = coordinatesList;

    }

//    public List<Coordinates> getCoordinatesList() {
//        return coordinatesList;
//    }
    public Context getContext() {
        return context;
    }


    @Override
    public AdapterPlaces.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View placeView = inflater.inflate(R.layout.item_place, parent, false);

        ViewHolder viewHolder = new ViewHolder(placeView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterPlaces.ViewHolder viewHolder, int position) {
        //Coordinates coordinates = coordinatesList.get(position);

        TextView textView = viewHolder.namePlace;
        textView.setText(coordinatesList.get(position));
    }

    @Override
    public int getItemCount() {
        return coordinatesList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView namePlace;
//        public TextView descriptionPlace;
//        public TextView coordinatesPlace;
//        public ImageView iconPlace;

        public ViewHolder(View itemView) {
            super(itemView);
            namePlace = (TextView) itemView.findViewById(R.id.name_place_item);
//            descriptionPlace = (TextView) itemView.findViewById(R.id.description_place_item);
//            coordinatesPlace = (TextView) itemView.findViewById(R.id.coordinates_place_item);
//            iconPlace = (ImageView) itemView.findViewById(R.id.icon_item_place);

        }
    }
}
//    Context c;
//    ArrayList<String> spacecrafts;
//
//    public AdapterPlaces(Context c, ArrayList<String> spacecrafts) {
//        this.c = c;
//        this.spacecrafts = spacecrafts;
//    }
//
//    @Override
//    public PlacesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
//        return new PlacesHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(PlacesHolder holder, int position) {
//        holder.nameTxt.setText(spacecrafts.get(position));
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return spacecrafts.size();
//    }
//}


//public class AdapterPlaces extends RecyclerView.Adapter<AdapterPlaces.PlaceHolder> {
//
//    private LayoutInflater mInflater;
//    private RealmResults<Coordinates> mResults;
//
//    public AdapterPlaces(Context context, RealmResults<Coordinates> results) {
//        mInflater = LayoutInflater.from(context);
//        mResults = results;
////        mPlaces = generateValues();
//    }
//
////    public static ArrayList<String> generateValues() {
////        ArrayList<String> dummyValues = new ArrayList<>();
////        for (int i = 1; i < 101; i++) {
////            dummyValues.add("Item " + i);
////        }
////        return dummyValues;
////    }
//
//
//    @Override
//    public PlaceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = mInflater.inflate(R.layout.item_place, parent, false);
//        PlaceHolder holder = new PlaceHolder(view);
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(PlaceHolder holder, int position) {
//
//        Coordinates coordinates = mResults.get(position);
//        holder.mTextPlace.setText(coordinates.getPlace());
//    }
//
//    @Override
//    public int getItemCount() {
//        return mResults.size();
//        //return 100;
//    }
//
//    public static class PlaceHolder extends RecyclerView.ViewHolder {
//
//        TextView mTextPlace;
//

//}
//
