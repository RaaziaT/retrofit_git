package com.raaziatariq.mvp_retro;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitHubClient {
//    @GET("/web")
//    Call<List<GitHubRepo>> reposForUser(
//            @Query("startDate") String date,
//            @Query("pageName") String coupon
//    );
    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> reposForUser(
            @Path("user") String user
    );
}
