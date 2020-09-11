package com.nguyai.gadsleadershipboard.services;

import com.nguyai.gadsleadershipboard.models.Learner;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LearningHoursService {

    @GET("hours")
    Call<List<Learner>> getLearningHours();

}
