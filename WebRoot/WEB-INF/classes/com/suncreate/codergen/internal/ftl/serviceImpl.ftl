package ${config.package_prefix}.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ${config.package_prefix}.dao.${table.javaObjectCamelName}Dao;
import ${config.package_prefix}.domain.${table.javaObjectCamelName};
import ${config.package_prefix}.service.${table.javaObjectCamelName}Service;

/**
 * Coder AutoGenerator generate.
 *
 * @author Coder AutoGenerator by Cheng,Zhi
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@Service
public class ${table.javaObjectCamelName}ServiceImpl implements ${table.javaObjectCamelName}Service {

	@Resource
	private ${table.javaObjectCamelName}Dao ${table.javaObjectCamelName?uncap_first}Dao;
	

	public Long create${table.javaObjectCamelName}(${table.javaObjectCamelName} t) {
		return this.${table.javaObjectCamelName?uncap_first}Dao.insertEntity(t);
	}

	public ${table.javaObjectCamelName} get${table.javaObjectCamelName}(${table.javaObjectCamelName} t) {
		return this.${table.javaObjectCamelName?uncap_first}Dao.selectEntity(t);
	}

	public Long get${table.javaObjectCamelName}Count(${table.javaObjectCamelName} t) {
		return this.${table.javaObjectCamelName?uncap_first}Dao.selectEntityCount(t);
	}

	public List<${table.javaObjectCamelName}> get${table.javaObjectCamelName}List(${table.javaObjectCamelName} t) {
		return this.${table.javaObjectCamelName?uncap_first}Dao.selectEntityList(t);
	}

	public int modify${table.javaObjectCamelName}(${table.javaObjectCamelName} t) {
		return this.${table.javaObjectCamelName?uncap_first}Dao.updateEntity(t);
	}

	public int remove${table.javaObjectCamelName}(${table.javaObjectCamelName} t) {
		return this.${table.javaObjectCamelName?uncap_first}Dao.deleteEntity(t);
	}

	public List<${table.javaObjectCamelName}> get${table.javaObjectCamelName}PaginatedList(${table.javaObjectCamelName} t) {
		return this.${table.javaObjectCamelName?uncap_first}Dao.selectEntityPaginatedList(t);
	}

}
