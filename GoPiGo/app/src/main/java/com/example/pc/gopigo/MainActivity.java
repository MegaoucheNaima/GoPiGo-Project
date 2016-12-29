package com.example.pc.gopigo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button connex, propos, quitte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connex=(Button)findViewById(R.id.button);
        propos=(Button)findViewById(R.id.button2);
        quitte=(Button)findViewById(R.id.button3);
        connex.setOnClickListener(this);
        propos.setOnClickListener(this);
        quitte.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button:
                Intent startActivity = new Intent(this, ConnexionPage.class);
                startActivity(startActivity);
                break;

            case R.id.button2:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Application Android pour manipuler le robot GOPIGO. Par NAIMA MEGAOUCHE et MAHDI HADJI");
                builder.setCancelable(true);
                builder.setTitle("à propos");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog dialogue = builder.create();
                dialogue.show();
                break;

            case R.id.button3:
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setMessage("Voulez-vous quitter?");
                alert.setTitle("QUITTER");
                alert.setCancelable(true);
                alert.setPositiveButton("OUI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //moveTaskToBack(true);
                        //finish();
                        Intent startMain = new Intent(Intent.ACTION_MAIN);
                        startMain.addCategory(Intent.CATEGORY_HOME);
                        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(startMain);
                        //android.os.process.killProcess(android.os.process.myPid());

                    }
                });
                alert.setNegativeButton("NON", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Continuez :)",
                                Toast.LENGTH_LONG).show();

                    }
                });
                AlertDialog dialog = alert.create();
                dialog.show();
                break;


        }

    }
}
