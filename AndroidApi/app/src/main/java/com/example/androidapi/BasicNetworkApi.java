package com.example.androidapi;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class BasicNetworkApi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_basic_network_api);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String apiUrl = "https://dummyjson.com/c/0f83-95e2-4a46-8910";

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, apiUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String jsonData = response;

                Log.d("JSON Data: ", jsonData);

                decodeJsonObject(jsonData);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(BasicNetworkApi.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        });

        requestQueue.add(stringRequest);

//        //JSON String
//        String jsonString = "{\"id\":1,\"name\":\"NirajShrestha\",\"age\":25,\"grade\":\"A\"}";
//
//        try{
//            // Parse JSON String to JSONObject
//            JSONObject jsonObject = new JSONObject(jsonString);
//
//            // Extract data
//            int id = jsonObject.getInt("id");
//            String name  = jsonObject.getString("name");
//            int age = jsonObject.getInt("age");
//            String grade = jsonObject.getString("grade");
//
//            Log.d("Student", "ID: " + id + ", Name: " + name  + ", Age: " + age + ", Grade: " + grade);
//        }catch(JSONException e){
//            e.printStackTrace();
//        }
//
//        String jsonStr = "[{\"id\":1,\"name\":\"NirajShrestha\",\"age\":25,\"grade\":\"A\"},{\"id\":2,\"name\":\"Johndoe\",\"age\":20,\"grade\":\"A\"},{\"id\":3,\"name\":\"Alexdoe\",\"age\":22,\"grade\":\"A\"},{\"id\":4,\"name\":\"Janedoe\",\"age\":15,\"grade\":\"A\"},{\"id\":5,\"name\":\"Hollydoe\",\"age\":19,\"grade\":\"A\"}]";
//
//        try{
//            JSONArray jsonArray = new JSONArray(jsonStr);
//            for (int i = 0; i < jsonArray.length(); i++){
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//
//                int id = jsonObject.getInt("id");
//                String name  = jsonObject.getString("name");
//                int age = jsonObject.getInt("age");
//                String grade = jsonObject.getString("grade");
//
//                Log.d("Student", "ID: " + id + ", Name: " + name  + ", Age: " + age + ", Grade: " + grade);
//
//            }
//        } catch(JSONException e){
//            e.printStackTrace();
//        }

    }

    private void decodeJsonObject(String jsonString) {
        try{
            JSONObject jsonObject = new JSONObject(jsonString);

            // Extract data
            int id = jsonObject.getInt("id");
            String name  = jsonObject.getString("name");
            int age = jsonObject.getInt("age");
            String grade = jsonObject.getString("grade");

            String result = "Student - ID: " + id + ", Name: " + name  + ", Age: " + age + ", Grade: " + grade;

            Toast.makeText(BasicNetworkApi.this, "Server response: " + result, Toast.LENGTH_LONG).show();
        } catch (JSONException e){
            Toast.makeText(BasicNetworkApi.this, "Error: " + e.toString(), Toast.LENGTH_LONG).show();
        }

    }
}