package com.urooj.internetprovidermanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.List;

public class AllFragment extends Fragment {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<User> userList;
    private DatabaseReference databaseReference;
    private FloatingActionButton fabAddUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all, container, false);

        // Initialize RecyclerView and Floating Action Button
        recyclerView = view.findViewById(R.id.recyclerViewAll);
        fabAddUser = view.findViewById(R.id.fab_add_user);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        userList = new ArrayList<>();
        userAdapter = new UserAdapter(userList, getContext(), "all");
        recyclerView.setAdapter(userAdapter);

        // Initialize Firebase reference for "all" users
        databaseReference = FirebaseDatabase.getInstance().getReference("users").child("all");

        // Load users from Firebase
        loadUsers();

        // Set click listener for "Add User" button
        fabAddUser.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), AddUser.class);
            intent.putExtra("status", "all");
            startActivity(intent);
        });

        return view;
    }

    private void loadUsers() {
        // Firebase query to load users goes here (similar for PendingFragment, PaidFragment)
    }
}
