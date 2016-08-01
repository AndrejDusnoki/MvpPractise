package com.example.andrej.myapplication.LoactionSelector;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrej on 31.7.16..
 */
public class LocationModelImpl implements LocationModel {
    private List<Address> coordinates;
    @Override
    public void GetLocations(final String UserInput, final Context context, final LocationListener listener) {
        /*
        IV
        Location Model Gets call, fetches data from server
         */

         class Async extends AsyncTask<Void,Void,List<Address>>{
             @Override
             protected void onPostExecute(List<Address> addresses) {
                 super.onPostExecute(addresses);
                 if(addresses!=null){
                      /*
        V
        Location Model Upon data fetch, returns data to presenter
         */
                     listener.onSuccess(addresses);
                 }
             }
             Geocoder geo=new Geocoder(context);
             @Override
             protected List<Address> doInBackground(Void... voids) {

                 List<Address>Locations=null;
                 ArrayList<String>StringAdress=new ArrayList<>();
                 try {
                     Locations= geo.getFromLocationName(UserInput,10);
                     coordinates=Locations;
                 } catch (Exception e) {
                     Log.d("Ne RAdi","Nope");
                 }
                 return Locations;
             }
         }
        Async AsynchronousTask=new Async();
        AsynchronousTask.execute();
    }
    @Override
    public String GetCoordinates(int index) {
        Address SelectedAddres =coordinates.get(index);
        String CorrdsToReturn= String.valueOf(SelectedAddres.getLatitude())
                                +","+String.valueOf(SelectedAddres.getLongitude());

        return CorrdsToReturn;
    }
}
