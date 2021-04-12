package com.lyw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@MapperScan("com.lyw.mapper")
public class BackgroundsystemApplication {

  public static void main(String[] args) {
    SpringApplication.run(BackgroundsystemApplication.class, args);
  }

  @Configuration
  public class SecurityPermitAll extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests().anyRequest().permitAll()
              .and().csrf().disable();
    }
  }

}
