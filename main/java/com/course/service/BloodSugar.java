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
        //TODO 后续补充血糖记录计数与记录数大于3的积分逻辑
        //写回积分文件
        String content = JsonUtils.objectToJson(pointObject);
        FileUtils.writeFile("score", content);
    }

}
