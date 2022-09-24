package com.eplusing.demo1200.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 *
 *静态资源的路径ResourceProperties.CLASSPATH_RESOURCE_LOCATIONS = {
			"classpath:/META-INF/resources/", "classpath:/resources/",
			"classpath:/static/", "classpath:/public/" };
			
  可以通过配置项spring.resources.staticLocations配置
 *
 *
 *
 *拦截器的使用:
 *1.写一个拦截器类实现HandlerInterceptor接口，该接口3个方法
 *2.写一个类继承WebMvcConfigurerAdapter抽象类，重写addInterceptors方法，通过registry.addInterceptor将拦截器类加进去
 *
 *HandlerInterceptor接口，该接口3个方法：
 *preHandle：controller执行之前
 *postHandle：controller执行之后，且页面渲染之前
 *afterCompletion：页面渲染完成之后
 *
 *
 *异常处理页面
 *去除默认的错误页面exclude=ErrorMvcAutoConfiguration.class
 *
 *使用ErrorPageRegistrar方法
 *写一个类实现ErrorPageRegistrar，实现方法registerErrorPages，添加具体的错误处理逻辑
 *
 *
 *
 *全局异常处理步骤：
 *1.写一个类加上注解@ControllerAdvice
 *2.写一个异常处理方法，加上注解@ExceptionHandler(value=Exception.class)，在该方法中处理异常
 *
 *
 *
 *springboot中使用servlet API
 *方法1：编写servlet,然后加上注解、在APP启动类上加上@ServletComponentScan
 *
 *方法2：编写servlet,装配bean到spring容器中
 *servlet->ServletRegistrationBean
 *filter->FilterRegistrationBean
 *listner->ServletRegistrationBean
 *
 *
 *定制tomcat方法
 *方法1：实现EmbeddedServletContainerCustomizer，纳入spring容器中管理
 *方法2：在Spring容器中装配对象EmbeddedServletContainerFactory，
 */

//@ServletComponentScan
//@SpringBootApplication(exclude=ErrorMvcAutoConfiguration.class)
@SpringBootApplication
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
