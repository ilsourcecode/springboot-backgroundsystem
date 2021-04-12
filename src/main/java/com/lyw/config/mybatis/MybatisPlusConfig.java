package com.lyw.config.mybatis;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {

  @Bean
  public MybatisPlusInterceptor mybatisPlusInterceptor() {
    MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
    //内部的分页插件
    PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
    //设置请求的页面大于最大页面后的操作，true跳回到首页，false继续请求，默认false
    paginationInnerInterceptor.setOverflow(true);
    //设置每页最大限制，默认500l，-1不受限制
    paginationInnerInterceptor.setMaxLimit(500l);
    mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);
    return mybatisPlusInterceptor;
  }
}
