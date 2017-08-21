package com.lifengdi.change.impl;

import com.lifengdi.change.AbstractNumChange;

/**  
 * All rights Reserved, Designed By www.lifengdi.com
 * @ClassName	NumberToChinese  
 * @Description 阿拉伯数字转中文数字
 * @author  李锋镝
 * @date    2017年8月9日 下午5:33:16   
 * @version v1.0.0 
 * @Copyright 2017 www.lifengdi.com  All rights reserved. 
 */
public class NumberToChinese extends AbstractNumChange<String, Long>{

	/**   
	 * <p>Title: change</p>   
	 * <p>Description: 阿拉伯数字转中文数字 </p>   
	 * @param num
	 * @return   
	 * @see com.lifengdi.change.IChange#change(java.lang.Object)   
	 */  
	@Override
	public String change(Long num) {
		
		//如果是0，则直接返回“零”
		if (num == ZERO) {
			return getNumChar()[0];
		}
		int unitPos = 0;//位数
		StringBuffer cn = new StringBuffer();
		boolean needZero = false;//是否需要补零
		while (num > 0) {
			long section = num % SECTION_UNIT;//num对10000取模
			if (needZero) {
				cn.insert(0, getNumChar()[0]);
			}
			cn.insert(0, section != ZERO ? getUnitSection()[unitPos] : getUnitSection()[ZERO]);
			sectionToChinese(section, cn);
			needZero = (section < THOUSAND_UNIT && section > ZERO);//1000以下0以上的，需要补零
			num = num / SECTION_UNIT;
			unitPos++;
		}
		//处理一十一，一十二等特殊数字
		if (cn.indexOf("一十") == 0) {
			cn = cn.deleteCharAt(0);
		}
		return cn.toString();
	}
	
	/**
	 * 
	 * @Title 	sectionToChinese   
	 * @Description 对取模的余数进行处理
	 * @author 李锋镝
	 * @date   2017年8月10日 下午6:27:02 
	 * @param  @param section
	 * @param  @param cn      
	 */
	private void sectionToChinese(long section, StringBuffer cn) {
		//对万以下的进行处理
		int unitPos = 0;//位数
		boolean zero = true;
		while (section > 0) {
			int index = (int) (section % TEN);//说明是十的整倍数
			if (index == ZERO) {
				if (!zero) {//补零
					zero = true;
					cn.insert(0, getNumChar()[index]);
				}
			} else {
				zero = false;
				cn.insert(0, getUnitChar()[unitPos]);
				cn.insert(0, getNumChar()[index]);
			}
			unitPos++;//从个位开始，每循环一轮位数进一
			section = section / TEN;
		}
	}
	
	private static void out(Object obj) {
		System.out.println(obj.toString());
	}
	
	public static void main(String[] args) {
		NumberToChinese numberToChinese = new NumberToChinese();
		long num = 1001L;
		out(num + " : "+numberToChinese.change(num));
		num = 10001L;
		out(num + " : "+numberToChinese.change(num));
		num = 110001L;
		out(num + " : "+numberToChinese.change(num));
		num = 1110001L;
		out(num + " : "+numberToChinese.change(num));
		num = 11000001L;
		out(num + " : "+numberToChinese.change(num));
		num = 111000001L;
		out(num + " : "+numberToChinese.change(num));
		num = 1111000001L;
		out(num + " : "+numberToChinese.change(num));
		num = 11111100001L;
		out(num + " : "+numberToChinese.change(num));
	}

}

