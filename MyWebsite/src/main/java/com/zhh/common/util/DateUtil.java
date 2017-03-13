package com.zhh.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
//	private static SimpleDateFormat sdfDate = new SimpleDateFormat();
	
	/**
	 * 比较是否同一天
	 * @param dateA
	 * @param dateB
	 * @return
	 */
	public static boolean areSameDay(Date dateA,Date dateB) {
	    Calendar calDateA = Calendar.getInstance();
	    calDateA.setTime(dateA);

	    Calendar calDateB = Calendar.getInstance();
	    calDateB.setTime(dateB);

	    return calDateA.get(Calendar.YEAR) == calDateB.get(Calendar.YEAR)
	            && calDateA.get(Calendar.MONTH) == calDateB.get(Calendar.MONTH)
	            &&  calDateA.get(Calendar.DAY_OF_MONTH) == calDateB.get(Calendar.DAY_OF_MONTH);
	}
	
	public static Date todayTimeZero(){
		return timeZeroDate(0);
	}
	public static Date yestodayTimeZero(){
		return timeZeroDate(-1);
	}
	public static Date tomorrowTimeZero(){
		return timeZeroDate(1);
	}
	
	private static Date timeZeroDate(int day){
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.HOUR, -12);
		ca.set(Calendar.MINUTE, 0);
		ca.set(Calendar.SECOND, 0);
		ca.set(Calendar.MILLISECOND, 0);
		ca.add(Calendar.DATE, day);
		return ca.getTime();
	}
	
	public static Date AddDay(Date date , int day){
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.add(Calendar.DAY_OF_MONTH, day);
		return ca.getTime();
	}
	
	/**
	 * 计算两个日期相差的天数精确到日，dateA-dateB
	 * @param dateA
	 * @param dateB
	 * @return
	 */
	public static int daySub(Date dateA,Date dateB){
		Calendar caA = Calendar.getInstance();
		caA.setTime(dateA);
		caA.set(Calendar.HOUR_OF_DAY, 0);
		caA.set(Calendar.MINUTE, 0);
		caA.set(Calendar.SECOND, 0);
		caA.set(Calendar.MILLISECOND, 0);
		
		Calendar caB = Calendar.getInstance();
		caB.setTime(dateB);
		caB.set(Calendar.HOUR_OF_DAY, 0);
		caB.set(Calendar.MINUTE, 0);
		caB.set(Calendar.SECOND, 0);
		caB.set(Calendar.MILLISECOND, 0);
		
		int day = Long.valueOf((caA.getTimeInMillis()-caB.getTimeInMillis())/86400000L).intValue(); 
		return day;
	}
	/**
	 * 字符串转为日期格式
	 * 
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static Date stringFormatDate(String dateString){
		try {
			SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = bartDateFormat.parse(dateString);
			return date;
		} catch (Exception e) {
			throw new RuntimeException("日期类型转换错误");
		}
	}

	/**
	 * 字符串转为日期格式
	 * 
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static Date stringFormatDateTime(String dateString){
		try{
			SimpleDateFormat bartDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			Date date = bartDateFormat.parse(dateString);
			return date;
		} catch (Exception e) {
			throw new RuntimeException("日期类型转换错误");
		}
	}

	/**
	 * 将时间格式化为含时分秒的字符串
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String dateTimeFormatString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}

	public static String dateFormatString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}

	/**
	 * 将时间格式化为含时分秒的字符串 24小时进制
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static String date24HourFormatString(Date date){
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}

	public static String greenwichMeanTime(Date date) {
		String strExpriseDate = date.toString();
		String[] strExpriseDates = strExpriseDate.split(" ");
		String stringDate = strExpriseDates[0] + ", " + strExpriseDates[2]
				+ " " + strExpriseDates[1] + " " + strExpriseDates[5] + " "
				+ strExpriseDates[3] + " GMT";
		return stringDate;
	}

	public static Date getTheDayOfEndTime(String dateString ) throws ParseException {
		Date date = null;
		if(dateString.contains(" ")){
			date = stringFormatDateTime(dateString);
		}else{
			date = stringFormatDate(dateString);
		}
		return getTheDayOfEndTime(date);
	}
	
	public static Date getTheDayOfEndTime(Date date) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}
	
	public static Date getTheDayOfStartTime(String dateString ) throws ParseException {
		Date date = null;
		if(dateString.contains(" ")){
			date = stringFormatDateTime(dateString);
		}else{
			date = stringFormatDate(dateString);
		}
		return getTheDayOfStartTime(date);
	}
	
	public static Date getTheDayOfStartTime(Date date) throws ParseException{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}
	public static String getStringHour(String date){
		return date.substring(date.indexOf(" ")+1);
	}

	public static void main(String[] args) {
//		System.out.println(daySub(stringFormatDateTime("2015-06-29 00:00:00"), stringFormatDateTime("2015-06-30 23:59:59")));
		
	}
}
