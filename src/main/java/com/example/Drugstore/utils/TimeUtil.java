package com.example.Drugstore.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeUtil {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static String getDate() {
        return DATE_FORMAT.format(Calendar.getInstance().getTime());
    }
}
