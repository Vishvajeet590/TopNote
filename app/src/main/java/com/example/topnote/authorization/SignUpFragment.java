package com.example.topnote.authorization;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.topnote.R;

public class SignUpFragment extends Fragment {
    private Button signUpBtn , SignInBtn;
    public NavController navController ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        signUpBtn = view.findViewById(R.id.signUpBtn_signUpFragment);
        SignInBtn = view.findViewById(R.id.signInBtn_signUpFragment);
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController = Navigation.findNavController(getActivity(),R.id.navhost_fragment_main);
                navController.navigate(R.id.action_signUpFragment_to_signupFormFragment);
            }
        });

        SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController = Navigation.findNavController(getActivity(),R.id.navhost_fragment_main);
                navController.navigate(R.id.action_signUpFragment_to_loginFragment);
            }
        });
        return view;
    }
}