package com.example.meer_.easypayment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registrationForm extends AppCompatActivity {

    private EditText nid,name,gender,email,password;
    private Button registrationButton;
    private userDetails usDetails;
    private MyDatabaseHelper myDatabaseHelper1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);

        nid = (EditText) findViewById(R.id.nid);
        name  = (EditText) findViewById(R.id.nameId);
        gender = (EditText) findViewById(R.id.genderId);
        email = (EditText) findViewById(R.id.emailId);
        password = (EditText) findViewById(R.id.pid);

        registrationButton = (Button) findViewById(R.id.regId);

        usDetails = new userDetails();
        myDatabaseHelper1 = new MyDatabaseHelper(this);


        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nid1 = nid.getText().toString();
                String name1 = name.getText().toString();
                String gender1 = gender.getText().toString();
                String email1 = email.getText().toString();
                String password1 = password.getText().toString();



                usDetails.setNid1(nid1);
                usDetails.setName1(name1);
                usDetails.setGender1(gender1);
                usDetails.setEmail1(email1);
                usDetails.setPassword1(password1);


                long rowid1= myDatabaseHelper1.insertData(usDetails);

                if(rowid1>0){
                    Toast.makeText(getApplicationContext(),"Row : "+rowid1+" insertion is successfully done",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Row insertion is failed",Toast.LENGTH_SHORT).show();
                }

            }
        });







    }
}
