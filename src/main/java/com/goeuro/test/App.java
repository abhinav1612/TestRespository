package com.goeuro.test;

import java.util.LinkedList;
import java.util.List;

import com.goeuro.test.databean.GoEuroCityDetails;
import com.goeuro.test.databean.GoEuroDataBean;
import com.goeuro.test.filebuilder.FileWriterFactory;
import com.goeuro.test.filebuilder.GoEuroFileWriter;
import com.goeuro.test.service.GoEuroServiceAPI;
import com.goeuro.test.util.GoEuroStringUtils;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		String input = "Berlin";
		System.out.println("Calling GoEuroTest.jar .......");

		if (!GoEuroStringUtils.isEmptyorNull(input)) {
			System.out.println("Initial Validation Passed .......");
			GoEuroServiceAPI goEuroService = new GoEuroServiceAPI();
			List<GoEuroCityDetails> cityList = goEuroService
					.getGoEuroCityDetails(input);

			if (cityList.isEmpty()) {
				System.out.println("No Details found for given City");
			} else {
				List<GoEuroDataBean> temp = new LinkedList<GoEuroDataBean>();
				temp.addAll(cityList);

				System.out.println("Size of Temp " + temp.size());

				GoEuroFileWriter fileWriter = FileWriterFactory
						.getFileWriter("csv");
				fileWriter.write(temp);

				for (GoEuroCityDetails obj : cityList) {
					System.out.println(obj);
				}
			}

		}

	}
}
