package com.geekband.alpha.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String  TVSCOREA_STATE_KEY = "TVSCOREA_STATE_KEY";
    private static final String  TVSCOREB_STATE_KEY = "TVSCOREB_STATE_KEY";
    private TextView tvscoreA;
    private TextView tvscoreB;
    private int scoreA;
    private int scoreB;
    String textA ="";
    String textB ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tvscoreA = (TextView) findViewById(R.id.scoreA);
        if(savedInstanceState != null && savedInstanceState.containsKey(TVSCOREA_STATE_KEY)){
            textA = savedInstanceState.getString(TVSCOREA_STATE_KEY);
            tvscoreA.setText(textA);
        }
        tvscoreB = (TextView) findViewById(R.id.scoreB);
        if(savedInstanceState != null && savedInstanceState.containsKey(TVSCOREB_STATE_KEY)){
            textB = savedInstanceState.getString(TVSCOREB_STATE_KEY);
            tvscoreA.setText(textB);
        }
        Button button3A = (Button) findViewById(R.id.plus3A);
        button3A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreA = scoreA + 3;
                tvscoreA.setText(Integer.toString(scoreA));
            }
        });
        Button button2A = (Button) findViewById(R.id.plus2A);
        button2A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreA = scoreA + 2;
                tvscoreA.setText(Integer.toString(scoreA));
            }
        });
        Button button0A = (Button) findViewById(R.id.plus0A);
        button0A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreA = scoreA + 0;
                tvscoreA.setText(Integer.toString(scoreA));
            }
        });
        Button button3B = (Button) findViewById(R.id.plus3B);
        button3B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreB = scoreB + 3;
                tvscoreB.setText(Integer.toString(scoreB));
            }
        });
        Button button2B = (Button) findViewById(R.id.plus2B);
        button2B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreB = scoreB + 2;
                tvscoreB.setText(Integer.toString(scoreB));
            }
        });
        Button button0B = (Button) findViewById(R.id.plus0B);
        button0B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreB = scoreB + 0;
                tvscoreB.setText(Integer.toString(scoreB));
            }
        });
        Button button = (Button) findViewById(R.id.reset);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreA = 0;
                scoreB = 0;
                tvscoreA.setText(Integer.toString(scoreA));
                tvscoreB.setText(Integer.toString(scoreB));

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textA = savedInstanceState.getString(TVSCOREA_STATE_KEY);
        tvscoreA.setText(textA);
        textB = savedInstanceState.getString(TVSCOREB_STATE_KEY);
        tvscoreB.setText(textB);


    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState ) {
        tvscoreA = (TextView) findViewById(R.id.scoreA);
        savedInstanceState.putString(TVSCOREA_STATE_KEY,tvscoreA.getText().toString());
        tvscoreB = (TextView)findViewById(R.id.scoreB);
        savedInstanceState.putString(TVSCOREB_STATE_KEY,tvscoreB.getText().toString());
        super.onSaveInstanceState(savedInstanceState);

    }


}
