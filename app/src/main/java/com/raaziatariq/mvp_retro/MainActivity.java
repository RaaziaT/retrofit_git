package com.raaziatariq.mvp_retro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
//    ListView Pagination_List;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecycleViewAdapter mAdapter;
    List<GitHubRepo> repos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView =findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

//        Retrofit.Builder builder = new Retrofit.Builder()
//                .baseUrl("https://api.net/")
//                .addConverterFactory(GsonConverterFactory.create());
//
//        Retrofit retrofit = builder.build();
//
//        GitHubClient client = retrofit.create(GitHubClient.class);
//        Call<List<GitHubRepo>> call = client.reposForUser("2018-09-18","Coupon%20Codes");
//        call.enqueue(new Callback<List<GitHubRepo>>() {
//            @Override
//            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
//                List<GitHubRepo> repos = response.body();
//
//                Pagination_List.setAdapter(new GitHubRepoAdapter(MainActivity.this, repos));
//            }
//
//            @Override
//            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
//                Toast.makeText(MainActivity.this,"ERROR",Toast.LENGTH_SHORT).show();
//            }
//        });

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        GitHubClient client = retrofit.create(GitHubClient.class);
        Call<List<GitHubRepo>> call = client.reposForUser("raaziat");
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                 repos = response.body();
//               mAdapter.setRepoList(repos);
               mAdapter = new RecycleViewAdapter(repos);
//                mRecyclerView.setAdapter(mAdapter);
//                mRecyclerView.setAdapter(mAdapter);
    //            Log.e("main",repos.toString());
//                Pagination_List.setAdapter(new GitHubRepoAdapter(MainActivity.this, repos));
                mLayoutManager = new LinearLayoutManager(MainActivity.this);
                mRecyclerView.setLayoutManager(mLayoutManager);
//        mAdapter = new RecycleViewAdapter(this.getApplicationContext(),repos);
                mRecyclerView.setAdapter(mAdapter);

            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"ERROR",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
