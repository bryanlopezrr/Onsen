package com.example.onsen;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.media.TimedText;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;

public class ReminderActivity extends AppCompatActivity {

    AlarmManager reminderManager;
    TimePicker reminderTimePicker;
    TextView isSet;
    Calendar calendar;
    PendingIntent pendingIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        final Button turnOffButton = findViewById(R.id.buttonTurnOff);
        turnOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOff();
            }
        });

        Button setButton = findViewById(R.id.buttonSet);
        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setReminder();
            }
        });

        BottomNavigationView bottomNavBar = findViewById(R.id.navigationBar);
        Menu menu = bottomNavBar.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

        reminderManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        reminderTimePicker = findViewById(R.id.timePickerAlarm);
        calendar = Calendar.getInstance();

        bottomNavBar.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {

            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.nav_reports:
//                        Toast.makeText(ReminderActivity.this, "Reports!!!!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent( ReminderActivity.this, ReportsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_meditate:
//                        Toast.makeText(ReminderActivity.this, "Meditate!!!!", Toast.LENGTH_LONG).show();
                        Intent intent1 = new Intent( ReminderActivity.this, MeditateActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_monitor:
//                        Toast.makeText(ReminderActivity.this, "Monitor!!!!", Toast.LENGTH_LONG).show();
                        Intent intent2 = new Intent( ReminderActivity.this, MonitorActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_settings:
//                        Toast.makeText(ReminderActivity.this, "Settings!!!!", Toast.LENGTH_LONG).show();
                        Intent intent3 = new Intent( ReminderActivity.this, SettingsActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.nav_reminder:
//                        Toast.makeText(ReminderActivity.this, "Reminder!!!!", Toast.LENGTH_LONG).show();
                        Intent intent4 = new Intent( ReminderActivity.this, ReminderActivity.class);
                        startActivity(intent4);
                        break;
                }

            }

        });


    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void setReminder(){

        calendar.set(Calendar.HOUR_OF_DAY, reminderTimePicker.getHour());
        calendar.set(Calendar.MINUTE, reminderTimePicker.getMinute());

        int hour = reminderTimePicker.getHour();
        int minute = reminderTimePicker.getMinute();

        String sHour = String.valueOf(hour);
        String sMinute = String.valueOf(minute);

        Toast.makeText(ReminderActivity.this, "Reminder set to " + sHour + ":" + sMinute, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(), ReminderLogic.class);
        intent.putExtra("extra", "reminder on");

        pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),  0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

//        reminderManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        reminderManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis() + 0, pendingIntent);

    }

    public void turnOff(){

        Toast.makeText(ReminderActivity.this, "Reminder OFF", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), ReminderLogic.class);
        intent.putExtra("extra", "reminder off");

        reminderManager.cancel(pendingIntent);

        sendBroadcast(intent);

    }

}
