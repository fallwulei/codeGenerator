package com.suncreate.codergen.service;

import java.sql.SQLException;
import java.util.List;

import com.suncreate.codergen.domain.Column;

/**
 * @author Cheng,Zhi
 * @version builder 2010.02.02
 */
public interface ColumnService {

	public List<Column> getColumnList(String tableName) throws SQLException;

	public List<Column> getColumnListForDomain(String tableName) throws SQLException;

}
