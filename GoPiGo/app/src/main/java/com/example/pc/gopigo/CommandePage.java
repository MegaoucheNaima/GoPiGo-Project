package com.example.pc.gopigo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/**
 * Created by PC on 26/12/2016.
 */

public class CommandePage extends AppCompatActivity implements View.OnClickListener {
        Button up,down,left,right,start,stop,graph,home,data;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.commande_activity);
        up=(Button)findViewById(R.id.button9);
        down=(Button)findViewById(R.id.button10);
        left=(Button)findViewById(R.id.button11);
        right=(Button)findViewById(R.id.button12);
        start=(Button)findViewById(R.id.button14);
        stop=(Button)findViewById(R.id.button13);
        graph=(Button)findViewById(R.id.button15);
        home=(Button)findViewById(R.id.button16);
        data=(Button)findViewById(R.id.button17);

    up.setOnClickListener(this);
    down.setOnClickListener(this);
    left.setOnClickListener(this);
    right.setOnClickListener(this);
    start.setOnClickListener(this);
    stop.setOnClickListener(this);
    graph.setOnClickListener(this);
    home.setOnClickListener(this);
    data.setOnClickListener(this);



        }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button9:
                // avancer
               // try {
                 //   Runtime.getRuntime().exec("python3 you_script.py");
                // } catch (IOException e) {
                  //  e.printStackTrace();
               // }
                break;
            case R.id.button10:
                //reculer
                // Runtime.getRuntime().exec("python3 you_script.py");
                break;
            case R.id.button11:
                //gauche
                // Runtime.getRuntime().exec("python3 you_script.py");
                break;
            case R.id.button12:
                //droite
                // Runtime.getRuntime().exec("python3 you_script.py");
                break;
            case R.id.button13:
                //stop
                // Runtime.getRuntime().exec("python3 you_script.py");
                break;
            case R.id.button14:
                //start
                // Runtime.getRuntime().exec("python3 you_script.py");
                break;
            case R.id.button16:
                Intent homeIntent= new Intent(CommandePage.this, MainActivity.class);
                startActivity(homeIntent);
                break;

            case R.id.button15:
                Intent graphIntent = new Intent(CommandePage.this, GraphPage.class);
                startActivity(graphIntent);
                break;

            case R.id.button17:
                Intent DataIntent = new Intent(CommandePage.this, DataPage.class);
                startActivity(DataIntent);
                break;

        }

    }
}
