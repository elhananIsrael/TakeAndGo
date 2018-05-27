package com.example.yyblumerandeiheller.takeandgo.controller;

import android.icu.text.SimpleDateFormat;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.yyblumerandeiheller.takeandgo.R;
import com.example.yyblumerandeiheller.takeandgo.model.backend.FactoryMethod;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Car;
import com.example.yyblumerandeiheller.takeandgo.model.entities.CarModel;

import java.util.Date;
import java.util.Locale;


public class AddCar extends AppCompatActivity {

    CalendarView calendarView;
    Spinner Model;
    EditText ProductionDate, Mileage, LicenseNumber, HomeBranch, AverageCostPerDay ;

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
        calendarView =( (CalendarView)   findViewById( R.id.calendarView));

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(AddCar.this, "נבחר התאריך: " + dayOfMonth + "/" + (month+1) + "/" + year  , Toast.LENGTH_LONG).show();
                ProductionDate.setText(dayOfMonth + "/" + (month+1) + "/" + year);
            }
        });

    //    Model.setAdapter(new ArrayAdapter<CarModel>(this, android.R.layout.simple_spinner_item, FactoryMethod.getDataSource(FactoryMethod.Type.MySQL).allCarModels()));

    }



    public void BtnAddCarClick(View view)
    {
        try
        {
            new AsyncTask<Void, Void, Long>() {

                Car car = new Car(
                        Model.getSelectedItem().toString(),
                        new Date(ProductionDate.getText().toString()),
                        LicenseNumber.getText().toString(),
                        Integer.parseInt(Mileage.getText().toString()),
                        HomeBranch.getText().toString(),
                        Integer.parseInt(AverageCostPerDay.getText().toString())  );

                @Override
                protected void onPostExecute(Long idResult) {
                    super.onPostExecute(idResult);
                    if (idResult > 0)
                        Toast.makeText(getBaseContext(), "insert car with License Number: " + LicenseNumber.getText().toString(), Toast.LENGTH_LONG).show();
                }

                @Override
                protected Long doInBackground(Void... params) {
                    return FactoryMethod.getDataSource(FactoryMethod.Type.MySQL).addCar(car);

                }
            }.execute();


            this.finish();

        }
        catch(Exception ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        };
    }

}

