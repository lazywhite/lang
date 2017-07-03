package local.spring;
import local.spring.service.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import local.spring.model.MessagePrinter;
/*
 * Application.java
 * Copyright (C) 2017 white <white@localhost>
 *
 * Distributed under terms of the MIT license.
 */

@Configuration
@ComponentScan
public class Application {
    @Bean
    MessageService mockMessageService(){
        return new MessageService(){
            public String getMessage(){
                return "hello world";
            }
        };
    }

    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();
    }
}

