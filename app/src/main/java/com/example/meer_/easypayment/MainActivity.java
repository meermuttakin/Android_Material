package com.example.meer_.easypayment;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button signinButton,signupButton;
    private EditText email1,password1;
    MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signinButton = (Button) findViewById(R.id.signId);
        signupButton = (Button) findViewById(R.id.reg1Id);

        email1 = (EditText) findViewById(R.id.email1);
        password1 = (EditText) findViewById(R.id.password1);



        myDatabaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,registrationForm.class);
                startActivity(intent);
            }
        });

        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = email1.getText().toString();
                String password = password1.getText().toString();

                Boolean result = myDatabaseHelper.findPassword(username,password);

                if(result==true){
                    Intent intent1 = new Intent(MainActivity.this,HomePage.class);
                    startActivity(intent1);
                }
                else{
                    Toast.makeText(getApplicationContext(),"username and password didn't matched",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
