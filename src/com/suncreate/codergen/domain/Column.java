package com.suncreate.codergen.domain;

import java.io.Serializable;

/**
 * 获取可在指定类别中使用的表列的描述。 仅返回与类别、模式、表和列名称标准匹配的列描述。它们根据 TABLE_CAT、TABLE_SCHEM、TABLE_NAME 和 ORDINAL_POSITION 进行排序。
 * 
 * @author Cheng,Zhi
 * @version builder 2010.02.02
 */
public class Column implements Serializable {

	private static final long serialVersionUID = 1L;

	private String table_cat;// 表类别（可为 null）

	private String table_schem;// 表模式（可为 null）

	private String table_name;// 表名称

	private String column_name;// 列名称

	private Integer data_type;// 来自 java.sql.Types 的 SQL 类型

	private String type_name;// 数据源依赖的类型名称，对于 UDT，该类型名称是完全限定的

	private Integer column_size;// 列的大小。

	private Integer buffer_length;// 未被使用。

	private Integer decimal_digits;// 小数部分的位数。对于 DECIMAL_DIGITS 不适用的数据类型，则返回 Null。

	private Integer num_prec_radix;// 基数（通常为 10 或 2）

	// 是否允许使用 NULL。
	// columnNoNulls - 可能不允许使用 NULL 值
	// columnNullable - 明确允许使用 NULL 值
	// columnNullableUnknown - 不知道是否可使用 null
	private Integer nullable;

	private String remarks;// 描述列的注释（可为 null）

	private String column_def;// 该列的默认值，当值在单引号内时应被解释为一个字符串（可为 null）

	private Integer sql_data_type;// 未使用

	private Integer sql_datetime_sub;// 未使用

	private Integer char_octet_length;// 对于 char 类型，该长度是列中的最大字节数

	private Integer ordinal_position;// 表中的列的索引（从 1 开始）

	private String is_nullable;// ISO 规则用于确定列是否包括 null。

	// YES --- 如果参数可以包括 NULL
	// NO --- 如果参数不可以包括 NULL
	// 空字符串 --- 如果不知道参数是否可以包括 null
	private String scope_catlog;// 表的类别，它是引用属性的作用域（如果 DATA_TYPE 不是 REF，则为 null）

	private String scope_schema;// 表的模式，它是引用属性的作用域（如果 DATA_TYPE 不是 REF，则为 null）

	private String scope_table;// 表名称，它是引用属性的作用域（如果 DATA_TYPE 不是 REF，则为 null）

	// 不同类型或用户生成 Ref 类型、来自 java.sql.Types 的 SQL 类型的源类型（如果 DATA_TYPE 不是 DISTINCT 或用户生成的REF，则为 null）
	private Short source_data_type;

	// 指示此列是否自动增加
	// YES --- 如果该列自动增加
	// NO --- 如果该列不自动增加
	// 空字符串 --- 如果不能确定该列是否是自动增加参数
	private String is_autoincrement;

	private String lowerCaseName;// 全部小写名称

	private String javaObjectCamelName; // 驼峰式列命命名法

	private String javaTypeShortName; // java类型名称（不包括完整【包】路径）

	private String javaTypeFullName; // java类型名称（包括完整【包】路径）

	private String jdbcTypeShortName;// jdbc类型名称（不包括完整【包】路径）

	private String jdbcTypeFullName;// jdbc类型名称（包括完整【包】路径）

	public Column() {

	}

	public String getTable_cat() {
		return table_cat;
	}

	public void setTable_cat(String tableCat) {
		table_cat = tableCat;
	}

	public String getTable_schem() {
		return table_schem;
	}

	public void setTable_schem(String tableSchem) {
		table_schem = tableSchem;
	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String tableName) {
		table_name = tableName;
	}

	public String getColumn_name() {
		return column_name;
	}

	public void setColumn_name(String columnName) {
		column_name = columnName;
	}

	public Integer getData_type() {
		return data_type;
	}

	public void setData_type(Integer dataType) {
		data_type = dataType;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String typeName) {
		type_name = typeName;
	}

	public Integer getColumn_size() {
		return column_size;
	}

	public void setColumn_size(Integer columnSize) {
		column_size = columnSize;
	}

	public Integer getBuffer_length() {
		return buffer_length;
	}

	public void setBuffer_length(Integer bufferLength) {
		buffer_length = bufferLength;
	}

	public Integer getDecimal_digits() {
		return decimal_digits;
	}

	public void setDecimal_digits(Integer decimalDigits) {
		decimal_digits = decimalDigits;
	}

	public Integer getNum_prec_radix() {
		return num_prec_radix;
	}

