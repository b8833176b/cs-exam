package com.ares.exam.entity;
/**
 * 警员信息类
 * @author szares02
 *
 */

import java.sql.Date;

public class PoliceInfo {
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
	//出生日期
	private Date csrq;
	//备注
	private String bz;
	//登陆密码
	private String pwd;
	//是否管理员 0-民警，1-超级管理员，2-分局管理员，3-基地管理员，4-教官
	private Integer isAdmin;
	private Date jssj;
	private Long bmbh;
	private Long dwbh;
	private Long jxbh;
	private Long zwbh;
	private Date addTime;
	//用户状态 0-无效,1-有效
	private Integer zt;
	private String mz;
	private String jg;
	private String csdm;
	private String czdm;
	private String xx;
	private String jkzk;
	private String jkzkms;
	private String gzdwqc;
	private Date cjgzrq;
	private String jcgzjlsj;
	private String zzmm;
	private Date cjzzrq;
	private String rylb;
	private Date jrgwysj;
	private String hjszd;
	private String sfzhm;
	private String zc;
	private String ryssbmjz;
	private String ryzt;
	private String rysf;
	private String xmpy;
	private String tjgxszdw;
	private String rygzgw;
	private Long jdbm;
	private String dzyx;
	private Long teacherID;
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
	public Date getCsrq() {
		return csrq;
	}
	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Date getJssj() {
		return jssj;
	}
	public void setJssj(Date jssj) {
		this.jssj = jssj;
	}
	public Long getBmbh() {
		return bmbh;
	}
	public void setBmbh(Long bmbh) {
		this.bmbh = bmbh;
	}
	public Long getDwbh() {
		return dwbh;
	}
	public void setDwbh(Long dwbh) {
		this.dwbh = dwbh;
	}
	public Long getJxbh() {
		return jxbh;
	}
	public void setJxbh(Long jxbh) {
		this.jxbh = jxbh;
	}
	public Long getZwbh() {
		return zwbh;
	}
	public void setZwbh(Long zwbh) {
		this.zwbh = zwbh;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Integer getZt() {
		return zt;
	}
	public void setZt(Integer zt) {
		this.zt = zt;
	}
	public String getMz() {
		return mz;
	}
	public void setMz(String mz) {
		this.mz = mz;
	}
	public String getJg() {
		return jg;
	}
	public void setJg(String jg) {
		this.jg = jg;
	}
	public String getCsdm() {
		return csdm;
	}
	public void setCsdm(String csdm) {
		this.csdm = csdm;
	}
	public String getCzdm() {
		return czdm;
	}
	public void setCzdm(String czdm) {
		this.czdm = czdm;
	}
	public String getXx() {
		return xx;
	}
	public void setXx(String xx) {
		this.xx = xx;
	}
	public String getJkzk() {
		return jkzk;
	}
	public void setJkzk(String jkzk) {
		this.jkzk = jkzk;
	}
	public String getJkzkms() {
		return jkzkms;
	}
	public void setJkzkms(String jkzkms) {
		this.jkzkms = jkzkms;
	}
	public String getGzdwqc() {
		return gzdwqc;
	}
	public void setGzdwqc(String gzdwqc) {
		this.gzdwqc = gzdwqc;
	}
	public Date getCjgzrq() {
		return cjgzrq;
	}
	public void setCjgzrq(Date cjgzrq) {
		this.cjgzrq = cjgzrq;
	}
	public String getJcgzjlsj() {
		return jcgzjlsj;
	}
	public void setJcgzjlsj(String jcgzjlsj) {
		this.jcgzjlsj = jcgzjlsj;
	}
	public String getZzmm() {
		return zzmm;
	}
	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}
	public Date getCjzzrq() {
		return cjzzrq;
	}
	public void setCjzzrq(Date cjzzrq) {
		this.cjzzrq = cjzzrq;
	}
	public String getRylb() {
		return rylb;
	}
	public void setRylb(String rylb) {
		this.rylb = rylb;
	}
	public Date getJrgwysj() {
		return jrgwysj;
	}
	public void setJrgwysj(Date jrgwysj) {
		this.jrgwysj = jrgwysj;
	}
	public String getHjszd() {
		return hjszd;
	}
	public void setHjszd(String hjszd) {
		this.hjszd = hjszd;
	}
	public String getSfzhm() {
		return sfzhm;
	}
	public void setSfzhm(String sfzhm) {
		this.sfzhm = sfzhm;
	}
	public String getZc() {
		return zc;
	}
	public void setZc(String zc) {
		this.zc = zc;
	}
	public String getRyssbmjz() {
		return ryssbmjz;
	}
	public void setRyssbmjz(String ryssbmjz) {
		this.ryssbmjz = ryssbmjz;
	}
	public String getRyzt() {
		return ryzt;
	}
	public void setRyzt(String ryzt) {
		this.ryzt = ryzt;
	}
	public String getRysf() {
		return rysf;
	}
	public void setRysf(String rysf) {
		this.rysf = rysf;
	}
	public String getXmpy() {
		return xmpy;
	}
	public void setXmpy(String xmpy) {
		this.xmpy = xmpy;
	}
	public String getTjgxszdw() {
		return tjgxszdw;
	}
	public void setTjgxszdw(String tjgxszdw) {
		this.tjgxszdw = tjgxszdw;
	}
	public String getRygzgw() {
		return rygzgw;
	}
	public void setRygzgw(String rygzgw) {
		this.rygzgw = rygzgw;
	}
	public Long getJdbm() {
		return jdbm;
	}
	public void setJdbm(Long jdbm) {
		this.jdbm = jdbm;
	}
	public String getDzyx() {
		return dzyx;
	}
	public void setDzyx(String dzyx) {
		this.dzyx = dzyx;
	}
	public Long getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(Long teacherID) {
		this.teacherID = teacherID;
	}
	
}
