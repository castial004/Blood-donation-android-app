package com.example.blooddonation2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class homepage extends AppCompatActivity {
    DrawerLayout d1;
    ImageButton b1;
    TextView t1;
    TextView t2;
    NavigationView n1;
    Button b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_homepage);

        // Apply window insets for padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Retrieve data passed from the previous activity
        Intent intent = getIntent();
        String fullname = intent.getStringExtra("name");
        String phonenumber = intent.getStringExtra("phone");

        // Initialize UI elements
        d1 = findViewById(R.id.main);
        n1 = findViewById(R.id.navigationView);
        View headerView = n1.getHeaderView(0);
        t1 = headerView.findViewById(R.id.username);
        t2 = headerView.findViewById(R.id.phonenumber);
        t1.setText(fullname);
        t2.setText(phonenumber);

        // Set up button for opening the navigation drawer
        b1 = findViewById(R.id.imageButton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d1.openDrawer(GravityCompat.START); // Open the drawer
            }
        });

        // Button for Donor
        b3 = findViewById(R.id.receiverbtn);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this, donatepage.class);
                startActivity(intent);
            }
        });

        // Button for Receiver
        b2 = findViewById(R.id.donorbtn);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle receiver button click here (you can add the logic for the receiver page)
                Intent intent = new Intent(homepage.this, requestlist.class);
                startActivity(intent);
            }
        });
    }
}
