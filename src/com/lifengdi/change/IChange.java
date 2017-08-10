/**  
 * All rights Reserved, Designed By www.lifengdi.com
 * @Title 	Change.java   
 * @Package com.lifengdi.change   
 * @Description 接口类
 * @author  李锋镝
 * @date    2017年8月10日 下午2:37:18   
 * @version v1.0.0 
 * @Copyright 2017 www.lifengdi.com  All rights reserved. 
 */
package com.lifengdi.change;

/**  
 * All rights Reserved, Designed By www.lifengdi.com
 * @ClassName	Change  
 * @Description 转换接口类
 * @author  李锋镝
 * @date    2017年8月10日 下午2:37:18   
 * @version v1.0.0 
 * @Copyright 2017 www.lifengdi.com  All rights reserved. 
 */
public interface IChange<T, O> {
	T change(O o);
}

