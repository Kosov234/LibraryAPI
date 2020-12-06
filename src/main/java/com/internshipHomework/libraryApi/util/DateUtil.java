package com.internshipHomework.libraryApi.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Map;

public class DateUtil {

    private DateUtil(){
        throw new IllegalStateException("Utility class");
    }

    public static long transformDateStringToUnixLong(Map<String,Object> volumeInfo) throws ParseException {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendValue(ChronoField.YEAR,4)
                .optionalStart()
                .appendPattern("-MM[-dd]")
                .optionalEnd()
                .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
                .parseDefaulting(ChronoField.DAY_OF_MONTH,1)
                .toFormatter();

        String buffer = formatter.parse((String)volumeInfo.get("publishedDate"), LocalDate::from).toString();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(buffer);

        return date.getTime()/1000 ;

    }
}
