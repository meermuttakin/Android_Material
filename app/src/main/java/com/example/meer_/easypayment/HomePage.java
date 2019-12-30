package com.example.meer_.easypayment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class HomePage extends AppCompatActivity implements View.OnClickListener{

    private CardView electricity,water,gas,passport,help;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        electricity = (CardView)findViewById(R.id.electricityId);
        water = (CardView)findViewById(R.id.waterId);
        gas = (CardView)findViewById(R.id.gasId);
        passport = (CardView)findViewById(R.id.passportId);
        help = (CardView)findViewById(R.id.helpId);

        electricity.setOnClickListener(this);
        water.setOnClickListener(this);
        gas.setOnClickListener(this);
        passport.setOnClickListener(this);
        help.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.electricityId) {
            intent = new Intent(HomePage.this,Electricity.class);
            startActivity(intent);
        }

    }
}
