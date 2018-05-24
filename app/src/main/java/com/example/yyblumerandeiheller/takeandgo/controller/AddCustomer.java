package com.example.yyblumerandeiheller.takeandgo.controller;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yyblumerandeiheller.takeandgo.R;
import com.example.yyblumerandeiheller.takeandgo.model.backend.FactoryMethod;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Customer;
import com.example.yyblumerandeiheller.takeandgo.model.utils.ConstantsAndEnums;

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

                new AsyncTask<Void, Void, Long>() {

                    Customer customer = new Customer(
                            id.getText().toString(),
                            firstName.getText().toString(),
                            lastName.getText().toString(),
                            phoneNum.getText().toString(),
                            email.getText().toString(),
                            creditCardNum.getText().toString()   );

                    @Override
                    protected void onPostExecute(Long idResult) {
                        super.onPostExecute(idResult);
                        if (idResult > 0)
                            Toast.makeText(getBaseContext(), "insert id: " + idResult, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    protected Long doInBackground(Void... params) {
                        return FactoryMethod.getDataSource(FactoryMethod.Type.MySQL).addCustomer(customer);


                    }
                }.execute();

            this.finish();

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