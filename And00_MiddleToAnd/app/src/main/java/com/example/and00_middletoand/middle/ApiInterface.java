package com.example.and00_middletoand.middle;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface ApiInterface {
    // 어떤 url을 요청하고 어떤 형태로 반환을 받을껀지,파라메터 등 이 지정되어있는 설계도
    // ApiInterface를 통해 레트로핏 전송객체가 초기화가 됨.
    //Retrofit 어노테이션 @GET , @POST
    //Form method("get" or "post")
    @FormUrlEncoded //같이 사용 @Url
    @POST
    Call<String> getData(@Url String url , @FieldMap HashMap<String,Object> params);



//    public interface GitHubService {
//        @GET("users/{user}/repos")
//        Call<List<Repo>> listRepos(@Path("user") String user);
//    }


}
