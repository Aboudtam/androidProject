package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {
    private List<car> items = new ArrayList<>();
    private RecyclerView recycler;
    private static  final String URL = "http://10.0.2.2/car_rental/get.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.car_recycler);


        recycler.setLayoutManager(new LinearLayoutManager(this));
        loadItems();
    }

    private void loadItems() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {



                        try {

                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i<array.length(); i++){

                                JSONObject object = array.getJSONObject(i);
                                String id = object.getString("id");
                                String photo = object.getString("image");
                                String name = object.getString("name");
                                String seat_num = object.getString("seat_num");
                                String type = object.getString("type");
                                String availability= object.getString("availability");
                                String year = object.getString("year");
                                car car = new car(id,photo,name,seat_num,type,availability,year);
                                items.add(car);
                            }

                        }catch (Exception e){


                        }

                        data adapter = new data(Main.this,
                                items);
                        recycler.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                Toast.makeText(Main.this, error.toString(),Toast.LENGTH_LONG).show();
                Log.e("VolleyError", "Error: " + error.toString());


            }
        });

        Volley.newRequestQueue(Main.this).add(stringRequest);

    }
}
