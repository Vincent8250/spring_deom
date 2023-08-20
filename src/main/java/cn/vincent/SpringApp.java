package cn.vincent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringApp {

    public static void main(String[] args) {
        System.out.println("run之前");
        ConfigurableApplicationContext context = SpringApplication.run(SpringApp.class, args);
        //VincentProperties vincent = context.getBean(VincentProperties.class);
        //System.out.println(vincent.getId());
        //System.out.println(vincent.getName());
        //System.out.println(vincent.getMsg());
    }
}
