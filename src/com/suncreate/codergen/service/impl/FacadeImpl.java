package com.suncreate.codergen.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.suncreate.codergen.service.ColumnService;
import com.suncreate.codergen.service.Facade;
import com.suncreate.codergen.service.TableService;

/**
 * @author Cheng,Zhi
 * @version builder 2010.02.02
 */
@Service("facade")
public class FacadeImpl implements Facade {

	@Resource
	ColumnService columnService;

	@Resource
	TableService tableService;

	public ColumnService getColumnService() {
		return columnService;
	}

	public TableService getTableService() {
		return tableService;
	}

}
