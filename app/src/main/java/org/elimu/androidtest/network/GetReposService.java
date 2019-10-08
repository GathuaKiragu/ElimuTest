package org.elimu.androidtest.network;

import org.elimu.androidtest.model.GithubReposModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface GetReposService {

    @GET()
    Call<List<GithubReposModel>> getUsers(@Url String url);
}