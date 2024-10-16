package com.urooj.internetprovidermanager;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class FragmentContainerActivity extends AppCompatActivity {

    private String fragmentType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container_activity);

        // Get the fragment type passed from MainActivity
        fragmentType = getIntent().getStringExtra("fragmentType");

        // Determine which fragment to load
        Fragment selectedFragment = null;

        if ("all".equals(fragmentType)) {
            selectedFragment = new AllFragment();
        } else if ("pending".equals(fragmentType)) {
            selectedFragment = new PendingFragment();
        } else if ("paid".equals(fragmentType)) {
            selectedFragment = new PaidFragment();
        }

        // Load the selected fragment
        if (selectedFragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit();
        }
    }
}