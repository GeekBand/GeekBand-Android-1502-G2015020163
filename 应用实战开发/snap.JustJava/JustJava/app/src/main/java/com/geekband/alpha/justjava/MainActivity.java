package com.geekband.alpha.justjava;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final int UNIT_PRICE = 5;
    private int totalprice;
    public int quantity;
    private TextView tvquantity;
    private TextView tvtotalprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvquantity = (TextView) findViewById(R.id.tvquantity);
        tvtotalprice = (TextView) findViewById(R.id.tvtotalprice);
        Button add = (Button) findViewById(R.id.btnAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity = quantity + 1;
                totalprice();

            }
        });
        Button minus = (Button) findViewById(R.id.btnMinus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantity > 0) {
                    quantity = quantity - 1;
                }
                totalprice();
            }

        });
        Button order = (Button) findViewById(R.id.btnOrder);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog();
            }
        });

    }
    private void totalprice() {
        totalprice = quantity*UNIT_PRICE;
        tvquantity.setText(Integer.toString(quantity));
        tvtotalprice.setText("$" + Integer.toString(totalprice));
    }
   protected  void dialog(){
       AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
       builder.setMessage("Quantity: "+quantity+"  and  "+"Price: "+"$"+totalprice);
       builder.setTitle("Confirm");
       builder.setPositiveButton("Correct", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {
               dialogInterface.dismiss();
               finish();
           }
       });
       builder.setNegativeButton("Wrong", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {
               dialogInterface.dismiss();
           }
       });
       builder.create().show();
   }
}
