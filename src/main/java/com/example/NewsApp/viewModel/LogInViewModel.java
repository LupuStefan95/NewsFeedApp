package com.example.NewsApp.viewModel;

import android.app.Application;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.NewsApp.repository.LogInRepository;
import com.google.firebase.auth.FirebaseUser;

public class LogInViewModel extends AndroidViewModel {

    private LogInRepository logInRepository;
    private MutableLiveData<FirebaseUser> userMutableLiveData;

    public LogInViewModel(@NonNull Application application) {
        super(application);

        logInRepository = new LogInRepository(application);
        userMutableLiveData = logInRepository.getUserMutableLiveData();
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void register(String email, String password){
        logInRepository.register(email, password);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void logIn(String email, String password){
        logInRepository.logIn(email, password);
    }

    public MutableLiveData<FirebaseUser> getUserMutableLiveData() {
        return userMutableLiveData;
    }
}
