package com.course.pojo;

import java.io.Serializable;

/**
 * @author lixuy
 * Created on 2019-04-10
 */
public class PointObject implements Serializable{

    private static final long serialVersionUID = 123456789L;

    private Integer id;
    //成长积分数
    private Integer growScore;
    //可兑换积分数
    private Integer exchangeScore;
    //总积分数
    private Integer scoreTotal;

    // ======== b/c 类积分限制条件所需的状态字段 ========

    //上次登陆计分的日期(yyyy-MM-dd)，用于"每日首次登陆"限制
    private String lastLoginDate;
    //是否已填写过个人资料，用于"首次填写"限制
    private Boolean infoFilled;
    //已记录血糖的次数，用于"记录数大于3才积分"限制
    private Integer bloodSugarCount;
    //上次填写并发症记录并计分的年份，用于"每年仅计分1次"限制
    private Integer bfzLastYear;
    //是否已生成过评估报告并计分，用于"评估报告只计分1次"限制
    private Boolean evaluateReported;
    //上次监测胰岛功能并计分的日期(yyyy-MM-dd)，用于"3个月只积分1次"限制
    private String ydgnLastDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrowScore() {
        return growScore;
    }

    public void setGrowScore(Integer growScore) {
        this.growScore = growScore;
    }

    public Integer getExchangeScore() {
        return exchangeScore;
    }

    public void setExchangeScore(Integer exchangeScore) {
        this.exchangeScore = exchangeScore;
    }

    public Integer getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(Integer scoreTotal) {
        this.scoreTotal = scoreTotal;
    }

    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Boolean getInfoFilled() {
        return infoFilled;
    }

    public void setInfoFilled(Boolean infoFilled) {
        this.infoFilled = infoFilled;
    }

    public Integer getBloodSugarCount() {
        return bloodSugarCount;
    }

    public void setBloodSugarCount(Integer bloodSugarCount) {
        this.bloodSugarCount = bloodSugarCount;
    }

    public Integer getBfzLastYear() {
        return bfzLastYear;
    }

    public void setBfzLastYear(Integer bfzLastYear) {
        this.bfzLastYear = bfzLastYear;
    }

    public Boolean getEvaluateReported() {
        return evaluateReported;
    }

    public void setEvaluateReported(Boolean evaluateReported) {
        this.evaluateReported = evaluateReported;
    }

    public String getYdgnLastDate() {
        return ydgnLastDate;
    }

    public void setYdgnLastDate(String ydgnLastDate) {
        this.ydgnLastDate = ydgnLastDate;
    }
}
