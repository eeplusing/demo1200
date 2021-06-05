package com.eplusing.spring.springboot.configuration;

import java.io.File;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.valves.AccessLogValve;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;


//@Component
public class MyEmbeddedServletContainerCustomizer implements EmbeddedServletContainerCustomizer {

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		System.out.println(container.getClass());
		
		if(container instanceof TomcatEmbeddedServletContainerFactory){
			TomcatEmbeddedServletContainerFactory factory = (TomcatEmbeddedServletContainerFactory)container;
			factory.setBaseDirectory(new File("D:/logs"));
			factory.setPort(8080);
			factory.addContextValves(getLogAccessLogValue());
			
			factory.addConnectorCustomizers(new MyTomcatConnectorCustomizer());
			
			factory.addInitializers((servletContext) -> {
				System.out.println("servletContext start up");
			});
			
		}
		
		
	}

	
	private AccessLogValve getLogAccessLogValue(){
		
		AccessLogValve log = new AccessLogValve();
		log.setDirectory("D:/logs/springboot/logs");
		log.setEnabled(true);
		log.setPattern("common");
		log.setPrefix("spring-access-log");
		log.setSuffix(".txt");
		return log;
		
	}
	
}

class MyTomcatConnectorCustomizer implements TomcatConnectorCustomizer{

	@Override
	public void customize(Connector connector) {
		System.out.println(connector.getClass());
		Http11NioProtocol protocol = (Http11NioProtocol)connector.getProtocolHandler();
		//设置最大连接数
		protocol.setMaxConnections(2000);
		
		//设置最大线程数
		protocol.setMaxThreads(500);
	}
	
}











