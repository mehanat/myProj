package ru.restaurant.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Анатолий on 24.04.2016.
 */
public class TimeConverter {
    public static Date toDate(LocalDate localDate){
        Instant instant=localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }
}
