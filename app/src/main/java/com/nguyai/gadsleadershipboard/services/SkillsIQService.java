package com.nguyai.gadsleadershipboard.services;

import com.nguyai.gadsleadershipboard.models.SkillsIQLeader;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SkillsIQService {

    @GET("skilliq")
    Call<List<SkillsIQLeader>> getIQScores();
}
