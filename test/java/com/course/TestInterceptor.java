package com.course;

import com.course.controller.TestDesign;
import com.course.controller.FollowUp;
import com.course.controller.ExtendedActivity;
import com.course.controller.ResearchRecruitment;
import com.course.controller.Login;
import com.course.controller.FillInformation;
import com.course.controller.BloodSugar;
import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lixuy
 * Created on 2019-04-10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
public class TestInterceptor {
	
	@Autowired
	TestDesign testDesign;

	@Autowired
	FollowUp followUp;

	@Autowired
	ExtendedActivity extendedActivity;

	@Autowired
	ResearchRecruitment researchRecruitment;

	@Autowired
	Login login;

	@Autowired
	FillInformation fillInformation;

	@Autowired
	BloodSugar bloodSugar;

    //读取当前积分对象
    private PointObject readPoint(){
        String file = FileUtils.readFile("score");
        return JsonUtils.jsonToPojo(file, PointObject.class);
    }

    //写回积分对象
    private void savePoint(PointObject pointObject){
        FileUtils.writeFile("score", JsonUtils.objectToJson(pointObject));
    }

    //检验当前积分情况
    private int assertScore(){
        try {
            String file = FileUtils.readFile("score");
            PointObject pointObject = JsonUtils.jsonToPojo(file,PointObject.class);
            System.out.println("成长积分："+pointObject.getGrowScore());
            System.out.println("可交换积分："+pointObject.getExchangeScore());
            System.out.println("总积分："+pointObject.getScoreTotal());
            
            return pointObject.getScoreTotal();
        }catch (Exception e){
            e.printStackTrace();
        }
		return 0;        
    }
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("this is setUpBeforeClass...");
    }
 
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("this is tearDownAfterClass...");
    }
 
    @Before
    public void setUp() throws Exception {
        System.out.println("this is setUp...");
    }
 
    @After
    public void tearDown() throws Exception {
        System.out.println("this is tearDown...");
    }
    
    @Test
    public void testDesign() {
    	try {
    		int score1=assertScore();
    		testDesign.testDesign();
    		int score2=assertScore();
    		
    		assertEquals(1, score2-score1);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }

    @Test
    public void followUp() {
    	try {
    		int score1=assertScore();
    		followUp.followUp();
    		int score2=assertScore();

    		assertEquals(3, score2-score1);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }

    @Test
    public void extendedActivity() {
    	try {
    		int score1=assertScore();
    		extendedActivity.extendedActivity();
    		int score2=assertScore();

    		assertEquals(5, score2-score1);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }

    @Test
    public void researchRecruitment() {
    	try {
    		int score1=assertScore();
    		researchRecruitment.researchRecruitment();
    		int score2=assertScore();

    		assertEquals(8, score2-score1);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }

    @Test
    public void login() {
    	try {
    		//清空今日登陆记录，保证"每日首次登陆"可计分，使测试可重复
    		PointObject p = readPoint();
    		p.setLastLoginDate(null);
    		savePoint(p);

    		int score1=assertScore();
    		login.login();
    		int score2=assertScore();
    		//每日首次登陆获得1分
    		assertEquals(1, score2-score1);

    		//同一天再次登陆不再计分
    		int score3=assertScore();
    		login.login();
    		int score4=assertScore();
    		assertEquals(0, score4-score3);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }

    @Test
    public void fillInformation() {
    	try {
    		//清空已填写标记，保证"首次填写"可计分，使测试可重复
    		PointObject p = readPoint();
    		p.setInfoFilled(false);
    		savePoint(p);

    		int score1=assertScore();
    		fillInformation.fillInformation();
    		int score2=assertScore();
    		//首次填写个人资料获得2分
    		assertEquals(2, score2-score1);

    		//再次填写不再计分
    		int score3=assertScore();
    		fillInformation.fillInformation();
    		int score4=assertScore();
    		assertEquals(0, score4-score3);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }

    @Test
    public void bloodSugar() {
    	try {
    		//重置血糖记录数，保证测试可重复
    		PointObject p = readPoint();
    		p.setBloodSugarCount(0);
    		savePoint(p);

    		//前3次记录：记录数不超过3，不积分
    		for (int i = 1; i <= 3; i++) {
    			int s1 = assertScore();
    			bloodSugar.bloodSugar();
    			int s2 = assertScore();
    			assertEquals(0, s2 - s1);
    		}

    		//第4次记录：记录数为4，超过3，积1分
    		int s1 = assertScore();
    		bloodSugar.bloodSugar();
    		int s2 = assertScore();
    		assertEquals(1, s2 - s1);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }
    
}
