package ${config.package_prefix}.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ${config.package_prefix}.service.Facade;

<#list tableList as table>
import ${config.package_prefix}.service.${table.javaObjectCamelName}Service;
</#list>

/**
 * Coder AutoGenerator generate.
 *
 * @author Coder AutoGenerator by Cheng,Zhi
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@Service("facade")
public class FacadeImpl implements Facade {

	<#list tableList as table>
	@Resource
	${table.javaObjectCamelName}Service ${table.javaObjectCamelName?uncap_first}Service;
	
	</#list>
	<#list tableList as table>
	public ${table.javaObjectCamelName}Service get${table.javaObjectCamelName}Service() {
		return ${table.javaObjectCamelName?uncap_first}Service;
	}
	
	</#list>
}
