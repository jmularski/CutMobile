package com.zukuzuku.nextorbis.cinemahack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuActivity extends AppCompatActivity {

    int[] IMAGES = {R.mipmap.ic_launcher, R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};

    String[] NAMES= {"Cinema 1 "," Cinema 2","Cinema 3","Cinema 4", "Cinema 5"};

    String[] DESCRIPTION = {"Description of the Cinema","Description of the Cinema","Description of the Cinema ","Description of the Cinema", "Description of the Cinema"};

    String[] URL={"URL1","URL2","URL3","URL4","URL5"};

    private MainService mAPIService;
    void getCinemas() {
        Call<CinemaPOJO> call = mAPIService.getCinemas();
        call.enqueue(new Callback<CinemaPOJO>() {
            @Override
            public void onResponse(Call<CinemaPOJO> call, Response<CinemaPOJO> response) {
                NAMES = response.body().getCinemaNames().toArray(new String[0]);
                ListView listView_events = (ListView) findViewById(R.id.listView_cinemas);
                MenuActivity.CustomAdapter customAdapter = new MenuActivity.CustomAdapter();
                listView_events.setAdapter(customAdapter);
            }

            @Override
            public void onFailure(Call<CinemaPOJO> call, Throwable t) {

            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mAPIService = APIUtils.getAPIService();
        getCinemas();
        Toolbar toolbar= findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        ListView listView_events=(ListView)findViewById(R.id.listView_cinemas);
        getSupportActionBar().setIcon(R.drawable.logobar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_booked:
                gobooked();
                break;
            case R.id.action_logout:
                gologin();
                break;
            default:

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    class CustomAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return NAMES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, final ViewGroup viewGroup) {
            view= getLayoutInflater().inflate(R.layout.customlayout,null);

            ImageView imageView=(ImageView)view.findViewById(R.id.imageView);
            TextView textView_name=(TextView)view.findViewById(R.id.textView_name_ev);
            TextView textView_description=(TextView)view.findViewById(R.id.textView_descript_ev);
            Button button_event_check= (Button)view.findViewById(R.id.button_events_check);

            button_event_check.setText("More");

            if ( URL[i].equals("URL1")) {
                button_event_check.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        gobuy();

                    }
                });

            } else if (URL[i].equals("URL2")) {
                button_event_check.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        gobuy();

                    }
                });


            }else if(URL[i].equals("URL3")){
                button_event_check.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        gobuy();

                    }
                });


            }else if(URL[i].equals("URL4")){
                button_event_check.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        gobuy();

                    }
                });


            }else if(URL[i].equals("URL5")){
                button_event_check.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        gobuy();

                    }
                });


            }



            imageView.setImageResource(IMAGES[i]);
            textView_name.setText(NAMES[i]);
            textView_description.setText(DESCRIPTION[i]);

            return view;
        }
    }
    public void  gobuy () {

        Intent intent = new Intent(this, CinameInfoActivity.class);
        startActivity(intent);

    }

    public void gobooked() {

        Intent intent = new Intent(this, BookedTicketsActivity.class);
        startActivity(intent);

    }
    public void  gologin () {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }
}