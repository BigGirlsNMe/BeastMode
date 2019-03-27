package com.example.beastmode;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.beastmode.dummy.DummyContent;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button inflateWorkoutListButton = (Button) findViewById(R.id.inflateWorkoutListButton);
        Button testWorkoutButton = (Button) findViewById(R.id.inflateTestButton);

    }

//    @Override
//    public void onAttachFragment(Fragment fragment) {
//        if(fragment instanceof WorkoutObjectFragment)
//            super.onAttachFragment(fragment);
//            WorkoutObjectFragment workoutObjectFragment = (WorkoutObjectFragment) fragment;
//            workoutObjectFragment.setmListener(this);
//
//    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.inflateWorkoutListButton:
                Log.d("LOG","Inside Inflate Workout List Button");
                //This is to create an android fragment. REcommended set this in oncreate but testing it here
                Fragment androidFragment = new AndroidFragment();
                this.setDefaultFragment(androidFragment);
                //For replacing fragment
                //Fragment androidFragment = new AndroidFragment();
                //replaceFragment(androidFragment);
                break;
            case R.id.inflateTestButton:
                Fragment workoutFragment = new WorkoutObjectFragment();
                workoutFragment.setArguments(getIntent().getExtras());

            //         getSupportFragmentManager().beginTransaction()
              //             .add(R.id.dynamic_fragment_frame_layout, workoutFragment).commit();
                //  this.setDefaultFragment(workoutFragment);
                //break;
            default:
                throw new RuntimeException("Unknow button ID");
        }
    }

    // Replace current Fragment with the destination Fragment.


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

    // This method is used to set the default fragment that will be shown.
    private void setDefaultFragment(Fragment defaultFragment)
    {
        this.replaceFragment(defaultFragment);
    }
    // Replace current Fragment with the destination Fragment.
    public void replaceFragment(Fragment destFragment)
    {
        // First get FragmentManager object.
        FragmentManager fragmentManager = this.getSupportFragmentManager();

        // Begin Fragment transaction.
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the layout holder with the required Fragment object.
        fragmentTransaction.replace(R.id.dynamic_fragment_frame_layout, destFragment);

        // Commit the Fragment replace action.
        fragmentTransaction.commit();
    }

//    @Override
//    public Void onListFragmentInteraction(DummyContent.DummyItem item) {
//        return null;
//    }
}
