package com.example.yyblumerandeiheller.takeandgo.controller;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yyblumerandeiheller.takeandgo.R;
import com.example.yyblumerandeiheller.takeandgo.model.backend.FactoryMethod;
import com.example.yyblumerandeiheller.takeandgo.model.backend.backendPHP;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Customer;

import static android.app.PendingIntent.getActivity;
import static android.widget.Toast.makeText;


public class AddCustomer extends AppCompatActivity {


        EditText id,firstName,lastName, phoneNum, email, creditCardNum;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
           try{

            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_add_customer );

            id = ((EditText) findViewById( R.id.Id ));
            firstName = ((EditText) findViewById( R.id.FirstName ));
            lastName = ((EditText) findViewById( R.id.LastName ));
            phoneNum = ((EditText) findViewById( R.id.PhoneNum ));
            email = ((EditText) findViewById( R.id.Email ));
            creditCardNum = ((EditText) findViewById( R.id.CreditCardNum ));

            throw new Exception("Congratulations! Car with ID number: " + id.getText().toString()+ "added to the database. \n" );
        }
            catch(Exception ex){};

        }

        public void btnAddUserClick(View view) {
            try
            {
            Customer customer = new Customer(
                    id.getText().toString(),
                    firstName.getText().toString(),
                    lastName.getText().toString(),
                    phoneNum.getText().toString(),
                    email.getText().toString(),
                    creditCardNum.getText().toString()   );

            //FactoryMethod.getDataSource().addCustomer( customer );
                backendPHP bphp=new backendPHP();
                bphp.addCustomer(customer);


                FragmentManager fm = getSupportFragmentManager();

            this.finish();

            //new DialogFragment().show(fm ,"Congratulations! Car with ID number: " + id.getText().toString()+ "added to the database. \n");
            //throw new Exception("Congratulations! Car with ID number: " + id.getText().toString()+ " added to the database. \n" );
            }
            catch(Exception ex){
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            };
        }
}


/*@Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute( aVoid );
                Toast.makeText( getBaseContext(), "Car Added OK", Toast.LENGTH_SHORT ).show();*/