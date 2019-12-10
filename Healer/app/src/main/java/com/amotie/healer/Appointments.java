package com.amotie.healer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class Appointments extends AppCompatActivity {
    GridView gridView;

    String  radioID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);
        gridView=(GridView)findViewById(R.id.TimeList);
        TimeList timeList=new TimeList(this);
        gridView.setAdapter(timeList);
    }
    public void BookNow(View view){
        AlertDialog.Builder mbelder=new AlertDialog.Builder(Appointments.this);
        View view1=getLayoutInflater().inflate(R.layout.book_conferm,null);
        ImageView close=(ImageView)view1.findViewById(R.id.Close);
        TextView date=(TextView)view1.findViewById(R.id.dateAppointment);
        TextView time=(TextView)view1.findViewById(R.id.timeAppointment);
        Button confirm=(Button)view1.findViewById(R.id.confermBooking);
        mbelder.setView(view1);
        final AlertDialog dialog=mbelder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.show();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),History.class);
                startActivity(intent);
            }
        });

    }
    class TimeList extends BaseAdapter {
        Context context;

        public TimeList(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return 15;
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
            View row=inflater.inflate(R.layout.timelist,parent,false);
            final Button time=(Button) row.findViewById(R.id.timeButton);
            time.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(radioID!=null){
                        int count=parent.getChildCount();

                        for (int i=0;i<count;i++){
                            View vew=   parent.getChildAt(i);
                            Button time1=(Button) vew.findViewById(R.id.timeButton);
                            time1.setBackground(getResources().getDrawable(R.drawable.whiteborder));
                            time1.setTextColor(getColor(R.color.colorPrimary));

                            System.out.println(i);



                        }


                    }


                    radioID="dsdsasda";

                    time.setBackground(getResources().getDrawable(R.drawable.primarycolorlayout));
                    time.setTextColor(Color.parseColor("#ffffff"));


                }
            });
//            time.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                    if(radioID!=null){
//                        int count=parent.getChildCount();
//
//                        for (int i=0;i<count;i++){
//                         View v=   parent.getChildAt(i);
//                            RadioButton time1=(RadioButton) v.findViewById(R.id.timeButton);
//                            time1.setBackground(getResources().getDrawable(R.drawable.whiteborder));
//                            time1.setTextColor(Color.parseColor("#000000"));
//                           time1.setChecked(false);
//                           System.out.println(i);
//
//
//
//                        }
//
//
//                    }
//
//                    int radioid =buttonView.getId();
//                    radioID=Integer.toString(radioid);
//
//                    buttonView.setBackground(getResources().getDrawable(R.drawable.primarycolorborder));
//                    buttonView.setTextColor(Color.parseColor("#ffffff"));
//
//                    buttonView.setChecked(true);
//                }
//            });

            return row;
        }
    }
}

