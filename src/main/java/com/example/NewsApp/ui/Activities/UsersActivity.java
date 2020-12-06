package com.example.NewsApp.ui.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.Observer;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.NewsApp.R;
import com.example.NewsApp.repository.localRepository.Room.Users;
import com.example.NewsApp.repository.localRepository.Room.UsersAdapter;
import com.example.NewsApp.viewModel.UserViewModel;

import java.util.List;


public class UsersActivity extends AppCompatActivity {
    UserViewModel userViewModel;
    UsersAdapter usersAdapter;
    RecyclerView recyclerView;
    Button btnNewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users_recycle_view);
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        usersAdapter = new UsersAdapter();
        recyclerView = findViewById(R.id.users_recycle_view);
        btnNewUser = findViewById(R.id.btnNewUser);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userViewModel.getAllUsers().observe(this, new Observer<List<Users>>() {
            @Override
            public void onChanged(List<Users> users) {
                if (users.size()>0) {
                    usersAdapter.setData(users);
                    recyclerView.setAdapter(usersAdapter);
                }
            }
        });

        btnNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUsers(UsersActivity.this);
            }
        });
    }

    public void addUsers(Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view1 = getLayoutInflater().inflate(R.layout.row_add_users, null);
        Button addUser = view1.findViewById(R.id.btnNewUser);
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edUsers = view1.findViewById(R.id.edUsers);
                Users users = new Users();
                users.setUsername(edUsers.getText().toString());
                userViewModel.insertUsers(users);
            }
        });
        builder.setView(view1);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}