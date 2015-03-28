package com.goeuro.test.filebuilder;

import com.goeuro.test.util.GoEuroConstants;

public class FileWriterFactory {

	private FileWriterFactory(){}
	
	public static GoEuroFileWriter getFileWriter(String fileType){
		
		GoEuroFileWriter fileWriter=null;
		
		if(fileType.equalsIgnoreCase(GoEuroConstants.OUTPUT_FILENAME_EXTENSION)){
			fileWriter=new CSVFileWriter();
			
		}else{
			
		}
		
		return fileWriter;
	}
}
