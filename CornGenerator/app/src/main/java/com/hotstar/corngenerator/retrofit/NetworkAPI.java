package com.hotstar.corngenerator.retrofit;

import com.hotstar.corngenerator.retrofit.model.CollectionResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface NetworkAPI {
    @Headers("user-key: d553d21b7e7d78154559d98277b8d1c8")
    @GET("collections")
    Call<CollectionResponse> getCollectionList(@Query("city_id") int CityId,
                                               @Query("lat") Double lat,
                                               @Query("lon") Double lon,
                                               @Query("count") Integer count);
}
