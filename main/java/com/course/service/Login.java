package com.course.service;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

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
        //累加成长积分与总积分
        pointObject.setGrowScore(pointObject.getGrowScore() + LOGIN_SCORE);
        pointObject.setScoreTotal(pointObject.getScoreTotal() + LOGIN_SCORE);
        //写回积分文件
        String content = JsonUtils.objectToJson(pointObject);
        FileUtils.writeFile("score", content);
    }

}
