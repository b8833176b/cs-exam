package com.ares.exam.dto;

public class ManualMarkCondition {

    //考试编号
    private Long examID;
    //考试名称
    private String examName;
    //警号
    private String jh;
    //是否阅卷
    private Integer isMark;

    public Long getExamID() {
        return examID;
    }

    public void setExamID(Long examID) {
        this.examID = examID;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getJh() {
        return jh;
    }

    public void setJh(String jh) {
        this.jh = jh;
    }

    public Integer getIsMark() {
        return isMark;
    }

    public void setIsMark(Integer isMark) {
        this.isMark = isMark;
    }

    @Override
    public String toString() {
        return "ManualMarkCondition{" +
                "examID=" + examID +
                ", examName='" + examName + '\'' +
                ", jh='" + jh + '\'' +
                ", isMark=" + isMark +
                '}';
    }
}
