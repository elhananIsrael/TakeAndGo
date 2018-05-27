package com.example.yyblumerandeiheller.takeandgo.controller;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yyblumerandeiheller.takeandgo.R;
import com.example.yyblumerandeiheller.takeandgo.model.backend.FactoryMethod;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Branch;
import com.example.yyblumerandeiheller.takeandgo.model.datasource.MySQL_DB_manager;


public class AddBranch extends AppCompatActivity
{

    EditText BranchNum, BranchAddress, Capacity, AdminName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_branch);

        BranchNum = ((EditText) findViewById( R.id.BranchNum ));
        BranchAddress = ((EditText) findViewById( R.id.BranchAddress ));
        Capacity = ((EditText) findViewById( R.id.Capacity ));
        AdminName = ((EditText) findViewById( R.id.AdminName ));
    }


    public void BtnAddBranchClick(View view)
    {
        try
        {

            new AsyncTask<Void, Void, Long>() {

                Branch branch=new Branch(
                        BranchAddress.getText().toString(),
                        Integer.parseInt(Capacity.getText().toString()),
                        BranchNum.getText().toString(),
                        AdminName.getText().toString());

                @Override
                protected void onPostExecute(Long idResult) {
                    super.onPostExecute(idResult);
                    if (idResult > 0)
                        Toast.makeText(getBaseContext(), "insert Branch Number: " + BranchNum.getText().toString(), Toast.LENGTH_LONG).show();
                }

                @Override
                protected Long doInBackground(Void... params) {
                    return FactoryMethod.getDataSource(FactoryMethod.Type.MySQL).addBranch(branch);

                }
            }.execute();

        this.finish();

        //throw new Exception("Congratulations! Branch number: " + BranchNum.getText().toString()+ " added to the database. \n" );

        }
        catch(Exception ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        };
    }
}
