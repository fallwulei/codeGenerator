package com.suncreate.codergen.generator;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.suncreate.codergen.generator.impl.DaoGenerator;
import com.suncreate.codergen.generator.impl.DaoImplGenerator;
import com.suncreate.codergen.generator.impl.DomainGenerator;
import com.suncreate.codergen.generator.impl.FacadeGenerator;
import com.suncreate.codergen.generator.impl.FacadeImplGenerator;
import com.suncreate.codergen.generator.impl.IbatisSqlMapConfigXmlGenerator;
import com.suncreate.codergen.generator.impl.IbatisSqlMapXmlGenerator;
import com.suncreate.codergen.generator.impl.ListJspGenerator;
import com.suncreate.codergen.generator.impl.ServiceGenerator;
import com.suncreate.codergen.generator.impl.ServiceImplGenerator;

/**
 * @author Cheng,Zhi
 * @version builder 2010.02.03
 */
@Service("generatorFacatory")
public class GeneratorFacatory {

	@Resource
	private DomainGenerator domainGenerator;

	@Resource
	private DaoGenerator daoGenerator;

	@Resource
	private DaoImplGenerator daoImplGenerator;

	@Resource
	private ServiceGenerator serviceGenerator;

	@Resource
	private ServiceImplGenerator serviceImplGenerator;

	@Resource
	private IbatisSqlMapXmlGenerator ibatisSqlMapXmlGenerator;

	@Resource
	private IbatisSqlMapConfigXmlGenerator ibatisSqlMapConfigXmlGenerator;

	@Resource
	private FacadeGenerator facadeGenerator;

	@Resource
	private FacadeImplGenerator facadeImplGenerator;
	
	@Resource
	private ListJspGenerator listJspGenerator;

	public DomainGenerator getDomainGenerator() {
		return domainGenerator;
	}

	public DaoGenerator getDaoGenerator() {
		return daoGenerator;
	}

	public DaoImplGenerator getDaoImplGenerator() {
		return daoImplGenerator;
	}

	public ServiceGenerator getServiceGenerator() {
		return serviceGenerator;
	}

	public ServiceImplGenerator getServiceImplGenerator() {
		return serviceImplGenerator;
	}

	public IbatisSqlMapXmlGenerator getIbatisSqlMapXmlGenerator() {
		return ibatisSqlMapXmlGenerator;
	}

	public IbatisSqlMapConfigXmlGenerator getIbatisSqlMapConfigXmlGenerator() {
		return ibatisSqlMapConfigXmlGenerator;
	}

	public FacadeGenerator getFacadeGenerator() {
		return facadeGenerator;
	}

	public FacadeImplGenerator getFacadeImplGenerator() {
		return facadeImplGenerator;
	}

	public ListJspGenerator getListJspGenerator() {
		return listJspGenerator;
	}

}
