/**  
 * All rights Reserved, Designed By www.lifengdi.com
 * @Title 	Change.java   
 * @Package com.lifengdi.change   
 * @Description �ӿ���
 * @author  �����
 * @date    2017��8��10�� ����2:37:18   
 * @version v1.0.0 
 * @Copyright 2017 www.lifengdi.com  All rights reserved. 
 */
package com.lifengdi.change;

/**  
 * All rights Reserved, Designed By www.lifengdi.com
 * @ClassName	Change  
 * @Description ת���ӿ���
 * @author  �����
 * @date    2017��8��10�� ����2:37:18   
 * @version v1.0.0 
 * @Copyright 2017 www.lifengdi.com  All rights reserved. 
 */
public interface IChange<T, O> {
	T change(O o);
}

