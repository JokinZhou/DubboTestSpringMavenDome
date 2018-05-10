package com.jokin.testng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;


//这个使用的一般的Testng进行的dubbo的测试
public class MailServiceTest {
	//private MailService mailService; 一个邮箱的类

	@Test(testName = "成功发送一封邮件")
	public void sendOneMailSuccess() {
		//mailService = (MailService) DubboService.getBean("mailService");加载
		//MailSendForm mail = new MailSendForm();
		//mail.setSubject("发送一封邮件成功1234567890qwertyuiop!@#$%^&*()");
		//mail.setContent("发送一封邮件成功的内容1234567890qwertyuiop!@#$%^&*()");
/*		List<String> toLists = new ArrayList<String>();
		toLists.add("jifeng.zhang@chinaredstar.com");
		mail.setToList(toLists);

		Map<String, Object> result = mailService.sendMail(mail);
		System.out.println("发送结果:" + result);
		Assert.assertEquals(Boolean.parseBoolean(result.get("ok").toString()), true);
		Assert.assertEquals(result.get("message"), "发送成功");*/
	}


}
