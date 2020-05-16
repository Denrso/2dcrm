package com.example.myapplication;


import android.graphics.RectF;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.alamkanak.weekview.OnEmptyViewLongClickListener;
import com.alamkanak.weekview.OnEventClickListener;
import com.alamkanak.weekview.OnEventLongClickListener;
import com.alamkanak.weekview.OnMonthChangeListener;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewDisplayable;
import com.alamkanak.weekview.WeekViewEvent;
//import com.alamkanak.weekview.sample.util.ToolbarUtils;

//import org.jetbrains.annotations.NotNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;
/*
public class LegacyActivity extends AppCompatActivity
        implements OnEventClickListener<Event>, OnMonthChangeListener<Event>,
        OnEventLongClickListener<Event>, OnEmptyViewLongClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar toolbar = findViewById(R.id.toolbar);
        WeekView<Event> weekView = findViewById(R.id.weekView);
        //ToolbarUtils.setupWithWeekView(toolbar, weekView);

        database = new EventsDatabase();

        weekView.setOnEventClickListener(this);
        weekView.setOnMonthChangeListener(this);
        weekView.setOnEventLongClickListener(this);
        weekView.setOnEmptyViewLongClickListener(this);
    }

    //@NotNull
    @Override
    public List<WeekViewDisplayable<Event>> onMonthChange(@NonNull Calendar startDate,
                                                          @NonNull Calendar endDate) {

        return database.getEventsInRange(startDate, endDate);
    }

    MonthLoader.MonthChangeListener mMonthChangeListener = new MonthLoader.MonthChangeListener() {
        @Override
        public List<WeekViewEvent> onMonthChange(int newYear, int newMonth) {
            // Populate the week view with some events.
            List<WeekViewEvent> events = getEvents(newYear, newMonth);
            return events;
        }
    };

    @Override
    public void onEventClick(@NonNull Event event, @NonNull RectF eventRect) {
        Toast.makeText(this, "Clicked " + event.getTitle(), LENGTH_SHORT).show();
    }

    @Override
    public void onEventLongClick(@NonNull Event event, @NonNull RectF eventRect) {
        Toast.makeText(this, "Long-clicked event: " + event.getTitle(), LENGTH_SHORT).show();
    }

    @Override
    public void onEmptyViewLongClick(@NonNull Calendar time) {
        DateFormat sdf = SimpleDateFormat.getDateTimeInstance();
        String formattedTime = sdf.format(time.getTime());
        Toast.makeText(this, "Empty view long pressed: " + formattedTime, LENGTH_SHORT).show();
    }

}
*/