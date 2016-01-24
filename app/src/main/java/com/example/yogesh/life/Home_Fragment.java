package com.example.yogesh.life;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Fragment extends Fragment {
    //Bundle bundle =this.getArguments();
    //String uid=bundle.getString("uid","xxx");
    Button b1,enter;
    EditText msg1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public Home_Fragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home_, container, false);
        String uidd = getArguments().getString("uid");
        TextView test;
        test=(TextView)v.findViewById(R.id.textView3);
        test.setText("According to your symtoms\n,I assume that you may be suffering from tuberculosis so you must get yous Blood Tested \n,X-ray of your chest the very next day");
        //test.setText("uid == "+uidd);
        Button upb = (Button) v.findViewById(R.id.updbutton);
        b1 = (Button)v.findViewById(R.id.button4);
        enter = (Button)v.findViewById(R.id.ent);
        msg1 = (EditText)v.findViewById(R.id.msg);

        upb.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                UpdStatus fragment = new UpdStatus();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });
        mycall();
        enter1();
        return v;
    }

    public void mycall()
    {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try
                {

                    if ( ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED )
                    {
                        //  ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION}, LocationService.MY_PERMISSION_ACCESS_COURSE_LOCATION);
                    }
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:7767983047"));
                    startActivity(callIntent);
                }
                catch (ActivityNotFoundException activityException) {
                    Log.e("Calling a Phone Number", "Call failed", activityException);
                }

            }
        });
    }

    public void enter1()
    {
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Message sending code here
                String m =  msg1.getText().toString();
                String number = "7767983047";
                SmsManager.getDefault().sendTextMessage(number, null,m, null,null);
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        super.onCreateOptionsMenu(menu, inflater);
    }





}
