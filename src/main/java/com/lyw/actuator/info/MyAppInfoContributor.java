package com.lyw.actuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class MyAppInfoContributor implements InfoContributor {
  @Override
  public void contribute(Info.Builder builder) {
    builder.withDetail("hello", "你好啊！")
            .withDetails(Collections.singletonMap("world", "nihao"));
  }
}
