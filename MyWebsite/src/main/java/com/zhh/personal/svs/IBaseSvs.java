package com.zhh.personal.svs;


import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @date 2017-2-22 下午5:18:43
 * @author zhaohaihao
 */
public interface IBaseSvs {
	
	public final static Logger logger = LoggerFactory.getLogger(IBaseSvs.class);
	
	/** 部分图片扩展名(缺少请自行补充) **/
	public static final String[] imageExtentions = new String[] { "tiff",
		"psd", "eps", "raw",  "png", "pxr", "mac", "jpg", "bmp",
		"tga", "vst", "pcd", "pct", "gif", "ai", "fpx", "img", "cal", "wi",
		"png", "eps", "ai", "sct", "pdp", "dxf", "jpeg" };
	
	public static Properties properties = new Properties();
	
	public static final String proFileName = "global.properties";
	
}
