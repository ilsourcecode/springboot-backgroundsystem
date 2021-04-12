package com.lyw.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;

@Configuration
public class MyDruidDataSource {

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource() throws SQLException {
    DruidDataSource druidDataSource = new DruidDataSource();
    //开启监控，打开防火墙
    druidDataSource.setFilters("stat,wall");
    druidDataSource.setMaxActive(20);
    return druidDataSource;
  }

  /*@Bean
  public ServletRegistrationBean servletRegistrationBean() {
    StatViewServlet statViewServlet = new StatViewServlet();
    ServletRegistrationBean registrationBean =
            new ServletRegistrationBean(statViewServlet, "/druid/*");
    registrationBean.addInitParameter("loginUsername", "admin");
    registrationBean.addInitParameter("loginPassword", "123");
    return registrationBean;
  }

  @Bean
  public FilterRegistrationBean filterRegistrationBean() {
    WebStatFilter filter = new WebStatFilter();
    FilterRegistrationBean<WebStatFilter> registrationBean =
            new FilterRegistrationBean<>(filter);
    registrationBean.addInitParameter("exclusions", "*.js,*.css,*.gif,*.jpg,*.png,*.ico,/druid/*");
//    registrationBean.addInitParameter("loginUsername", "admin");
//    registrationBean.addInitParameter("loginPassword", "123");
    registrationBean.setUrlPatterns(Arrays.asList("/*"));
    return registrationBean;
  }*/
}
