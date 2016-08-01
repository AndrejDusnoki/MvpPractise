package com.example.andrej.myapplication.LoactionSelector;

import android.content.Context;
import android.location.Address;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.andrej.myapplication.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LocationSelectorView {
    EditText EtLocation;
    ListView Locations;
    List<String> items;
    ArrayAdapter<String> adapter;
    private LocationPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Locations = (ListView) findViewById(R.id.LvLocations);
        presenter = new LocationModelPresenterImpl(this);
        EtLocation = (EditText) findViewById(R.id.EtLocation);
       /*
       I
       User searches desired location
        */
        EtLocation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 2) {
                     /*
                     II
                    After 3 inputed chars passing call to presenter
                     */
                    presenter.getLocations(charSequence.toString());

                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        Locations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast toast=Toast.makeText(getContext(),"Selected coordinates"+" "+presenter.getCoordinates(i),Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }



    @Override
    public void addLocation(List<String> Location) {
                       /*
        VIII
        View gets called and shows data
         */
        items=Location;
        if(items!=null){
            adapter=new ArrayAdapter<>(this,R.layout.list_item,items);
            Locations.setAdapter(adapter);
        }

    }

    @Override
    public void LocationSelected(String Coordinates) {

    }

    @Override
    public EditText UserInput() {
        return EtLocation;
    }

    @Override
    public Context getContext() {
        return this;
    }

}
