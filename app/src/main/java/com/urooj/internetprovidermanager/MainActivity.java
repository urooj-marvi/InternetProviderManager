package com.urooj.internetprovidermanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonAll, buttonPending, buttonPaid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons
        buttonAll = findViewById(R.id.buttonAll);
        buttonPending = findViewById(R.id.buttonPending);
        buttonPaid = findViewById(R.id.buttonPaid);

        // Set onClick listeners to navigate to the respective fragment container activity
        buttonAll.setOnClickListener(v -> openFragmentActivity("all"));
        buttonPending.setOnClickListener(v -> openFragmentActivity("pending"));
        buttonPaid.setOnClickListener(v -> openFragmentActivity("paid"));
    }

    private void openFragmentActivity(String fragmentType) {
        Intent intent = new Intent(MainActivity.this, FragmentContainerActivity.class);
        intent.putExtra("fragmentType", fragmentType);
        startActivity(intent);
    }
}
