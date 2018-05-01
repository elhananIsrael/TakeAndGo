package com.example.yyblumerandeiheller.takeandgo.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.yyblumerandeiheller.takeandgo.R;
import com.example.yyblumerandeiheller.takeandgo.model.datasource.ListsDataSource;
import com.example.yyblumerandeiheller.takeandgo.model.entities.CarModel;
import com.example.yyblumerandeiheller.takeandgo.model.utils.ConstantsAndEnums;


public class AddCarModel extends AppCompatActivity
{

    ListsDataSource listsDataSource = new ListsDataSource();
    EditText CompanyName, ModelName, ModelCode, EngineVolume, NumOfSeats;
    Spinner Gearbox, CarKind;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car_model);

        CompanyName = ((EditText) findViewById( R.id.CompanyName ));
        ModelName = ((EditText) findViewById( R.id.ModelName ));
        ModelCode = ((EditText) findViewById( R.id.ModelCode ));
        EngineVolume = ((EditText) findViewById( R.id.EngineVolume ));
        Gearbox = (Spinner) findViewById(R.id.Gearbox);
        NumOfSeats = ((EditText) findViewById( R.id.NumOfSeats ));
        CarKind=(Spinner) findViewById(R.id.CarKind);

        Gearbox.setAdapter(new ArrayAdapter<ConstantsAndEnums.gearboxMode>(this, android.R.layout.simple_spinner_item, ConstantsAndEnums.gearboxMode.values()));
        CarKind.setAdapter(new ArrayAdapter<ConstantsAndEnums.carKind>(this, android.R.layout.simple_spinner_item, ConstantsAndEnums.carKind.values()));
    }

    public void BtnAddCarModel(View view)
    {
        CarModel carModel=new CarModel(CompanyName.getText().toString(), ModelName.getText().toString(), ModelCode.getText().toString(), Integer.parseInt(EngineVolume.getText().toString()), ConstantsAndEnums.gearboxMode.valueOf(Gearbox.getSelectedItem().toString()), Integer.parseInt(NumOfSeats.getText().toString()), ConstantsAndEnums.carKind.valueOf(CarKind.getSelectedItem().toString()));
        listsDataSource.addCarModel(carModel);
    }
}


//