package com.example.NewsApp.ui.Fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.NewsApp.R;
import com.example.NewsApp.ui.Activities.BreakingNewsActivity;
import com.example.NewsApp.viewModel.LogInViewModel;
import com.google.firebase.auth.FirebaseUser;

public class LogInFragment extends Fragment {
    private LogInViewModel logInViewModel;
    TextView textViewlogInEmail;
    TextView textViewlogInPassword;
    Button buttonlogInRegister;
    Button buttonlogIn;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //pay attention . . . method DEPRECATED . . .
        logInViewModel = ViewModelProviders.of(this).get(LogInViewModel.class);
        logInViewModel.getUserMutableLiveData().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if (firebaseUser != null){
                    Navigation.findNavController(getView()).navigate(R.id.action_logInFragment_to_succesLogedInFragment);
                }
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.log_in_fragment, container, false);
        textViewlogInEmail = view.findViewById(R.id.log_in_fragment_email);
        textViewlogInPassword = view.findViewById(R.id.log_in_fragment_password);
        buttonlogIn = view.findViewById(R.id.log_in_fragment_log_in);
        buttonlogInRegister = view.findViewById(R.id.log_in_fragment_register);

        buttonlogInRegister.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View view) {
                String email = textViewlogInEmail.getText().toString();
                String password = textViewlogInPassword.getText().toString();
                if(email.length()>0 && password.length()>0){
                    logInViewModel.register(email, password);
                }
            }
        }
        );

        buttonlogIn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View view) {
                String email = textViewlogInEmail.getText().toString();
                String password = textViewlogInPassword.getText().toString();
                if(!(email.isEmpty() && password.isEmpty())){
                    logInViewModel.logIn(email, password);
                    Intent intent = new Intent(getActivity(), BreakingNewsActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), "Write email and password", Toast.LENGTH_SHORT).show();
                }
            }
        });




        return view;
    }
}
