package com.lifengdi.change.impl;

import com.lifengdi.change.AbstractNumChange;

/**  
 * All rights Reserved, Designed By www.lifengdi.com
 * @ClassName	NumberToChinese  
 * @Description ����������ת��������
 * @author  �����
 * @date    2017��8��9�� ����5:33:16   
 * @version v1.0.0 
 * @Copyright 2017 www.lifengdi.com  All rights reserved. 
 */
public class NumberToChinese extends AbstractNumChange<String, Long>{

	/**   
	 * <p>Title: change</p>   
	 * <p>Description: ����������ת�������� </p>   
	 * @param num
	 * @return   
	 * @see com.lifengdi.change.IChange#change(java.lang.Object)   
	 */  
	@Override
	public String change(Long num) {
		
		//�����0����ֱ�ӷ��ء��㡱
		if (num == ZERO) {
			return getNumChar()[0];
		}
		int unitPos = 0;//λ��
		StringBuffer cn = new StringBuffer();
		boolean needZero = false;//�Ƿ���Ҫ����
		while (num > 0) {
			long section = num % SECTION_UNIT;//num��10000ȡģ
			if (needZero) {
				cn.insert(0, getNumChar()[0]);
			}
			cn.insert(0, section != ZERO ? getUnitSection()[unitPos] : getUnitSection()[ZERO]);
			sectionToChinese(section, cn);
			needZero = (section < THOUSAND_UNIT && section > ZERO);//1000����0���ϵģ���Ҫ����
			num = num / SECTION_UNIT;
			unitPos++;
		}
		//����һʮһ��һʮ������������
		if (cn.indexOf("һʮ") == 0) {
			cn = cn.deleteCharAt(0);
		}
		return cn.toString();
	}
	
	/**
	 * 
	 * @Title 	sectionToChinese   
	 * @Description ��ȡģ���������д���
	 * @author �����
	 * @date   2017��8��10�� ����6:27:02 
	 * @param  @param section
	 * @param  @param cn      
	 */
	private void sectionToChinese(long section, StringBuffer cn) {
		//�������µĽ��д���
		int unitPos = 0;//λ��
		boolean zero = true;
		while (section > 0) {
			int index = (int) (section % TEN);//˵����ʮ��������
			if (index == ZERO) {
				if (!zero) {//����
					zero = true;
					cn.insert(0, getNumChar()[index]);
				}
			} else {
				zero = false;
				cn.insert(0, getUnitChar()[unitPos]);
				cn.insert(0, getNumChar()[index]);
			}
			unitPos++;//�Ӹ�λ��ʼ��ÿѭ��һ��λ����һ
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

