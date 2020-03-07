package com.example.onsen;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MonitorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);


        BottomNavigationView bottomNavBar = findViewById(R.id.navigationBar);
        Menu menu = bottomNavBar.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavBar.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {

            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.nav_reports:
//                        Toast.makeText(MonitorActivity.this, "Reports!!!!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MonitorActivity.this, ReportsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_meditate:
//                        Toast.makeText(MonitorActivity.this, "Meditate!!!!", Toast.LENGTH_LONG).show();
                        Intent intent1 = new Intent(MonitorActivity.this, MeditateActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_monitor:
//                        Toast.makeText(MonitorActivity.this, "Monitor!!!!", Toast.LENGTH_LONG).show();
                        Intent intent2 = new Intent(MonitorActivity.this, MonitorActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_settings:
//                        Toast.makeText(MonitorActivity.this, "Settings!!!!", Toast.LENGTH_LONG).show();
                        Intent intent3 = new Intent(MonitorActivity.this, SettingsActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.nav_reminder:
//                        Toast.makeText(MonitorActivity.this, "Reminder!!!!", Toast.LENGTH_LONG).show();
                        Intent intent4 = new Intent(MonitorActivity.this, ReminderActivity.class);
                        startActivity(intent4);
                        break;
                }

            }

        });
    }

}
