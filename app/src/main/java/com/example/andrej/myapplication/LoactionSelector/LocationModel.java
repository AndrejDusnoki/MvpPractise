package com.example.andrej.myapplication.LoactionSelector;

import android.content.Context;
import android.location.Address;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrej on 31.7.16..
 */
public interface LocationModel {
    interface LocationListener {
         void onSuccess(List<Address>Addresses);
    }
    public void GetLocations(String UserInput, Context context,LocationListener listener);
    public String GetCoordinates(int index);
}
