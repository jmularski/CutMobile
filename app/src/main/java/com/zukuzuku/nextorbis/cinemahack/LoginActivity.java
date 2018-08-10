package com.zukuzuku.nextorbis.cinemahack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cloudrail.si.CloudRail;
import com.cloudrail.si.interfaces.Profile;
import com.cloudrail.si.services.Facebook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.CallAdapter;
import retrofit2.HttpException;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button login, facebook;
    TextView signin;
    EditText username, password;
    private MainService mAPIService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        CloudRail.setAppKey("5b6cb81b70a77f7d86b61746");
        login= (Button) findViewById(R.id.buttonLogin);
        signin=(TextView) findViewById(R.id.sign_up);
        facebook = (Button) findViewById(R.id.buttonFbLogin);
        username =(EditText) findViewById(R.id.fieldEmail);
        password= (EditText) findViewById(R.id.fieldPassword);

        mAPIService = APIUtils.getAPIService();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(username.getText().toString().trim(), password.getText().toString().trim());
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> scope = new ArrayList<>();
                scope.add("public_profile");
                scope.add("email");
                final Profile profile = new Facebook(LoginActivity.this, "516044692140717", "23d761b45629854248870714560874d5", scope);
                new Thread() {
                    @Override
                    public void run() {
                        String fullName = profile.getFullName();
                        String email = profile.getEmail();
                        Log.d("fullname", fullName);
                        Log.d("email", email);
                        Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                        startActivity(intent);
                    }
                }.start();
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
        HashMap<String, String> map = new HashMap<>();
        map.put("email", user);
        map.put("password", pass);
        Call<UserPOJO> call = mAPIService.loginUser(map);
        call.enqueue(new Callback<UserPOJO>() {
            @Override
            public void onResponse(Call<UserPOJO> call, Response<UserPOJO> response) {
                Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                intent.putExtra("userId", response.body().getId());
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<UserPOJO> call, Throwable t) {

            }
        });
    }

    public void  gosingin () {

        Intent intent = new Intent(this, signupActivity.class);
        startActivity(intent);

    }
}

