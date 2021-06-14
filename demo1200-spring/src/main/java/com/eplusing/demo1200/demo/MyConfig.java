package com.eplusing.demo1200.demo;

import com.eplusing.demo1200.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Hello world!
 *
 */
@Configuration
public class MyConfig {
	
/*	@Bean
	@Primary
	public UserDao createUserDao(){
		return new UserDao();
	}*/
	
	@Bean
	public User createUser(){
		return new User();
	}
	
	@Bean
	public Animal createAnimal(){
		return new Animal();
	}
	

	@Bean
	public Cat createCat(){
		return new Cat();
	}
	
	
	@Bean
	public CarFactory createJeepFactory(){
		return new CarFactory();
	}
	
	@Bean
	public Car createCar(CarFactory factory){
		return factory.create();
	}
	
	
	@Bean(name="myBean")
	@Scope("prototype")//不指定@Scope("prototype"),则默认为单例
	public MyBean createMyBean()
    {
        return new MyBean();
    }
	
	@Bean
	public RunnabelFactoryBean createRunnabelFactoryBean(){
		return new RunnabelFactoryBean();
	}
}
