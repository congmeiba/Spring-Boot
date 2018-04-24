package cn.gzsxt;

import cn.gzsxt.filter.BootFilter;
import cn.gzsxt.listener.BootListener;
import cn.gzsxt.serlvet.BootServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @SpringBootApplication 注解是表示这个类是SpringBoot 的启动器
 * @ServletComponentScan : 用于扫描Servlet 等之类的其他注解
 *
 *  不使用ServletComponentScan 的方式映射
 *  使用Bean的方式注入Servlet 的支持
 *
 *
        */
@SpringBootApplication
//@ServletComponentScan
public class Application {

    public static void main(String[] args) {
        //这个类run方法是启动那个启动器
        SpringApplication.run(Application.class,args);
    }


    /**
     * 使用@Bean注解的方式注入访问Servlet,Filter,Listener
     * 这里如果用注入的方式,那么我们得Servlet类就不用写任何注解
     */

    @Bean
    public ServletRegistrationBean getServletRegistrationBean(){
        //创建这个BootServlet
        ServletRegistrationBean srb = new ServletRegistrationBean(new BootServlet());
        //给Servlet一个名字
        srb.setName("bootServlet");
        //添加访问路径
        srb.addUrlMappings("/boot.do");
        return srb;
    }

    /**
     * 注入拦截器
     * @return
     */
    @Bean
    public FilterRegistrationBean getFilterRegistrationBean(){
        FilterRegistrationBean frb = new FilterRegistrationBean(new BootFilter());
        frb.addUrlPatterns("/boot.do");
        return frb;
    }

    /**
     * 注入监听器
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean<BootListener> getServletListenerRegistrationBean(){
        ServletListenerRegistrationBean<BootListener> srb = new ServletListenerRegistrationBean<BootListener>(new BootListener());
        return srb;
    }


}
