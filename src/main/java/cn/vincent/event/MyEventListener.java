package cn.vincent.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        System.out.println(myEvent.getMessage());
    }
}
