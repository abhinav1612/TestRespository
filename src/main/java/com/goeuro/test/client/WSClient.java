package com.goeuro.test.client;

import com.goeuro.test.util.GoEuroConstants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class WSClient {

	private static WSClient instance;
	private Client client;

	private WSClient() {
		System.out.println("JAX-RS Client Initialized for GoEuroAPI ....");
		client = Client.create();
	};

	public static WSClient getClientInstance() {

		if (instance == null) {
			synchronized (WSClient.class) {
				if (instance == null) {
					instance = new WSClient();
				}
			}
		}
		return instance;
	}

	public String getData(String requestURL, String response_type) {

		int retry_attempt = 1;
		String output = "-1";

		ClientResponse response = null;

		try {
			WebResource webResource = client.resource(requestURL);

			while (retry_attempt < GoEuroConstants.MAX_RETRY_ATTEMPTS) {

				System.out
						.println("Establishing Connection ( Connection Attempt "
								+ retry_attempt + " )");

				response = webResource.type(response_type).get(
						ClientResponse.class);

				if (response.getStatus() == 200) {
					break;
				} else {
					retry_attempt++;

					if (retry_attempt >= GoEuroConstants.MAX_RETRY_ATTEMPTS) {
						throw new RuntimeException(
								"Failed : HTTP error code : "
										+ response.getStatus());
					}
				}
			}

			System.out.println("Output from Server .... \n");
			output = response.getEntity(String.class);
			System.out.println(output);
		} catch (UniformInterfaceException e) {
			e.printStackTrace();
			return output;
		} catch (ClientHandlerException e) {
			e.printStackTrace();
			return output;
		}	
		return output;
		
	}
}
