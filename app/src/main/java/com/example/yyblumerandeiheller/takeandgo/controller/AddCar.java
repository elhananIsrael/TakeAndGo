package com.example.yyblumerandeiheller.takeandgo.controller;

import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.yyblumerandeiheller.takeandgo.R;
import com.example.yyblumerandeiheller.takeandgo.model.datasource.ListsDataSource;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Car;
import com.example.yyblumerandeiheller.takeandgo.model.entities.CarModel;
import com.example.yyblumerandeiheller.takeandgo.model.utils.ConstantsAndEnums;

import java.util.Locale;


public class AddCar extends AppCompatActivity {

    Spinner Model;
    EditText ProductionDate, Mileage, LicenseNumber, HomeBranch, AverageCostPerDay ;

    ListsDataSource listsDataSource = new ListsDataSource();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        //not forget factory method
        Model=(Spinner) findViewById(R.id.Model);
        ProductionDate = ((EditText) findViewById( R.id.ProductionDate ));
        Mileage = ((EditText) findViewById( R.id.Mileage ));
        LicenseNumber = ((EditText) findViewById( R.id.LicenseNumber ));
        HomeBranch = ((EditText) findViewById( R.id.HomeBranch));
        AverageCostPerDay = ((EditText) findViewById( R.id.AverageCostPerDay));

        Model.setAdapter(new ArrayAdapter<CarModel>(this, android.R.layout.simple_spinner_item, listsDataSource.allCarModels()));

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void BtnAddCarClick(View view)
    {
        try
        {
            CarModel SelectedCarModel=(CarModel)((Spinner)findViewById(R.id.Model)).getSelectedItem();
            Car car;
            car = new Car(SelectedCarModel, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(ProductionDate.getText().toString()), LicenseNumber.getText().toString(), Integer.parseInt(Mileage.getText().toString()), HomeBranch.getText().toString(), Integer.parseInt(AverageCostPerDay.getText().toString()));
            listsDataSource.addCar(car);
        }catch (Exception ex){};
    }
}
