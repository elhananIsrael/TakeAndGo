package com.example.yyblumerandeiheller.takeandgo.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import com.example.yyblumerandeiheller.takeandgo.R;
import com.example.yyblumerandeiheller.takeandgo.model.datasource.ListsDataSource;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Customer;

    public class AddCustomer extends AppCompatActivity {
        ListsDataSource listsDataSource = new ListsDataSource();
        EditText id,firstName,lastName, phoneNum, email, creditCardNum;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_add_customer );

            id = ((EditText) findViewById( R.id.id ));
            firstName = ((EditText) findViewById( R.id.firstName ));
            lastName = ((EditText) findViewById( R.id.lastName ));

        }

        public void btnAddUserClick(View view) {
            Customer customer = new Customer(
                    id.getText().toString(),
                    firstName.getText().toString(),
                    lastName.getText().toString(),phoneNum.toString(), email.toString(), creditCardNum.toString());

            listsDataSource.addCustomer( customer );
        }
}
