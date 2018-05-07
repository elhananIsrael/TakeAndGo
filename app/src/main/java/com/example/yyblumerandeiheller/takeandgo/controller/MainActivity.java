package com.example.yyblumerandeiheller.takeandgo.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.yyblumerandeiheller.takeandgo.R;
import com.example.yyblumerandeiheller.takeandgo.model.backend.*;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Customer;
import com.example.yyblumerandeiheller.takeandgo.model.utils.ConstantsAndEnums;





    public class MainActivity extends AppCompatActivity {

        DataSource ds;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            ds = FactoryMethod.getDataSource();
ds.addCustomer(new Customer("xcxx","cxxc","ffff","cxcxcx","cxcxc", "ccxcxcx"));
        }

        public void addCustomerBtnClick(View view) {
            try {
                startActivity( new Intent( MainActivity.this,AddCustomer.class ) );
            } catch (Exception e) {
                Log.e( ConstantsAndEnums.Log.TAG,e.getMessage());

            }
        }

        public void addBranchBtnClick(View view) {
            try {
                startActivity( new Intent( MainActivity.this,AddBranch.class ) );
            } catch (Exception e) {
                Log.e( ConstantsAndEnums.Log.TAG,e.getMessage());

            }
        }

        public void addCarBtnClick(View view) {
            try {
                startActivity( new Intent( MainActivity.this,AddCar.class ) );
            } catch (Exception e) {
                Log.e( ConstantsAndEnums.Log.TAG,e.getMessage());

            }
        }


        public void addCarModelBtnClick(View view) {
            try {
                startActivity( new Intent( MainActivity.this,AddCarModel.class ) );
            } catch (Exception e) {
                Log.e( ConstantsAndEnums.Log.TAG,e.getMessage());

            }
        }


}
