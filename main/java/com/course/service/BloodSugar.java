package com.course.service;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
//类名与方法名须与controller层拦截的方法一致
public class BloodSugar {

    //记录血糖获得的成长积分：当血糖记录数大于3时，每次记录积1分
    private static final int BLOOD_SUGAR_SCORE = 1;
    //开始计分的记录数阈值：记录数大于3才积分
    private static final int BLOOD_SUGAR_THRESHOLD = 3;

    public void bloodSugar(){
        System.out.println("+++++bloodSugar积分计算方法执行+++++");
        //读取积分文件
        String file = FileUtils.readFile("score");
        PointObject pointObject = JsonUtils.jsonToPojo(file, PointObject.class);

        //血糖记录数加1（兼容历史数据为null的情况）
        int count = pointObject.getBloodSugarCount() == null ? 0 : pointObject.getBloodSugarCount();
        count = count + 1;
        pointObject.setBloodSugarCount(count);

        //限制：血糖记录数大于3才积分
        if (count > BLOOD_SUGAR_THRESHOLD) {
            //累加成长积分与总积分
            pointObject.setGrowScore(pointObject.getGrowScore() + BLOOD_SUGAR_SCORE);
            pointObject.setScoreTotal(pointObject.getScoreTotal() + BLOOD_SUGAR_SCORE);
        } else {
            System.out.println("血糖记录数未超过3次，本次记录不积分，当前记录数：" + count);
        }
        //写回积分文件
        String content = JsonUtils.objectToJson(pointObject);
        FileUtils.writeFile("score", content);
    }

}
