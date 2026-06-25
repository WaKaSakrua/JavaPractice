package com.course.service;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
//类名与方法名须与controller层拦截的方法一致
public class YdgnNote {

    //监测胰岛功能获得的成长积分：2分
    private static final int YDGN_NOTE_SCORE = 2;
    //计分间隔限制：胰岛功能3个月只积分1次
    private static final int YDGN_INTERVAL_MONTHS = 3;

    public void ydgnNote(){
        System.out.println("+++++ydgnNote积分计算方法执行+++++");
    }

}
