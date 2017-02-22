package com.zhh.personal.test.druid;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class DruidLogTest {
	
	
	@Before
	public void setup(){
		System.getProperties().put("logback.configurationFile", "./conf/logback.xml");
	}
	
	
	@Test
	public void testLog(){
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		StatusPrinter.setPrintStream(System.err);
		StatusPrinter.print(lc);
	}
	
	
	@Test
	public void fileLog(){
		try {
			FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("./conf/spring-base.xml"); 
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
