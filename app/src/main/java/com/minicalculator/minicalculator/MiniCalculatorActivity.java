package com.minicalculator.minicalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MiniCalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAdd, btnSub, btnMult, btnDiv;
    private TextView tvResult;
    private EditText etFirst, etSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        init();
    }

    private void init(){
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        etFirst = (EditText) findViewById(R.id.etFirstNumber);
        etSecond = (EditText) findViewById(R.id.etSecondNumber);
        tvResult = (TextView) findViewById(R.id.tvResultNo);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        String num1 = etFirst.getText().toString();
        String num2 = etSecond.getText().toString();
        switch(view.getId()){
            case R.id.btnAdd:
                int add = Integer.parseInt(num1) + Integer.parseInt(num2);
                tvResult.setText(String.valueOf(add));
                break;
            case R.id.btnSub:
                int sub = Integer.parseInt(num1) - Integer.parseInt(num2);
                tvResult.setText(String.valueOf(sub));
                break;
            case R.id.btnMult:
                int mult = Integer.parseInt(num1) * Integer.parseInt(num2);
                tvResult.setText(String.valueOf(mult));
                break;
            case R.id.btnDiv:
                try{
                    int div = Integer.parseInt(num1) / Integer.parseInt(num2);
                    tvResult.setText(String.valueOf(div));
                }catch(Exception e){
                    tvResult.setText("cannot DIVIDE");
                }
                break;
        }
    }

}
