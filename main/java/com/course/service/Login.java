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
public class Login {

    //登陆平台获得的成长积分：每日首次登陆获得1分
    private static final int LOGIN_SCORE = 1;

    public void login(){
        System.out.println("+++++login积分计算方法执行+++++");
        //读取积分文件
        String file = FileUtils.readFile("score");
        PointObject pointObject = JsonUtils.jsonToPojo(file, PointObject.class);

        //限制：每日首次登陆才计分。若今天已登陆计分过则直接返回
        String today = LocalDate.now().toString();
        if (today.equals(pointObject.getLastLoginDate())) {
            System.out.println("今日已登陆计分，本次登陆不再积分");
            return;
        }

        //累加成长积分与总积分，并记录今日登陆日期
        pointObject.setGrowScore(pointObject.getGrowScore() + LOGIN_SCORE);
        pointObject.setScoreTotal(pointObject.getScoreTotal() + LOGIN_SCORE);
        pointObject.setLastLoginDate(today);
        //写回积分文件
        String content = JsonUtils.objectToJson(pointObject);
        FileUtils.writeFile("score", content);
    }

}
