package com.example.yogesh.life;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class Appointment_Fragment extends Fragment {
    TextView e1,e2,e3,e4,e5,e6;
    String v1,v2,v3,v44,v5,v6;

    public Appointment_Fragment() {
        // Required empty public constructor
    }
   static Button createreport;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View  view = inflater.inflate(R.layout.fragment_appointment_, container, false);
        SharedPreferences sharedPreff=getActivity().getPreferences(Context.MODE_PRIVATE);
        createreport = (Button)view.findViewById(R.id.appoint);
        String name = sharedPreff.getString("Name", null);
        String dob = sharedPreff.getString("dob", null);
        String pan = sharedPreff.getString("pan", null);
        String bloodgrp = sharedPreff.getString("bloodgrp",null);
        String adha = sharedPreff.getString("adhar",null);
        String addr = sharedPreff.getString("addr", null);
        TextView e1,e2,e3,e4,e5,e6;
        Date dt;
        Calendar c = Calendar.getInstance();



        e1=(TextView)view.findViewById(R.id.editText6);
        e2=(TextView)view.findViewById(R.id.editText7);
        e3=(TextView)view.findViewById(R.id.editText8);
        e4=(TextView)view.findViewById(R.id.editText9);
        e5=(TextView)view.findViewById(R.id.editText10);
        e6=(TextView)view.findViewById(R.id.editText11);
        v1=e1.getText().toString();
        v2=e2.getText().toString();
        v3=e3.getText().toString();
        v44=e4.getText().toString();
        v5=e5.getText().toString();
        v6=e6.getText().toString();
        e1.setText(name);
        String uidd = getArguments().getString("uid");
        e3.setText(uidd);
        e2.setText(adha);
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        e4.setText(df.format(c.getTime()));

        Report();

        return view;
    }

    public void Report()
    {
        createreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                SharedPreferences sharedPreff=getActivity().getPreferences(Context.MODE_PRIVATE);
                String name = sharedPreff.getString("Name",null);
                String dob = sharedPreff.getString("dob", null);
                String pan = sharedPreff.getString("pan", null);
                String bloodgrp = sharedPreff.getString("bloodgrp", null);
                Toast.makeText(getActivity(), "Apointment Sended", Toast.LENGTH_SHORT).show();
                new get(getActivity()).execute(v1, dob, pan, bloodgrp);
            }
        });

    }

}
