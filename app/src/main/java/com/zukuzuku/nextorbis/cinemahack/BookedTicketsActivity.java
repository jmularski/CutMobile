package com.zukuzuku.nextorbis.cinemahack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class BookedTicketsActivity extends AppCompatActivity {

    int[] IMAGES = {R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    String[] NAMES= {"Tickets 1 "," Tickets 2"};

    String[] DESCRIPTION = {"Description of the Cinema ","Description of the Cinema"};

    String[] URL={"URL1","URL2"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked_tickets);
        ListView listView_events=(ListView)findViewById(R.id.listView_cinemas_booked);

        BookedTicketsActivity .CustomAdapter customAdapter=new BookedTicketsActivity .CustomAdapter();

        listView_events.setAdapter(customAdapter);
    }
    class CustomAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return IMAGES.length;
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

                        gotake();


                    }
                });

            } else if (URL[i].equals("URL2")) {
                button_event_check.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        gotake();

                    }
                });


            }



            imageView.setImageResource(IMAGES[i]);
            textView_name.setText(NAMES[i]);
            textView_description.setText(DESCRIPTION[i]);

            return view;
        }
    }
    public void  gotake () {

        Intent intent = new Intent(this, getTicketsActivity.class);
        startActivity(intent);

    }
}