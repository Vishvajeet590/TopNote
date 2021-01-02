package com.example.topnote.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.topnote.Adapters.PopularRecyclerAdapter;
import com.example.topnote.Models.NoteModel;
import com.example.topnote.Models.UserModel;
import com.example.topnote.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class HomeFragment extends Fragment {
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    RecyclerView popularRecycler;
    PopularRecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        popularRecycler = view.findViewById(R.id.poplarRecyclerView);


        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Popular");
        setPopualRecycler();
        return view;
    }
    public void setPopualRecycler(){
        FirebaseRecyclerOptions<NoteModel> options = new FirebaseRecyclerOptions.Builder<NoteModel>().setQuery(databaseReference,NoteModel.class).build();
        adapter = new PopularRecyclerAdapter(options,getActivity());
        layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        popularRecycler.setLayoutManager(layoutManager);
        popularRecycler.setAdapter(adapter);

    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }


}