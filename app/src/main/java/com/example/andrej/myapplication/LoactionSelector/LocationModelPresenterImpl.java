package com.example.andrej.myapplication.LoactionSelector;

import android.location.Address;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrej on 31.7.16..
 */
public class LocationModelPresenterImpl implements LocationPresenter,LocationModel.LocationListener {
    private List<Address> Addresses;
    private LocationSelectorView SelectorView;
    private LocationModel locationModel;
    public LocationModelPresenterImpl(LocationSelectorView view){
        this.SelectorView=view;
        this.locationModel=new LocationModelImpl();
    }


    @Override
    public void getLocations(String et) {
        /*
        III
        Presenter gets call
        Passes call to model, which can get the appropriate data
         */
       locationModel.GetLocations(et,SelectorView.getContext(),this);
    }

    @Override
    public String getCoordinates(int index) {
        return  locationModel.GetCoordinates(index);
    }


    @Override
    public void onSuccess(List<Address> Addresses) {
                       /*
        VI
        Gets called when Model finishes operations
         */
        this.Addresses=Addresses;
        Log.d("Listener result",Addresses.toString());
        ArrayList<String>StringAdress=new ArrayList<>();
        for(int i=0;i<Addresses.size();i++){
            Address currentAddress=Addresses.get(i);
            StringAdress.add(i,currentAddress.getAddressLine(0)
                    +","+currentAddress.getAddressLine(1)
                    +","+currentAddress.getAddressLine(2)
                    +","+currentAddress.getAddressLine(3));
            StringAdress.set(i,StringAdress.get(i).replace(",null"," "));

        }
                       /*
        VII
        Tells the view to show formated data
         */
        SelectorView.addLocation(StringAdress);
    }
}
