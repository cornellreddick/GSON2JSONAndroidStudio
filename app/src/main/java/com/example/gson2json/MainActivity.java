package com.example.gson2json;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {
    final String TAG = "Demo";
    private final OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPerson();
    }

    void getPerson () {
        Log.d(TAG, "getContact: start");
        Request request = new Request.Builder()
                .url("https://www.theappsdr.com/persons/json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                Log.d(TAG, "onResponse: Thread Id" + Thread.currentThread().getId());
                if (response.isSuccessful()) {

                        Gson gson = new Gson();
                       // Person person = gson.fromJson(response.body().charStream(), Person.class);

                    PersonResponse personResponse = gson.fromJson(response.body().charStream(), PersonResponse.class);



                        Log.d(TAG, "onResponse: " + personResponse.persons);
                } else {
                    ResponseBody responseBody = response.body();
                    String body = responseBody.string();
                    Log.d(TAG, "onResponse: " + body);
                }
            }
        });

        Log.d(TAG, "getContact: end");
    }

}
