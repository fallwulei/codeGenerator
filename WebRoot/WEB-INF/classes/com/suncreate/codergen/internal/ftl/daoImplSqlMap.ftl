<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE sqlMap PUBLIC "-//ibatis.apache.org//DTD SQL Map 2.0//EN" "http://ibatis.apache.org/dtd/sql-map-2.dtd" >
<sqlMap namespace="${table.table_name}}">

	<typeAlias alias="${table.javaObjectCamelName?uncap_first}" type="${config.package_prefix}.domain.${table.javaObjectCamelName}" />

	<cacheModel id="oneDayCache" type="OSCACHE">
		<flushInterval hours="24" />
		<flushOnExecute statement="insert${table.javaObjectCamelName}" />
		<flushOnExecute statement="update${table.javaObjectCamelName}" />
		<flushOnExecute statement="delete${table.javaObjectCamelName}" />
	</cacheModel>

	<resultMap id="${table.javaObjectCamelName?uncap_first}ResultForList" class="${table.javaObjectCamelName?uncap_first}">
		<#list table.columnList as col>
		<result column="${col.column_name}" property="${col.column_name?lower_case}" jdbcType="${col.jdbcTypeShortName}" />
		</#list>
	</resultMap>

	<resultMap id="${table.javaObjectCamelName?uncap_first}Result" class="${table.javaObjectCamelName?uncap_first}" extends="${table.javaObjectCamelName?uncap_first}ResultForList">
	</resultMap>

	<sql id="sf-${table.javaObjectCamelName?uncap_first}">
		<#list table.columnList as col>
		<isNotEmpty prepend=" and " property="${col.column_name?lower_case}">${col.column_name} = #${col.column_name?lower_case}:${col.jdbcTypeShortName}#</isNotEmpty>
		</#list>
	</sql>

	<select id="select${table.javaObjectCamelName}" resultMap="${table.javaObjectCamelName?uncap_first}Result" parameterClass="${table.javaObjectCamelName?uncap_first}" cacheModel="oneDayCache">
		select * from ${table.table_name}  where 1 = 1
		<include refid="sf-${table.javaObjectCamelName?uncap_first}" />
	</select>

	<select id="select${table.javaObjectCamelName}List" resultMap="${table.javaObjectCamelName?uncap_first}ResultForList" parameterClass="${table.javaObjectCamelName?uncap_first}" cacheModel="oneDayCache">
		<isNotEmpty property="row.count">
			<![CDATA[ select * from ( ]]>
		</isNotEmpty>
		select * from ${table.table_name} where 1 = 1
		<include refid="sf-${table.javaObjectCamelName?uncap_first}" />
		<!-- order by ID desc -->
		<isNotEmpty property="row.count">
			<![CDATA[ ) where rownum <= #row.count# ]]>
		</isNotEmpty>
	</select>

	<select id="select${table.javaObjectCamelName}Count" resultClass="long" parameterClass="${table.javaObjectCamelName?uncap_first}" cacheModel="oneDayCache">
		select count(*) from ${table.table_name}  where 1 = 1
		<include refid="sf-${table.javaObjectCamelName?uncap_first}" />
	</select>

	<select id="select${table.javaObjectCamelName}PaginatedList" resultMap="${table.javaObjectCamelName?uncap_first}Result" parameterClass="${table.javaObjectCamelName?uncap_first}" cacheModel="oneDayCache">
		<![CDATA[ select * from ( select t_.*, rownum rn_ from ( ]]>
		select * from ${table.table_name} where 1 = 1
		<include refid="sf-${table.javaObjectCamelName?uncap_first}" />
		<!-- order by ID desc -->
		<![CDATA[ ) t_ where rownum <= (#row.first# + #row.count#)) where rn_ >= (#row.first# + 1) ]]>
	</select>

	<insert id="insert${table.javaObjectCamelName}" parameterClass="${table.javaObjectCamelName?uncap_first}">
		<!-- <selectKey resultClass="long" keyProperty="id">select S_${table.table_name}.nextval as id from dual </selectKey> -->
		<![CDATA[insert into ${table.table_name} (]]>
		<dynamic prepend=" ">
			<#list table.columnList as col>
			<isNotNull prepend="," property="${col.column_name?lower_case}">${col.column_name}</isNotNull>	
			</#list>
		</dynamic>
		<![CDATA[) values (]]>
		<dynamic prepend=" ">
			<#list table.columnList as col>
			<isNotNull prepend="," property="${col.column_name?lower_case}">#${col.column_name?lower_case}:${col.jdbcTypeShortName}#</isNotNull>
			</#list>
		</dynamic>
		<![CDATA[)]]>
	</insert>

	<update id="update${table.javaObjectCamelName}" parameterClass="${table.javaObjectCamelName?cap_first}">
		update ${table.table_name}
		<dynamic prepend="set">
			<#list table.columnList as col>
			<isNotNull prepend="," property="${col.column_name?lower_case}">${col.column_name} = #${col.column_name?lower_case}:${col.jdbcTypeShortName}#</isNotNull>
			</#list>
		</dynamic>
		where
		<isNotEmpty prepend=" " property="id">ID = #id#</isNotEmpty>
		<isEmpty prepend=" " property="id">
			<isNotEmpty prepend=" " property="map.pks">
				ID in
				<iterate close=")" open="(" conjunction="," property="map.pks">#map.pks[]#</iterate>
			</isNotEmpty>
		</isEmpty>
	</update>

	<delete id="delete${table.javaObjectCamelName}" parameterClass="${table.javaObjectCamelName?cap_first}">
		delete from ${table.table_name} where
		<isNotEmpty prepend=" " property="id">ID = #id#</isNotEmpty>
		<isEmpty prepend=" " property="id">
			<isNotEmpty prepend=" " property="map.pks">
				ID in
				<iterate close=")" open="(" conjunction="," property="map.pks">#map.pks[]#</iterate>
			</isNotEmpty>
		</isEmpty>
	</delete>

</sqlMap>