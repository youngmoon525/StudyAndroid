package com.example.project02_last.common;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class CommonRetClient {

    public static Retrofit getApiClient(){

        Retrofit retrofit = new Retrofit.Builder() // Retrofit.Builder로 초기화 시켜야함. ( Retrofit )
                .baseUrl("http://192.168.0.40/mid/") // 내꺼 톰캣에서 프로젝트까지.(index.html뜨는 주소가 base)
                .addConverterFactory(ScalarsConverterFactory.create())// String json사용이 가능해짐.
                .build();

        return retrofit;
    }

}
