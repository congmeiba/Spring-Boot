package cn.gzsxt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
    /**
     * Redis 连接池参数
     *
     * @return
     */
    @Bean("jedisPoolConfig")
    public JedisPoolConfig getJedisPoolConfig() {
        JedisPoolConfig jpc = new JedisPoolConfig();
        //jpc.setMaxIdle(10);
        return jpc;
    }

    /**
     * Redis 连接工厂
     */
    @Bean("jedisConnectionFactory")
    public JedisConnectionFactory getJedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
        JedisConnectionFactory jcf = new JedisConnectionFactory();
        //添加连接池
        //jcf.setPoolConfig(jedisPoolConfig);
        //连接redis地址
        //jcf.setHostName("127.0.0.1");
        //redis端口
       // jcf.setPort(6379);
        //数据库
       // jcf.setDatabase(0);
        return jcf;
    }


    /**
     * Redis 模板
     */
    @Bean
    public RedisTemplate<String, Object> getRedisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate rt = new RedisTemplate();

        //管理连接工程
        rt.setConnectionFactory(jedisConnectionFactory);
        /***
         * 设置 key 和value
         * 使用string 序列化
         */
        rt.setKeySerializer(new StringRedisSerializer());
        rt.setValueSerializer(new StringRedisSerializer());

        return rt;
    }
}
