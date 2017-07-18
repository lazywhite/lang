package com.local.spring.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by white on 17/7/11.
 */

//自定义formatter必须调用Formatter接口
@Component
public class DateFormatter implements Formatter<Date> {
    //Formatter<Date>  字符串到其他类型的转换
    //Converter: 任意类型到任意类型的转换

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        String[] parts = text.split("[-/:\\s]+");
        String tr = String.join(" ", parts);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH mm ss");
        Date d = null;
        try {
            d = sdf.parse(tr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    @Override
    public String print(Date object, Locale locale) {
        Date d = (Date) object;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(d);
        return date;
    }
}


