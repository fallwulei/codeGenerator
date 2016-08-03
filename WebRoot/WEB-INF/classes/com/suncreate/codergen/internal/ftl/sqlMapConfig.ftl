<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE sqlMapConfig 
		PUBLIC "-//ibatis.apache.org//DTD SQL Map Config 2.0//EN" 
		"http://ibatis.apache.org/dtd/sql-map-config-2.dtd">

<sqlMapConfig>
	<settings cacheModelsEnabled="false" enhancementEnabled="true" lazyLoadingEnabled="true"
		useStatementNamespaces="false" statementCachingEnabled="true" classInfoCacheEnabled="true" />

	<typeHandler jdbcType="BLOB" javaType="[B"
		callback="org.springframework.orm.ibatis.support.BlobByteArrayTypeHandler" />
	<typeHandler jdbcType="CLOB" javaType="java.lang.String"
		callback="org.springframework.orm.ibatis.support.ClobStringTypeHandler" />

<#list tableList as table>
	<sqlMap resource="${config.package_dao_impl_maps?replace('.', '/')}/${table.table_name}_SqlMap.xml" />
</#list>

</sqlMapConfig>