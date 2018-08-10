package com.zukuzuku.nextorbis.cinemahack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signupActivity extends AppCompatActivity {
    private Button signup;
    EditText name, lastName, email, password, adress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signup= (Button) findViewById(R.id.buttonSignup);
        name= (EditText) findViewById(R.id.fieldName);
        email =(EditText) findViewById(R.id.fieldEmail);
        password= (EditText) findViewById(R.id.fieldPassword);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gosingin();
            }
        });

    }

    public void  gosingin () {

        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);

    }
}

