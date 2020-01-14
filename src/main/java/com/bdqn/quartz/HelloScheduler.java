package com.bdqn.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * ClassName: HelloScheduler
 * create by:  xyf
 * description: 调度器测试类
 * create time: 2020/1/13 17:49
 */
public class HelloScheduler {

    public static void main(String[] args) throws SchedulerException {
        //创建JobDetail的实例
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("hellojob", "group1").build();
        //创建一个Trigger的实例，定义该job方法立即执行，并每隔2秒重复执行
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .build();
        //创建Scheduler的实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler=schedulerFactory.getScheduler();
        //开启调度器
        scheduler.start();
        scheduler.scheduleJob(jobDetail,trigger);
    }
}
