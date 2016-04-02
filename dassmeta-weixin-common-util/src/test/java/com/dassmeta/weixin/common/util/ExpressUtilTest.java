package com.dassmeta.weixin.common.util;

import org.junit.Assert;
import org.junit.Test;

public class ExpressUtilTest {

	@Test
	public void testGetType() {
		Assert.assertEquals("tiantian", ExpressUtil.getType("天天"));
	}

	@Test
	public void testQuery() {
		String query = ExpressUtil.query(ExpressUtil.getType("天天"), "550254786985");
		System.out.println(query);
	}

}
