package cn.gzsxt.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @WebListener 注解用于监听器
 */
//@WebListener
public class BootListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("boot Context 监听");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
