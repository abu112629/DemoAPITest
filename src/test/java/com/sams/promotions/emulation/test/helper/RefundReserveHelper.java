package com.sams.promotions.emulation.test.helper;


import com.sams.promotions.platform.models.emulation.refund.reserve.api.request.RefundReserveRequest;
import com.sams.promotions.platform.models.emulation.refund.reserve.api.response.RefundResponse;
import com.sams.promotions.platform.models.emulation.refund.reserve.request.CheckoutRefundReserveRequest;
import com.sams.promotions.platform.emulation.core.constants.MappingConstants;
import com.sams.promotions.platform.emulation.model.MutableMessage;

public class RefundReserveHelper extends MessageHelper<RefundReserveRequest, RefundResponse> {
	
	public RefundReserveHelper() {
		super(RefundReserveRequest.class, RefundResponse.class);
	}
	
	private static final RefundReserveHelper refundReserveHelper;
	
	static {
		refundReserveHelper = new RefundReserveHelper();
	}
	
	public static RefundReserveHelper get() {
		return refundReserveHelper;
	}
	
	public MutableMessage<RefundResponse> wrapResponse(String body, 
			CheckoutRefundReserveRequest request) {
		MutableMessage<RefundResponse> response = super.wrapResponse(body);
		response.getInternalProperties().put(MappingConstants.ORIGINAL_REQUEST_KEY, request);
		return response;
	}
}