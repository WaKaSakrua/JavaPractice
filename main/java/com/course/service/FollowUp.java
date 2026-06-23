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
    }

}
