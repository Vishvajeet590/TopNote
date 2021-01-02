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

public class LoginFragment extends Fragment {
    EditText email_text,password_text;
    Button SignInBtn;
    private FirebaseAuth mAuth;
    public NavController navController ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        navController = Navigation.findNavController(getActivity(),R.id.navhost_fragment_main);
        email_text = view.findViewById(R.id.EmailTextField_SignInFragment);
        password_text = view.findViewById(R.id.Password_Field_SignIn);
        SignInBtn = view.findViewById(R.id.SignInBtn_SignInFragment);
        mAuth = FirebaseAuth.getInstance();

        SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_text.getText().toString();
                email = email.trim();
                String pass = password_text.getText().toString();
                pass = pass.trim();
                mAuth.signInWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("SignInFrag", "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    navController.navigate(R.id.action_loginFragment_to_homeFragment);
                                    //updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("SignInFrag", "signInWithEmail:failure", task.getException());
                                    Toast.makeText(getActivity(), "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    //updateUI(null);
                                    // ...
                                }

                                // ...
                            }
                        });
            }
        });
        return view;
    }
}