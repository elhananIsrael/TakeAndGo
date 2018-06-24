package com.example.yyblumerandeiheller.takeandgo.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.yyblumerandeiheller.takeandgo.R;
import com.example.yyblumerandeiheller.takeandgo.model.utils.ConstantsAndEnums;





    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            try {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            startService(new Intent(getBaseContext(), LookingForBusyCarService.class));


            } catch (Exception e) {
                Log.e( ConstantsAndEnums.Log.TAG,e.getMessage());
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

        public void addCustomerBtnClick(View view) {
            try {
                startActivity( new Intent( MainActivity.this,AddCustomer.class ) );
            } catch (Exception e) {
                Log.e( ConstantsAndEnums.Log.TAG,e.getMessage());
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

        public void addBranchBtnClick(View view) {
            try {
                startActivity( new Intent( MainActivity.this,AddBranch.class ) );
            } catch (Exception e) {
                Log.e( ConstantsAndEnums.Log.TAG,e.getMessage());
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }

        public void addCarBtnClick(View view) {
            try {
                startActivity( new Intent( MainActivity.this,AddCar.class ) );
            } catch (Exception e) {
                Log.e( ConstantsAndEnums.Log.TAG,e.getMessage());
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }


        public void addCarModelBtnClick(View view) {
            try {
                startActivity( new Intent( MainActivity.this,AddCarModel.class ) );
            } catch (Exception e) {
                Log.e( ConstantsAndEnums.Log.TAG,e.getMessage());
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }


        public void printListBtnClick(View view) {
            try {
                startActivity( new Intent( MainActivity.this,PrintLists.class ) );
            } catch (Exception e) {
                Log.e( ConstantsAndEnums.Log.TAG,e.getMessage());
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }



    }
