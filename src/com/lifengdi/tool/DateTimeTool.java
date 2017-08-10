package com.lifengdi.tool;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ʱ�����ڹ�����
 * @author �����
 * @date 2017��1��18�� ����4:58:33
 * @version 1.0.0
 */
public class DateTimeTool {
	/** 
	 * ȱʡ��������ʾ��ʽ�� yyyy-MM-dd 
	 */  
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";  

	/** 
	 * ȱʡ������ʱ����ʾ��ʽ��yyyy-MM-dd HH:mm:ss 
	 */  
	public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";  

	/**
	 * ȱʡ������ʱ����ʾ��ʽ��yyyy-MM-dd HH:mm
	 */ 
	public static final String DEFAULT_DATE_TIME_HHmm_FORMAT = "yyyy-MM-dd HH:mm"; 

	/**
	 * ȱʡ������ʱ����ʾ��ʽ��yyyy-MM-dd HH
	 */ 
	public static final String DEFAULT_DATE_TIME_HH_FORMAT = "yyyy-MM-dd HH"; 

	/**
	 * ȱʡ��ʱ����ʾ��ʽ��HH:mm:ss
	 */ 
	public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

	/**
	 * ȱʡ��ʱ����ʾ��ʽ��HH:mm
	 */ 
	public static final String DEFAULT_TIME_HHmm_FORMAT = "HH:mm"; 

	/** 
	 * 1s�еĺ����� 
	 */  
	private static final int MILLIS = 1000;  

	/** 
	 * һ�굱�е��·��� 
	 */  
	private static final int MONTH_PER_YEAR = 12;  

	/** 
	 * ˽�й��췽������ֹ�Ը������ʵ���� 
	 */  
	private DateTimeTool() {  
	}  

	/** 
	 * �õ�ϵͳ��ǰ����ʱ�� 
	 * @return ��ǰ����ʱ�� 
	 */  
	public static Date getNow() {  
		return Calendar.getInstance().getTime();  
	}  

	/** 
	 * �õ���ȱʡ��ʽ��ʽ���ĵ�ǰ���� 
	 *  
	 * @return ��ǰ���� 
	 */  
	public static String getDate() {  
		return getDateTime(DEFAULT_DATE_FORMAT);  
	}  

	/** 
	 * �õ���ȱʡ��ʽ��ʽ���ĵ�ǰ���ڼ�ʱ�� 
	 * @return ��ǰ���ڼ�ʱ�� 
	 */  
	public static String getDateTime() {  
		return getDateTime(DEFAULT_DATE_TIME_FORMAT);  
	}  

	/** 
	 * �õ�ϵͳ��ǰ���ڼ�ʱ�䣬����ָ���ķ�ʽ��ʽ�� 
	 * @param pattern ��ʾ��ʽ 
	 * @return ��ǰ���ڼ�ʱ�� 
	 */  
	public static String getDateTime(String pattern) {  
		Date datetime = Calendar.getInstance().getTime();  
		return getDateTime(datetime, pattern);  
	}  


