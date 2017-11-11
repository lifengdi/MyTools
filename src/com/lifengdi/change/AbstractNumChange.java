/**  
 * All rights Reserved, Designed By www.lifengdi.com
 * @Title 	AbstractNumChange.java   
 * @Package com.lifengdi.change   
 * @Description ����ת��������
 * @author  �����
 * @date    2017��8��10�� ����3:09:35   
 * @version v1.0.0 
 * @Copyright 2017 www.lifengdi.com  All rights reserved. 
 */
package com.lifengdi.change;

/**  
 * All rights Reserved, Designed By www.lifengdi.com
 * @ClassName	AbstractNumChange  
 * @Description ����ת��������
 * @author  �����
 * @date    2017��8��10�� ����3:09:35   
 * @version v1.0.0 
 * @Copyright 2017 www.lifengdi.com  All rights reserved. 
 */
public abstract class AbstractNumChange<T, O> implements IChange<T, O>{
	
	private static final String[] NUM_CHAR = {"��", "һ", "��", "��", "��", "��", "��", "��", "��", "��"};
	private static final String[] UNIT_CHAR = {"", "ʮ", "��", "ǧ"};
	private static final String[] UNIT_SECTION = {"", "��", "��", "��"};
	private static final Object[][] CHN_VALUE_PAIR = {{"ʮ", 10L, 0}, {"��", 100L, 0}, {"ǧ", 1000L, 0},
			{"��", 10000L, 1}, {"��", 100000000L, 1}, {"��", 1000000000000L, 1}};
	
	public static final int ZERO = 0;
	public static final int TEN = 10;
	public static final int HUNDRED = 100;
	public static final int THOUSAND_UNIT = 1000;
	public static final int SECTION_UNIT = 10000;
	/**  
	 * @Title  getNumChar <BR>  
	 * @Description ��ȡ�������ֵ����� <BR>  
	 * @return String[] <BR>  
	 */
	public static String[] getNumChar() {
		return NUM_CHAR;
	}
	/**  
	 * @Title  getUnitChar <BR>  
	 * @Description ��ȡ��������ǧ���µ�λ������ <BR>  
	 * @return String[] <BR>  
	 */
	public static String[] getUnitChar() {
		return UNIT_CHAR;
	}
	/**  
	 * @Title  getUnitSection <BR>  
	 * @Description ��ȡ�������������ϵ�λ������ <BR>  
	 * @return String[] <BR>  
	 */
	public static String[] getUnitSection() {
		return UNIT_SECTION;
	}
	public static Object[][] getChnValuePair() {
		return CHN_VALUE_PAIR;
	}
	
	protected class BooleanEx {
		private int seed;

		public BooleanEx(int seed) {
			super();
			this.seed = seed;
		}

		public int getSeed() {
			return seed;
		}

		public void setSeed(int seed) {
			this.seed = seed;
		}
		
		public boolean getBoolean() {
			return seed == 1;
		}
		
	}
}

