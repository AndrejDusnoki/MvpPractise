package com.example.andrej.myapplication.LoactionSelector;

import android.content.Context;
import android.location.Address;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrej on 31.7.16..
 */
public interface LocationSelectorView {
    public void addLocation(List<String> Location);
    public void LocationSelected(String Coordinates);
    public EditText UserInput();
    public Context getContext();
}
