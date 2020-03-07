package com.example.onsen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MonitorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);
    }

    public void goToReports(View view){
        Intent intent = new Intent( MonitorActivity.this, ReportsActivity.class);
        startActivity(intent);
    }

    public void goToMonitor(View view){
        Intent intent = new Intent( MonitorActivity.this, MonitorActivity.class);
        startActivity(intent);
    }

    public void goToMeditate(View view){
        Intent intent = new Intent( MonitorActivity.this, MeditateActivity.class);
        startActivity(intent);
    }

    public void goToReminder(View view){
        Intent intent = new Intent( MonitorActivity.this, ReminderActivity.class);
        startActivity(intent);
    }
}
