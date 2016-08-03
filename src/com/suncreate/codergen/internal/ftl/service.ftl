package ${config.package_prefix}.service;

import java.util.List;

import ${config.package_prefix}.domain.${table.javaObjectCamelName};

/**
 * Coder AutoGenerator generate.
 *
 * @author Coder AutoGenerator by Cheng,Zhi
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
public interface ${table.javaObjectCamelName}Service {

	Long create${table.javaObjectCamelName}(${table.javaObjectCamelName} t);

	int modify${table.javaObjectCamelName}(${table.javaObjectCamelName} t);

	int remove${table.javaObjectCamelName}(${table.javaObjectCamelName} t);

	${table.javaObjectCamelName} get${table.javaObjectCamelName}(${table.javaObjectCamelName} t);

	List<${table.javaObjectCamelName}> get${table.javaObjectCamelName}List(${table.javaObjectCamelName} t);

	Long get${table.javaObjectCamelName}Count(${table.javaObjectCamelName} t);

	List<${table.javaObjectCamelName}> get${table.javaObjectCamelName}PaginatedList(${table.javaObjectCamelName} t);

}