package com.example.student.lab4;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {
    public int tag = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        FragmentOne fragOne;
        fragOne = new FragmentOne();
        FragmentTwo fragTwo = new FragmentTwo();


        transaction.add(R.id.fragView, fragTwo, "Fragment2");
        transaction.add(R.id.fragView, fragOne, "Fragment1");
        transaction.commit();
        Button btm = (Button) findViewById(R.id.button);
        btm.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        if(tag == 1) {
                            ImageView img1 = (ImageView) findViewById(R.id.imageView);
                            //img1.setAlpha((float)0);
                            img1.setImageResource(R.drawable.image2);
                            ImageView img2 = (ImageView) findViewById(R.id.imageView2);
                            //img2.setAlpha((float)255);
                            img2.setImageResource(R.drawable.image1);
                            tag = 0;
                        }

                        else
                        {
                            ImageView img2 = (ImageView) findViewById(R.id.imageView2);
                            img2.setImageResource(R.drawable.image2);
                            //img2.setAlpha((float)255);
                            ImageView img1 = (ImageView) findViewById(R.id.imageView);
                            //img1.setAlpha((float)0);
                            img1.setImageResource(R.drawable.image1);
                            tag = 1;
                        }
                    }
                }
        );
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
