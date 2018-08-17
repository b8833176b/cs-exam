package com.ares.exam.dto;

import java.util.ArrayList;
import java.util.List;
/**
 * 考试错误信息,添加考试,更新考试时的错误返回
 * @author szares02
 *
 */
public class ExamErrorInfo {
	private List<ExamQuestionBankError> eqbes;
	private ExamPoliceInfoError epie;
	private List<ExamError> ee;
	private boolean hasError;
	
	public List<ExamQuestionBankError> getEqbes() {
		return eqbes;
	}

	public ExamPoliceInfoError getEpie() {
		return epie;
	}
	public List<ExamError> getEe() {
		return ee;
	}

	public boolean isHasError() {
		return hasError;
	}

	public ExamErrorInfo() {
		// TODO Auto-generated constructor stub
		ee=new ArrayList<>();
		eqbes=new ArrayList<>();
		hasError=false;
	}
	/**
	 * 考试基本信息错误
	 * @author szares02
	 *
	 */

	@SuppressWarnings("unused")
	private class ExamError {
		String msg;
		public ExamError(String msg) {
		
			this.msg = msg;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}
		
	}
	/**
	 * 考生应用错误信息
	 * @author szares02
	 *
	 */
	
	@SuppressWarnings("unused")
	private class ExamPoliceInfoError {
		private String msg; //错误消息

		
		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}
		
	}
	/**
	 * 考试题库引用错误信息

	 * @author szares02
	 *
	 */
	@SuppressWarnings("unused")
	private class ExamQuestionBankError{
		//题库ID
		private Long useQuestionBankID;
		//出现错误的列数   1 题目使用数量
		private Integer columnNum;
		//错误类型           1   题库试题不够  2没有添加题库
		private Integer errorType;
		//题目使用类型
		private Long userType;
		//题库中存在的此种题目数量
		private Integer hasNum;
	
		public Long getUseQuestionBankID() {
			return useQuestionBankID;
		}
		public void setUseQuestionBankID(Long useQuestionBankID) {
			this.useQuestionBankID = useQuestionBankID;
		}
		public Integer getColumnNum() {
			return columnNum;
		}
		public void setColumnNum(Integer columnNum) {
			this.columnNum = columnNum;
		}
		public Integer getErrorType() {
			return errorType;
		}
		public void setErrorType(Integer errorType) {
			this.errorType = errorType;
		}
		public Long getUserType() {
			return userType;
		}
		public void setUserType(Long userType) {
			this.userType = userType;
		}
		public Integer getHasNum() {
			return hasNum;
		}
		public void setHasNum(Integer hasNum) {
			this.hasNum = hasNum;
		}
		
	}
	
	public void addQuestionBankNotEnoughError(Long useQuestionBankID,Long userType,Integer hasNum) {
		ExamQuestionBankError eqbe=new ExamQuestionBankError();
		eqbe.setUseQuestionBankID(useQuestionBankID);
		eqbe.setUserType(userType);
		eqbe.setHasNum(hasNum);
		eqbe.setErrorType(1);
		eqbes.add(eqbe);
		hasError=true;
	}
	public void addNotHasQuestionBankError() {
		ExamQuestionBankError eqbe=new ExamQuestionBankError();
		eqbe.setErrorType(2);
		eqbes.add(eqbe);
		hasError=true;
	}
	
	public void setUserError(String msg) {
		ExamPoliceInfoError ue=new ExamPoliceInfoError();
		ue.setMsg(msg);
		epie=ue;
		hasError=true;
	}

	public void addExamInfoError(String msg) {
		ExamError eer=new ExamError(msg);
		ee.add(eer);
		hasError=true;
	}
	
	
}
