/**  
 * All rights Reserved, Designed By www.lifengdi.com
 * @Title 	AbstractNumChange.java   
 * @Package com.lifengdi.change   
 * @Description 数组转换抽象类
 * @author  李锋镝
 * @date    2017年8月10日 下午3:09:35   
 * @version v1.0.0 
 * @Copyright 2017 www.lifengdi.com  All rights reserved. 
 */
package com.lifengdi.change;

/**  
 * All rights Reserved, Designed By www.lifengdi.com
 * @ClassName	AbstractNumChange  
 * @Description 数组转换抽象类
 * @author  李锋镝
 * @date    2017年8月10日 下午3:09:35   
 * @version v1.0.0 
 * @Copyright 2017 www.lifengdi.com  All rights reserved. 
 */
public abstract class AbstractNumChange<T, O> implements IChange<T, O>{
	
	private static final String[] NUM_CHAR = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
	private static final String[] UNIT_CHAR = {"", "十", "百", "千"};
	private static final String[] UNIT_SECTION = {"", "万", "亿", "兆"};
	private static final Object[][] CHN_VALUE_PAIR = {{"十", 10L, 0}, {"百", 100L, 0}, {"千", 1000L, 0},
			{"万", 10000L, 1}, {"亿", 100000000L, 1}, {"兆", 1000000000000L, 1}};
	
	public static final int ZERO = 0;
	public static final int TEN = 10;
	public static final int HUNDRED = 100;
	public static final int THOUSAND_UNIT = 1000;
	public static final int SECTION_UNIT = 10000;
	/**  
	 * @Title  getNumChar <BR>  
	 * @Description 获取中文数字的数组 <BR>  
	 * @return String[] <BR>  
	 */
	public static String[] getNumChar() {
		return NUM_CHAR;
	}
	/**  
	 * @Title  getUnitChar <BR>  
	 * @Description 获取中文数字千以下单位的数组 <BR>  
	 * @return String[] <BR>  
	 */
	public static String[] getUnitChar() {
		return UNIT_CHAR;
	}
	/**  
	 * @Title  getUnitSection <BR>  
	 * @Description 获取中文数字万以上单位的数组 <BR>  
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

