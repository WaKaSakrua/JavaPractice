package com.course.service;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
//类名与方法名须与controller层拦截的方法一致
public class ExtendedActivity {

    //参加扩展活动获得的可兑换积分，无限制
    private static final int EXTENDED_ACTIVITY_SCORE = 5;

    public void extendedActivity(){
        System.out.println("+++++extendedActivity积分计算方法执行+++++");
        //读取积分文件
        String file = FileUtils.readFile("score");
        PointObject pointObject = JsonUtils.jsonToPojo(file, PointObject.class);
        //累加可兑换积分与总积分
        pointObject.setExchangeScore(pointObject.getExchangeScore() + EXTENDED_ACTIVITY_SCORE);
        pointObject.setScoreTotal(pointObject.getScoreTotal() + EXTENDED_ACTIVITY_SCORE);
        //写回积分文件
        String content = JsonUtils.objectToJson(pointObject);
        FileUtils.writeFile("score", content);
    }

}
