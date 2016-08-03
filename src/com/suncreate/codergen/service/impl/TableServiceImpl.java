package com.suncreate.codergen.service.impl;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.suncreate.codergen.domain.Table;
import com.suncreate.codergen.service.ColumnService;
import com.suncreate.codergen.service.TableService;
import com.suncreate.codergen.utils.UtilsString;

/**
 * @author Cheng,Zhi
 * @version builder 2010.02.02
 */
@Service
public class TableServiceImpl extends BaseServiceImpl implements TableService {

	@Resource
	ColumnService columnService;

	public List<Table> getAllTableList() throws SQLException {

		List<Table> tableList = new ArrayList<Table>();

		DatabaseMetaData metaData = super.getConnection(false).getMetaData();
		ResultSet rs = metaData.getTables(null, dataSource.getUsername().toUpperCase(), null, new String[] { "TABLE" });

		while (rs.next()) {

			if (rs.getString("TABLE_NAME").contains("$") || StringUtils.isBlank(rs.getString("TABLE_NAME"))) {
				continue;
			}
			String exp_table_name = rs.getString("TABLE_NAME").substring(0, 3);
			if (exp_table_name.equals("WF_") || exp_table_name.equals("FC_")) {
				continue;
			}

			Table table = new Table();
			table.setType_cat(rs.getString("TABLE_CAT"));
			table.setType_schem(rs.getString("TABLE_SCHEM"));
			table.setTable_name(rs.getString("TABLE_NAME"));
			table.setTable_type(rs.getString("TABLE_TYPE"));
			table.setRemarks(rs.getString("REMARKS"));
			table.setJavaObjectCamelName(UtilsString.camelize(table.getTable_name()));
			table.setColumnList(columnService.getColumnList(table.getTable_name()));
			tableList.add(table);

			logger.debug(table.toString());
		}
		rs.close();

		return tableList;
	}

	public List<Table> getTableList(String table_names) throws SQLException {
		List<Table> tableList = new ArrayList<Table>();

		String[] tableNameArray = table_names.split(",");

		for (String s : tableNameArray) {
			if (s.contains("$") || StringUtils.isBlank(s)) {
				continue;
			}

			s = UtilsString.removeQuote(s).trim().toUpperCase();

			Table t = new Table();
			t.setTable_name(s);
			t.setJavaObjectCamelName(UtilsString.camelize(t.getTable_name()));
			t.setColumnList(columnService.getColumnList(s));
			tableList.add(t);
		}

		return tableList;
	}

	public List<Table> getAllTableListForDomain() throws SQLException {

		List<Table> tableList = new ArrayList<Table>();

		DatabaseMetaData metaData = super.getConnection(false).getMetaData();
		ResultSet rs = metaData.getTables(null, dataSource.getUsername().toUpperCase(), null, new String[] { "TABLE" });

		while (rs.next()) {

			if (rs.getString("TABLE_NAME").contains("$") || StringUtils.isBlank(rs.getString("TABLE_NAME"))) {
				continue;
			}
			String exp_table_name = rs.getString("TABLE_NAME").substring(0, 3);
			if (exp_table_name.equals("WF_") || exp_table_name.equals("FC_")) {
				continue;
			}

			Table table = new Table();
			table.setType_cat(rs.getString("TABLE_CAT"));
			table.setType_schem(rs.getString("TABLE_SCHEM"));
			table.setTable_name(rs.getString("TABLE_NAME"));
			table.setTable_type(rs.getString("TABLE_TYPE"));
			table.setRemarks(rs.getString("REMARKS"));
			table.setJavaObjectCamelName(UtilsString.camelize(table.getTable_name()));
			table.setColumnList(columnService.getColumnListForDomain(table.getTable_name()));
			tableList.add(table);

			logger.debug(table.toString());
		}
		rs.close();

		return tableList;
	}

	public List<Table> getTableListForDomain(String table_names) throws SQLException {
		List<Table> tableList = new ArrayList<Table>();

		String[] tableNameArray = table_names.split(",");

		for (String s : tableNameArray) {
			if (s.contains("$") || StringUtils.isBlank(s)) {
				continue;
			}

			s = UtilsString.removeQuote(s).trim().toUpperCase();

			Table t = new Table();
			t.setTable_name(s);
			t.setJavaObjectCamelName(UtilsString.camelize(t.getTable_name()));
			t.setColumnList(columnService.getColumnListForDomain(s));
			tableList.add(t);
		}

		return tableList;
	}

}
