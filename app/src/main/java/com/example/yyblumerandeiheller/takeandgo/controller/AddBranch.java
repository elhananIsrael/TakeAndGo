package com.example.yyblumerandeiheller.takeandgo.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.yyblumerandeiheller.takeandgo.R;
import com.example.yyblumerandeiheller.takeandgo.model.backend.DataSource;
import com.example.yyblumerandeiheller.takeandgo.model.backend.FactoryMethod;
import com.example.yyblumerandeiheller.takeandgo.model.datasource.ListsDataSource;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Branch;

public class AddBranch extends AppCompatActivity
{
    //FactoryMethod factoryMethod=FactoryMethod.getInstance();
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
        Branch branch=new Branch(BranchAddress.getText().toString(), Integer.parseInt(Capacity.getText().toString()) , BranchNum.getText().toString(), AdminName.getText().toString());
        FactoryMethod.getDataSource().addBranch(branch);
    }
}
