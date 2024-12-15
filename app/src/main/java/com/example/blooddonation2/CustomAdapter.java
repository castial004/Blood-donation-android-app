package com.example.blooddonation2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<String> usernames, phoneNumbers, bloodGroups;

    // Constructor
    public CustomAdapter(Context context, ArrayList<String> usernames, ArrayList<String> phoneNumbers, ArrayList<String> bloodGroups) {
        this.context = context;
        this.usernames = usernames;
        this.phoneNumbers = phoneNumbers;
        this.bloodGroups = bloodGroups;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.myadapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.username.setText(usernames.get(position));
        holder.phoneNumber.setText(phoneNumbers.get(position));
        holder.bloodGroup.setText(bloodGroups.get(position));
    }

    @Override
    public int getItemCount() {
        return usernames.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView username, phoneNumber, bloodGroup;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.textView3);
            phoneNumber = itemView.findViewById(R.id.textView4);
            bloodGroup = itemView.findViewById(R.id.textView5);
        }
    }
}
