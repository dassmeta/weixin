package com.dassmeta.weixin.core.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dassmeta.weixin.core.model.ExpressModel;
import com.dassmeta.weixin.core.service.ExpressManager;

public class ExpressManagerTest {

	private static ExpressManager expressManager;

	static {
		ApplicationContext context = new ClassPathXmlApplicationContext();
		expressManager = context.getBean(ExpressManager.class);
	}

	@Test
	public void testQuery() {
		ExpressModel expressModel = expressManager.query("550254786985", "天天");
		Assert.assertNotNull(expressModel);
		Assert.assertEquals("tiantian", expressModel.getCom());
	}
}
