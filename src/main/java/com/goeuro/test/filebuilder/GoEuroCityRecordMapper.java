package com.goeuro.test.filebuilder;

import com.goeuro.test.databean.GoEuroCityDetails;
import com.goeuro.test.databean.GoEuroDataBean;

public class GoEuroCityRecordMapper{

	private final String LOCATION_ID_HEADER="ID";
	private final String LOCATION_NAME="Name";
	private final String LOCATION_TYPE="Type";
	private final String LOCATION_LATITUDE="Latitude";
	private final String LOCATION_LONGITUDE="Longitude";
	
	
	public String getRecord(GoEuroDataBean dataBean,String delimiter) {
		
		StringBuffer record;
		
		if(dataBean instanceof GoEuroCityDetails){
			record=new StringBuffer();
			GoEuroCityDetails city=(GoEuroCityDetails) dataBean;
			record.append(city.get_id());
			record.append(delimiter);
			
			record.append(city.getName());
			record.append(delimiter);
			
			record.append(city.getType());
			record.append(delimiter);
			
			record.append(city.getGeo_position().getLatitude());
			record.append(delimiter);
			
			record.append(city.getGeo_position().getLongitude());
			
		}else{
			System.out.println("Not a valid GoEuroCityDetails Data Bean");
			record=new StringBuffer("-1");
		}
				
		return record.toString();
	}
	
	public String getHeaderRecord(String delimiter){
		
		StringBuffer header= new StringBuffer();
		header.append(LOCATION_ID_HEADER);
		header.append(delimiter);
		
		header.append(LOCATION_NAME);
		header.append(delimiter);
		
		header.append(LOCATION_TYPE);
		header.append(delimiter);
		
		header.append(LOCATION_LATITUDE);
		header.append(delimiter);
		
		header.append(LOCATION_LONGITUDE);
		
		return header.toString();
	}

}
