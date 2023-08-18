package cn.vincent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}