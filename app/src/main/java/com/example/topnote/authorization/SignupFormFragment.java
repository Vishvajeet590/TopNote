package com.example.topnote.authorization;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.topnote.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupFormFragment extends Fragment {

    EditText email_text,password_text;
    Button signUpBtn;
    private FirebaseAuth mAuth;
    public NavController navController ;


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup_form, container, false);
        navController = Navigation.findNavController(getActivity(),R.id.navhost_fragment_main);
        email_text = view.findViewById(R.id.EmailTextField_SignUpFragment);
        password_text = view.findViewById(R.id.Password_Field_SignUp);
        signUpBtn = view.findViewById(R.id.SignUpBtn_SignUpFragment);
        mAuth = FirebaseAuth.getInstance();

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_text.getText().toString();
                email = email.trim();
                String pass = password_text.getText().toString();
                pass = pass.trim();
                mAuth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("SignUpFrag", "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    navController.navigate(R.id.action_signupFormFragment_to_homeFragment);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("SignUpFrag", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(getActivity(), "Check email address....", Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });

            }
        });

        return view;
    }




}