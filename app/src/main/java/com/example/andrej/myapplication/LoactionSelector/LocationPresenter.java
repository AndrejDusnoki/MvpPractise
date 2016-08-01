package com.example.andrej.myapplication.LoactionSelector;

import android.widget.EditText;

/**
 * Created by andrej on 31.7.16..
 */
public interface LocationPresenter {
    public void getLocations(String Et);
    public String getCoordinates(int index);
}
