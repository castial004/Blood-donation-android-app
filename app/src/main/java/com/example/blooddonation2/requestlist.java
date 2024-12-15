package com.example.blooddonation2;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class requestlist extends AppCompatActivity {
    RecyclerView recyclerView;
    mydbhelper mydb;
    ArrayList<String> usernames, phoneNumbers, bloodGroups;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestlist);

        mydb = new mydbhelper(requestlist.this);

        // Initialize the RecyclerView and data lists
        recyclerView = findViewById(R.id.recyclerView);
        usernames = new ArrayList<>();
        phoneNumbers = new ArrayList<>();
        bloodGroups = new ArrayList<>();

        // Apply window insets for padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Fetch data and set up RecyclerView
        storeDataInArrays();
        customAdapter = new CustomAdapter(this, usernames, phoneNumbers, bloodGroups);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    void storeDataInArrays() {
        Cursor cursor = mydb.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                usernames.add(cursor.getString(1)); // Username column
                phoneNumbers.add(cursor.getString(2)); // Phone column
                bloodGroups.add(cursor.getString(3)); // Blood group column
            }
        }
        cursor.close(); // Close the cursor to avoid resource leaks
    }
}
