package com.sams.promotions.emulation.test.steps.util;

import com.sams.promotions.platform.emulation.model.mercury.wrappers.OrderApplyRequestWrapper;
import com.sams.promotions.platform.emulation.model.mercury.wrappers.OrderApplyResponseWrapper;

public class ReserveTestHelper extends MessageHelper<OrderApplyRequestWrapper, OrderApplyResponseWrapper> {
	
	public ReserveTestHelper() {
		super(OrderApplyRequestWrapper.class, OrderApplyResponseWrapper.class);
	}
	
	private static final ReserveTestHelper reserveHelper;
	
	static 
	{
		reserveHelper = new ReserveTestHelper();
	}
	
	public static ReserveTestHelper get() {
		return reserveHelper;
	}
}