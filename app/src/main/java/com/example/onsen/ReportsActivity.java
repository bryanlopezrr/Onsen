package com.example.onsen;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ReportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        BottomNavigationView bottomNavBar = findViewById(R.id.navigationBar);


        bottomNavBar.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {

            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.nav_reports:
//                        Toast.makeText(ReportsActivity.this, "Reports!!!!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent( ReportsActivity.this, ReportsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_meditate:
//                        Toast.makeText(ReportsActivity.this, "Meditate!!!!", Toast.LENGTH_LONG).show();
                        Intent intent1 = new Intent( ReportsActivity.this, MeditateActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_monitor:
//                        Toast.makeText(ReportsActivity.this, "Monitor!!!!", Toast.LENGTH_LONG).show();
                        Intent intent2 = new Intent( ReportsActivity.this, MonitorActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_settings:
//                        Toast.makeText(ReportsActivity.this, "Settings!!!!", Toast.LENGTH_LONG).show();
                        Intent intent3 = new Intent( ReportsActivity.this, SettingsActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.nav_reminder:
//                        Toast.makeText(ReportsActivity.this, "Reminder!!!!", Toast.LENGTH_LONG).show();
                        Intent intent4 = new Intent( ReportsActivity.this, ReminderActivity.class);
                        startActivity(intent4);
                        break;
                }

            }
        });

    }


}