package com.example.lab3_age_calculator;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AgeCalculatorActivity extends AppCompatActivity {
    // ~ For the manual code from the calender by creating instances ~
    //private final Calendar birthDateCalendar = Calendar.getInstance();
    //private final Calendar todayDateCalendar = Calendar.getInstance();

    private CardView fromDataBtn, toDateBtn;
    private Button calculateBtn;
    private TextView birthTv, todayTv;
    private TextView yearTv, monthTv, dayTv;

    DatePickerDialog.OnDateSetListener dateSetListenerFromDate, getDateSetListenerToDate;

    String birthDateLocal = "";
    String todayDateLocal = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_calculator);

        // Getting the references of the text views and buttons
//        TextView todayDate = findViewById(R.id.today_date);
//        TextView birthDate = findViewById(R.id.b_date);
//        TextView year = findViewById(R.id.year);
//        TextView month = findViewById(R.id.month);
//        TextView day = findViewById(R.id.day);
//
//        Button btn = findViewById(R.id.calculateBtn);
// ~ Manual code using Calender ~
//        //Setting the Today's Date text to the present date
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
//        todayDate.setText(sdf.format(todayDateCalendar.getTime()));
//
//        // setting an on click listener for the TextView of birth date
//        birthDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // defining the year month and day for the birth date
//                int year = birthDateCalendar.get(Calendar.YEAR);
//                int month = birthDateCalendar.get(Calendar.MONTH);
//                int day = birthDateCalendar.get(Calendar.DAY_OF_MONTH);
//
//                // Dialog box that opens up in calender format for picking date
//                DatePickerDialog datePickerDialog = new DatePickerDialog(AgeCalculatorActivity.this, new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                        //setting the date picked by the user
//                        birthDateCalendar.set(Calendar.YEAR, year);
//                        birthDateCalendar.set(Calendar.MONTH, month);
//                        birthDateCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//
//                        // Formatting the date to Year/Month/Day
//                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
//                        birthDate.setText(sdf.format(birthDateCalendar.getTime()));
//                    }
//                }, year, month, day);
//                datePickerDialog.show();
//            }
//        });
//
//        todayDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int year = todayDateCalendar.get(Calendar.YEAR);
//                int month = todayDateCalendar.get(Calendar.MONTH);
//                int day = todayDateCalendar.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog datePickerDialog = new DatePickerDialog(AgeCalculatorActivity.this, new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                        todayDateCalendar.set(Calendar.YEAR, year);
//                        todayDateCalendar.set(Calendar.MONTH, month);
//                        todayDateCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
//                        todayDate.setText(sdf.format(todayDateCalendar.getTime()));
//                    }
//                }, year, month, day);
//                datePickerDialog.show();
//            }
//        });
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // getting the year month and day of the today and birth date
//                int birthYear = birthDateCalendar.get(Calendar.YEAR);
//                int birthMonth = birthDateCalendar.get(Calendar.MONTH);
//                int birthDay = birthDateCalendar.get(Calendar.DAY_OF_MONTH);
//
//                int todayYear = todayDateCalendar.get(Calendar.YEAR);
//                int todayMonth = todayDateCalendar.get(Calendar.MONTH);
//                int todayDay = todayDateCalendar.get(Calendar.DAY_OF_MONTH);
//
//                int years = todayYear - birthYear;
//                int months = todayMonth - birthMonth;
//                int days = todayDay - birthDay;
//
//                if (days < 0) {
//                    months--;
//                    days += birthDateCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
//                }
//
//                if (months < 0) {
//                    years--;
//                    months += 12;
//                }
//
//                year.setText(String.valueOf(years));
//                month.setText(String.valueOf(months));
//                day.setText(String.valueOf(days));
//            }
//        });
//    }
//}

        // ~ Code from package -> Joda-time ~

        fromDataBtn = findViewById(R.id.fromDate);
        toDateBtn = findViewById(R.id.toDate);

        calculateBtn = findViewById(R.id.calculateBtn);
        birthTv = findViewById(R.id.b_date);
        todayTv = findViewById(R.id.today_date);
        yearTv = findViewById(R.id.year);
        monthTv = findViewById(R.id.month);
        dayTv = findViewById(R.id.day);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String todayDate = simpleDateFormat.format(calendar.getTime());
        birthTv.setText(todayDate);
        todayTv.setText(todayDate);

        birthDateLocal = todayDate;
        todayDateLocal = todayDate;

        setupBirthDateCalendar(year, month, day);

        setupTodayDateCalendar(year, month, day);
    }

        private void setupTodayDateCalendar ( int year, int month, int day ){

            toDateBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    DatePickerDialog datePickerDialog = new DatePickerDialog(
                            AgeCalculatorActivity.this,

                            (datePicker, selectedYear, selectedMonth, selectedDay) -> {
                                selectedMonth = selectedMonth + 1;
                                String todayDate = selectedDay + "/" + selectedMonth + "/" + selectedDay;
                                todayTv.setText(todayDate);
                                todayDateLocal = todayDate;


                            },

//                        getDateSetListenerToDate,
                            year, month, day
                    );
                    datePickerDialog.show();
                }
            });

        }

        private void setupBirthDateCalendar ( int year, int month, int day ){

            fromDataBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(
                            AgeCalculatorActivity.this,
                            dateSetListenerFromDate,
                            year, month, day
                    );

                    datePickerDialog.show();

                }


            });

            dateSetListenerFromDate = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                    selectedMonth = selectedMonth + 1;
                    String birthDate = selectedDay + "/" + selectedMonth + "/" + selectedYear;
                    birthTv.setText(birthDate);
                    birthDateLocal = birthDate;

                }
            };

        }
    }