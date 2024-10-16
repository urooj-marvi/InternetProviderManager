package com.urooj.internetprovidermanager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> userList;
    private Context context;
    private String status;

    public UserAdapter(List<User> userList, Context context, String status) {
        this.userList = userList;
        this.context = context;
        this.status = status;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.useritem, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);

        holder.textViewName.setText(user.getName());
        holder.textViewPhone.setText(user.getPhoneNumber());
        holder.textViewAmount.setText(String.valueOf(user.getAmount()));

        // Call button
        holder.buttonCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + user.getPhoneNumber()));
            context.startActivity(intent);
        });

        // Delete button
        holder.buttonDelete.setOnClickListener(v -> {
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users").child(status);
            databaseReference.child(user.getID()).removeValue();
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewPhone, textViewAmount;
        ImageButton buttonCall, buttonDelete;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textViewName);
            textViewPhone = itemView.findViewById(R.id.textViewPhone);
            textViewAmount = itemView.findViewById(R.id.textViewAmount);
            buttonCall = itemView.findViewById(R.id.buttonCall);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);
        }
    }
}
