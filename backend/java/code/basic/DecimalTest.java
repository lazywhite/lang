package basic;
import java.math.BigDecimal;

/**
 * BigDecimal用于精确浮点数运算
 */
public class DecimalTest{
    public static void main(String[] args){
        BigDecimal bd = new BigDecimal(10.1);
        BigDecimal bd2 = new BigDecimal(1.3);
        BigDecimal result = bd.add(bd2);
        System.out.println(result.doubleValue());
        System.out.println(result.floatValue());
    }
}
