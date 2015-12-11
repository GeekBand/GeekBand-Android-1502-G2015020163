package com.geekband.alpha.omgandroid;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView displaydata;
    private EditText editText;
    ListView lv;
    ArrayAdapter<String> mAdapter;
    ArrayList<String> arrayList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//      getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
        displaydata = (TextView) findViewById(R.id.displaydata);
        editText = (EditText) findViewById(R.id.edittext);
        lv = (ListView) findViewById(R.id.lv);
        mAdapter = new ArrayAdapter<String>(this,R.layout.playlist,arrayList);
        lv.setAdapter(mAdapter);
        lv.setOnItemClickListener(lvLis);
        Handler handler = new Handler();
        handler.postDelayed(add,1000);
        Button button = (Button) findViewById(R.id.btnUpdate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(TextUtils.isEmpty(editText.getText().toString()))){
                    displaydata.setText(editText.getText().toString()
                            + " is learning Android development!");
                    arrayList.add(0,editText.getText().toString());
                    mAdapter.notifyDataSetChanged();
                    lv.setSelection(0);
                    editText.setText("");
                }else {
                    Toast.makeText(MainActivity.this,"name could not null",Toast.LENGTH_SHORT).show();
                }

                }
        });

    }
     Runnable add = new Runnable() {
         @Override
         public void run() {
             arrayList.add("Darryl");
             mAdapter.notifyDataSetChanged();
         }
     };
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
   private AdapterView.OnItemClickListener lvLis = new AdapterView.OnItemClickListener() {
       @Override
       public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
           displaydata.setText(String.valueOf(arrayList.get(arg2))+ "  is learning Android development!");
       }
   };
}
