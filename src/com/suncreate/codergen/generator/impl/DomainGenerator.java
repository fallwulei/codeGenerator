package com.suncreate.codergen.generator.impl;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.suncreate.codergen.domain.Column;
import com.suncreate.codergen.domain.Table;
import com.suncreate.codergen.internal.Constants;

/**
 * @author Cheng,Zhi
 * @version builder 2010.02.04
 */
@Service
public class DomainGenerator extends AbstractGenerator {

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

			// import package
			Set<String> packageImportList = new HashSet<String>();
			for (Column c : t.getColumnList()) {
				String type = c.getJavaTypeFullName();
				if (!StringUtils.startsWith(type, "java.lang.")) {
					packageImportList.add(type);
				}
			}
			Arrays.sort(packageImportList.toArray());
			model.put("packageImportList", packageImportList);
			model.put("tijiao", "提交");
			model.put("zztijiao", "正在提交");
			model.put("weizhi", "您当前的位置：");
			model.put("title", "平台管理系统");
			model.put("ctx", "${ctx}");
			model.put("tjbtn", "提 交");
			model.put("czbtn", "重 置");
			model.put("fhbtn", "返 回");
			model.put("cxbtn", "查 询");
			model.put("addbtn", "添 加");
			model.put("ckbtn", "查看");
			model.put("xgbtn", "修改");
			model.put("scbtn", "删除");
			model.put("navString", "${navString}");
			model.put("mod_name", "${mod_name}");
			model.put("$", "$");
			model.put("maohao", "：");
			model.put("xuhao", "序号");
			model.put("caozuo", "操作");

			String content = super.getTemplateService().getContent("domain.ftl", model);

			// write to file
			StringBuilder nameBuilder = new StringBuilder();
			nameBuilder.append(t.getJavaObjectCamelName()).append(Constants.EXTEND_JAVA);

			StringBuilder pathBuilder = new StringBuilder();
			pathBuilder.append(config.getRealpath_domain()).append(File.separator).append(nameBuilder);

			logger.info(internal.getString("log.generator.run.file", nameBuilder.toString(), pathBuilder.toString()));

			super.writeToFile(pathBuilder.toString(), content);

			// 生成ACTION
			String action_content = super.getTemplateService().getContent("action.ftl", model);

			// write to file
			StringBuilder actionNameBuilder = new StringBuilder();

			actionNameBuilder.append(t.getJavaObjectCamelName()).append("Action").append(Constants.EXTEND_JAVA);

			StringBuilder actionPathBuilder = new StringBuilder();
			actionPathBuilder.append(config.getRealpath_action()).append(File.separator).append(actionNameBuilder);

			logger.info(internal.getString("log.generator.run.file", actionNameBuilder.toString(),
					actionPathBuilder.toString()));

			super.writeToFile(actionPathBuilder.toString(), action_content);

			// 生成jsp页面
			String jsp_form_content = super.getTemplateService().getContent("form.ftl", model);
			super.getTemplateService().getContent("form.ftl", model);

			StringBuilder jsp_form_nameBuilder = new StringBuilder();
			jsp_form_nameBuilder.append(t.getJavaObjectCamelName()).append(File.separator).append("form")
					.append(Constants.EXTEND_JSP);

			StringBuilder jsp_from_pathBuilder = new StringBuilder();
			jsp_from_pathBuilder.append(config.getRealpath()).append(File.separator).append("jsp")
					.append(File.separator).append(jsp_form_nameBuilder);

			logger.info(internal.getString("log.generator.run.file", jsp_form_nameBuilder.toString(),
					jsp_from_pathBuilder.toString()));

			super.writeToFile(jsp_from_pathBuilder.toString(), jsp_form_content);

			// 生成list页面
			String jsp_list_content = super.getTemplateService().getContent("list.ftl", model);
			super.getTemplateService().getContent("list.ftl", model);

			StringBuilder jsp_list_nameBuilder = new StringBuilder();
			jsp_list_nameBuilder.append(t.getJavaObjectCamelName()).append(File.separator).append("list")
					.append(Constants.EXTEND_JSP);

			StringBuilder jsp_list_pathBuilder = new StringBuilder();
			jsp_list_pathBuilder.append(config.getRealpath()).append(File.separator).append("jsp")
					.append(File.separator).append(jsp_list_nameBuilder);

			logger.info(internal.getString("log.generator.run.file", jsp_list_nameBuilder.toString(),
					jsp_list_pathBuilder.toString()));

			super.writeToFile(jsp_list_pathBuilder.toString(), jsp_list_content);

			// 生成view页面
			String jsp_view_content = super.getTemplateService().getContent("view.ftl", model);
			super.getTemplateService().getContent("view.ftl", model);

			StringBuilder jsp_view_nameBuilder = new StringBuilder();
			jsp_view_nameBuilder.append(t.getJavaObjectCamelName()).append(File.separator).append("view")
					.append(Constants.EXTEND_JSP);

			StringBuilder jsp_view_pathBuilder = new StringBuilder();
			jsp_view_pathBuilder.append(config.getRealpath()).append(File.separator).append("jsp")
					.append(File.separator).append(jsp_view_nameBuilder);

			logger.info(internal.getString("log.generator.run.file", jsp_view_nameBuilder.toString(),
					jsp_view_pathBuilder.toString()));

			super.writeToFile(jsp_view_pathBuilder.toString(), jsp_view_content);

		}
	}

}
