package com.zukuzuku.nextorbis.cinemahack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CinameInfoActivity extends AppCompatActivity {
    Button buy_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciname_info);
        buy_button= (Button) findViewById(R.id.button_buy_tickets);

        buy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"You got your tikets!", Toast.LENGTH_LONG).show();
            }
        });

            }

    }


