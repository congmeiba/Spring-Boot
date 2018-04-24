package cn.gzsxt.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * 实现Job接口实现方法
 */
public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("进入了MyJob 类 调度了方法"+new Date());
    }
}
