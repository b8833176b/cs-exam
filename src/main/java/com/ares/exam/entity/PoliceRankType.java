package com.ares.exam.entity;
/**
 * 警衔
 * @author szares02
 *
 */
public class PoliceRankType {
	//警衔编号
	private Long jxbh;
	//警械名称
	private String jxmc;
	//晋升年限
	private Integer JSNX;
	public Long getJxbh() {
		return jxbh;
	}
	public void setJxbh(Long jxbh) {
		this.jxbh = jxbh;
	}
	public String getJxmc() {
		return jxmc;
	}
	public void setJxmc(String jxmc) {
		this.jxmc = jxmc;
	}
	public Integer getJSNX() {
		return JSNX;
	}
	public void setJSNX(Integer jSNX) {
		JSNX = jSNX;
	}
}
