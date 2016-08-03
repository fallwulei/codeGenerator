package com.suncreate.codergen.internal.config;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @author Cheng,Zhi
 * @version builder 2010.02.02
 */
public class Configuration {

	private static final String DAO_IMPL = "ibatis";

	private String name;

	private String workspace;

	private String package_prefix;

	private String package_prefix_commons;

	private String table_names;

	private String workspace_zip;

	private String realpath;

	private String realpath_dao;

	private String realpath_dao_impl;

	private String realpath_dao_impl_maps;

	private String realpath_domain;

	private String realpath_service;

	private String realpath_service_impl;

	private String realpath_web;

	private String realpath_web_struts;
	
	private String realpath_action;

	private String package_dao;

	private String package_dao_impl;

	private String package_dao_impl_maps;

	private String package_domain;

	private String package_service;

	private String package_service_impl;

	private String package_web;

	private String package_web_struts;
	
	private String package_jsp;
	
	private String package_action;

	public void init() throws IOException {
		// package prefix
		this.package_dao = this.package_prefix + ".dao";
		this.package_dao_impl = this.package_dao + "." + DAO_IMPL;
		this.package_dao_impl_maps = this.package_dao_impl + ".maps";
		this.package_domain = this.package_prefix + ".domain";
		this.package_service = this.package_prefix + ".service";
		this.package_service_impl = this.package_service + ".impl";
		this.package_web = this.package_prefix + ".web";
		this.package_web_struts = this.package_web + ".struts";
		this.package_jsp = this.package_prefix + ".jsp";
		this.package_action = this.package_web_struts + ".admin";

		if (!StringUtils.endsWith(this.workspace, File.separator)) {
			this.workspace += File.separator;
		}

		// real path :to project name
		this.realpath = this.workspace + this.name + File.separator;

		String relative_realpath = this.realpath;
		relative_realpath += package_prefix.replace(".", File.separator) + File.separator;

		this.realpath_dao = relative_realpath + "dao";
		this.realpath_dao_impl = this.realpath_dao + File.separator + DAO_IMPL;
		this.realpath_dao_impl_maps = this.realpath_dao_impl + File.separator + "maps";
		this.realpath_domain = relative_realpath + "domain";
		this.realpath_service = relative_realpath + "service";
		this.realpath_service_impl = this.realpath_service + File.separator + "impl";
		this.realpath_web = relative_realpath + "web";
		this.realpath_web_struts = this.realpath_web + File.separator + "struts";
		this.realpath_action = this.realpath_web_struts + File.separator + "admin";

		FileUtils.forceMkdir(new File(this.workspace));

		System.out.println("workspace : " + workspace);
		System.out.println("package_prefix : " + package_prefix);
		System.out.println("package_prefix_commons : " + package_prefix_commons);
		System.out.println("table_names : " + table_names);
		System.out.println("package_dao : " + package_dao);
		System.out.println("package_dao_impl : " + package_dao_impl);
		System.out.println("package_dao_impl_maps : " + package_dao_impl_maps);
		System.out.println("package_domain : " + package_domain);
		System.out.println("package_service : " + package_service);
		System.out.println("package_service_impl : " + package_service_impl);
		System.out.println("package_web : " + package_web);
		System.out.println("package_web_struts : " + package_web_struts);
		System.out.println("package_action : " + package_action);
		System.out.println("relative_path : " + relative_realpath);
		System.out.println("realpath_dao : " + realpath_dao);
		System.out.println("realpath_dao_impl : " + realpath_dao_impl);
		System.out.println("realpath_dao_impl_maps : " + realpath_dao_impl_maps);
		System.out.println("realpath_domain : " + realpath_domain);
		System.out.println("realpath_service : " + realpath_service);
		System.out.println("realpath_service_impl : " + realpath_service_impl);
		System.out.println("realpath_web : " + realpath_web);
		System.out.println("realpath_web_struts : " + realpath_web_struts);
		System.out.println("realpath_action : " + realpath_action);
	}

