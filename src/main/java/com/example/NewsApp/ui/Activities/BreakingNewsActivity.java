package com.example.NewsApp.ui.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.NewsApp.R;
import com.example.NewsApp.repository.remoteRepository.NewsFeed;
import com.example.NewsApp.repository.remoteRepository.NewsRepository;
import com.example.NewsApp.viewModel.BreakingNewsViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BreakingNewsActivity extends AppCompatActivity {
    private BreakingNewsViewModel breakingNewsViewModel;
    TextView breakingNewsTitle;
    TextView breakingNewsDescription;
    TextView breakingNewsUrl;
    Animation rotateOpen;
    Animation rotateCLose;
    Animation fromBottom;
    Animation toBottom;
    FloatingActionButton expandButton;
    FloatingActionButton seeDescriptionbutton;
    FloatingActionButton recycleViewButton;
    private boolean clicked = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breaking_news);
        breakingNewsViewModel = new ViewModelProvider(this).get(BreakingNewsViewModel.class);
        rotateOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_open_anim);
        rotateCLose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_close_anime);
        fromBottom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.from_bottom_anime);
        toBottom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.to_bottom_anime);

        breakingNewsTitle = findViewById(R.id.breakingNewsTtitle);
        breakingNewsDescription = findViewById(R.id.breakingNewsDescription);
        breakingNewsUrl = findViewById(R.id.breakingNewsURL);
        expandButton = findViewById(R.id.expand_button);
        seeDescriptionbutton = findViewById(R.id.see_description_button);
        recycleViewButton = findViewById(R.id.recycle_view_button);


        expandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onExpandButtonClick(clicked);
                setAnimation(clicked);
            }
        });

       seeDescriptionbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Not implemented properly
                //return on signin activity
                Toast.makeText(BreakingNewsActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
                Intent ii = new Intent(BreakingNewsActivity.this, UsersActivity.class);
                startActivity(ii);

            }
        });

        recycleViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(BreakingNewsActivity.this, "Go to List of News", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(BreakingNewsActivity.this, TestActivity.class);
                    startActivity(i);
            }
        });





        NewsRepository.getInstance().getNewsFeed().observe(this, new Observer<NewsFeed>() {
            @Override
            public void onChanged(@Nullable NewsFeed newsFeed) {
                if (newsFeed != null) {
                    breakingNewsTitle.setText(newsFeed.getFeed().get(3).getTitle());
                    breakingNewsDescription.setText(newsFeed.getFeed().get(3).getDescription());
                    breakingNewsUrl.setText(newsFeed.getFeed().get(3).getUrl());
                }
            }
        });
    }

    private void onExpandButtonClick(boolean clicked) {
        setVisibility(clicked);
        setAnimation(clicked);
        if (!clicked){
            clicked = false;
        } else {
            clicked = true;
        }
    }

    private void setAnimation(Boolean clicked) {
        if (!clicked){
            expandButton.startAnimation(rotateOpen);
            seeDescriptionbutton.startAnimation(fromBottom);
            recycleViewButton.startAnimation(fromBottom);
        } else {
            expandButton.startAnimation(rotateCLose);
            seeDescriptionbutton.startAnimation(toBottom);
            recycleViewButton.startAnimation(toBottom);
        }
    }

    private void setVisibility(Boolean clicked) {
        if (!clicked){
            seeDescriptionbutton.setVisibility(View.VISIBLE);
            recycleViewButton.setVisibility(View.VISIBLE);
        } else {
            seeDescriptionbutton.setVisibility(View.INVISIBLE);
            recycleViewButton.setVisibility(View.INVISIBLE);
        }
    }

}