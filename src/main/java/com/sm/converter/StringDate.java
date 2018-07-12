package com.sm.converter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StringDate implements Formatter<Date> {
    private String pattern;
    private SimpleDateFormat sd;
    public StringDate(String pattern) {
        super();
        this.pattern = pattern;
        sd = new SimpleDateFormat(pattern);
    }
    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        sd.setLenient(false);
        return sd.parse(s);
    }

    @Override
    public String print(Date date, Locale locale) {

        sd.setLenient(false);
        return sd.format(date);
    }
}
