package com.course.service;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
//类名与方法名须与controller层拦截的方法一致
public class EvaluateReport {

    //生成评估报告获得的成长积分：2分
    private static final int EVALUATE_REPORT_SCORE = 2;
    //生成评估报告的前置条件：血糖记录数需大于等于10
    private static final int REQUIRED_BLOOD_SUGAR_COUNT = 10;

    public void evaluateReport(){
        System.out.println("+++++evaluateReport积分计算方法执行+++++");
        //读取积分文件
        String file = FileUtils.readFile("score");
        PointObject pointObject = JsonUtils.jsonToPojo(file, PointObject.class);
        //TODO 后续补充积分累加与前置条件(已填资料、血糖记录数>=10)限制逻辑
        //写回积分文件
        String content = JsonUtils.objectToJson(pointObject);
        FileUtils.writeFile("score", content);
    }

}
