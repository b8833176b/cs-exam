package com.ares.exam.dto;
/**
 * 考生信息封装类
 * @author szares02
 *
 */
public class PoliceInfoDto {
	//警员编号
	private Long userID;
	//警号
	private String jh;
	//姓名
	private String xm;
	//性别
	private String xb;
	//年龄
	private Integer nl;
	//联系电话
	private String lxdh;
	//部门名称
	private String BMMC;
	//单位名称
	private String DWMC;
	//警衔名称
	private String JXMC;
	//职务名称
	private String ZWMC;
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public String getJh() {
		return jh;
	}
	public void setJh(String jh) {
		this.jh = jh;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public Integer getNl() {
		return nl;
	}
	public void setNl(Integer nl) {
		this.nl = nl;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getBMMC() {
		return BMMC;
	}
	public void setBMMC(String bMMC) {
		BMMC = bMMC;
	}
	public String getDWMC() {
		return DWMC;
	}
	public void setDWMC(String dWMC) {
		DWMC = dWMC;
	}
	public String getJXMC() {
		return JXMC;
	}
	public void setJXMC(String jXMC) {
		JXMC = jXMC;
	}
	public String getZWMC() {
		return ZWMC;
	}
	public void setZWMC(String zWMC) {
		ZWMC = zWMC;
	}
	@Override
	public String toString() {
		return "PoliceInfoDto [userID=" + userID + ", jh=" + jh + ", xm=" + xm + ", xb=" + xb + ", nl=" + nl + ", lxdh="
				+ lxdh + ", BMMC=" + BMMC + ", DWMC=" + DWMC + ", JXMC=" + JXMC + ", ZWMC=" + ZWMC + "]";
	}
	
	
}
