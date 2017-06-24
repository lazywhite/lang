package tool;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class DateUtils {

    /**
     * 获取时间戳
     * 输出结果:1438692801766
     */
    public void getTimeStamp() {
        Date date = new Date();
        long times = date.getTime();
        System.out.println(times);

        //第二种方法：
        //    new Date().getTime();
    }

    /**
     * 获取格式化的时间
     * 输出格式：2015-08-04 20:55:35
     */
    public void getFormatDate(){
        Date date = new Date();
        long times = date.getTime();//时间戳
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        System.out.println(dateString);
    }

    /**
     * 将时间戳转化为标准时间
     * 输出：Tue Oct 07 12:04:36 CST 2014
     */
    public void timestampToDate(){
        long times = 1412654676572L;
        Date date = new Date(times);
        System.out.println(date);
    }

    public boolean isSameWeekDates(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
        if (0 == subYear) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
                return true;
        } else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {
            // 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
                return true;
        } else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
                return true;
        }
        return false;
    }
}
