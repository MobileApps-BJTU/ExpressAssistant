package com.team20.java.expressassistant1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by Chen Jixuan on 2015/3/29.
 */
public class HomePageCustomer extends ActionBarActivity implements TransactionHistory.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage_customer);

        final Button topackageinfolist=(Button)findViewById(R.id.toPackageInfoList);
        topackageinfolist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent("android.intent.action.PackageInformationList"));
            }
        });

        //Here is the listfragment which is used to display history transaction list
        final Button totransactionhistory=(Button)findViewById(R.id.toTransactionHistory);
        totransactionhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .add(R.id.fragmentContainer, new TransactionHistory()).commit();
            }
        });

    }

    //This is to implement the communication between fragments through activity
    public void sendPositionToFragment2(int itemNum) {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, HistoryDetail.newInstance(itemNum))
                .addToBackStack(null)
                .commit();
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
