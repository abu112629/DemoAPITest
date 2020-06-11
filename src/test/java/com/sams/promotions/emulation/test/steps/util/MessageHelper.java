package com.sams.promotions.emulation.test.steps.util;

import java.util.Map;
import java.util.TreeMap;

import com.sams.promotions.platform.emulation.model.MutableMessage;
import com.sams.promotions.platform.emulation.util.mapper.SmartObjectMapper;

public class MessageHelper <REQ, RSP> {
	
	private Map<String, Object> requestProperties; 
	private SmartObjectMapper smartMapper;
	private final Class<REQ> request_clazz;
	private final Class<RSP> response_clazz;
	
	MessageHelper(Class<REQ> request_clazz, Class<RSP> response_clazz){
		smartMapper = new SmartObjectMapper();
		requestProperties = new TreeMap<>();
		this.request_clazz = request_clazz;
		this.response_clazz = response_clazz;
	}
	
	public SmartObjectMapper getSmartMapper() {
		return smartMapper;
	}
	
	public void resetRequestProperties() {
		requestProperties.clear();
	}

	public Map<String, Object> getRequestProperties() {
		return requestProperties;
	}
	
	public MutableMessage<REQ> wrapRequest(String body) {
		REQ incomingMessage = smartMapper.deserialize(body, 
				request_clazz);
		return MutableMessage.from(incomingMessage, requestProperties);
	}
	
	public MutableMessage<RSP> wrapResponse(String body) {
		RSP incomingMessage = smartMapper.deserialize(body, 
				response_clazz);
		return MutableMessage.from(incomingMessage, requestProperties);
	}
	
	public String unwrapRequest(MutableMessage<REQ> request) {
		return smartMapper.serialize(request.getBody());
	}
	
	public String unwrapResponse(MutableMessage<RSP> response) {
		return smartMapper.serialize(response.getBody());
	}
}
