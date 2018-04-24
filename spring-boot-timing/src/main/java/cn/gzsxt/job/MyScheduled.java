package cn.gzsxt.job;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 把这个类注入到ioc容器内
 */
@Component
public class MyScheduled {


    /**
     * 使用@Scheduled 注解 cron表达式,什么时候去调用这个方法
     */
    //@Scheduled(cron = "0/3 * * * * ?")
    public void job(){
        System.out.println(new Date());
    }


}
