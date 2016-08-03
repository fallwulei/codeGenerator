package com.suncreate.codergen.service;

import java.util.Map;

/**
 * @author Cheng,Zhi
 * @version builder 2010.02.02
 */
public interface TemplateService {

	String getContent(String templateName, Map<String, Object> model);

}
