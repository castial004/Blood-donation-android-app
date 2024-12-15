package com.example.blooddonation2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class donatepage extends AppCompatActivity {
    EditText e1, e2;
    Spinner s1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_donatepage);

        // Initialize views
        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
        s1 = findViewById(R.id.spinner_blood_group);
        b1 = findViewById(R.id.btn_send_request);

        // Apply window insets for padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set onClickListener for the button
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize the database helper
                mydbhelper mydb = new mydbhelper(donatepage.this);

                // Retrieve values from the EditText and Spinner
                String name = e1.getText().toString().trim();
                String phone = e2.getText().toString().trim();
                String bloodgroup = s1.getSelectedItem().toString();

                // Validate inputs
                if (name.isEmpty() || phone.isEmpty() || bloodgroup.equals("Choose Blood Group")) {
                    Toast.makeText(donatepage.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    Toast.makeText(donatepage.this, "Request sent successfully", Toast.LENGTH_SHORT).show();
                }
                // Save data to the database
                mydb.adduser(name, phone, bloodgroup);
                Intent intent = new Intent(donatepage.this, homepage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
