package cn.gzsxt.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzMain {


    public static void main(String[] args) throws Exception{
        //1.首先第一步先获取Scheduler工厂获取Scheduler
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();
        //2.创建Job任务
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).build();
        //3.创建触发器Trigger
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/3 * * * * ?")).build();
        //将任务和触发器放入程序调度中
        scheduler.scheduleJob(jobDetail,cronTrigger);
        //开启任务调度
        scheduler.start();
    }
}
