package com.eplusing.demo1200.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import com.eplusing.demo1200.springboot.dao.IUserDao;
import com.eplusing.demo1200.springboot.dao.UserDao;


/**
#日志级别,默认INFO,root标识所有包的级别
#logging.level.*=INFO，*可以是类名或包名
#logging.level.root=DEBUG

日志级别：TRACE/DEGUB/INFO/WARN/ERROR/FATAL/OFF

springboot默认支持logback,在classpath下放logback.xml，logback-spring.xml的文件
 * */
@SpringBootApplication(exclude=WebSocketAutoConfiguration.class)
public class AppLog {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AppLog.class, args);
		
		System.out.println(context.getBean(IUserDao.class).getClass());
		context.getBean(UserDao.class).log();
		
		context.close();
	}
}
