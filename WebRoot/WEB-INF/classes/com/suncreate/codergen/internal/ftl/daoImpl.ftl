package ${config.package_prefix}.dao.ibatis;

import org.springframework.stereotype.Service;

import ${config.package_prefix}.dao.${table.javaObjectCamelName}Dao;
import ${config.package_prefix}.domain.${table.javaObjectCamelName};
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

/**
 * Coder AutoGenerator generate.
 *
 * @author Coder AutoGenerator by Cheng,Zhi
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@Service
public class ${table.javaObjectCamelName}DaoSqlMapImpl extends EntityDaoSqlMapImpl<${table.javaObjectCamelName}> implements ${table.javaObjectCamelName}Dao {

}
