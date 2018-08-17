package com.ares.exam.util;
/**
 * 常量类
 * @author szares02
 *
 */
public class Constants {
	/**
	 * 警号属性
	 */
	public final static String JH_KEY="jh";
	/**
	 * 用户名属性
	 */
	public final static String USERNAME_KEY = "username";
	
	
	public final static String USERID_KEY = "userid";
	/**
	 * 权限属性
	 */
	public final static String ADMIN_KEY="admin";
	
	/**
	 * 现在正在进行的考试ID
	 */
	public final static String NOWEXAMID_KEY="nowExamID";
	/**
	 * 试题类型枚举
	 * @author szares02
	 *
	 */
	public static enum QuestionType{
		Radio(1,"单选题"),multiple(2,"多选题"),Judgment(3,"判断题"),Cloze(4,"填空题"),Answer(5,"问答题"),typing(6,"打字题");
		private QuestionType(Integer value,String name) {
			// TODO Auto-generated constructor stub
			this.value=value;
			this.name=name;
		}
		private final Integer value;
		private final String name;
		public Integer getValue() {
			return value;
		}
		public String getName() {
			return name;
		}
		public static QuestionType getType(int type) {
			 switch (type) {  
	            case 1:  
	                return QuestionType.Radio;  
	            case 2:  
	                return QuestionType.multiple;  
	            case 3:  
	                return QuestionType.Judgment;  
	            case 4:  
	                return QuestionType.Cloze;  
	            case 5:  
	                return QuestionType.Answer; 
	            case 6:  
	                return QuestionType.typing;
	            default:  
	                return null;  
	            } 
			
		}
		
		
	}

}
