package com.eplusing.spring.springboot;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * 
 * @Conditional 基于条件的自动配置，一般配合Condition接口一起使用，只有接口的实现类返回true才装配
 * 可用在方法或类上，用在方法仅对方法有用，若在类上则对类中的所有方法都起作用
 * @Conditional 的参数为Condition数组，所有条件军返回true才装配
 * */

//@SpringBootConfiguration
//@Conditional({UTF8Condition.class, GBKCondition.class})
public class EncodingConvertConfiguration {
	
	@Bean
	@Conditional(UTF8Condition.class)
	public EncodingConvert createUTF8EncodingConvert(){
		return new UTF8EncodingConvert();
	}
	
	@Bean
	@Conditional(GBKCondition.class)
	public EncodingConvert createGBKEncodingConvert(){
		return new GBKEncodingConvert();
	}

}
