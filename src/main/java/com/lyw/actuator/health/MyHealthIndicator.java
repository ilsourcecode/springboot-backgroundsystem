package com.lyw.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MyHealthIndicator extends AbstractHealthIndicator {
  @Override
  protected void doHealthCheck(Health.Builder builder) throws Exception {

    Map<String, Object> map = new HashMap<>();

    if (1 == 1)
    {
//      builder.up();
      builder.status(Status.UP);
      map.put("count", 1);
      map.put("ms", 100);
    } else {
      //信息不全
//    builder.down();
      //信息比较全
      builder.status(Status.OUT_OF_SERVICE);
      map.put("err", "超时了！");
      map.put("ms", 3000);
    }

    builder.withDetail("code", 100)
            //
            .withDetails(map);
  }
}