	/** 
	 * �õ���ָ����ʽ��ʽ�������� 
	 * @param date ��Ҫ���и�ʽ�������� 
	 * @param pattern ��ʾ��ʽ 
	 * @return ����ʱ���ַ��� 
	 */  
	public static String getDateTime(Date date, String pattern) {  
		if (null == pattern || "".equals(pattern)) {  
			pattern = DEFAULT_DATE_TIME_FORMAT;  
		}  
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);  
		return dateFormat.format(date);  
	}  

	/** 
	 * �õ���ǰ��� 
	 * @return ��ǰ��� 
	 */  
	public static int getCurrentYear() {  
		return Calendar.getInstance().get(Calendar.YEAR);  

	}  

	/** 
	 * �õ���ǰ�·� 
	 * @return ��ǰ�·� 
	 */  
	public static int getCurrentMonth() {  
		//��get�õ����·�����ʵ�ʵ�С1����Ҫ����  
		return Calendar.getInstance().get(Calendar.MONTH) + 1;  
	}  

	/** 
	 * �õ���ǰ�� 
	 * @return ��ǰ�� 
	 */  
	public static int getCurrentDay() {  
		return Calendar.getInstance().get(Calendar.DATE);  
	}

	/**
	 * �ı䵱ǰʱ�������
	 * @param date ��׼ʱ��
	 * @param seconds Ҫ���ӻ��߼��ٵ������������ø�����ʾ��
	 * @param pattern ���ڸ�ʽ
	 * @return �ı���ʱ��
	 */
	public static String addSeconds(Date date, int seconds, String pattern){
		return getDateTime(addSeconds(date, seconds), pattern);
	}

	/**
	 * �ı䵱ǰʱ�������
	 * @param date ��׼ʱ��
	 * @param seconds Ҫ���ӻ��߼��ٵ������������ø�����ʾ��
	 * @return �ı���ʱ��
	 */
	public static Date addSeconds(Date date, int seconds){
		return add(date, seconds, Calendar.SECOND);
	}

	/**
	 * �ı䵱ǰʱ��ķ�����
	 * @param date ��׼ʱ��
	 * @param minutes Ҫ���ӻ��߼��ٵķ������������ø�����ʾ��
	 * @param pattern ���ڸ�ʽ
	 * @return �ı���ʱ��
	 */
	public static String addMinutes(Date date, int minutes, String pattern){
		return getDateTime(addMinutes(date, minutes), pattern);
	}

	/**
	 * �ı䵱ǰʱ��ķ�����
	 * @param date ��׼ʱ��
	 * @param minutes Ҫ���ӻ��߼��ٵķ������������ø�����ʾ��
	 * @return �ı���ʱ��
	 */
	public static Date addMinutes(Date date, int minutes){
		return add(date, minutes, Calendar.MINUTE);
	}

	/**
	 * �ı䵱ǰʱ���Сʱ
	 * @param date ��׼ʱ��
	 * @param hours Ҫ���ӻ��߼��ٵ�Сʱ�������ø�����ʾ��
	 * @param pattern ���ڸ�ʽ
	 * @return �ı���ʱ��
	 */
	public static String addHours(Date date, int hours, String pattern){
		return getDateTime(addHours(date, hours), pattern);
	}

	/**
	 * �ı䵱ǰʱ���Сʱ
	 * @param date ��׼ʱ��
	 * @param hours Ҫ���ӻ��߼��ٵ�Сʱ�������ø�����ʾ��
	 * @return �ı���ʱ��
	 */
	public static Date addHours(Date date, int hours){
		return add(date, hours, Calendar.HOUR);
	}

	/** 
	 * ȡ�õ�ǰ�����Ժ�����������ڡ����Ҫ�õ���ǰ�����ڣ������ø����� ����Ҫ�õ�������ͬһ������ڣ�������Ϊ-7 
	 * @param date ��׼ʱ��
	 * @param days ���ӵ������� 
	 * @param pattern ���ڸ�ʽ
	 * @return �ı��Ժ������ 
	 */  
	public static String addDays(Date date, int days, String pattern) {  
		return getDateTime(addDays(date, days), pattern);  
	}  

	/** 
	 * ȡ��ָ�������Ժ�����������ڡ����Ҫ�õ���ǰ�����ڣ������ø����� 
	 * @param date ��׼ʱ��
	 * @param days ���ӵ������� 
	 * @return �ı��Ժ������ 
	 */  
	public static Date addDays(Date date, int days) {  
		return add(date, days, Calendar.DATE);  
	}  

	/** 
	 * ȡ�õ�ǰ�����Ժ�ĳ�µ����ڡ����Ҫ�õ���ǰ�·ݵ����ڣ������ø����� 
	 * @param date ��׼ʱ��
	 * @param months ���ӵ��·��� 
	 * @param pattern ���ڸ�ʽ
	 * @return �ı��Ժ������ 
	 */  
	public static String addMonths(Date date, int months, String pattern) {  
		return getDateTime(addMonths(date, months), pattern);  
	}  

	/** 
	 * ȡ��ָ�������Ժ�ĳ�µ����ڡ����Ҫ�õ���ǰ�·ݵ����ڣ������ø����� 
	 * ע�⣬���ܲ���ͬһ���ӣ�����2003-1-31����һ������2003-2-28 
	 * @param date ��׼ʱ��
	 * @param months ���ӵ��·��� 
	 * @return �ı��Ժ������ 
	 */  
	public static Date addMonths(Date date, int months) {  
		return add(date, months, Calendar.MONTH);  
	}

	/** 
	 * ȡ�õ�ǰ�����Ժ�ĳ�������
	 * @param date ��׼ʱ��
	 * @param years ���ӵ������ 
	 * @param pattern ���ڸ�ʽ
	 * @return �ı��Ժ������ 
	 */  
	public static String addYears(Date date, int years, String pattern) {  
		return getDateTime(addYears(date, years), pattern);  
	}  

	/** 
	 * ȡ�õ�ǰ�����Ժ�ĳ�������
	 * @param date ��׼ʱ��
	 * @param years ���ӵ������ 
	 * @return �ı��Ժ������ 
	 */  
	public static Date addYears(Date date, int years) {  
		return add(date, years, Calendar.YEAR);  
	} 

	/** 
	 * �ڲ�������Ϊָ������������Ӧ������������ 
	 * @param date ��׼ʱ��
	 * @param amount �ı������ 
	 * @param field �ı��ʱ��ĵ�λ���ꡢ�¡��ա�ʱ���֡���� 
	 * @return �ı��Ժ������ 
	 */  
	private static Date add(Date date, int amount, int field) {  
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(date);  
		calendar.add(field, amount);  
		return calendar.getTime();  
	}  
	/** 
	 * ͨ��date����ȡ�ø�ʽΪСʱ:���ӵ��ַ��� 
	 * @return 
	 */  
	public static String getHourMin(Date date){  
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		StringBuffer sf = new StringBuffer();          
		sf.append(calendar.get(Calendar.HOUR_OF_DAY));  
		sf.append(":");
		sf.append(calendar.get(Calendar.MINUTE));  
		return sf.toString();  
	}  

	/** 
	 * ��������������������� �õ�һ�����ڼ�ȥ�ڶ��������ǰһ������С�ں�һ�����ڣ��򷵻ظ��� 
	 * @param one ��һ������������Ϊ��׼ 
	 * @param two �ڶ�������������Ϊ�Ƚ� 
	 * @return ��������������� 
	 */  
	public static long diffDays(Date one, Date two) {  
		Calendar calendar = Calendar.getInstance();  
		calendar.clear();  
		calendar.setTime(one);  
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONDAY), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);  
		Date d1 = calendar.getTime();  
		calendar.clear();  
		calendar.setTime(two);  
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONDAY), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);  
		Date d2 = calendar.getTime();  
		final int MILISECONDS = 24 * 60 * 60 * 1000;  
		BigDecimal r = new BigDecimal(new Double((d1.getTime() - d2.getTime())) / MILISECONDS);          
		return Math.round(r.doubleValue());  
	}  

	/** 
	 * ����������������·��� ���ǰһ������С�ں�һ�����ڣ��򷵻ظ��� 
	 * @param one ��һ������������Ϊ��׼ 
	 * @param two �ڶ�������������Ϊ�Ƚ� 
	 * @return ������������·��� 
	 */  
	public static int diffMonths(Date one, Date two) {  

		Calendar calendar = Calendar.getInstance();  

		//�õ���һ�����ڵ���ֺ��·���  
		calendar.setTime(one);  
		int yearOne = calendar.get(Calendar.YEAR);  
		int monthOne = calendar.get(Calendar.MONDAY);  
		//�õ��ڶ������ڵ���ݺ��·�  
		calendar.setTime(two);  
		int yearTwo = calendar.get(Calendar.YEAR);  
		int monthTwo = calendar.get(Calendar.MONDAY);  

		return (yearOne - yearTwo) * MONTH_PER_YEAR + (monthOne - monthTwo);  
	}

	/** 
	 * �������������������� ���ǰһ������С�ں�һ�����ڣ��򷵻ظ��� 
	 * @param one ��һ������������Ϊ��׼ 
	 * @param two �ڶ�������������Ϊ�Ƚ� 
	 * @return ������������·��� 
	 */  
	public static int diffYears(Date one, Date two) {  

		Calendar calendar = Calendar.getInstance();  

		//�õ���һ�����ڵ���� 
		calendar.setTime(one);  
		int yearOne = calendar.get(Calendar.YEAR);  
		//�õ��ڶ������ڵ����
		calendar.setTime(two);  
		int yearTwo = calendar.get(Calendar.YEAR);  

		return yearOne - yearTwo;  
	}

	/** 
	 * ��ȡĳһ�����ڵ���� 
	 * @param date 
	 * @return 
	 */  
	public static int getYear(Date date) {  
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(date);  
		return calendar.get(Calendar.YEAR);  
	}  

	/** 
	 * ��һ���ַ����ø����ĸ�ʽת��Ϊ�������͡�
	 * ע�⣺�������null�����ʾ����ʧ�� 
	 * @param datestr ��Ҫ�����������ַ��� 
	 * @param pattern �����ַ����ĸ�ʽ��Ĭ��Ϊ"yyyy-MM-dd"����ʽ 
	 * @return ����������� 
	 */  
	public static Date parse(String dateStr, String pattern) {  
		Date date = null;  
		if (null == pattern || "".equals(pattern)) {  
			pattern = DEFAULT_DATE_FORMAT;  
		}  
		try {  
			SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);  
			date = dateFormat.parse(dateStr);  
		} catch (ParseException e) {  
			e.printStackTrace();  
		}  
		return date;  
	}  

	/** 
	 * ���ر��µ����һ�� 
	 * @return �������һ������� 
	 */  
	public static Date getMonthLastDay() {  
		return getMonthLastDay(getNow());  
	}  

	/** 
	 * ���ظ��������е��·��е����һ�� 
	 *  
	 * @param date ��׼���� 
	 * @return �������һ������� 
	 */  
	public static Date getMonthLastDay(Date date) {  

		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(date);  

		//����������Ϊ��һ�µ�һ��  
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, 1);  

		//��ȥ1�죬�õ��ļ����µ����һ��  
		calendar.add(Calendar.DATE, -1);  

		return calendar.getTime();  
	}  

	/** 
	 * ����������������֮�������һ������-�ڶ������� 
	 * @param date1  
	 * @param date2 
	 * @param onlyTime �Ƿ�ֻ����2�����ڵ�ʱ����죬�������ڣ�true����ֻ����ʱ��� 
	 * @return 
	 */  
	public static long diffSeconds(Date date1, Date date2, boolean onlyTime) {  
		if (onlyTime) {  
			Calendar calendar = Calendar.getInstance();  
			calendar.setTime(date1);  
			//calendar.set(1984, 5, 24);  
			long t1 = calendar.getTimeInMillis();  
			calendar.setTime(date2);  
			//calendar.set(1984, 5, 24);  
			long t2 = calendar.getTimeInMillis();  
			return (t1-t2)/MILLIS;  
		} else {  
			return (date1.getTime()-date2.getTime())/MILLIS;  
		}  
	}  

	/**
	 * ����������������֮�������һ������-�ڶ������� 
	 * @param date1 
	 * @param date2 
	 * @return 
	 */  
	public static long diffSeconds(Date date1, Date date2) {  
		return diffSeconds(date1, date2, false);  
	}  

	/** 
	 * ��������ȷ�����ڼ�:1-�����գ�2-����һ.....
	 * @param date 
	 * @return 
	 */  
	public static int getDayOfWeek(Date date){  
		Calendar cd = Calendar.getInstance();     
		cd.setTime(date);     
		int mydate = cd.get(Calendar.DAY_OF_WEEK);   
		return mydate;  
	}  

	/** 
	 * ��֤�Ƿ�����Ч����(����ǰ���ڱȽ�) 
	 * @param validDate Ҫ�Ƚϵ�ʱ��
	 * @param format �����ַ����ĸ�ʽ 
	 * @return 
	 */  
	public static boolean isValidDate(String validDate, String format) {  
		return isValidDate(validDate, getDateTime(), format);  
	}

	/** 
	 * ��֤�Ƿ�����Ч����(����ǰ���ڱȽ�) 
	 * @param validDate Ҫ�Ƚϵ�ʱ��
	 * @param date ��׼ʱ��
	 * @param format �����ַ����ĸ�ʽ 
	 * @return 
	 */ 
	public static boolean isValidDate(String validDate, String date, String format) {
		if(validDate==null||validDate.equals("")){
			return false;
		}
		Date valid=null;
		Date now = new Date();
		valid = parse(validDate, format);  
		now = parse(date, format);
		return valid.after(now);  
	}
}
