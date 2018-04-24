package cn.gzsxt;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "cn.gzsxt.dao")
public class SpringBootDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataJpaApplication.class, args);
    }


    @Bean("dataSource")
    public DataSource getDataSource(){
        DruidDataSource dds = new DruidDataSource();
        dds.setDriverClassName("com.mysql.jdbc.Driver");
        dds.setUrl("jdbc:mysql:///spring-boot-data-jpa");
        dds.setUsername("root");
        dds.setPassword("root");
        return dds;
    }


    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean(DataSource dataSource){
        LocalContainerEntityManagerFactoryBean lcemf = new LocalContainerEntityManagerFactoryBean();
        lcemf.setDataSource(dataSource);
        lcemf.setPackagesToScan("cn.gzsxt.entity");
        Properties prop = new Properties();
        prop.put("generateDdl","true");
        prop.put("showSql","true");
        HibernateJpaVendorAdapter hjva  = new HibernateJpaVendorAdapter();
        hjva.setGenerateDdl(true);
        hjva.setShowSql(true);
        lcemf.setJpaVendorAdapter(hjva);
        return lcemf;
    }

}
