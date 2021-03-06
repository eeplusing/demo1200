package com.eplusing.demo1200.prospring5.ch4.config;

import com.eplusing.demo1200.prospring5.ch4.FoodProviderService;
import com.eplusing.demo1200.prospring5.ch4.kindergarten.FoodProviderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author eplusing
 * @date 2020/3/2
 */
@Configuration
@Profile("kindergarten")
public class KindergartenConfig {
    @Bean
    public FoodProviderService foodProviderService() {
        return new FoodProviderServiceImpl();
    }
}
