package com.ares.exam.entity;
/**
 * 职务类型
 * @author szares02
 *
 */
public class PostType {
	/**
	 * 职务编号
	 */
	private Long zwbh;
	/**
	 * 职务名称
	 */
	private String zwmc;
	public Long getZwbh() {
		return zwbh;
	}
	public void setZwbh(Long zwbh) {
		this.zwbh = zwbh;
	}
	public String getZwmc() {
		return zwmc;
	}
	public void setZwmc(String zwmc) {
		this.zwmc = zwmc;
	}
	
}
