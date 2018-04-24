package cn.gzsxt;

import cn.gzsxt.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisApplicationTests {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void stringSet() {
        redisTemplate.opsForValue().set("name","李四");
    }

    @Test
    public void stringGet(){
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    @Test
    public void beanSet(){
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        User user = new User();
        user.setId(1);
        user.setName("zhangsan");
        user.setPassword("123456");
        redisTemplate.opsForValue().set("user:bean",user);
    }
    @Test
    public  void beanGet(){
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        User user = (User) redisTemplate.opsForValue().get("user:bean");
        System.out.println(user);
    }


    @Test
    public void jsonSet(){
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
        User user = new User();
        user.setId(1);
        user.setName("zhangsan");
        user.setPassword("123456");
        redisTemplate.opsForValue().set("user:json",user);
    }
    @Test
    public void jsonGet(){
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
        User user = (User) redisTemplate.opsForValue().get("user:json");
        System.out.println(user);
    }

}
