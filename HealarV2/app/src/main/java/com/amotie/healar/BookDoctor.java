package com.amotie.healar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.GridView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BookDoctor extends AppCompatActivity {
    GridView gridView;
    String  radioID;
    CalendarView doctorAppointmentDate;
    ArrayList<String> date1=new ArrayList<>();

    ArrayList<String> date=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_doctor);
        gridView=(GridView)findViewById(R.id.bookDoctorTimeList);
        date1.add("9:00 AM");
        date1.add("10:00 AM");
        date1.add("10:00 AM");
        date1.add("10:00 AM");
        date1.add("10:00 AM");
        date1.add("10:00 AM");
        date1.add("10:00 AM");
        date1.add("10:00 AM");
        date1.add("10:00 AM");
        date.add("9:00 AM");
        date.add("9:00 AM");
        date.add("9:00 AM");
        date.add("9:00 AM");
        date.add("9:00 AM");
        date.add("9:00 AM");
        date.add("9:00 AM");
        date.add("9:00 AM");
        TimeList timeList=new TimeList(this,date1);
        gridView.setAdapter(timeList);
        doctorAppointmentDate =(CalendarView)findViewById(R.id.DoctorAppointmentDate);
        doctorAppointmentDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                TimeList timeList=new TimeList(getApplicationContext(),date);
                gridView.setAdapter(timeList);
            }
        });
    }
    class TimeList extends BaseAdapter {
        Context context;
        ArrayList<String> times;

        public TimeList(Context context,ArrayList<String> times) {
            this.context = context;
            this.times = times;

        }

        @Override
        public int getCount() {
            return times.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, final View convertView, final ViewGroup parent) {
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=inflater.inflate(R.layout.book_doctor_time_list,parent,false);
            final CardView time=(CardView) row.findViewById(R.id.timeButton);
            final TextView clockTime=(TextView)row.findViewById(R.id.timeintimeBtn);
            clockTime.setText(times.get(position));
            time.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if(radioID!=null){
                        int count=parent.getChildCount();

                        for (int i=0;i<count;i++){
                            View vew=   parent.getChildAt(i);
                            CardView time1=(CardView) vew.findViewById(R.id.timeButton);
                            TextView clockTime=(TextView)vew.findViewById(R.id.timeintimeBtn);
//                            time1.setBackgroundColor(R.styleable.CardView_cardBackgroundColor);
                            clockTime.setTextColor(getColor(R.color.colorPrimary));

                            System.out.println(i);



                        }


                    }


                    radioID="dsdsasda";

//                    time.setBackgroundColor(R.styleable.CardView_cardBackgroundColor);
                    clockTime.setTextColor(Color.parseColor("#000000"));


                }
            });


            return row;
        }
    }
}
