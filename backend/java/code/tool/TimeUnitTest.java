package tool;
import java.util.concurrent.TimeUnit;

public class TimeUnitTest  {
	public static void main(String[] args)throws InterruptedException{
		System.out.println("before sleeping");
		TimeUnit.SECONDS.sleep(5);
		System.out.println("after sleeping");
	}
}
