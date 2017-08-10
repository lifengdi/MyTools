package com.lifengdi.tool;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * �����ַ���������
 * @author �����
 * @date 2017��1��18�� ����10:19:37
 * @version 1.0.0
 */
public class StringTool {

	private StringTool() {
	}

	/**
	 * �ж��ַ�Ϊ�ջ�մ�
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return (str == null) || (str.length() == 0);
	}

	/**
	 * �ж��ַ�Ϊ�ջ�մ�������Ϊ�ո�
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		return (str == null) || (str.length() == 0) || ("".equals(str.replaceAll(" ", ""))) || ("null".equals(str));
	}

	/**
	 * �Ż��滻�հ��ַ��㷨
	 * @param str
	 * @return
	 */
	public static String replaceAllBlankSpace(String str) {
		if (str != null) {
            int length = str.length();
            if (length > 0) {
                final char[] src = str.toCharArray();
                final char[] dest = new char[length];
                int pos = 0;
                char c = 0;
                for (int i=0; i<length; i++) {
                    c = src[i];
                    if (!Character.isWhitespace(c)) {
                        dest[pos++] = c;
                    }
                }
                str = new String(dest, 0, pos);
            }
        }
        return str;
	}

	/**
	 * ���ַ����еĻس�\r�����з�\n���Ʊ��\t ���ǩ�д�����ʽ���ԣ��ʲ���ȥ���ո�\s*
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str) {
		Pattern p = Pattern.compile("\\t|\r|\n");
		Matcher m = p.matcher(str);
		String after = m.replaceAll("");
		return after;
	}

	/**
	 * �ж��ַ����Ƿ���Ч
	 * @param str
	 * @return
	 */
	public static boolean isValid(String str) {
		return !isEmpty(str);
	}

	/**
	 * �ж����������㷨
	 * @param str
	 * @return
	 */
	
	public static boolean isNumber(String str) {
		if (isBlank(str)) {
			return false;
		}
		
		int sz = str.length();
		// ��¼'.'�ĸ���
		int count = 0;
		for (int i = 0; i < sz; i++) {
			char c = str.charAt(i);
			// ����Ϊ������continue
			if (i == 0 && c == '-') {
				continue;
			}
			//�����ǰ�ַ������֣����һ��Ƿǿհ��ַ�
			if ((!Character.isDigit(c)) && (!Character.isWhitespace(c)) && (c != '.')) {
				return false;
			}
			// Double���Ͱ���'.'������ֻ����һ��
			if (c == '.') {
				count++;
				continue;
			}
			// '.'�ĸ������ܳ���1
			if (count > 1) {
				return false;
			}
		}
		return true;
	}

