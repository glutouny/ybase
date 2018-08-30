
package com.yl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * @author 杨黎
 * @Title DateUtils
 * @Description
 * @date 2018/8/30
 */
public final class DateUtils
{
	public static final SimpleDateFormat SDF_COMMON_CREATE = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat SDF_COMMON_CREATE_YEAR = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat SDF_COMMON = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat SDF_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat SDF_FORMAT_ORDERDETAIL = new SimpleDateFormat("yyyy年MM月dd日");
	public static final SimpleDateFormat SDF_FORMAT_APP = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
	
	public static final SimpleDateFormat SDF_COMMON_REDIS = new SimpleDateFormat("yyyy:MM:dd");

	public static final SimpleDateFormat SDF_ONE_DAYFROM = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
	public static final SimpleDateFormat SDF_ONE_DAYTO = new SimpleDateFormat("yyyy-MM-dd 23:59:59");

	/**
	 * 当前日期转化成指定格式时间(T->java.lang.String)
	 */
	public static <T> T dateFormatToString()
	{
		return (T) SDF_COMMON.format((new Date()));
	}
	
	/**
	 * 指定日期转化成指定格式时间(T->java.lang.String)
	 */
	public static <T> T dateArgsFormatToString(final Date date)
	{
		return (T) SDF_COMMON.format(date);
	}


	/**
	 * 指定日期转化成指定格式时间(T->java.lang.String)
	 */
	public static <T> T dateArgsFormatToDateDetail(final Date date)
	{
		return (T) SDF_FORMAT_ORDERDETAIL.format(date);
	}

	/**
	 * 日期转化成指定格式时间(T->java.lang.String)
	 */
	public static <T> T dateFormatToString(final Date date)
	{
		return (T) SDF_FORMAT.format(date);
	}

	/**
	 * 解析指定的字符串到日期格式(T->java.util.Date)["yyyy-MM-dd HH:mm:ss"]
	 */
	public static <T> T parseToDate(final String source)
	{
		T date = null;
		try
		{
			date = (T) SDF_FORMAT.parse(source);
		}
		catch (final ParseException e)
		{
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 解析指定的字符串到日期格式(T->java.util.Date)["yyyyMMdd HH:mm:ss"]
	 */
	public static <T> T parseToDateForAPP(final String source)
	{
		T date = null;
		try
		{
			date = (T) SDF_FORMAT_APP.parse(source);
		}
		catch (final ParseException e)
		{
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 获取当前月的最后几天(T->java.lang.String)
	 */
	public static <T> List<T> getLastDays(final int days)
	{
		final Calendar calendar = Calendar.getInstance();
		final List<T> list = new ArrayList<T>();
		for (int i = 1; i <= days; i++)
		{
			calendar.add(Calendar.MONTH, 1);
			calendar.set(Calendar.DATE, 1);
			calendar.add(Calendar.DATE, -i);
			final Date theDate = calendar.getTime();
			final T s = (T) SDF_COMMON.format(theDate);
			list.add(s);

		}
		return list;
	}

	/**
	 * 将SAP传过来的日期20180309拆分成2018-03-09
	 * @param str
	 * @param i
	 * @param <T>
	 * @return
	 */
	public static <T> T parseSAPDateToString(String str,int i){
		T result = null;
		String str1 = str.substring(0,i);
		String str2 = str.substring(i,i+2);
		String str3 = str.substring(i+2,str.length());

		result = (T)(str1 + "-" + str2 + "-" + str3);
		return result;
	}

	/**
	 * AP传过来的日期120328拆分成12:03:28
	 * @param str
	 * @param i
	 * @param <T>
	 * @return
	 */
	public static <T> T parseSAPTimeToString(String str,int i){
		T result = null;
		String str1 = str.substring(0,i);
		String str2 = str.substring(i,i+2);
		String str3 = str.substring(i+2,str.length());

		result = (T)(str1 + ":" + str2 + ":" + str3);
		return result;
	}

	/**
	 * 解析指定的字符串到日期格式(T->java.util.Date)["yyyy-MM-dd"]
	 */
	public static <T> T parseToDateByComFormat(final String source)
	{
		T date = null;
		try
		{
			date = (T) SDF_COMMON.parse(source);
		}
		catch (final ParseException e)
		{
			e.printStackTrace();
		}
		return date;
	}
}

