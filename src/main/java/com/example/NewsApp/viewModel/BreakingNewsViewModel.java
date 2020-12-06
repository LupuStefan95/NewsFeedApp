package com.example.NewsApp.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.NewsApp.repository.remoteRepository.NewsRepository;

public class BreakingNewsViewModel extends ViewModel{

    private MutableLiveData<String> mText;

    public BreakingNewsViewModel() {

        //mText = new MutableLiveData<>();
        //mText.setValue("This is breaking news fragment");
        NewsRepository.getInstance().updateNewsFeed();
    }

    //public LiveData<String> getText() {
    // return mText;
    //}
}