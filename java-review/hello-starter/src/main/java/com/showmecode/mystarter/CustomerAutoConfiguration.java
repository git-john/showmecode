package com.showmecode.mystarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CustomerProperties.class)
@ConditionalOnClass(CustomerService.class)
@ConditionalOnProperty(prefix="customer", value="enabled", matchIfMissing=true)
public class CustomerAutoConfiguration {

    @Autowired
    private CustomerProperties customerProperties;

    @Bean
    @ConditionalOnMissingBean(CustomerService.class)
    public CustomerService customerService() {
        CustomerService customerService = new CustomerService();
        customerService.setName(customerProperties.getName());
        return customerService;
    }
}
