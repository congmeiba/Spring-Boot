package cn.gzsxt;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
/**
 * @MapperScan 扫描mapper接口
 */
@MapperScan("cn.gzsxt.mapper")
    public class Application {


        public static void main(String[] args) {
            SpringApplication.run(Application.class,args);
        }


}
