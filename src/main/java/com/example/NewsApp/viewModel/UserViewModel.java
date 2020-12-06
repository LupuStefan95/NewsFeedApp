package com.example.NewsApp.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.NewsApp.repository.localRepository.Room.Users;
import com.example.NewsApp.repository.localRepository.UsersRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
     UsersRepository usersRepository;
     LiveData<List<Users>> userList;

    public UserViewModel(@NonNull Application application) {
        super(application);
        usersRepository = new UsersRepository(application);
        userList = usersRepository.getAllUsers();
    }
    public void insertUsers(Users users){
        usersRepository.insertUsers(users);
    }
    public LiveData<List<Users>> getAllUsers() {
        return usersRepository.getAllUsers();
    }
}
