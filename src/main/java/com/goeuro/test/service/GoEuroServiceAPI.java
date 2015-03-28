package com.goeuro.test.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.goeuro.test.client.WSClient;
import com.goeuro.test.databean.GoEuroCityDetails;
import com.goeuro.test.parser.JsonParser;
import com.goeuro.test.request.RequestBuilder;
import com.goeuro.test.request.SimpleRequestBuilder;
import com.goeuro.test.util.GoEuroConstants;
import com.google.gson.reflect.TypeToken;

public class GoEuroServiceAPI {

	public List<GoEuroCityDetails> getGoEuroCityDetails(String paramString) {

		List<GoEuroCityDetails> goEuroCityList = null;
		Object parsedOuput = null;
		RequestBuilder requestBuilderObj = new SimpleRequestBuilder();
		WSClient goEuroClient = WSClient.getClientInstance();

		String requestURL = requestBuilderObj.buildrequest(paramString);

		String jsonResponse = goEuroClient.getData(requestURL,
				GoEuroConstants.JSON_RESPONSE_TYPE);
		
		if(jsonResponse.equalsIgnoreCase("-1")){
			return Collections.emptyList();
		}
		
		Type formatType = new TypeToken<List<GoEuroCityDetails>>() {
		}.getType();

		parsedOuput = JsonParser.parse(jsonResponse, formatType);
		
		if (parsedOuput == null) {
			goEuroCityList = Collections.emptyList();
		} else {
			goEuroCityList = (List<GoEuroCityDetails>) parsedOuput;
		}

		return goEuroCityList;
	}

}
