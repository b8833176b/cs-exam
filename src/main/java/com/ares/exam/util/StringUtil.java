package com.ares.exam.util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class StringUtil {
	/**
	 * 判断是否为空`
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s) {
		if(s!=null&&s.trim().length()>0) {
			return false;
		}
		return true;
	}
	/**
	 * 转换为长整型
	 * @param s
	 * @return
	 */
	public static Long toLong(String s) {
		return Long.valueOf(s);
	}
	
	public static boolean isNumeric(String str){ 
		   Pattern pattern = Pattern.compile("[0-9]*"); 
		   Matcher isNum = pattern.matcher(str);
		   if( !isNum.matches() ){
		       return false; 
		   } 
		   return true; 
	}
	
	//判断是不是abcd字母中的一个
	public static boolean isABCDEF(String s) {
		if(isEmpty(s)) {
			return false;
		}else {
			  Pattern pattern = Pattern.compile("[abcdefABCDEF]");
			   Matcher m = pattern.matcher(s);
			   if(m.matches()) {
				   return true;
			   }else{
				   return false;
			   }
		}
	}
	
	/**
	 * 利用逗号把字符串分割成数组
	 * @param s
	 * @return
	 */
	public static String[] Mysplit(String s) {
		if(s==null||s.length()==0) {
			return null;
		}else {
			return s.split("[,，\\s]");
		}
	
	}
	
	/*public static void main(String[] args) {
		String s="a,A,b，d，b r,2    t";
		String [] as=Mysplit(s);
		Arrays.sort(as);
		for(String key:as) {
			System.out.println(key+" ");
		}
	}*/
}
