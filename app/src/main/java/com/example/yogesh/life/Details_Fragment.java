package com.example.yogesh.life;


import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Details_Fragment extends Fragment
{

    SQLiteDatabase sd;
    Cursor c;
    private static EditText e5,e1,e3,e4,ad1,ad2,ad3,adhar;
    public Button but;
    String link;
    String data;

    String result;
    //private View myview;
    public Details_Fragment()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragm
        SharedPreferences sharedPreff = getActivity().getPreferences(Context.MODE_PRIVATE);

        View view =  inflater.inflate(R.layout.fragment_details_, container, false);//In fragments use View: helpful
        e1 = (EditText)view.findViewById(R.id.editText1);
        e3 = (EditText)view.findViewById(R.id.editText3);
        e4 = (EditText)view.findViewById(R.id.editText4);
        e5 = (EditText)view.findViewById(R.id.editText5);
        ad1 = (EditText)view.findViewById(R.id.edit);
        ad2 = (EditText)view.findViewById(R.id.editT6);
        ad3 = (EditText)view.findViewById(R.id.editTex);
        adhar= (EditText)view.findViewById(R.id.ad);

        but = (Button)view.findViewById(R.id.button);
        func();

        String name = sharedPreff.getString("Name",null);
        String dob = sharedPreff.getString("dob",null);
        String pan = sharedPreff.getString("pan",null);
        String bloodgrp = sharedPreff.getString("bloodgrp",null);
        String adha = sharedPreff.getString("adhar",null);
        String addr = sharedPreff.getString("addr",null);
        //Toast.makeText(getContext(),"Name == "+ name,Toast.LENGTH_LONG).show();
        e1.setText(name);
        e3.setText(dob);
        e4.setText(pan);
        e5.setText(bloodgrp);
        adhar.setText(adha);
        ad2.setText(addr);
        e1.setEnabled(false);
        e3.setEnabled(false);
        e4.setEnabled(false);
        e5.setEnabled(false);
        ad1.setEnabled(false);
        ad2.setEnabled(false);
        ad3.setEnabled(false);
        adhar.setEnabled(false);

        return view;

    }
    int x=1;
    public void func()
    {

        but.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(x==0)
                {
                    SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("Name", e1.getText().toString());
                    editor.putString("dob", e3.getText().toString());
                    editor.putString("pan", e4.getText().toString());
                    editor.putString("bloodgrp", e5.getText().toString());
                    editor.putString("addr", ad2.getText().toString());
                    editor.putString("adhar", adhar.getText().toString());
                    editor.commit();
                    Toast.makeText(getActivity(), "Details Updated..", Toast.LENGTH_SHORT).show();
                    new GetAndPost(getActivity()).execute(e1.getText().toString(), e1.getText().toString(), e1.getText().toString(), e1.getText().toString(), e1.getText().toString(), e1.getText().toString());

                    e1.setEnabled(false);
                    e3.setEnabled(false);
                    e4.setEnabled(false);
                    e5.setEnabled(false);
                    ad1.setEnabled(false);
                    ad2.setEnabled(false);
                    ad3.setEnabled(false);
                    adhar.setEnabled(false);
                    x++;
                    return;
                }
                if(x==1)
                {
                    e1.setEnabled(true);
                    e3.setEnabled(true);
                    e4.setEnabled(true);
                    e5.setEnabled(true);
                    ad1.setEnabled(true);
                    ad2.setEnabled(true);
                    ad3.setEnabled(true);
                    adhar.setEnabled(true);
                    x--;
                    return;
                }
            }
        });
    }

}