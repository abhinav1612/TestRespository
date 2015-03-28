package com.goeuro.test.filebuilder;

import java.util.List;
import com.goeuro.test.databean.GoEuroDataBean;

public interface GoEuroFileWriter {

	public void write(List<GoEuroDataBean> dataBeanList);
}
