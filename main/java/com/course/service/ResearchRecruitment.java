package com.course.service;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
//类名与方法名须与controller层拦截的方法一致
public class ResearchRecruitment {

    //参加科研招募获得的可兑换积分，无限制
    private static final int RESEARCH_RECRUITMENT_SCORE = 8;

    public void researchRecruitment(){
        System.out.println("+++++researchRecruitment积分计算方法执行+++++");
    }

}
