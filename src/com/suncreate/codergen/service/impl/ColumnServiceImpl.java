package com.suncreate.codergen.service.impl;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.suncreate.codergen.domain.Column;
import com.suncreate.codergen.service.ColumnService;
import com.suncreate.codergen.utils.JavaTypeNameTranslator;
import com.suncreate.codergen.utils.JdbcTypeNameTranslator;
import com.suncreate.codergen.utils.UtilsString;
import com.suncreate.exception.NullTableNameException;

/**
 * @author Cheng,Zhi
 * @version builder 2010.02.02
 */
@Service
public class ColumnServiceImpl extends BaseServiceImpl implements ColumnService {
	public List<Column> getColumnList(String tableName) throws SQLException {
		if (StringUtils.isBlank(tableName)) {
			throw new NullTableNameException();
		}

		List<Column> columnList = new ArrayList<Column>();
		DatabaseMetaData metaData = super.getConnection(false).getMetaData();

		ResultSet rs = metaData.getColumns(null, dataSource.getUsername().toUpperCase(), tableName, null);

		String sql_desc = "select * from user_col_comments where table_name = '" + tableName + "'";
		PreparedStatement pstmt_desc = null;
		ResultSet rs_List = null;
		try {
			pstmt_desc = conn.prepareStatement(sql_desc);
			rs_List = pstmt_desc.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		while (rs.next()) {
			Column column = new Column();
			column.setTable_name(rs.getString("TABLE_NAME"));
			column.setColumn_name(rs.getString("COLUMN_NAME"));
			column.setData_type(rs.getInt("DATA_TYPE"));
			column.setType_name(rs.getString("TYPE_NAME"));
			column.setColumn_size(rs.getInt("COLUMN_SIZE"));
			column.setDecimal_digits(rs.getInt("DECIMAL_DIGITS"));
			column.setNum_prec_radix(rs.getInt("NUM_PREC_RADIX"));
			column.setColumn_def(rs.getString("COLUMN_DEF"));
			column.setIs_nullable(rs.getString("IS_NULLABLE"));
			//column.setRemarks(column.getRemarks());
			
			while (rs_List.next()) {
				if (rs_List.getString(2).equals(rs.getString("COLUMN_NAME"))) {
					String remarks=rs_List.getString(3);
					if(null==remarks||remarks.length()==0){
						column.setRemarks("");
					}else{
						column.setRemarks(remarks);
					}
					break;
				}
			}

			column.setJavaObjectCamelName(UtilsString.camelize(column.getColumn_name()));

			column.setJavaTypeFullName(JavaTypeNameTranslator.getJavaTypeName(column.getData_type(), column
					.getColumn_size(), column.getDecimal_digits()));
			column.setJavaTypeShortName(StringUtils.substringAfterLast(column.getJavaTypeFullName(), "."));
			column.setJdbcTypeFullName(JdbcTypeNameTranslator.getJdbcTypeName(column.getData_type()));
			column.setJdbcTypeShortName(JdbcTypeNameTranslator.getJdbcTypeName(column.getData_type()));

			columnList.add(column);

			logger.debug(column.toString());
		}
		rs.close();
		return columnList;
	}

	public List<Column> getColumnListForDomain(String tableName) throws SQLException {
		if (StringUtils.isBlank(tableName)) {
			throw new NullTableNameException();
		}

		List<Column> columnList = new ArrayList<Column>();
		DatabaseMetaData metaData = super.getConnection(false).getMetaData();

		ResultSet rs = metaData.getColumns(null, dataSource.getUsername().toUpperCase(), tableName, null);

		String sql_desc = "select * from user_col_comments where table_name = '" + tableName + "'";
		PreparedStatement pstmt_desc = null;
		ResultSet rs_List = null;
		try {
			pstmt_desc = conn.prepareStatement(sql_desc);
			rs_List = pstmt_desc.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}

		while (rs.next()) {
			Column column = new Column();
			column.setTable_name(rs.getString("TABLE_NAME"));
			column.setColumn_name(rs.getString("COLUMN_NAME"));
			column.setData_type(rs.getInt("DATA_TYPE"));
			column.setType_name(rs.getString("TYPE_NAME"));
			column.setColumn_size(rs.getInt("COLUMN_SIZE"));
			column.setDecimal_digits(rs.getInt("DECIMAL_DIGITS"));
			column.setNum_prec_radix(rs.getInt("NUM_PREC_RADIX"));
			column.setColumn_def(rs.getString("COLUMN_DEF"));
			column.setIs_nullable(rs.getString("IS_NULLABLE"));
			// column.setRemarks(column.getRemarks());
			logger.info("#######################################");
			while (rs_List.next()) {
				if (rs_List.getString(2).equals(rs.getString("COLUMN_NAME"))) {
					column.setRemarks(rs_List.getString(3));
					break;
				}
			}

			column.setJavaObjectCamelName(UtilsString.camelize(column.getColumn_name()));

			column.setJavaTypeFullName(JavaTypeNameTranslator.getJavaTypeName(column.getData_type(), column
					.getColumn_size(), column.getDecimal_digits()));
			column.setJavaTypeShortName(StringUtils.substringAfterLast(column.getJavaTypeFullName(), "."));
			column.setJdbcTypeFullName(JdbcTypeNameTranslator.getJdbcTypeName(column.getData_type()));
			column.setJdbcTypeShortName(JdbcTypeNameTranslator.getJdbcTypeName(column.getData_type()));

			columnList.add(column);

			logger.debug(column.toString());
		}
		rs.close();
		return columnList;
	}
}
