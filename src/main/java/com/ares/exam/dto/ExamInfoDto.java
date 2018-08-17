package com.ares.exam.dto;
/**
 * 考试信息封装
 * @author szares02
 *
 */
import com.ares.exam.entity.PoliceSelect;

import java.util.List;
public class ExamInfoDto {
	private  ExamDto examDto;//考试基础信息
	private List<PoliceInfoDto> pis;
	private List<PoliceSelect> pss;//考生信息
	private List<ExamQuestionBankDto> qbs;//考题信息
	public ExamDto getExamDto() {
		return examDto;
	}
	public void setExamDto(ExamDto examDto) {
		this.examDto = examDto;
	}
	public List<PoliceInfoDto> getPis() {
		return pis;
	}
	public void setPis(List<PoliceInfoDto> pis) {
		this.pis = pis;
	}

	public List<PoliceSelect> getPss() {
		return pss;
	}

	public void setPss(List<PoliceSelect> pss) {
		this.pss = pss;
	}

	public List<ExamQuestionBankDto> getQbs() {
		return qbs;
	}
	public void setQbs(List<ExamQuestionBankDto> qbs) {
		this.qbs = qbs;
	}
	@Override
	public String toString() {
		return "ExamInfoDto [examDto=" + examDto + ", pis=" + pis +", pss=" + pss + ", qbs=" + qbs + "]";
	}
	
}
