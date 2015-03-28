package com.goeuro.test.request;

import com.goeuro.test.util.GoEuroConstants;

public class SimpleRequestBuilder implements RequestBuilder {

	@Override
	public String buildrequest(String parameterString) {
		
		StringBuilder requestUrl=new StringBuilder(GoEuroConstants.BASE_URL);
		requestUrl=requestUrl.append(parameterString);
		return requestUrl.toString();
	}
	
	
}
