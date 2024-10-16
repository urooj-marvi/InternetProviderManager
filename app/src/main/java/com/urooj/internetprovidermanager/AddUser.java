package com.urooj.internetprovidermanager;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddUser extends AppCompatActivity {

    private EditText editTextName, editTextPhone, editTextAmount;
    private Button buttonSave;
    private String status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextAmount = findViewById(R.id.editTextAmount);
        buttonSave = findViewById(R.id.buttonSave);

        // Get status (all, pending, or paid) from intent
        status = getIntent().getStringExtra("status");

        buttonSave.setOnClickListener(v -> saveUser());
    }

    private void saveUser() {
        String name = editTextName.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String amountStr = editTextAmount.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(amountStr)) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        int amount = Integer.parseInt(amountStr);

        // Create a User object
        User user = new User(name, phone, amount);

        // Save to Firebase under the relevant status
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users").child(status);
        String userId = databaseReference.push().getKey();
        databaseReference.child(userId).setValue(user);

        Toast.makeText(this, "User added", Toast.LENGTH_SHORT).show();
        finish(); // Close the activity
    }
}
