package com.example.yogesh.life;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Log_In extends AppCompatActivity {
    private static Button but1;
    private static EditText user,pass;
    private static TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log__in);
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
    }
    int count =3;
    public void log_in()
    {
        user = (EditText)findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.password);
        but1 = (Button)findViewById(R.id.button3);
        t1 = (TextView)findViewById(R.id.textView2);
        t1.setText(Integer.toString(count));

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.equals("y") && pass.equals("y"))
                {
                    Intent intent = new Intent(".MainActivity");
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Log_In.this, "Login Fialed", Toast.LENGTH_LONG).show();
                    count--;
                    t1.setText(Integer.toString(count));
                    if(count==0)
                    {
                        t1.setEnabled(false);
                        Toast.makeText(Log_In.this, "Restart the app.", Toast.LENGTH_LONG).show();
                    }
                }


            }
        });
    }

}
