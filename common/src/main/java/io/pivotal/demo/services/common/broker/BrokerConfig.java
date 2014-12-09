package io.pivotal.demo.services.common.broker;

import io.pivotal.demo.services.common.broker.auth.ServiceAuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by sgupta on 12/8/14.
 */
@Component
@Configuration
public class BrokerConfig {

  @Bean
  public WebMvcConfigurerAdapter configurerAdapter() {
    return new WebMvcConfigurerAdapter() {
      @Override
      public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ServiceAuthenticationInterceptor());
      }
    };
  }
}
