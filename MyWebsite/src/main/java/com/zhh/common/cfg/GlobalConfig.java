package com.zhh.common.cfg;

import com.zhh.common.ConfigReader;

public class GlobalConfig extends ConfigReader {

	public GlobalConfig(String fileName) {
		super(fileName);
	}
	
	private static GlobalConfig def;
	
	public static GlobalConfig getDef() {
		if (def == null) {
			def = new GlobalConfig("global.properties");
		}
		return def;
	}
}
