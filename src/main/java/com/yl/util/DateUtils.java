
package com.yl.util;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


/**
 * @author 杨黎
 * @Title DateUtils
 * @Description 时间使用工具类(线程安全)
 * @date 2018/8/30
 */
public final class DateUtils {


	private static final ThreadLocal<DateFormat> SDF_FORMAT = new ThreadLocal<DateFormat>() {
		@Override protected DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); }
	};

	private static final String SDF_COMMON = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 时间转化成指定格式时间(T->java.lang.String)
	 */
	public static String dateFormatToString(final Date date)
	{
		return  SDF_FORMAT.get().format(date);
	}

	/**
	 * 解析指定的字符串到日期格式(T->java.util.Date)["yyyy-MM-dd HH:mm:ss"]
	 */
	public static Date parseToDate(final String source) {
		Date date = null;
		try {
			date =  SDF_FORMAT.get().parse(source);
		} catch (final ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 *使用DateTimeFormatter做时间转换，线程安全（SimpleDateFormat是线程不安全的）
	 * @param date
	 * @return
	 */
	public static String dateTimeFormatterToString(final Date date){
		LocalDateTime dateTime = dateConvertToLocalDateTime(date);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(SDF_COMMON);
		return dateTime.format(formatter);
	}

	/**
	 * 转换String To Date  YYYYMMDDHH24MISS
	 * @return
	 */
	public static Date stringFormatDate(final String dateStr){
		if(StringUtils.isNotBlank(dateStr)){
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(SDF_COMMON);
			try {
				LocalDateTime dateTime = LocalDateTime.parse(dateStr,formatter);
				return localDateTimeConvertToDate(dateTime);
			} catch (Exception e) {
				e.printStackTrace();
				LogUtil.error("Convert String from Date error: ", e);
				return null;
			}
		}else{
			return null;
		}
	}

	/**
	 * 将java.util.Date 转换为java8+ 的java.time.LocalDateTime
	 * @param date
	 * @return
	 */
	public static LocalDateTime dateConvertToLocalDateTime(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}


	/**
	 * 将java8 的 java.time.LocalDateTime 转换为 java.util.Date
	 * @param localDateTime
	 * @return	Date
	 */
	public static Date localDateTimeConvertToDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}


	public static void main(String[] args) {
		System.out.println(DateUtils.dateTimeFormatterToString(new Date()));
		System.out.println(DateUtils.dateFormatToString(new Date()));
		System.out.println(DateUtils.stringFormatDate("2019-05-21 09:09:33"));
	}
}

