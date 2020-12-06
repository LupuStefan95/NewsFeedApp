package com.example.NewsApp.repository.localRepository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.NewsApp.repository.localRepository.Room.Database;
import com.example.NewsApp.repository.localRepository.Room.Users;
import com.example.NewsApp.repository.localRepository.Room.UsersDao;

import java.util.List;

public class UsersRepository {
    private UsersDao usersDao;
    private Database database;
    private LiveData<List<Users>> usersList;


    public UsersRepository(Application application) {
        database = Database.getDatabase(application);
        usersDao = database.usersDao();
        usersList = usersDao.getAllUsers();

    }

    public LiveData<List<Users>> getAllUsers(){
        return usersDao.getAllUsers();
    }

    public void insertUsers(final Users users){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                database.usersDao().insertUsers(users);
                return null;
            }
        }.execute();
    }



}
