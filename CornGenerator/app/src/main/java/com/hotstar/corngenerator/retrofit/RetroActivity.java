package com.hotstar.corngenerator.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hotstar.corngenerator.R;
import com.hotstar.corngenerator.retrofit.model.CollectionResponse;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retro);
        getLatestCollection(4);

    }


    private void getLatestCollection(int cityId) {
        NetworkAPI apiService = BaseClient.getBaseClient().create(NetworkAPI.class);

        Call<CollectionResponse> call = apiService.getCollectionList(cityId,
                null,
                null,
                null);
        call.enqueue(new Callback<CollectionResponse>() {
            @Override
            public void onResponse(Call<CollectionResponse> call, Response<CollectionResponse> response) {
                if (response.isSuccessful() && HttpURLConnection.HTTP_OK == response.code()) {
                    Toast.makeText(RetroActivity.this, "Response Received", Toast.LENGTH_SHORT).show();
                    CollectionResponse abd = response.body();
                    Gson gson = new Gson();
                    Log.e("Response", gson.toJson(abd));
                } else {
                    Toast.makeText(RetroActivity.this, "Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CollectionResponse> call, Throwable t) {
                Toast.makeText(RetroActivity.this, "Please Try Again Later", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
