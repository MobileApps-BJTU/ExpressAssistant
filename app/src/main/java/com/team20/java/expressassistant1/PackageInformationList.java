package com.team20.java.expressassistant1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivity;


/**
 * Created by Chen Jixuan on 2015/3/29.
 */
public class PackageInformationList extends ActionBarActivity{


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.package_list);

        ListView packagelist=(ListView)findViewById(R.id.packagelist);/*Correct this ID*/

        ArrayList<String> listData=new ArrayList<String>();
        listData.add("Laptop Y#####");
        listData.add("PC Y#####");
        listData.add("iPhone 6 #######");
        listData.add("Textbook #######");

        ArrayAdapter<String> listAdapter=
                new ArrayAdapter<String>(this,R.layout.package_list_item,R.id.NameOfPackage/*android.R.layout.simple_list_item_1*/,listData);

        packagelist.setAdapter(listAdapter);

        //temporarily turn to panel through this
        packagelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position>=0){
                    startActivity(new Intent("android.intent.action.PackageOperationPanelTemp"));
                }}
        });


         /*packagelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                 /*CheckBox checkbox=(CheckBox)view.findViewById(R.id.checkBox);
                 checkbox.setChecked(!checkbox.isChecked());

                 Button topackageoperationpanel=(Button)view.findViewById(R.id.toPackageOperationPanel);

                 topackageoperationpanel.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         startActivity(new Intent("android.intent.action.PackageOperationPanelTemp"));
                     }
                 });


             }
         });*/

        //need to add package operation panel later (fragment)

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
