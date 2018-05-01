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


public class AddCarModel extends AppCompatActivity {

    ListsDataSource listsDataSource = new ListsDataSource();
    EditText CodeModel,ManufactorName,ModelName, EngineVolume, NumOfTravel;
    Spinner GearKind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car_model);

        CodeModel = ((EditText) findViewById( R.id.CodeModel ));
        ManufactorName = ((EditText) findViewById( R.id.ManufactorName ));
        ModelName = ((EditText) findViewById( R.id.ModelName ));
        EngineVolume = ((EditText) findViewById( R.id.EngineVolume ));
        GearKind = (Spinner) findViewById(R.id.GearKind);
        NumOfTravel = ((EditText) findViewById( R.id.NumOfTravel ));

        GearKind.setAdapter(new ArrayAdapter<ConstantsAndEnums.gearboxMode>(this, android.R.layout.simple_spinner_item, ConstantsAndEnums.gearboxMode.values()));

    }

    public void BtnAddCarModel(View view)
    {
        CarModel carModel=new CarModel(CodeModel.getText().toString(), ManufactorName.getText().toString(), ModelName.getText().toString(), Integer.parseInt(EngineVolume.getText().toString()), ConstantsAndEnums.gearboxMode.valueOf(GearKind.getSelectedItem().toString()), Integer.parseInt(NumOfTravel.getText().toString()));
        listsDataSource.addCarModel(carModel);
    }
}


//