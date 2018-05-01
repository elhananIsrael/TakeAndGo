package com.example.yyblumerandeiheller.takeandgo.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import com.example.yyblumerandeiheller.takeandgo.R;
import com.example.yyblumerandeiheller.takeandgo.model.datasource.ListsDataSource;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Customer;

    public class AddCustomer extends AppCompatActivity
    {

        ListsDataSource listsDataSource = new ListsDataSource();
        EditText Id,FirstName,LastName, PhoneNum, Email, CreditCardNum;

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_add_customer );

            Id = ((EditText) findViewById( R.id.Id ));
            FirstName = ((EditText) findViewById( R.id.FirstName ));
            LastName = ((EditText) findViewById( R.id.LastName ));
            PhoneNum = ((EditText) findViewById( R.id.PhoneNum ));
            Email = ((EditText) findViewById( R.id.Email ));
            LastName = ((EditText) findViewById( R.id.LastName ));

        }

        public void btnAddUserClick(View view)
        {
            Customer customer = new Customer(
                    Id.getText().toString(),
                    FirstName.getText().toString(),
                    LastName.getText().toString(),
                    PhoneNum.toString(),
                    Email.toString(),
                    CreditCardNum.toString());

            listsDataSource.addCustomer( customer );
        }
}
