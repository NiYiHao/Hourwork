package com.example.administrator.hourwork;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.zip.DeflaterInputStream;

public class MainActivity extends AppCompatActivity {
    private AlertDialog.Builder builder;
    private Dialog dialog;
    private String[] fruit = {"香蕉", "蘋果", "芭樂"};
    private Context mContext;
    private int mYear,mMonth,mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Button btnmenu = findViewById( R.id.btnmenu );
        Button btnlogin= findViewById( R.id.btnlogin );
        final TextView dateText = findViewById(R.id.date);
        Button btndate = findViewById( R.id.btndate );
        btnmenu.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder = new AlertDialog.Builder( MainActivity.this );
                builder.setTitle( "水果選單" )
                        .setMultiChoiceItems( fruit, null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                            }
                        } )
                        .setPositiveButton( "確定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        } );
                dialog = builder.create();
                dialog.show();

            }
        });
        btnlogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View row = inflater.inflate(R.layout.activity_login , null);
                builder = new AlertDialog.Builder( MainActivity.this );
                builder.setView(inflater.inflate( R.layout.activity_login,null ));
                builder.setPositiveButton( "確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                } );
                builder.setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                } );
                dialog = builder.create();
                dialog.show();
            }
        } );
    btndate.setOnClickListener( new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get( Calendar.YEAR );
            mMonth = c.get( Calendar.MONTH );
            mDay =c.get( Calendar.DAY_OF_MONTH );
            new DatePickerDialog( MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    String format = "日期：" + setDateFormat( year, month, day );
                    dateText.setText( format );
                }
            },mYear,mMonth, mDay).show();
                }
        });

    }
    private String setDateFormat(int year,int month,int day){
        return String.valueOf(year) + "-"
                + String.valueOf(month+1) + "-"
                + String.valueOf(day);
    }
 }

