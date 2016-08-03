package com.suncreate.codergen.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 获取可在给定类别中使用的表的描述。仅返回与类别、模式、表名称和类型标准匹配的表描述。它们根据 TABLE_TYPE、TABLE_CAT、TABLE_SCHEM 和 TABLE_NAME 进行排序。
 * 
 * @author Cheng,Zhi
 * @version builder 2010.02.02
 */
public class Table implements Serializable {

	private static final long serialVersionUID = 1L;

	// 表名称
	private String table_name;

	// 表类型。典型的类型是 "TABLE"、"VIEW"、"SYSTEM TABLE"、"GLOBAL TEMPORARY"、"LOCAL TEMPORARY"、"ALIAS" 和 "SYNONYM"。
	private String table_type;

	// 表的解释性注释
	private String remarks;

	// 类型的类别（可为 null）
	private String type_cat;

	// 类型模式（可为 null）
	private String type_schem;

	// 类型名称（可为 null）
	private String type_name;

	// 有类型表的指定 "identifier" 列的名称（可为 null）
	private String self_referencing_col_name;

	// 指定在 SELF_REFERENCING_COL_NAME 中创建值的方式。这些值为 "SYSTEM"、"USER" 和 "DERIVED"。（可能为 null）
	private String ref_generation;

	private String javaObjectCamelName;

	private List<Column> columnList;

	public Table() {

	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String tableName) {
		table_name = tableName;
	}

	public String getTable_type() {
		return table_type;
	}

	public void setTable_type(String tableType) {
		table_type = tableType;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getType_cat() {
		return type_cat;
	}

	public void setType_cat(String typeCat) {
		type_cat = typeCat;
	}

	public String getType_schem() {
		return type_schem;
	}

	public void setType_schem(String typeSchem) {
		type_schem = typeSchem;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String typeName) {
		type_name = typeName;
	}

	public String getSelf_referencing_col_name() {
		return self_referencing_col_name;
	}

	public void setSelf_referencing_col_name(String selfReferencingColName) {
		self_referencing_col_name = selfReferencingColName;
	}

	public String getRef_generation() {
		return ref_generation;
	}

	public void setRef_generation(String refGeneration) {
		ref_generation = refGeneration;
	}

	public List<Column> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<Column> columnList) {
		this.columnList = columnList;
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
		sb.append("'table_type':'").append(table_type).append("',");
		sb.append("'remarks':'").append(remarks).append("',");
		sb.append("'type_cat':'").append(type_cat).append("',");
		sb.append("'type_schem':'").append(type_schem).append("',");
		sb.append("'type_name':'").append(type_name).append("',");
		sb.append("'self_referencing_col_name':'").append(self_referencing_col_name).append("',");
		sb.append("'ref_generation':'").append(ref_generation).append("'");
		sb.append("}");
		return sb.toString();
	}
}
