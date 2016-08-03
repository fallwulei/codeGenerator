package com.suncreate.codergen.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.suncreate.codergen.service.TemplateService;

import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @author Jin, QingHua
 */
public class TemplateServiceFreeMarkerSpringImpl implements TemplateService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private FreeMarkerConfigurer freeMarkerConfigurer;

	public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
		this.freeMarkerConfigurer = freeMarkerConfigurer;
	}

	public String getContent(String templateName, Map<String, Object> model) {
		try {
			Template t = freeMarkerConfigurer.getConfiguration().getTemplate(templateName);
			logger.debug(FreeMarkerTemplateUtils.processTemplateIntoString(t, model));
			return FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
		} catch (TemplateException e) {
			logger.error("Error while processing FreeMarker template ", e);
		} catch (FileNotFoundException e) {
			logger.error("Error while open template file ", e);
		} catch (IOException e) {
			logger.error("Error while generate Email Content ", e);
		}
		return null;
	}
}
