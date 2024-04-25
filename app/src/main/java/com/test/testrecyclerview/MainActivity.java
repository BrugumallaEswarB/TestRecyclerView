package com.test.testrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcv_article;
    ArticleRecyclerAdapter articleRecyclerAdapter;
    ArrayList<ArticleModel> articleModelArrayList;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        RecyclerView.LayoutManager manager = new LinearLayoutManager(MainActivity.this);
        rcv_article.setLayoutManager(manager);
        getArticlelist();
    }

    void Init() {
        rcv_article = findViewById(R.id.rcv_article);
    }

    void getArticlelist() {
      //  progressDialog=new ProgressDialog(this,"Fetching dAT").show();
        // progressDialog=new ProgressDialog()
        RetrofitInterface retrofitInterface = RetrofitClient.getClient().create(RetrofitInterface.class);
        Call<List<ArticleModel>> call = retrofitInterface.arrayListCall();
        call.enqueue(new Callback<List<ArticleModel>>() {
            @Override
            public void onResponse(Call<List<ArticleModel>> call, Response<List<ArticleModel>> response) {
                articleModelArrayList = new ArrayList<>(response.body());
                articleRecyclerAdapter = new ArticleRecyclerAdapter(MainActivity.this, articleModelArrayList);
                rcv_article.setAdapter(articleRecyclerAdapter);
            }

            @Override
            public void onFailure(Call<List<ArticleModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

    }
}