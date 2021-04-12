package com.lyw;

import com.lyw.entity.User;
import com.lyw.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.sql.DataSource;

@SpringBootTest
class BackgroundsystemApplicationTests {

  @Autowired
  DataSource dataSource;

  @Autowired
  UserMapper userMapper;

  @Autowired
  StringRedisTemplate stringRedisTemplate;

  @Autowired
  RedisConnectionFactory redisConnectionFactory;

  @Test
  void contextLoads() {
    //System.out.println(dataSource.getClass());
    User user = userMapper.selectById(1);
    System.out.println(user);
  }


  @Test
  void redis() {
    ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
//    operations.set("name", "zs123");
    System.out.println(operations.get("name"));
    System.out.println(redisConnectionFactory.getClass());
  }

}
