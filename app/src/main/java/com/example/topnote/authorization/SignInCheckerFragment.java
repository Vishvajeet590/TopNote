package com.example.topnote.authorization;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.topnote.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignInCheckerFragment extends Fragment {
    public NavController navController ;
    public FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        return inflater.inflate(R.layout.fragment_sign_in_checker, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            logger("no login....going for sign in");
            navController = Navigation.findNavController(getActivity(),R.id.navhost_fragment_main);
            navController.navigate(R.id.action_signInCheckerFragment_to_signUpFragment);
        }
        else {
            logger("User found.....going to home");
            navController = Navigation.findNavController(getActivity(),R.id.navhost_fragment_main);
            navController.navigate(R.id.action_signInCheckerFragment_to_homeFragment);


        }
    }
    private void logger(String msg){
        Log.v("Checker",msg);
    }
}