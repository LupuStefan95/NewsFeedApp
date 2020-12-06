package com.example.NewsApp.repository.localRepository.Room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.NewsApp.R;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersAdapterVH> {
    private List<Users> usersList;
    private Context context;

    public UsersAdapter() {
    }

    public void setData(List<Users> usersList){
        this.usersList = usersList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UsersAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new UsersAdapter.UsersAdapterVH(LayoutInflater.from(context).inflate(R.layout.users_row, null));
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapterVH holder, int position) {
        Users users = usersList.get(position);
        String username = users.getUsername();
        holder.users.setText(username);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class UsersAdapterVH extends RecyclerView.ViewHolder{

        TextView users;
        public UsersAdapterVH(@NonNull View itemView) {
            super(itemView);

            users = itemView.findViewById(R.id.users_row);
        }
    }
}
