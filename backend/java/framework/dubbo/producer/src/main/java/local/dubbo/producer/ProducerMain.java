package local.dubbo.producer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProducerMain {
    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring.xml"});
        context.start();

        System.out.println(" app run ");
        System.in.read(); // 按任意键退出
    }
}
