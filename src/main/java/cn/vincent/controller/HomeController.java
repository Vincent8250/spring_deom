package cn.vincent.controller;

import cn.vincent.config.VincentProperties;
import cn.vincent.event.MyEvent;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/h")
public class HomeController {

    @GetMapping("/spring")
    public String hello() {
        return "hello Spring!";
    }

    //region 使用 ThreadLocal 维护Bean的线程安全
    ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "threadStr");

    private String threadStr = "threadStr";

    @GetMapping("/test_1")
    public String test_1() throws InterruptedException {
        threadLocal.set("threadStr test_1");
        Thread.sleep(5000);
        return threadLocal.get();
    }

    @GetMapping("/test_2")
    public String test_2() {
        return threadLocal.get();
    }
    //endregion

    //region 通过 Properties 获取配置文件数据
    @Autowired
    VincentProperties vincent;

    @GetMapping("/vincent")
    public String getVincent() {
        return vincent.getId() + vincent.getName() + vincent.getMsg();
    }
    //endregion

    //region 事件模型
    @Autowired
    ApplicationContext applicationContext;

    @GetMapping("/event")
    public void eventTest(){
        applicationContext.publishEvent(new MyEvent(this, "事件发布"));
    }
    //endregion


}