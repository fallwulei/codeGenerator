package ${config.package_prefix}.domain;

import java.io.Serializable;
<#list packageImportList as packageImport>
import ${packageImport};
</#list>

import com.ebiz.ssi.domain.BaseDomain;

/**
 * Coder AutoGenerator generate.
 *
 * @author Coder AutoGenerator by Cheng,Zhi
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
public class ${table.javaObjectCamelName} extends BaseDomain implements Serializable {

	private static final long serialVersionUID = -1L;

	<#list table.columnList as col>
	/**
	 * <#if col.remarks??>${col.remarks}<#else>${col.column_name}</#if>
	 */
	private ${col.javaTypeShortName} ${col.column_name?lower_case};
	
	</#list>
	public ${table.javaObjectCamelName}() {

	}

	<#list table.columnList as col>
	public ${col.javaTypeShortName} get${col.column_name?lower_case?cap_first}() {
		return ${col.column_name?lower_case};
	}

	public void set${col.column_name?lower_case?cap_first}(${col.javaTypeShortName} ${col.column_name?lower_case}) {
		this.${col.column_name?lower_case} = ${col.column_name?lower_case};
	}
	
	</#list>
}