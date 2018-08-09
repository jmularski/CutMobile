package com.zukuzuku.nextorbis.cinemahack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button login, signin;
    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login= (Button) findViewById(R.id.buttonlogin);
        signin=(Button) findViewById(R.id.button_signin);
        username =(EditText) findViewById(R.id.editText_user);
        password= (EditText) findViewById(R.id.edittextPassword);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login ( username.getText().toString().trim(), password.getText().toString().trim());
                //login();
            }
        });

        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                gosingin ();

            }

        });
    }
    //hard coded user
    public void login (String user, String pass) {

        if ((user.equals("cut"))&& (pass.equals("1234"))){
            Toast.makeText(this,"good", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);


        }else{
            Toast.makeText(LoginActivity.this,"incorrect", Toast.LENGTH_LONG).show();

        }
    }

    public void  gosingin () {

        Intent intent = new Intent(this, signupActivity.class);
        startActivity(intent);

    }
}

