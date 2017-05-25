/*
 * enum 不能为本地类型, 字符串成员无需双引号
 * enum 类型也会被编译为单独的class 
 */
enum WeekDay {MON, TUE, WED, THR, FRI, SAT, SUN}

public class EnumTest{
    public static void main(String[] args){
    WeekDay wd = WeekDay.MON;
    System.out.println(wd);
    }
}