	// setters and getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWorkspace() {
		return workspace;
	}

	public void setWorkspace(String workspace) {
		this.workspace = workspace;
	}

	public String getPackage_prefix() {
		return package_prefix;
	}

	public void setPackage_prefix(String packagePrefix) {
		package_prefix = packagePrefix;
	}

	public String getPackage_prefix_commons() {
		return package_prefix_commons;
	}

	public void setPackage_prefix_commons(String packagePrefixCommons) {
		package_prefix_commons = packagePrefixCommons;
	}

	public String getTable_names() {
		return table_names;
	}

	public void setTable_names(String tableNames) {
		table_names = tableNames;
	}

	public String getWorkspace_zip() {
		return workspace_zip;
	}

	public void setWorkspace_zip(String workspaceZip) {
		workspace_zip = workspaceZip;
	}

	public String getRealpath() {
		return realpath;
	}

	public void setRealpath(String realpath) {
		this.realpath = realpath;
	}

	public String getRealpath_dao() {
		return realpath_dao;
	}

	public void setRealpath_dao(String realpathDao) {
		realpath_dao = realpathDao;
	}

	public String getRealpath_dao_impl() {
		return realpath_dao_impl;
	}

	public void setRealpath_dao_impl(String realpathDaoImpl) {
		realpath_dao_impl = realpathDaoImpl;
	}

	public String getRealpath_dao_impl_maps() {
		return realpath_dao_impl_maps;
	}

	public void setRealpath_dao_impl_maps(String realpathDaoImplMaps) {
		realpath_dao_impl_maps = realpathDaoImplMaps;
	}

	public String getRealpath_domain() {
		return realpath_domain;
	}

	public void setRealpath_domain(String realpathDomain) {
		realpath_domain = realpathDomain;
	}

	public String getRealpath_service() {
		return realpath_service;
	}

	public void setRealpath_service(String realpathService) {
		realpath_service = realpathService;
	}

	public String getRealpath_service_impl() {
		return realpath_service_impl;
	}

	public void setRealpath_service_impl(String realpathServiceImpl) {
		realpath_service_impl = realpathServiceImpl;
	}

	public String getRealpath_web() {
		return realpath_web;
	}

	public void setRealpath_web(String realpathWeb) {
		realpath_web = realpathWeb;
	}

	public String getRealpath_web_struts() {
		return realpath_web_struts;
	}

	public void setRealpath_web_struts(String realpathWebStruts) {
		realpath_web_struts = realpathWebStruts;
	}

	public String getPackage_dao() {
		return package_dao;
	}

	public void setPackage_dao(String packageDao) {
		package_dao = packageDao;
	}

	public String getPackage_dao_impl() {
		return package_dao_impl;
	}

	public void setPackage_dao_impl(String packageDaoImpl) {
		package_dao_impl = packageDaoImpl;
	}

	public String getPackage_dao_impl_maps() {
		return package_dao_impl_maps;
	}

	public void setPackage_dao_impl_maps(String packageDaoImplMaps) {
		package_dao_impl_maps = packageDaoImplMaps;
	}

	public String getPackage_domain() {
		return package_domain;
	}

	public void setPackage_domain(String packageDomain) {
		package_domain = packageDomain;
	}

	public String getPackage_service() {
		return package_service;
	}

	public void setPackage_service(String packageService) {
		package_service = packageService;
	}

	public String getPackage_service_impl() {
		return package_service_impl;
	}

	public void setPackage_service_impl(String packageServiceImpl) {
		package_service_impl = packageServiceImpl;
	}

	public String getPackage_web() {
		return package_web;
	}

	public void setPackage_web(String packageWeb) {
		package_web = packageWeb;
	}

	public String getPackage_web_struts() {
		return package_web_struts;
	}

	public void setPackage_web_struts(String packageWebStruts) {
		package_web_struts = packageWebStruts;
	}

	public String getPackage_jsp() {
		return package_jsp;
	}

	public void setPackage_jsp(String package_jsp) {
		this.package_jsp = package_jsp;
	}

	public String getPackage_action() {
		return package_action;
	}

	public void setPackage_action(String package_action) {
		this.package_action = package_action;
	}

	public String getRealpath_action() {
		return realpath_action;
	}

	public void setRealpath_action(String realpath_action) {
		this.realpath_action = realpath_action;
	}

}