	/**
	 * ���ַ���ת����double��ֵ �ṩת������
	 * @param str Ҫת����double��ֵ���ַ���
	 * @param defaultNumber ���ת��ʧ�ܵ�Ĭ��ֵ
	 * @return
	 */
	private static Double value(String str, Number defaultNumber) {
		double d = defaultNumber.doubleValue();

		if (isNumber(str)) {
			String reStr = replaceAllBlankSpace(str);
			try {
				d = Double.parseDouble(reStr);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		return d;
	}

	/**
	 * ���ַ���ת����double��ֵ
	 * @param str Ҫת����double��ֵ���ַ���
	 * @param defaultDoubleValue ���ת��ʧ�ܵ�Ĭ��ֵ
	 * @return
	 */
	public static double doubleValue(String str, double defaultDoubleValue) {
		return value(str, defaultDoubleValue);
	}

	/**
	 * ���ַ���ת����int��ֵ
	 * @param str Ҫת����int��ֵ���ַ���
	 * @param defaultIntValue ���ת��ʧ�ܵ�Ĭ��ֵ
	 * @return
	 */
	public static int intValue(String str, int defaultIntValue) {
		if (str!= null) {
			int length = str.length();
			try {
				if (length <= 11) {
					int num = Integer.parseInt(str);
					return num;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			Double d = value(str, defaultIntValue);

			if (d != null && d.intValue() <= Integer.MAX_VALUE) {
				return d.intValue();
			}
		}
		return defaultIntValue;
	}

	/**
	 * ���ַ���ת����long��ֵ
	 * @param str Ҫת����long��ֵ���ַ���
	 * @param defaultLongValue ���ת��ʧ�ܵ�Ĭ��ֵ
	 * @return
	 */
	public static long longValue(String str, long defaultLongValue) {
		Double d = null;
		d = value(str, defaultLongValue);
		if (d != null && d <= Long.MAX_VALUE) {
			return d.longValue();
		}
		return defaultLongValue;
	}

	/**
	 * �滻�ַ����к���XSS���ַ�
	 * @param str
	 * @return
	 */
	public static String replaceXssCharacter(String str) {
		if (str == null) {
			return str;
		}
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot");
		str = str.replaceAll("'", "��");
		return str;
	}
	
	/**
	 * ��ֹSQLע��
	 * @param str
	 * @return
	 */
	public static String escapeSql(String str) {
		if (str == null) {
			return str;
		}
		str = replace(str, "'", "''");
		return str;
	}
	
	/**
	 * �滻�ַ���
	 * @param text ��Ҫ�����滻�ַ����ַ���
	 * @param repl �滻���ַ�
	 * @param with �����滻���ַ�
	 * @return
	 */
	public static String replace(String text, String repl, String with) {
		return replace(text, repl, with, -1);
	}
	
	/**
	 * �滻�ַ���
	 * @param text ��Ҫ�����滻�ַ����ַ���
	 * @param repl �滻���ַ�
	 * @param with �����滻���ַ�
	 * @param max ����滻����
	 * @return
	 */
	public static String replace(String text, String repl, String with, int max) {
		if (isEmpty(text) || isEmpty(repl) || with == null || max == 0)
			return text;
		int start = 0;
		int end = text.indexOf(repl, start);
		if (end == -1)
			return text;
		int replLength = repl.length();
		int increase = with.length() - replLength;
		increase = increase >= 0 ? increase : 0;
		increase *= max >= 0 ? max <= 64 ? max : 64 : 16;
		StringBuffer buf = new StringBuffer(text.length() + increase);
		for (; end != -1; end = text.indexOf(repl, start)) {
			buf.append(text.substring(start, end)).append(with);
			start = end + replLength;
			if (--max == 0)
				break;
		}
		buf.append(text.substring(start));
		return buf.toString();
	}

	/**
	 * �ж��ַ����ܷ�ת�������ڸ�ʽ
	 * @param str Ҫת�����ڸ�ʽ���ַ���
	 * @return
	 */
	public static boolean isValidDate(String str) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		fmt.setLenient(false);
		try {
			fmt.parse(str);
			return true;
		} catch (Exception e) {
			// ���throw java.text.ParseException����NullPointerException����˵����ʽ����
			return false;
		}
	}
	/**
	 * �ж��ַ������Ƿ��� *.* �� ���ļ۸��ʶ
	 * @param str Ҫ�жϵ��ַ���
	 * @return   
	 */
	public static boolean isHavePriceTag(String str){
    	String reg="\\d";
		boolean isHavePriceTag=false;
		if(str.contains(".")){
			String[] contents=str.trim().split("");
    		for(int i=0;i<contents.length;i++){
    			if(contents[i].equals(".")){
    				if(i>0&&i<contents.length-1){
    					int index=i;
    					int leftindex=index-1-1;
    					int rightIndex=index+1;
    					String left=str.substring(leftindex,index-1);
    					String right=str.substring(index,rightIndex);
        				isHavePriceTag=Pattern.matches(reg, left);
                    	isHavePriceTag=Pattern.matches(reg, right);
    				}
    			}else{
    				continue;
    			}
    			if(isHavePriceTag){
    				break;
    			}
    		}
    	}
		if(str.contains("��")){
			isHavePriceTag=true;
		}
		return isHavePriceTag;
	}
	
	/**
	 * ȥ���ַ����еĿո��\s�����з�\n�Ϳ�ͷ���β�Ķ���
	 * @param str
	 * @return
	 */
	public static String stringFilter(String str){
		if(isEmpty(str)){
			return str;
		}
		Pattern p = Pattern.compile("\\s|\n");// ���˵��ַ����еĿո��\s�����з�\n
		Matcher m = p.matcher(str);
		String after = m.replaceAll("");
		if(after.startsWith(",")){// ���˵��ַ�����ͷ�Ķ���
			after = after.substring(1);
		}
		if(after.endsWith(",")){// ���˵��ַ�����β�Ķ���
			after = after.substring(0,after.length() - 1);
		}
		return after;
	}
	
	/**
	 * �ֻ������м���λ�滻��*��
	 * @param mobile
	 * @return
	 */
	public static String stringHidMobile(String mobile){
		if(isEmpty(mobile)){
			return mobile;
		}
		//��������ƥ���Ƿ����ֻ�����
		String reg = "1(3|4|5|7|8|9)\\d{9}";
		boolean b= Pattern.matches(reg,mobile);
		//���ֻ�����Ļ��ٽ����滻������ֱ�ӷ���
		if(b){
			String newNum = mobile.substring(0,3)+"****"+mobile.substring(7);
			return newNum;
		}
		return mobile;
	}

}

