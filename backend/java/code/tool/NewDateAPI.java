package tool;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * Created by white on 17/7/1.
 */
public class NewDateAPI {
    /*
        LocalDateTime
        LocalDate
        LocalTime
     */
    public static void main(String[] args){
        LocalDateTime now = LocalDateTime.now();
        System.out.println("local datetime: " + now);
        LocalDate date = now.toLocalDate();
        System.out.println("local date: " + date);
        LocalTime time = now.toLocalTime();
        System.out.println("local time: " + time);
        Month month = now.getMonth();
        System.out.println("month name: " + month);
        System.out.println("month value; " + month.getValue());
        int day = now.getDayOfMonth();
        System.out.println("day: " + day);

        LocalDateTime d1 = now.withYear(2011).withDayOfMonth(12);
        System.out.println(d1);

        LocalDate d2 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println(d2);

        LocalTime d3 = LocalTime.of(22, 15);
        System.out.println(d3);

        LocalTime d4 = LocalTime.parse("22:03:24");
        System.out.println(d4);


        // ZonedDateTime
        ZonedDateTime date1 = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Shanghai]");
        ZoneId zoneId = ZoneId.of("Europe/Paris");
        System.out.println("zone id: " + zoneId);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println(currentZone);


        //ChronoUnit  (python: timedelta)
        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println(nextWeek);

        LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
        System.out.println(nextMonth);

        System.out.println(today.withMonth(now.getMonthValue() + 1).withDayOfMonth(1).plus(-1, ChronoUnit.DAYS));//本月的最后一天

        //Period (date based difference) Duration(time based difference)
        System.out.println(Period.between(nextWeek, today).getDays()); // (second - first),  getMonth(), getYear()
        System.out.println(Duration.between(now, now.plus(1, ChronoUnit.SECONDS)).getSeconds());


        // transform between old Date API
        Date oldNow = new Date();
        System.out.println(oldNow);
        Instant newNow = oldNow.toInstant();
//        LocalDateTime localDateTime = LocalDateTime.ofInstant(newNow, zoneId);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(newNow, ZoneId.of("UTC"));
        System.out.println(localDateTime);
    }

}
