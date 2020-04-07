package com.sams.promotions.emulation.test.helper;


import com.sams.promotions.platform.models.emulation.refund.reserve.api.request.RefundRequest;
import com.sams.promotions.platform.models.emulation.refund.reserve.api.response.RefundResponse;

public class RefundHelper extends MessageHelper<RefundRequest, RefundResponse> {
	
	public RefundHelper() {
		super(RefundRequest.class, RefundResponse.class);
	}
	
	private static final RefundHelper refundHelper;
	
	static {
		refundHelper = new RefundHelper();
	}
	
	public static RefundHelper get() {
		return refundHelper;
	}
}