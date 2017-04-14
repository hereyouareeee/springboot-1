package com.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//@EnableScheduling
@Slf4j
@ServletComponentScan  //开启Druid
@EnableTransactionManagement
@EnableRetry
public class SpringbootApplication {

	@RequestMapping("/")
	public String home(){
		return "hello world";
	}

	public static void main(String[] args) {
		String fozu ="\n"+
				"                   _ooOoo_"+"\n"+
						"                  o8888888o"+"\n"+
						"                  88\" . \"88"+"\n"+
						"                  (| -_- |)"+"\n"+
						"                  O\\  =  /O"+"\n"+
						"               ____/`---'\\____"+"\n"+
						"             .'  \\\\|     |//  `."+"\n"+
						"            /  \\\\|||  :  |||//  \\"+"\n"+
						"           /  _||||| -:- |||||-  \\"+"\n"+
						"           |   | \\\\\\  -  /// |   |"+"\n"+
						"           | \\_|  ''\\---/''  |   |"+"\n"+
						"           \\  .-\\__  `-`  ___/-. /"+"\n"+
						"         ___`. .'  /--.--\\  `. . __"+"\n"+
						"      .\"\" '<  `.___\\_<|>_/___.'  >'\"\"."+"\n"+
						"     | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |"+"\n"+
						"     \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /"+"\n"+
						"======`-.____`-.___\\_____/___.-`____.-'======"+"\n"+
						"                   `=---='"+"\n"+
						"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+"\n"+
						"              佛祖保佑       永无BUG"+"\n"+
				        "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+"\n"+
				        "              写字楼里写字间，写字间里程序员；"+"\n"+
				        "              程序人员写程序，又拿程序换酒钱。"+"\n"+
				        "              酒醒只在网上坐，酒醉还来网下眠；"+"\n"+
				        "              酒醉酒醒日复日，网上网下年复年。"+"\n"+
				        "              但愿老死电脑间，不愿鞠躬老板前；"+"\n"+
				        "              奔驰宝马贵者趣，公交自行程序员。"+"\n"+
				        "              别人笑我忒疯癫，我笑自己命太贱；"+"\n"+
				        "              不见满街漂亮妹，哪个归得程序员？"+"\n";
		log.info(fozu);
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
