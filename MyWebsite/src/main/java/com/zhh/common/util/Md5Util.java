package com.zhh.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * MD5加密工具类
 * @author Sylthas
 *
 */
public class Md5Util {
	private static final char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',  'A', 'B', 'C', 'D', 'E', 'F' };
	private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	
	/**
	 * 得到参数加密后的MD5值(大写)
	 * @param inStr
	 * @return 32byte MD5 Value
	 */
	public static String getMD5(String inStr){
		byte[] inStrBytes = null;
		try {
			inStrBytes = inStr.getBytes("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			MessageDigest MD = MessageDigest.getInstance("MD5");
			MD.update(inStrBytes);
			byte[] mdByte = MD.digest();
			char[] str = new char[mdByte.length * 2];
			int k = 0;
			for(int i=0;i<mdByte.length;i++) {
				byte temp = mdByte[i];
				str[k++] = hexDigits[temp >>> 4 & 0xf];
				str[k++] = hexDigits[temp & 0xf];
			}
			return new String(str);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 得到参数加密后的MD5值(小写)
	 * @param inStr
	 * @return 32byte MD5 Value
	 */
	public static String getmd5(String inStr){
		byte[] inStrBytes = null;
		try {
			inStrBytes = inStr.getBytes("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			MessageDigest MD = MessageDigest.getInstance("MD5");
			MD.update(inStrBytes);
			byte[] mdByte = MD.digest();
			char[] str = new char[mdByte.length * 2];
			int k = 0;
			for(int i=0;i<mdByte.length;i++) {
				byte temp = mdByte[i];
				str[k++] = DIGITS[temp >>> 4 & 0xf];
				str[k++] = DIGITS[temp & 0xf];
			}
			return new String(str);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Date(1442282653000l));
		System.out.println(getMD5("1321313"));
		System.out.println(getmd5("1321313"));
		System.out.println(Integer.MAX_VALUE);
//		SortedMap<String , String> clientMap = new TreeMap<String , String>(new Comparator<String>() {
//			@Override
//			public int compare(String o1,String o2) {
//				return o1.compareTo(o2);
//			}
//		});
//		
//		clientMap.put("AAA", "1");
//		clientMap.put("AAAA", "1");
//		clientMap.put("AAaA", "1");
//		clientMap.put("aaa", "1");
//		clientMap.put("!BB", "1");
//		clientMap.put("$bb", "1");
//		clientMap.put("}bb", "1");
//		clientMap.put("~bb", "1");
//		
//		
//		for (String string : clientMap.keySet()) {
//			System.out.println(string);
//		}
	}
}

