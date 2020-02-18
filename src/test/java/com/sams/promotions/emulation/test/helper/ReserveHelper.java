package com.sams.promotions.emulation.test.helper;

import com.sams.promotions.platform.emulation.model.mercury.wrappers.OrderApplyRequestWrapper;
import com.sams.promotions.platform.emulation.model.mercury.wrappers.OrderApplyResponseWrapper;

public class ReserveHelper extends MessageHelper<OrderApplyRequestWrapper, OrderApplyResponseWrapper> {
	
	public ReserveHelper() {
		super(OrderApplyRequestWrapper.class, OrderApplyResponseWrapper.class);
	}
	
	private static final ReserveHelper reserveHelper;
	
	static 
	{
		reserveHelper = new ReserveHelper();
	}
	
	public static ReserveHelper get() {
		return reserveHelper;
	}
}