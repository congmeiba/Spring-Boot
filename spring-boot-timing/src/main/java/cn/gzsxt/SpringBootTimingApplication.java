package cn.gzsxt;

import cn.gzsxt.job.MyJob;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * @EnableScheduling 注解开启@Scheduled注解的任务方法调度
 */
@SpringBootApplication
@EnableScheduling
public class SpringBootTimingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTimingApplication.class, args);
    }

    /**
     * 创建JOB对象
     */
    @Bean
    public JobDetailFactoryBean getJobDetailFactoryBean(){
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(MyJob.class);
        return jobDetailFactoryBean;
    }

    /**
     * 创建CronTrigger 时间调度对象
     */
    //@Bean
    public CronTriggerFactoryBean getCronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        cronTriggerFactoryBean.setCronExpression("0/3 * * * * ?");
        return cronTriggerFactoryBean;
    }


    /**
     * 使用SimpleTriggerFactoryBean 时间调度
     * @param jobDetailFactoryBean
     * @return
     */
    @Bean
    public SimpleTriggerFactoryBean getSimpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        simpleTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        //调度次数
        simpleTriggerFactoryBean.setRepeatCount(4);
        //多少秒调度一次
        simpleTriggerFactoryBean.setRepeatInterval(3000);
        return simpleTriggerFactoryBean;
    }


    /**
     * 任务调度器
     */
    @Bean
    public SchedulerFactoryBean getSchedulerFactoryBean(SimpleTriggerFactoryBean simpleTriggerFactoryBean){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(simpleTriggerFactoryBean.getObject());
        return schedulerFactoryBean;
    }

}
