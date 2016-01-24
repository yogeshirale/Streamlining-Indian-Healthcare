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


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdStatus extends Fragment {

    TextView e1,e2,e3,e4,e5,e6;
    Button updateme;
    public UpdStatus() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_upd_status, container, false);
        updateme = (Button)view.findViewById(R.id.updstatus);
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        e1=(TextView)view.findViewById(R.id.editweight);
        e2=(TextView)view.findViewById(R.id.editheight);
        e3=(TextView)view.findViewById(R.id.editinsulin);
        e4=(TextView)view.findViewById(R.id.editbp);
        e5=(TextView)view.findViewById(R.id.edittemp);
        e6=(TextView)view.findViewById(R.id.editsymp);

        e1.setText(sharedPref.getString("weight",null));
        e2.setText(sharedPref.getString("height",null));
        e3.setText(sharedPref.getString("insulin",null));
        e4.setText(sharedPref.getString("bp",null));
        e5.setText(sharedPref.getString("temp",null));
        e6.setText(sharedPref.getString("symp",null));
        updateme();
        return view;
    }
    public void updateme()
    {
        updateme.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {



                Toast.makeText(getActivity(), "Status updated and sent to your doctor", Toast.LENGTH_LONG).show();
                SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("weight", e1.getText().toString());
                editor.putString("height", e2.getText().toString());
                editor.putString("insulin", e3.getText().toString());
                editor.putString("bp", e4.getText().toString());
                editor.putString("temp", e5.getText().toString());
                editor.putString("sym", e6.getText().toString());
                editor.commit();

                //getActivity().getFragmentManager().beginTransaction().remove(this).commit();

            }
        });

    }


}












