package com.example.yyblumerandeiheller.takeandgo.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.yyblumerandeiheller.takeandgo.R;
import com.example.yyblumerandeiheller.takeandgo.model.backend.DataSource;
import com.example.yyblumerandeiheller.takeandgo.model.backend.FactoryMethod;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Customer;



    public class AddCustomer extends AppCompatActivity {

        DataSource ds;
       // ListsDataSource listsDataSource = new ListsDataSource();
        EditText id,firstName,lastName, phoneNum, email, creditCardNum;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_add_customer );

            ds = FactoryMethod.getDataSource();

            id = ((EditText) findViewById( R.id.id ));
            firstName = ((EditText) findViewById( R.id.firstName ));
            lastName = ((EditText) findViewById( R.id.lastName ));
            phoneNum = ((EditText) findViewById( R.id.phoneNum ));
            email = ((EditText) findViewById( R.id.email ));
            creditCardNum = ((EditText) findViewById( R.id.creditCardNum ));

        }

        public void btnAddUserClick(View view) {
            Customer customer = new Customer(
                    id.getText().toString(),
                    firstName.getText().toString(),
                    lastName.getText().toString(),
                    phoneNum.getText().toString(),
                    email.getText().toString(),
                    creditCardNum.getText().toString());

           // listsDataSource.addCustomer( customer );
            ds.addCustomer( customer );
        }
}
