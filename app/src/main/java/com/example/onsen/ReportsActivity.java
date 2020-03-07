package com.example.onsen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ReportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

    }

    public void goToReports(View view){
        Intent intent = new Intent( ReportsActivity.this, ReportsActivity.class);
        startActivity(intent);
    }

    public void goToMonitor(View view){
        Intent intent = new Intent( ReportsActivity.this, MonitorActivity.class);
        startActivity(intent);
    }

    public void goToMeditate(View view){
        Intent intent = new Intent( ReportsActivity.this, MeditateActivity.class);
        startActivity(intent);
    }

    public void goToReminder(View view){
        Intent intent = new Intent( ReportsActivity.this, ReminderActivity.class);
        startActivity(intent);
    }




}
