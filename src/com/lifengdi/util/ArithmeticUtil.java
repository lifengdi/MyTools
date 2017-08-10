package com.lifengdi.util;

import java.math.BigDecimal;

/**
 * 高精度四则运算
 * @author 李锋镝
 * @date 2017年1月18日 下午10:15:53
 * @version 1.0.0
 */
public class ArithmeticUtil {
	
	private ArithmeticUtil(){}
	
	/**
	 * 进行加法运算
	 * @param d1 参数1
	 * @param d2 参数2
	 * @return double 
	 */
	public static double add(double d1, double d2) {
		BigDecimal b1 = BigDecimal.valueOf(d1);
		BigDecimal b2 = BigDecimal.valueOf(d2);
		return b1.add(b2).doubleValue();
	}

	/**
	 * 进行减法运算
	 * @param d1 被减数
	 * @param d2 减数
	 * @return double
	 */
	public static double sub(double d1, double d2) {
		BigDecimal b1 = BigDecimal.valueOf(d1);
		BigDecimal b2 = BigDecimal.valueOf(d2);
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 进行乘法运算
	 * @param d1
	 * @param d2
	 * @return double
	 */
	public static double mul(double d1, double d2) {
		BigDecimal b1 = BigDecimal.valueOf(d1);
		BigDecimal b2 = BigDecimal.valueOf(d2);
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 进行除法运算
	 * @param d1 被除数
	 * @param d2 除数
	 * @param len 小数点后的数字位数
	 * @return double
	 */
	public static double div(double d1, double d2, int len) {
		BigDecimal b1 = BigDecimal.valueOf(d1);
		BigDecimal b2 = BigDecimal.valueOf(d2);
		return b1.divide(b2, len, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 进行四舍五入
	 * @param d 需要进行四舍五的double
	 * @param len 小数点后的数字位数
	 * @return double 
	 */
	public static double round(double d, int len) {
		BigDecimal b1 = BigDecimal.valueOf(d);
		BigDecimal b2 = new BigDecimal(1);
		// 任何一个数字除以1都是原数字
		// ROUND_HALF_UP是BigDecimal的一个常量，
		return b1.divide(b2, len, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 进行四舍五入
	 * @param d 需要进行四舍五的double
	 * @param len 小数点后的数字位数
	 * @return long
	 */
	public static long roundLong(double d, int len) {
		BigDecimal b1 = BigDecimal.valueOf(d);
		BigDecimal b2 = new BigDecimal(1);
		// 任何一个数字除以1都是原数字
		// ROUND_HALF_UP是BigDecimal的一个常量，
		return (long) b1.divide(b2, len, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

}

