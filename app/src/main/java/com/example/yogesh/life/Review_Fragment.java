package com.example.yogesh.life;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Review_Fragment extends Fragment {
    private  static RatingBar bar;
    private static Button b1,b2;

    public Review_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_review_, container, false);
        b1 = (Button)view.findViewById(R.id.button5);
        b2 =(Button)view.findViewById(R.id.button6);
        func();
        return view;

    }

    public void func()
    {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getActivity(),"Rated Successfully",Toast.LENGTH_LONG).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getActivity(),"Rated Successfully",Toast.LENGTH_LONG).show();
            }
        });
    }

}
