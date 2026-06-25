package com.course.service;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

import java.time.LocalDate;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
//类名与方法名须与controller层拦截的方法一致
public class YdgnNote {

    //监测胰岛功能获得的成长积分：2分
    private static final int YDGN_NOTE_SCORE = 2;
    //计分间隔限制：胰岛功能3个月只积分1次
    private static final int YDGN_INTERVAL_MONTHS = 3;

    public void ydgnNote(){
        System.out.println("+++++ydgnNote积分计算方法执行+++++");
        //读取积分文件
        String file = FileUtils.readFile("score");
        PointObject pointObject = JsonUtils.jsonToPojo(file, PointObject.class);

        //限制：胰岛功能3个月只积分1次。距上次计分不足3个月则不计分
        LocalDate today = LocalDate.now();
        String lastDateStr = pointObject.getYdgnLastDate();
        if (lastDateStr != null && !lastDateStr.isEmpty()) {
            LocalDate lastDate = LocalDate.parse(lastDateStr);
            //下一次可计分日期 = 上次计分日期 + 3个月
            LocalDate nextAvailable = lastDate.plusMonths(YDGN_INTERVAL_MONTHS);
            if (today.isBefore(nextAvailable)) {
                System.out.println("距上次监测胰岛功能计分不足" + YDGN_INTERVAL_MONTHS + "个月，本次不积分");
                return;
            }
        }

        //累加成长积分与总积分，并记录本次计分日期
        pointObject.setGrowScore(pointObject.getGrowScore() + YDGN_NOTE_SCORE);
        pointObject.setScoreTotal(pointObject.getScoreTotal() + YDGN_NOTE_SCORE);
        pointObject.setYdgnLastDate(today.toString());
        //写回积分文件
        String content = JsonUtils.objectToJson(pointObject);
        FileUtils.writeFile("score", content);
    }

}
