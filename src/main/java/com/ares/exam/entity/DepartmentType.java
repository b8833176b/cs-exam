package com.ares.exam.entity;
/**
 * 部门类型
 * @author szares02
 *
 */
public class DepartmentType {
	//部门编号
	private Long bmbh;
	//部门名称
	private String bmmc;
	//单位编号
	private Long dwbh;
	public Long getBmbh() {
		return bmbh;
	}
	public void setBmbh(Long bmbh) {
		this.bmbh = bmbh;
	}
	public String getBmmc() {
		return bmmc;
	}
	public void setBmmc(String bmmc) {
		this.bmmc = bmmc;
	}
	public Long getDwbh() {
		return dwbh;
	}
	public void setDwbh(Long dwbh) {
		this.dwbh = dwbh;
	}
	
}
