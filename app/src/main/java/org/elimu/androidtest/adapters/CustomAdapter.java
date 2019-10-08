package org.elimu.androidtest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.elimu.androidtest.R;
import org.elimu.androidtest.model.GithubReposModel;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<GithubReposModel> dataList;
    private Context context;

    public CustomAdapter(Context context, List<GithubReposModel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView txtRepoName;
        TextView txtCreatedAt;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtRepoName = mView.findViewById(R.id.txtRepoName);
            txtCreatedAt = mView.findViewById(R.id.txtCreatedAt);

        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.repo_list_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.txtRepoName.setText(dataList.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
