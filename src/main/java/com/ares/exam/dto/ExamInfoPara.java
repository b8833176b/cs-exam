package com.ares.exam.dto;

import java.util.List;

import com.ares.exam.entity.Exam;
import com.ares.exam.entity.ExamPoliceInfo;
import com.ares.exam.entity.ExamQuestionBank;

/**
 * 考试信息参数，用于添加考试
 * @author szares02
 *
 */
public class ExamInfoPara {
	private Exam exam;
	private List<ExamQuestionBank> eqbs;
	private List<ExamPoliceInfo> epis;
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public List<ExamQuestionBank> getEqbs() {
		return eqbs;
	}
	public void setEqbs(List<ExamQuestionBank> eqbs) {
		this.eqbs = eqbs;
	}
	public List<ExamPoliceInfo> getEpis() {
		return epis;
	}
	public void setEpis(List<ExamPoliceInfo> epis) {
		this.epis = epis;
	}
}
