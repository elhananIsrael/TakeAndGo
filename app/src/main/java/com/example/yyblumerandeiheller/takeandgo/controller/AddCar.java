package com.example.yyblumerandeiheller.takeandgo.controller;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.yyblumerandeiheller.takeandgo.R;
import com.example.yyblumerandeiheller.takeandgo.model.backend.FactoryMethod;
import com.example.yyblumerandeiheller.takeandgo.model.entities.*;
import com.example.yyblumerandeiheller.takeandgo.model.utils.ConstantsAndEnums;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class AddCar extends AppCompatActivity {

    CalendarView calendarView;
    Spinner Model;
    EditText ProductionDate, Mileage, LicenseNumber, HomeBranch, AverageCostPerDay ;
    ArrayAdapter<String> carModelsAdapter;
    static ArrayList<CarModel> carModelsSimpleList = null;
    static ArrayList<String> carModelsCodeSimpleList = new ArrayList<String>();
    String dayOfMonth= new String();
    String Month= new String();



    public ArrayList<String> getALLCarModelsCode(ArrayList<CarModel> CarModelList )
    {

        ArrayList<String> temp=new ArrayList<>();
        for (CarModel item : CarModelList)
    {
        temp.add(item.getModelCode());
    }
    return temp;
    }

    public String returnTwoDigitNo(int number)
    {
        String twoDigitNo = "0";
        int length = String.valueOf(number).length();
        if(length == 1)
        {
            twoDigitNo = twoDigitNo+number;
        }
        if(length == 2)
        {
            twoDigitNo = Integer.toString(number);
        }

        return twoDigitNo;
    }

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
        carModelsAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, carModelsCodeSimpleList);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int DayOfMonth) {
                dayOfMonth=returnTwoDigitNo(DayOfMonth);
                Month=returnTwoDigitNo(month+1);
                Toast.makeText(AddCar.this, "נבחר התאריך: " + dayOfMonth + "/" + Month + "/" + year  , Toast.LENGTH_LONG).show();
                ProductionDate.setText(year+"-"+ dayOfMonth +"-" + Month  );
                //1900-05-02
            }
        });


        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {

                carModelsSimpleList= FactoryMethod.getDataSource(FactoryMethod.Type.MySQL).allCarModels();
                return null;
            }


            @Override
            protected void onPostExecute(Void aVoid) {
                try {
                    if(carModelsCodeSimpleList == null){
                        carModelsCodeSimpleList = new ArrayList<>( );
                    }
                super.onPostExecute(aVoid);
                carModelsCodeSimpleList.clear();
                carModelsCodeSimpleList.addAll( getALLCarModelsCode(carModelsSimpleList) );
                carModelsAdapter.notifyDataSetChanged();
                Model.setAdapter(carModelsAdapter);

                } catch (Exception e) {
                    Log.w(ConstantsAndEnums.Log.APP_LOG, e.getMessage() );
                    Toast.makeText( AddCar.this, e.getMessage(), Toast.LENGTH_SHORT ).show();
                }


            }
        }.execute();






    }



    public void BtnAddCarClick(View view)
    {
        try
        {
            new AsyncTask<Void, Void, Long>() {

                Car car = new Car(
                        Model.getSelectedItem().toString(),
                        ProductionDate.getText().toString(),
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

