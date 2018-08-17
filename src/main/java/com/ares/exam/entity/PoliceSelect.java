package com.ares.exam.entity;

public class PoliceSelect {

    /** 考生id */
    private String userid;
    /** 考生警号 */
    private String jh;
    /** 考生姓名 */
    private String xm;
    /** 考生性别 */
    private String xb;
    /** 警衔编号 */
    private String jxbh;
    /** 警衔名称 */
    private String jxmc;
    /** 部门编号 */
    private String bmbh;
    /** 部门名称 */
    private String bmmc;
    /** 职务编号 */
    private String zwbh;
    /** 职务名称 */
    private String zwmc;
    /** 单位编号 */
    private String dwbh;
    /** 单位名称 */
    private String dwmc;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    public String getJxbh() {
        return jxbh;
    }

    public void setJxbh(String jxbh) {
        this.jxbh = jxbh;
    }

    public String getJxmc() {
        return jxmc;
    }

    public void setJxmc(String jxmc) {
        this.jxmc = jxmc;
    }

    public String getBmbh() {
        return bmbh;
    }

    public void setBmbh(String bmbh) {
        this.bmbh = bmbh;
    }

    public String getBmmc() {
        return bmmc;
    }

    public void setBmmc(String bmmc) {
        this.bmmc = bmmc;
    }

    public String getZwbh() {
        return zwbh;
    }

    public void setZwbh(String zwbh) {
        this.zwbh = zwbh;
    }

    public String getZwmc() {
        return zwmc;
    }

    public void setZwmc(String zwmc) {
        this.zwmc = zwmc;
    }

    public String getDwbh() {
        return dwbh;
    }

    public void setDwbh(String dwbh) {
        this.dwbh = dwbh;
    }

    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }

    @Override
    public String toString() {
        return "PoliceSelect{" +
                "userid='" + userid + '\'' +
                ", jh='" + jh + '\'' +
                ", xm='" + xm + '\'' +
                ", xb='" + xb + '\'' +
                ", jxbh='" + jxbh + '\'' +
                ", jxmc='" + jxmc + '\'' +
                ", bmbh='" + bmbh + '\'' +
                ", bmmc='" + bmmc + '\'' +
                ", zwbh='" + zwbh + '\'' +
                ", zwmc='" + zwmc + '\'' +
                ", dwbh='" + dwbh + '\'' +
                ", dwmc='" + dwmc + '\'' +
                '}';
    }
}
