package com.zukuzuku.nextorbis.cinemahack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class getTicketsActivity extends AppCompatActivity {
    Button get_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_tickets);

        get_button= (Button) findViewById(R.id.button_get_tickets);

        get_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"User served!", Toast.LENGTH_LONG).show();
            }
        });
    }

}
