package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.usage.UsageEvents;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;


import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;
import  com.alamkanak.weekview.*;
import com.alamkanak.weekview.sample.data.EventsDatabase;
import com.alamkanak.weekview.sample.data.model.Event;


import  retrofit2.converter.gson.GsonConverterFactory;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity
        implements OnEventClickListener<Event>, OnMonthChangeListener<Event>,
        OnEventLongClickListener<Event>, OnEmptyViewLongClickListener{
    private TextView textView;
    private Object itemlv;
    private WeekView mWeekView;
    private EventsDatabase database;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view_result);
        mWeekView = (WeekView) findViewById(R.id.weekView);

        database = new EventsDatabase(this);


        mWeekView.setOnEventClickListener(this);
        mWeekView.setOnMonthChangeListener(this);
        mWeekView.setOnEventLongClickListener(this);
        mWeekView.setOnEmptyViewLongClickListener(this);

        mWeekView.setNumberOfVisibleDays(1);
        List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();

        Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, 5-1);
        startTime.set(Calendar.YEAR, 2020-1);
        Calendar endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR, 1);
        endTime.set(Calendar.MONTH, 5-1);
        //WeekViewEvent event = new  WeekViewEvent(1,"test", startTime, endTime);
        //WeekViewEvent.Builder<Event>(this)
        //event.setColor(getResources().getColor(R.color.event_color_01));
        //events.add(event);

        Retrofit retrofit = new Builder()
                .baseUrl("http://api.2dcrm.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonApi jsonApi = retrofit.create(JsonApi.class);
        Call<List<Item>> call = jsonApi.getItems();
        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {

                if(!response.isSuccessful()){
                    textView.setText("code "+response.code());
                    return;
                }
                List<Item> items = response.body();

                // adapter
                
               /* ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, (Integer) itemlv);
                mListView.setAdapter(adapter);*/

               for(Item item:items){
                    String content="";
                    content += " создано "+item.getCreatedate()+"\n\n";
                    content += " обьявление"+ item.getName()+"\n\n";
                    content += " описание "+item.getDescription()+"\n\n";
                    content += " адрес "+item.getAddress()+"\n\n";
                    content += " цена "+item.getCost()+"\n\n";


                    textView.append(content);

                }

            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                textView.setText(t.getMessage());

            }
        });
    }



    @Override
    public List<WeekViewDisplayable<Event>> onMonthChange(@NonNull Calendar startDate,
                                                          @NonNull Calendar endDate) {

        return database.getEventsInRange(startDate);


    }

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
