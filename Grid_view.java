package com.viacom.vengal.newsfeed;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
/**
 * Created by vengal on 2/2/2015.
 */
public class Grid_view extends ActionBarActivity {
    private int images[] = {R.drawable.image1,R.drawable.image2,R.drawable.image3,
                            R.drawable.image4,R.drawable.image5,R.drawable.image6};
    private String names[] = {"Top news","Technology", "Sports" , "Fav_picks",
                             "Local News","International"};
    Handler m_handler;
    Runnable m_handlerTask ;
    boolean bln;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_grid1);
        final GridView gridView = (GridView)findViewById(R.id.gridview);
        gridView.setAdapter(new MyAdapter(this,names,images));
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fly_in_from_center);
        gridView.setAnimation(anim);
        anim.start();
        m_handler = new Handler();
        m_handlerTask = new Runnable()
        {
            @Override
            public void run() {
                if(bln)
                {
                    Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fly_in_from_center);
                    gridView.setAnimation(anim);
                    anim.start();
                    bln = false;
                }
                else
                {
                    Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fly_in_from_top_corner);
                    gridView.setAnimation(anim);
                    anim.start();
                    bln = true;
                }
                m_handler.postDelayed(m_handlerTask, 30000);
            }
        };
        m_handlerTask.run();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //final String item = (String) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),names[position],Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Grid_view.this,MainActivity.class);
                startActivity(intent);


            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
