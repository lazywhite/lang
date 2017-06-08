import java.util.Date;
import java.text.SimpleDateFormat;

public class DateTest {
    public static void main(String[] args){
        Date d = new Date();
        System.out.println(d.getTime());
        System.out.print(d.toString());


        DateUtils du = new DateUtils();
        du.getTimeStamp();
        du.getFormatDate();
        du.timestampToDate();

        Date d1 = new Date(1412654676572L);
        Date d2 = new Date(1412654776572L);
        System.out.println(du.isSameWeekDates(d1, d2));

        //parse string to get Date
        String str = "2012-02-10";
        Date d3;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");        
            d3 = sdf.parse(str);
            System.out.println(d3.getTime());
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
