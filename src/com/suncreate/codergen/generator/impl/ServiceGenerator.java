package com.suncreate.codergen.generator.impl;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.suncreate.codergen.domain.Table;
import com.suncreate.codergen.internal.Constants;

/**
 * @author Cheng,Zhi
 * @version builder 2010.02.04
 */
@Service
public class ServiceGenerator extends AbstractGenerator {

	public void generate() throws SQLException {

		List<Table> tableList = new ArrayList<Table>();

		if (isGenerateAllTables()) {
			tableList = super.getFacade().getTableService().getAllTableList();
		} else {
			tableList = super.getFacade().getTableService().getTableList(config.getTable_names());
		}

		for (Table t : tableList) {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("table", t);
			model.put("config", config);
			model.put("now", new Date());

			String content = super.getTemplateService().getContent("service.ftl", model);

			// write to file
			StringBuilder nameBuilder = new StringBuilder();
			nameBuilder.append(t.getJavaObjectCamelName()).append(FILE_SUFFIX_SERVICE).append(Constants.EXTEND_JAVA);

			StringBuilder pathBuilder = new StringBuilder();
			pathBuilder.append(config.getRealpath_service()).append(File.separator).append(nameBuilder);

			logger.info(internal.getString("log.generator.run.file", nameBuilder.toString(), pathBuilder.toString()));

			super.writeToFile(pathBuilder.toString(), content);

		}
	}

}
