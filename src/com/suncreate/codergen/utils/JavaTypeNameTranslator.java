package com.suncreate.codergen.utils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

/**
 * @author Jeff Butler ,last edit by Cheng,Zhi @ 2010.02.04
 * @since org.apache.ibatis.ibator.internal.types.JavaTypeResolverDefaultImpl
 */
public class JavaTypeNameTranslator {

	/*
	 * (non-Javadoc)
	 * @see
	 * org.apache.ibatis.ibator.api.JavaTypeResolver#initializeResolvedJavaType(org.apache.ibatis.ibator.internal.db
	 * .ColumnDefinition)
	 */
	public static String getJavaTypeName(final int jdbcType, final int size, final int decimal_digits)
			throws SQLException {

		String answer = null;
		
		switch (jdbcType) {
		case Types.ARRAY:
			answer = Object.class.getName();
			break;

		case Types.BIGINT:
			answer = Long.class.getName();
			break;

		case Types.BINARY:
			answer = "byte[]"; //$NON-NLS-1$
			break;

		case Types.BIT:
			answer = Boolean.class.getName();
			break;

		case Types.BLOB:
			answer = "byte[]"; //$NON-NLS-1$
			break;

		case Types.BOOLEAN:
			answer = Boolean.class.getName();
			break;

		case Types.CHAR:
			answer = String.class.getName();
			break;

		case Types.CLOB:
			answer = String.class.getName();
			break;

		case Types.DATALINK:
			answer = Object.class.getName();
			break;

		case Types.DATE:
			answer = Date.class.getName();
			break;

		case Types.DECIMAL:
		    if(size == 22){
		    	answer = Integer.class.getName();
		    }else if (size > 9) {
				answer = Long.class.getName();
			} else if (size > 4) {
				answer = Integer.class.getName();
			} else {
				// answer = Short.class.getName();
				answer = Integer.class.getName(); // ChengZhi add for javaType of Domain
			}
			break;
			
/*		case Types.DECIMAL:
			if (decimal_digits > 0 || size > 18) {
				answer = BigDecimal.class.getName();
			} else if (size > 9) {
				answer = Long.class.getName();
			} else if (size > 4) {
				answer = Integer.class.getName();
			} else {
				// answer = Short.class.getName();
				answer = Integer.class.getName(); // ChengZhi add for javaType of Domain
			}
			break;
*/
		case Types.DISTINCT:
			answer = Object.class.getName();
			break;

		case Types.DOUBLE:
			answer = Double.class.getName();
			break;

		case Types.FLOAT:
			answer = Double.class.getName();
			break;

		case Types.INTEGER:
			answer = Integer.class.getName();
			break;

		case Types.JAVA_OBJECT:
			answer = Object.class.getName();
			break;

		case Types.LONGVARBINARY:
			answer = "byte[]"; //$NON-NLS-1$
			break;

		case Types.LONGVARCHAR:
			answer = String.class.getName();
			break;

		case Types.NULL:
			answer = Object.class.getName();
			break;

		case Types.NUMERIC:
			if (size > 9) {
				answer = Long.class.getName();
			} else if (size > 4) {
				answer = Integer.class.getName();
			} else {
				// answer = Short.class.getName();
				answer = Integer.class.getName(); // ChengZhi add for javaType of Domain
			}
			break;
			
/*		case Types.NUMERIC:
			if (decimal_digits > 0 || size > 18) {
				answer = BigDecimal.class.getName();
			} else if (size > 9) {
				answer = Long.class.getName();
			} else if (size > 4) {
				answer = Integer.class.getName();
			} else {
				// answer = Short.class.getName();
				answer = Integer.class.getName(); // ChengZhi add for javaType of Domain
			}
			break;
*/
		case Types.OTHER:
			answer = Object.class.getName();
			break;

		case Types.REAL:
			answer = Float.class.getName();
			break;

		case Types.REF:
			answer = Object.class.getName();
			break;

		case Types.SMALLINT:
			// answer = Short.class.getName();
			answer = Integer.class.getName(); // ChengZhi add for javaType of Domain
			break;

		case Types.STRUCT:
			answer = Object.class.getName();
			break;

		case Types.TIME:
			answer = Date.class.getName();
			break;

		case Types.TIMESTAMP:
			answer = Date.class.getName();
			break;

		case Types.TINYINT:
			answer = Byte.class.getName();
			break;

		case Types.VARBINARY:
			answer = "byte[]"; //$NON-NLS-1$
			break;

		case Types.VARCHAR:
			answer = String.class.getName();
			break;

		default:
			answer = null;
			break;
		}

		return answer;
	}
}
