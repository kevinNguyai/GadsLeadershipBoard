package com.nguyai.gadsleadershipboard.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {
    private static final String HERUKO_URL = "https://gadsapi.herokuapp.com/api/";

    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(HERUKO_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    public static <S> S buildService(Class<S> serviceType) {
        return retrofit.create(serviceType);
    }
}
