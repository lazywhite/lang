import java.util.Date;

public class DateTest {
	public static void main(String[] args){
		Date d = new Date();
		System.out.println(d.getClass().getName());
		System.out.println(d.getTime());
		System.out.print(d.toString());


        DateUtils du = new DateUtils();
        du.getTimeStamp();
        du.getFormatDate();
        du.timestampToDate();

        Date d1 = new Date(1412654676572L);
        Date d2 = new Date(1412654776572L);
		System.out.println(du.isSameWeekDates(d1, d2));
	}
}
