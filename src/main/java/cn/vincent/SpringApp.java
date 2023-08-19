package cn.vincent;

import cn.vincent.config.VincentProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringApp.class, args);
        VincentProperties vincent = context.getBean(VincentProperties.class);
        System.out.println(vincent.getId());
        System.out.println(vincent.getName());
        System.out.println(vincent.getMsg());
    }
}
