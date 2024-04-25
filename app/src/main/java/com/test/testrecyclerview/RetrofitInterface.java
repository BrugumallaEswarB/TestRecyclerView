package com.test.testrecyclerview;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("/articles")
    Call<List<ArticleModel>> arrayListCall() ;

}
