package com.example.yogesh.life;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class Splashscreen extends AppCompatActivity {

    MyAnimation obj;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        obj = (MyAnimation)findViewById(R.id.gif_view);



        Thread mythread = new Thread()
        {
            public void run()
            {
                try {
                    sleep(3000);
                    Intent intent = new Intent(Splashscreen.this,LOG.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        mythread.start();

    }

}
