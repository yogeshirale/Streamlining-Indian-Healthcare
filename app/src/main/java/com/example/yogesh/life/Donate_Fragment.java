package com.example.yogesh.life;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Donate_Fragment extends Fragment {

    Button button,b2;
    private static RadioGroup group;
    public Donate_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_donate_, container, false);
        button = (Button)view.findViewById(R.id.ok);
        b2 = (Button)view.findViewById(R.id.sure);
        func1();
        func2();
        return view;
    }

    public void func1()
    {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

                alert.setMessage("Attach your digital signature ? ").setCancelable(false).setPositiveButton("NOW", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setNegativeButton("LATER", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert1 = alert.create();
                alert1.setTitle("Authentication");
                alert1.show();
            }
        });
    }

    public void func2()
    {
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

                alert.setMessage("Notification will be sent to the server ").setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert1 = alert.create();
                alert1.setTitle("Authentication");
                alert1.show();
            }
        });
    }
}
