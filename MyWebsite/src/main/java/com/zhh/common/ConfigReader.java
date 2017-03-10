package com.zhh.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 通用的配置文件读取器
 */
public abstract class ConfigReader {
	protected Properties configProperties;
	protected String fileName;
	protected static Logger logger = LoggerFactory.getLogger(ConfigReader.class);
	
	public ConfigReader(String fileName) {
		this.fileName = fileName;
		init();
	}
	
	/**
	 * 读取某条数据
	 * @param property
	 * @return
	 */
	public String getValue(String property) {
		if (configProperties == null) {
			init();
		}
		return configProperties.getProperty(property);
	}
	
	public Map<String, String> getLikeParamMap(String partParam) {
		if (configProperties == null) {
			init();
		}
		Map<String, String> resMap = new HashMap<String, String>();
		for (Object key : configProperties.keySet()) {
			if (key.toString().contains(partParam)) {
				resMap.put(key.toString(), configProperties.getProperty(key.toString()));
			}
		}
		return resMap;
	}
	
	/**
	 * 读取配置文件
	 */
	public synchronized void init() {
		Properties configPropertiesNew = new Properties();
		Resource res = new ClassPathResource(fileName);
		try {
			configPropertiesNew.load(res.getInputStream());
		} catch (IOException e) {
			logger.info("读取"+fileName+"文件错误",e);
	        return;
		}
		configProperties = configPropertiesNew;
	}
}
