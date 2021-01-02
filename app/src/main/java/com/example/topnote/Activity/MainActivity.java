package com.example.topnote.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.topnote.R;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class    MainActivity extends AppCompatActivity  {
    public NavController navController ;
    BottomAppBar bottomAppBar;
    FloatingActionButton floatingButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomAppBar = findViewById(R.id.bottomBar);
        floatingButton = findViewById(R.id.fab);
        navController = Navigation.findNavController(this,R.id.navhost_fragment_main);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if(destination.getId() == R.id.homeFragment) {
                    bottomAppBar.setVisibility(View.VISIBLE);
                    floatingButton.setVisibility(View.VISIBLE);
                } else {
                    bottomAppBar.setVisibility(View.GONE);
                    floatingButton.setVisibility(View.GONE);
                }
            }
        });


        

    }

}