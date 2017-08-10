package com.lifengdi.util;

import java.math.BigDecimal;

/**
 * �߾�����������
 * @author �����
 * @date 2017��1��18�� ����10:15:53
 * @version 1.0.0
 */
public class ArithmeticUtil {
	
	private ArithmeticUtil(){}
	
	/**
	 * ���мӷ�����
	 * @param d1 ����1
	 * @param d2 ����2
	 * @return double 
	 */
	public static double add(double d1, double d2) {
		BigDecimal b1 = BigDecimal.valueOf(d1);
		BigDecimal b2 = BigDecimal.valueOf(d2);
		return b1.add(b2).doubleValue();
	}

	/**
	 * ���м�������
	 * @param d1 ������
	 * @param d2 ����
	 * @return double
	 */
	public static double sub(double d1, double d2) {
		BigDecimal b1 = BigDecimal.valueOf(d1);
		BigDecimal b2 = BigDecimal.valueOf(d2);
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * ���г˷�����
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
	 * ���г�������
	 * @param d1 ������
	 * @param d2 ����
	 * @param len С����������λ��
	 * @return double
	 */
	public static double div(double d1, double d2, int len) {
		BigDecimal b1 = BigDecimal.valueOf(d1);
		BigDecimal b2 = BigDecimal.valueOf(d2);
		return b1.divide(b2, len, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * ������������
	 * @param d ��Ҫ�����������double
	 * @param len С����������λ��
	 * @return double 
	 */
	public static double round(double d, int len) {
		BigDecimal b1 = BigDecimal.valueOf(d);
		BigDecimal b2 = new BigDecimal(1);
		// �κ�һ�����ֳ���1����ԭ����
		// ROUND_HALF_UP��BigDecimal��һ��������
		return b1.divide(b2, len, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * ������������
	 * @param d ��Ҫ�����������double
	 * @param len С����������λ��
	 * @return long
	 */
	public static long roundLong(double d, int len) {
		BigDecimal b1 = BigDecimal.valueOf(d);
		BigDecimal b2 = new BigDecimal(1);
		// �κ�һ�����ֳ���1����ԭ����
		// ROUND_HALF_UP��BigDecimal��һ��������
		return (long) b1.divide(b2, len, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

}

