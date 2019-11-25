package com.example.frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import  android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;




public class Main2Activity extends AppCompatActivity {

    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text1 = findViewById(R.id.textView);

        new MyTask().execute();
    }
    private class MyTask extends AsyncTask<Void,Void,Void>{
String o1;
        @Override
        protected Void doInBackground(Void... voids) {
            // return null;

            URL url = null;
            Intent myNewIntent = getIntent();
            int u_id = myNewIntent.getIntExtra("ID",99);
            String Firstname = myNewIntent.getStringExtra("Firstname");
            String lastname = myNewIntent.getStringExtra("lastname");
            String email = myNewIntent.getStringExtra("email");
            int phone = myNewIntent.getIntExtra("phone",99);
            String address = myNewIntent.getStringExtra("address");



            try{
                url =new URL("http://172.26.30.29:8080/webservicecalls/webresources/toolrental/user1/userregister&"+ u_id + "&" +Firstname+ "&" +lastname+ "&" +email+ "&"+phone+ "&" +address+ "");

                HttpURLConnection client = null;

                client = (HttpURLConnection) url.openConnection();
                client.setRequestMethod("GET");
                int responseCOde = client.getResponseCode();
                System.out.println(" URL :"+url);
                System.out.println("Response Code :" + responseCOde);
                InputStreamReader myInput = new InputStreamReader(client.getInputStream());
                BufferedReader in = new BufferedReader(myInput);
                String inputLine;
                StringBuffer response = new StringBuffer();
                while((inputLine = in.readLine()) != null){
                    response .append(inputLine);

                }

                in.close();
                System.out.println(response.toString());
                JSONObject obj = new JSONObject(response.toString());
                o1 = ""+obj.getString("message");


            }
            catch (MalformedURLException e){
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            catch (JSONException e){
                e.printStackTrace();
            }
            return  null;
        }
        @Override
        protected void onPostExecute(Void result){

text1.setText(o1);
            super.onPostExecute(result);
        }
        }
}
