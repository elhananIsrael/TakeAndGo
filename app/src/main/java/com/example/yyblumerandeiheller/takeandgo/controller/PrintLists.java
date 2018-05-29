package com.example.yyblumerandeiheller.takeandgo.controller;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yyblumerandeiheller.takeandgo.R;
import com.example.yyblumerandeiheller.takeandgo.model.backend.FactoryMethod;
import com.example.yyblumerandeiheller.takeandgo.model.datasource.MySQL_DB_manager;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Branch;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Car;
import com.example.yyblumerandeiheller.takeandgo.model.entities.CarModel;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Customer;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Order;

import java.util.ArrayList;

public class PrintLists extends AppCompatActivity {

    MySQL_DB_manager factory=new MySQL_DB_manager();

    Spinner spinner;
    TextView textView4;
     static String temp=new String("");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_lists);

        spinner=(Spinner) findViewById(R.id.spinner);
        textView4=(TextView)findViewById(R.id.textView4);

        ArrayList<String> menu=new ArrayList<>();
        menu.add("Branches");
        menu.add("Cars");
        menu.add("CarModels");
        menu.add("Customers");
        menu.add("Orders");
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, menu));

    }


    public void display_lists(View view)
    {
        try {
            switch (spinner.getSelectedItem().toString()) {
                case "Branches":

                    temp="";

                new  AsyncTask<Void, Void, Void>() {


                    @Override
                        protected Void doInBackground(Void... params) {
                            ArrayList<Branch> br = FactoryMethod.getDataSource(FactoryMethod.Type.MySQL).allBranches();
                            for (Branch item : br) {
                                temp+=item.ToString();
                            }

                            return null;

                        }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        super.onPostExecute(aVoid);
                        textView4.setText(temp);

                    }


                    }.execute();


                    break;

                case "Cars":

                    temp="";


                    new AsyncTask<Void, Void, Void>() {


                        @Override
                        protected Void doInBackground(Void... params) {
                            ArrayList<Car> ca  = FactoryMethod.getDataSource(FactoryMethod.Type.MySQL).allCars();
                            for (Car item : ca) {
                                temp+=item.ToString();
                            }

                            return null;

                        }


                        @Override
                        protected void onPostExecute(Void aVoid) {
                            super.onPostExecute(aVoid);
                            textView4.setText(temp);

                        }

                    }.execute();


                    break;

                case "CarModels":

                    temp="";


                    new AsyncTask<Void, Void, Void>() {


                        @Override
                        protected Void doInBackground(Void... params) {
                            ArrayList<CarModel> cm = FactoryMethod.getDataSource(FactoryMethod.Type.MySQL).allCarModels();
                            for (CarModel item : cm) {
                                temp+=item.ToString();
                            }

                            return null;

                        }

                        @Override
                        protected void onPostExecute(Void aVoid) {
                            super.onPostExecute(aVoid);
                            textView4.setText(temp);

                        }


                    }.execute();


                    break;

                case "Customers":

                    temp="";


                    new AsyncTask<Void, Void, Void>() {


                        @Override
                        protected Void doInBackground(Void... params) {
                            ArrayList<Customer> cu  = FactoryMethod.getDataSource(FactoryMethod.Type.MySQL).allCustomers();
                            for (Customer item : cu) {
                                temp+=item.ToString();
                            }

                             return null;

                        }

                        protected void onPostExecute(Void aVoid) {
                            super.onPostExecute(aVoid);
                            textView4.setText(temp);

                        }

                    }.execute();

                    break;

                case "Orders":

                    temp="";


                    new AsyncTask<Void, Void, Void>() {


                        @Override
                        protected Void doInBackground(Void... params) {

                            ArrayList<Order> or  = FactoryMethod.getDataSource(FactoryMethod.Type.MySQL).allOrders();
                            for (Order item : or) {
                                temp+=item.ToString();
                            }

                            return null;

                        }

                        protected void onPostExecute(Void aVoid) {
                            super.onPostExecute(aVoid);
                            textView4.setText(temp);

                        }

                    }.execute();

                    break;
            }


        }
        catch(Exception ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
