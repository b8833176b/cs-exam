package com.ares.exam.dto;

public class PoliceSelectCondition {

    /** 考生id */
    private String userid;
    /** 考生警号 */
    private String jh;
    /** 考生姓名 */
    private String xm;
    /** 考生性别 */
    private String xb;
    /** 警衔编号 */
    private String jx;
    /** 部门编号 */
    private String bm;
    /** 职务编号 */
    private String zw;
    /** 单位编号 */
    private String dw;

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

    public String getJx() {
        return jx;
    }

    public void setJx(String jx) {
        this.jx = jx;
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    public String getZw() {
        return zw;
    }

    public void setZw(String zw) {
        this.zw = zw;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    @Override
    public String toString() {
        return "PoliceSelectCondition{" +
                "userid='" + userid + '\'' +
                ", jh='" + jh + '\'' +
                ", xm='" + xm + '\'' +
                ", xb='" + xb + '\'' +
                ", jx='" + jx + '\'' +
                ", bm='" + bm + '\'' +
                ", zw='" + zw + '\'' +
                ", dw='" + dw + '\'' +
                '}';
    }
}
