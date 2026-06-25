package com.course.service;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
//类名与方法名须与controller层拦截的方法一致
public class BfzNote {

    //填写并发症记录获得的成长积分：每年只计分1次，每次3分
    private static final int BFZ_NOTE_SCORE = 3;

    public void bfzNote(){
        System.out.println("+++++bfzNote积分计算方法执行+++++");
    }

}
