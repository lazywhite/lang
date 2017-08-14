package local.dubbo.consumer;

import local.dubbo.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring.xml" });
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService"); // 获取bean
        String message = "";
        try {
            message = demoService.sayHello("bob");
            System.out.println(" the message from server is:" + message);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
