package com.bdqn.quartz;

import com.bdqn.utils.DateTimeUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * ClassName: HelloJob
 * create by:  xyf
 * description: 任务测试类
 * create time: 2020/1/13 17:45
 */
public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("执行时间为:"+DateTimeUtil.dateToStr(new Date()));
        System.out.println("hello world");
    }
}
