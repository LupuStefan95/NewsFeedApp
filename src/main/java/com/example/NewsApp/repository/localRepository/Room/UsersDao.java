package com.example.NewsApp.repository.localRepository.Room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import java.util.List;


@Dao
public interface UsersDao {
    @Insert
    void insertUsers(Users users);

    @Query("SELECT * from users")
    LiveData<List<Users>> getAllUsers();

}
