package com.suncreate.codergen.service;

import java.sql.SQLException;
import java.util.List;

import com.suncreate.codergen.domain.Table;

/**
 * @author Cheng,Zhi
 * @version builder 2010.02.02
 */
public interface TableService {

	public List<Table> getTableList(String table_names) throws SQLException;

	public List<Table> getTableListForDomain(String table_names) throws SQLException;
	
	public List<Table> getAllTableList() throws SQLException;
	
	public List<Table> getAllTableListForDomain() throws SQLException;

}
