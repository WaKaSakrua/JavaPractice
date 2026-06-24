package com.course.service;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
//类名与方法名须与controller层拦截的方法一致
public class FillInformation {

    //填写个人资料获得的成长积分：首次填写获得2分
    private static final int FILL_INFORMATION_SCORE = 2;

    public void fillInformation(){
        System.out.println("+++++fillInformation积分计算方法执行+++++");
        //读取积分文件
        String file = FileUtils.readFile("score");
        PointObject pointObject = JsonUtils.jsonToPojo(file, PointObject.class);
        //TODO 后续补充积分累加与首次填写限制逻辑
        //写回积分文件
        String content = JsonUtils.objectToJson(pointObject);
        FileUtils.writeFile("score", content);
    }

}
