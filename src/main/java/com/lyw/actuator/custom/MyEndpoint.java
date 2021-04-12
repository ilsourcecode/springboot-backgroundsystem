package com.lyw.actuator.custom;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
@Endpoint(id = "myservice")
public class MyEndpoint {

  @ReadOperation
  public Map<String, Object> getDockerInfo() {
    return Collections.singletonMap("info", "docker info...");
  }

  @WriteOperation
  public void setDockerInfo() {
    System.out.println("docker destroy!");
  }
}