	public void setNum_prec_radix(Integer numPrecRadix) {
		num_prec_radix = numPrecRadix;
	}

	public Integer getNullable() {
		return nullable;
	}

	public void setNullable(Integer nullable) {
		this.nullable = nullable;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getColumn_def() {
		return column_def;
	}

	public void setColumn_def(String columnDef) {
		column_def = columnDef;
	}

	public Integer getSql_data_type() {
		return sql_data_type;
	}

	public void setSql_data_type(Integer sqlDataType) {
		sql_data_type = sqlDataType;
	}

	public Integer getSql_datetime_sub() {
		return sql_datetime_sub;
	}

	public void setSql_datetime_sub(Integer sqlDatetimeSub) {
		sql_datetime_sub = sqlDatetimeSub;
	}

	public Integer getChar_octet_length() {
		return char_octet_length;
	}

	public void setChar_octet_length(Integer charOctetLength) {
		char_octet_length = charOctetLength;
	}

	public Integer getOrdinal_position() {
		return ordinal_position;
	}

	public void setOrdinal_position(Integer ordinalPosition) {
		ordinal_position = ordinalPosition;
	}

	public String getIs_nullable() {
		return is_nullable;
	}

	public void setIs_nullable(String isNullable) {
		is_nullable = isNullable;
	}

	public String getScope_catlog() {
		return scope_catlog;
	}

	public void setScope_catlog(String scopeCatlog) {
		scope_catlog = scopeCatlog;
	}

	public String getScope_schema() {
		return scope_schema;
	}

	public void setScope_schema(String scopeSchema) {
		scope_schema = scopeSchema;
	}

	public String getScope_table() {
		return scope_table;
	}

	public void setScope_table(String scopeTable) {
		scope_table = scopeTable;
	}

	public Short getSource_data_type() {
		return source_data_type;
	}

	public void setSource_data_type(Short sourceDataType) {
		source_data_type = sourceDataType;
	}

	public String getIs_autoincrement() {
		return is_autoincrement;
	}

	public void setIs_autoincrement(String isAutoincrement) {
		is_autoincrement = isAutoincrement;
	}

	public String getLowerCaseName() {
		return lowerCaseName;
	}

	public void setLowerCaseName(String lowerCaseName) {
		this.lowerCaseName = lowerCaseName;
	}

	public String getJavaTypeShortName() {
		return javaTypeShortName;
	}

	public void setJavaTypeShortName(String javaTypeShortName) {
		this.javaTypeShortName = javaTypeShortName;
	}

	public String getJavaTypeFullName() {
		return javaTypeFullName;
	}

	public void setJavaTypeFullName(String javaTypeFullName) {
		this.javaTypeFullName = javaTypeFullName;
	}

	public String getJdbcTypeShortName() {
		return jdbcTypeShortName;
	}

	public void setJdbcTypeShortName(String jdbcTypeShortName) {
		this.jdbcTypeShortName = jdbcTypeShortName;
	}

	public String getJdbcTypeFullName() {
		return jdbcTypeFullName;
	}

	public void setJdbcTypeFullName(String jdbcTypeFullName) {
		this.jdbcTypeFullName = jdbcTypeFullName;
	}

	public String getJavaObjectCamelName() {
		return javaObjectCamelName;
	}

	public void setJavaObjectCamelName(String javaObjectCamelName) {
		this.javaObjectCamelName = javaObjectCamelName;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("{");
		sb.append("'table_name':'").append(table_name).append("',");
		sb.append("'column_name':'").append(column_name).append("',");
		sb.append("'type_name':'").append(type_name).append("',");
		sb.append("'data_type':'").append(data_type).append("',");
		sb.append("'column_size':'").append(column_size).append("',");
		sb.append("'decimal_digits':'").append(decimal_digits).append("',");
		sb.append("'num_prec_radix':'").append(num_prec_radix).append("',");
		sb.append("'column_def':'").append(column_def).append("',");
		sb.append("'javaObjectCamelName':'").append(javaObjectCamelName).append("',");
		sb.append("'javaTypeShortName':'").append(javaTypeShortName).append("',");
		sb.append("'javaTypeFullName':'").append(javaTypeFullName).append("',");
		sb.append("'jdbcTypeFullName':'").append(jdbcTypeFullName).append("',");
		sb.append("'jdbcTypeShortName':'").append(jdbcTypeShortName).append("',");
		sb.append("'remarks':'").append(remarks).append("',");
		sb.append("'is_nullable':'").append(is_nullable).append("'");
		sb.append("}");
		return sb.toString();
	}
}
