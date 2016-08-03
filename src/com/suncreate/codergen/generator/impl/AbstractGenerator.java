package com.suncreate.codergen.generator.impl;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.suncreate.codergen.internal.Constants;
import com.suncreate.codergen.internal.config.Configuration;
import com.suncreate.codergen.service.Facade;
import com.suncreate.codergen.service.TemplateService;
import com.suncreate.codergen.utils.Messages;
import com.suncreate.codergen.utils.UtilsString;

/**
 * @author Cheng,Zhi
 * @version builder 2010.02.03
 */
public abstract class AbstractGenerator {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	protected Configuration config;

	@Resource
	private Facade facade;

	@Resource
	private TemplateService templateService;

	@Resource
	protected Messages internal;

	protected Facade getFacade() {
		return facade;
	}

	protected TemplateService getTemplateService() {
		return templateService;
	}

	protected Boolean isGenerateAllTables() {
		String tablenames = UtilsString.removeQuote(config.getTable_names()).trim();
		return StringUtils.isBlank(tablenames) || StringUtils.equalsIgnoreCase(tablenames, "all");
	}

	protected Boolean isZipFile() {
		return new Boolean(UtilsString.removeQuote(config.getWorkspace_zip()).trim());
	}

	protected void writeToFile(String realPath, String content) {
		try {
			FileUtils.writeStringToFile(new File(realPath), content, Constants.FILE_ENCODING);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	protected static final String FILE_FACADE = "Facade";

	protected static final String FILE_FACADE_IMPL = "FacadeImpl";

	protected static final String FILE_SUFFIX_DAO = "Dao";

	protected static final String FILE_SUFFIX_DAO_IMPL = "DaoSqlMapImpl";

	protected static final String FILE_SUFFIX_IBATIS_SQLMAP_XML = "_SqlMap";

	protected static final String FILE_SUFFIX_SERVICE = "Service";

	protected static final String FILE_SUFFIX_SERVICE_IMPL = "ServiceImpl";

	protected static final String FILE_IBATIS_SQLMAP_CONFIG = "sqlmap-config";

}
