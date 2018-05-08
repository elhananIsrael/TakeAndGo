package com.example.yyblumerandeiheller.takeandgo.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.yyblumerandeiheller.takeandgo.R;
import com.example.yyblumerandeiheller.takeandgo.model.backend.FactoryMethod;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Customer;



    public class AddCustomer extends AppCompatActivity {


        EditText id,firstName,lastName, phoneNum, email, creditCardNum;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_add_customer );

            id = ((EditText) findViewById( R.id.Id ));
            firstName = ((EditText) findViewById( R.id.FirstName ));
            lastName = ((EditText) findViewById( R.id.LastName ));
            phoneNum = ((EditText) findViewById( R.id.PhoneNum ));
            email = ((EditText) findViewById( R.id.Email ));
            creditCardNum = ((EditText) findViewById( R.id.CreditCardNum ));

        }

        public void btnAddUserClick(View view) {
            Customer customer = new Customer(
                    id.getText().toString(),
                    firstName.getText().toString(),
                    lastName.getText().toString(),
                    phoneNum.getText().toString(),
                    email.getText().toString(),
                    creditCardNum.getText().toString()   );

            FactoryMethod.getDataSource().addCustomer( customer );

            this.finish();
        }
}
