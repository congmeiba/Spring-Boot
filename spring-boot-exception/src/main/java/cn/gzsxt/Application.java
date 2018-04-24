package cn.gzsxt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }



    @Bean
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver smer = new SimpleMappingExceptionResolver();
        Properties prop = new Properties();

        prop.put("java.lang.NullPointerException","error2");
        smer.setExceptionMappings(prop);
        return smer;
    }
}
