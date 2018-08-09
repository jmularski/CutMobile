package com.zukuzuku.nextorbis.cinemahack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    int[] IMAGES = {R.mipmap.ic_launcher, R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};

    String[] NAMES= {"Cinema 1 "," Cinema 2","Cinema 3","Cinema 4", "Cinema 5"};

    String[] DESCRIPTION = {"Description of the Cinema ","Description of the Cinema","Description of the Cinema ","Description of the Cinema", "Description of the Cinema"};

    String[] URL={"URL1","URL2","URL3","URL4","URL5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ListView listView_events=(ListView)findViewById(R.id.listView_cinemas);

        MenuActivity .CustomAdapter customAdapter=new MenuActivity .CustomAdapter();

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

            button_event_check.setText("Reward");

            if ( URL[i].equals("URL1")) {
                button_event_check.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(v.getContext(),"1", Toast.LENGTH_LONG).show();
                        Toast.makeText(v.getContext(),"Go to tickets", Toast.LENGTH_LONG).show();
                        // Intent browsermaps= new Intent (Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/2ukcNM8cSHu"));
                        //startActivity(browsermaps);

                    }
                });

            } else if (URL[i].equals("URL2")) {
                button_event_check.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(),"Go to tickets", Toast.LENGTH_LONG).show();

                        // Intent browsermaps= new Intent (Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/9HLwNfUgdGm"));
                        // startActivity(browsermaps);

                    }
                });


            }else if(URL[i].equals("URL3")){
                button_event_check.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        //  Toast.makeText(v.getContext(),"3", Toast.LENGTH_LONG).show();
                        Toast.makeText(v.getContext(),"Go to tickets", Toast.LENGTH_LONG).show();
                        ///Intent browsermaps= new Intent (Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/2pKRGLJ1kFL2"));
                        // startActivity(browsermaps);

                    }
                });


            }else if(URL[i].equals("URL4")){
                button_event_check.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        //  Toast.makeText(v.getContext(),"3", Toast.LENGTH_LONG).show();
                        Toast.makeText(v.getContext(),"Go to tickets", Toast.LENGTH_LONG).show();
                        //Intent browsermaps= new Intent (Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/2pKRGLJ1kFL2"));
                        // startActivity(browsermaps);

                    }
                });


            }else if(URL[i].equals("URL5")){
                button_event_check.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        //  Toast.makeText(v.getContext(),"3", Toast.LENGTH_LONG).show();
                        Toast.makeText(v.getContext(),"Go to tickets", Toast.LENGTH_LONG).show();
                        //Intent browsermaps= new Intent (Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/2pKRGLJ1kFL2"));
                        // startActivity(browsermaps);

                    }
                });


            }



            imageView.setImageResource(IMAGES[i]);
            textView_name.setText(NAMES[i]);
            textView_description.setText(DESCRIPTION[i]);

            return view;
        }
    }

}