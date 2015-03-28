package com.goeuro.test.filebuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.goeuro.test.databean.GoEuroDataBean;

public class CSVFileWriter implements GoEuroFileWriter{

	private final String FILENAME="LocationExtract.csv";
	private final String DELIMITER=",";
	private final String NEW_LINE_CHAR="\n";
		
	@Override
	public void write(List<GoEuroDataBean> dataBeanList) {
		
		System.out.println("Inside CSVFileWriter....");
		FileWriter fileWriter =null;
		try {
			fileWriter= new FileWriter(FILENAME);
			GoEuroCityRecordMapper recordMapper= new GoEuroCityRecordMapper();
			
			fileWriter.append(recordMapper.getHeaderRecord(DELIMITER));
			System.out.println();
			System.out.println(recordMapper.getHeaderRecord(DELIMITER));
			
			for(GoEuroDataBean dataBean:dataBeanList){
				fileWriter.append(recordMapper.getRecord(dataBean,DELIMITER));
				fileWriter.append(NEW_LINE_CHAR);
				System.out.println(recordMapper.getRecord(dataBean,DELIMITER));
			}
			fileWriter.flush();
			fileWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
