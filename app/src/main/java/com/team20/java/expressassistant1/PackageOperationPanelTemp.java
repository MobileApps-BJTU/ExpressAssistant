package com.team20.java.expressassistant1;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by Chen Jixuan on 2015/3/29.
 */

//This activity is a temporary platform to maintain the transaction between several fragments
public class PackageOperationPanelTemp extends ActionBarActivity implements PackageOperationPanel.OnFragmentInteractionListener {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_operation_panel);

        /*if (findViewById(R.id.fragmentContainer) != null) {
            if(SavedInstanceState!=null){
                return;
            }
        }

        PackageOperationPanel fragment=new PackageOperationPanel();

        fragment.setArguments(getIntent().getExtras());*/


        getFragmentManager().beginTransaction()
                .add(R.id.fragmentContainer, new PackageOperationPanel()).commit();
    }

    public void sendFlagToFragment2(int flag2) {
        if(flag2==1){
            getFragmentManager().beginTransaction()
                    .add(R.id.fragmentContainer, new PackageDetailInfo()).commit();
        }
    }

    public void sendFlagToFragment3(int flag3) {
        if (flag3 == 1) {
            getFragmentManager().beginTransaction()
                    .add(R.id.fragmentContainer, new PackageLocation()).commit();
        }
    }

    public void sendFlagToFragment5(int flag5) {
        if (flag5 == 1) {
            getFragmentManager().beginTransaction()
                    .add(R.id.fragmentContainer, new EndTransaction()).commit();
        }
    }



    public void onFragmentInteraction(Uri uri){

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
        // automatically handle clicks on the Home/Up button, solong
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
