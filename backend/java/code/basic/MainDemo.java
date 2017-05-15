package basic;


public class MainDemo {
	public static void main(String[] args){
		String greeting = "hello";
		int a = 10; 
		double b = 20.5;
		int o, p=10;
		int q = p>10?5:6;//三目运算符
		double $my = 10.1;  //变量命名法则
		float bb = 3.14f; //大写F也合法
		int[] m = {1, 2, 3, 4};
		int n = 10;
		int gg = 2147483647;
		int mm = gg + 5; //溢出， 变为Integer.MIN_VALUE
		char c = 'c'; //字符必须用单引号
		System.out.println(mm);
		System.out.println(Integer.MAX_VALUE);
		
		System.out.println("hello world");
		System.out.println(5+7+"hello world"+5+7);
		System.out.printf("%s  %s\n" ,greeting, "job");
		
	
		

	
	}

}
