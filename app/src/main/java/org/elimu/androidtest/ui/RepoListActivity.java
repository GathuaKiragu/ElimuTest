package org.elimu.androidtest.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import org.elimu.androidtest.R;
import org.elimu.androidtest.adapters.CustomAdapter;
import org.elimu.androidtest.model.GithubReposModel;
import org.elimu.androidtest.network.GetReposService;
import org.elimu.androidtest.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepoListActivity extends AppCompatActivity {


    ProgressDialog progressDoalog;
    private CustomAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo);


        progressDoalog = new ProgressDialog(RepoListActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        GetReposService service = RetrofitClientInstance.getRetrofitInstance().create(GetReposService.class);

        String url = "users/"+ getIntent().getStringExtra("Username") + "/repos";


        Call<List<GithubReposModel>> call = service.getUsers(url

        );
        call.enqueue(new Callback<List<GithubReposModel>>() {
            @Override
            public void onResponse(Call<List<GithubReposModel>> call, Response<List<GithubReposModel>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<GithubReposModel>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(RepoListActivity.this, "Something went wrong...Please try again later!", Toast.LENGTH_SHORT).show();
            }
        });


    }


    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<GithubReposModel> photoList) {
        recyclerView = findViewById(R.id.my_recycler_view);
        adapter = new CustomAdapter(this, photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RepoListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
