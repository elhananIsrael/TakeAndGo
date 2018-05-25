package com.example.yyblumerandeiheller.takeandgo.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_lists);

        spinner=(Spinner) findViewById(R.id.spinner);
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
                    ArrayList<Branch> br = factory.allBranches();
                    for (Branch item : br) {
                        item.ToString();
                    }
                    break;

                case "Cars":
                    ArrayList<Car> ca = factory.allCars();
                    for (Car item : ca) {
                        item.ToString();
                    }
                    break;

                case "CarModels":
                    ArrayList<CarModel> cm = factory.allCarModels();
                    for (CarModel item : cm) {
                        item.ToString();
                    }
                    break;

                case "Customers":
                    ArrayList<Customer> cu = factory.allCustomers();
                    for (Customer item : cu) {
                        item.ToString();
                    }
                    break;

                case "Orders":
                    ArrayList<Order> or = factory.allOrders();
                    for (Order item : or) {
                        item.ToString();
                    }
                    break;
            }
        }
        catch(Exception ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
