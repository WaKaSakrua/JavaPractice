package com.course.service;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
//类名与方法名须与controller层拦截的方法一致
public class FollowUp {

    //完成门诊随访获得的可兑换积分，无限制
    private static final int FOLLOW_UP_SCORE = 3;

    public void followUp(){
        System.out.println("+++++followUp积分计算方法执行+++++");
        //读取积分文件
        String file = FileUtils.readFile("score");
        PointObject pointObject = JsonUtils.jsonToPojo(file, PointObject.class);
        //累加可兑换积分与总积分
        pointObject.setExchangeScore(pointObject.getExchangeScore() + FOLLOW_UP_SCORE);
        pointObject.setScoreTotal(pointObject.getScoreTotal() + FOLLOW_UP_SCORE);
        //写回积分文件
        String content = JsonUtils.objectToJson(pointObject);
        FileUtils.writeFile("score", content);
    }

}
