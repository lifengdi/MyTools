package com.lifengdi.change.impl;

import com.lifengdi.change.AbstractNumChange;
import com.lifengdi.change.IChange;

/**  
 * All rights Reserved, Designed By www.lifengdi.com
 * @ClassName	ChineseToNumber  
 * @Description 中文数字转阿拉伯数字   
 * @author  李锋镝
 * @date    2017年8月9日 下午5:32:37   
 * @version v1.0.0 
 * @Copyright 2017 www.lifengdi.com  All rights reserved. 
 */
public class ChineseToNumber extends AbstractNumChange<Long, String>{

	/**   
	 * <p>Title: change</p>   
	 * <p>Description: 中文数字转阿拉伯数字   </p>   
	 * @param obj
	 * @return   
	 * @see com.lifengdi.change.IChange#change(java.lang.Object)   
	 */  
	@Override
	public Long change(String str) {
		
		Long nc = Long.valueOf(ZERO);
		long section = 0;
		long number = 0;
		BooleanEx secUnit = new BooleanEx(0);
		int pos = ZERO;
		
		while (str.length() > pos) {
			long num = chineseToValue(str.substring(pos, pos + 1));
			if (num >= 0) {
				number = num;
				pos++;
				if (pos >= str.length()) {
					section += number;
					nc += section;
					break;
				}
			} else {
				long unit = chineseToUnit(str.substring(pos, pos + 1), secUnit);
				if (secUnit.getBoolean()) {
					section = (section + number) * unit;
					nc += section;
					section = 0;
				} else {
					section += (number * unit);
				}
				number = 0;
				pos++;
				if (pos >= str.length()) {
					nc += section;
					break;
				}
			}
		}
		
		return nc;
	}
	
	/**
	 * 判断是数字还是单位
	 * @author LiFengdi
	 * @date 2017年11月11日 下午2:39:02
	 * @param str
	 * @return
	 */
	private int chineseToValue(String str) {
		for (int i = 0; i < getNumChar().length; i++) {
			if (str.equals(getNumChar()[i])) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 判断是否是节权位，如果是 则返回节权位的值
	 * @author LiFengdi
	 * @date 2017年11月11日 下午3:12:55
	 * @param str
	 * @param secUnit
	 * @return
	 */
	private long chineseToUnit(String str, BooleanEx secUnit) {
		for (int i = 0; i < getChnValuePair().length; i++) {
			if (str.equals(getChnValuePair()[i][0])) {
				secUnit.setSeed((int)getChnValuePair()[i][2]);
				return (long)getChnValuePair()[i][1];
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		ChineseToNumber change = new ChineseToNumber();
		System.out.println(change.change("一兆四千三百一十二亿九千四百九十六万七千二百九十五"));
	}
}

