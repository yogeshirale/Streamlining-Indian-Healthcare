package com.example.yogesh.life;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class GetAndPost extends AsyncTask<String, Void, String> {

    private Context context;

    public GetAndPost(Context context) {
        this.context = context;
    }

    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(String... arg0) {

        String link;
        String data;
        BufferedReader bufferedReader;
        String result;
        String e1=arg0[0];
        String e3=arg0[1];
        String e4=arg0[2];
        String e5=arg0[3];
        String ad2=arg0[4];
        String adhar=arg0[5];

        try {
            data = "?name=" + URLEncoder.encode(e1, "UTF-8");
            data += "&adc=" + URLEncoder.encode(e3, "UTF-8");
            data += "&email=" + URLEncoder.encode(e4, "UTF-8");
            data += "&date=" + URLEncoder.encode(e5, "UTF-8");


            link = "http://equakeanalysis.hol.es/test.php" + data;
            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String Line;
            while((Line = bufferedReader.readLine())!=null){
                sb.append(Line);
                Log.d("Result Status", Line);
            }

            return sb.toString();

        } catch (Exception e) {
            return new String("Exception: " + e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if(result.equals(1)){
            Log.d("LOGIN_SUCCESS", result);

        }
        else
            Log.d("LOGIN_FAILURE", result);

    }
}