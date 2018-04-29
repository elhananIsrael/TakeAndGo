package com.example.yyblumerandeiheller.takeandgo.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.yyblumerandeiheller.takeandgo.R;
import com.example.yyblumerandeiheller.takeandgo.model.utils.ConstantsAndEnums;


    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        public void btnUsersClick(View view) {
            try {
                startActivity( new Intent( MainActivity.this,AddCustomer.class ) );
            } catch (Exception e) {
                Log.e( ConstantsAndEnums.Log.TAG,e.getMessage());

            }
        }

}
