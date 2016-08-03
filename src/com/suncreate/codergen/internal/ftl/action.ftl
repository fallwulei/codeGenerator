package ${config.package_prefix}.web.struts.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ebiz.ssi.web.struts.bean.Pager;
import ${config.package_prefix}.domain.${table.javaObjectCamelName};
import ${config.package_prefix}.web.BaseAction;
import com.suncreate.util.UUIDGenerator;
/**
 * @author Xxx,Xxx
 */
public class ${table.javaObjectCamelName}Action extends BaseAction {
	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return this.list(mapping, form, request, response);
	}

	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		super.callPubMethod(request, response);
		//鏉冮檺鐩稿叧
		super.getModPopeDom(form, request);
		
		DynaBean dynaBean = (DynaBean) form;
		Pager pager = (Pager) dynaBean.get("pager");

		${table.javaObjectCamelName} entity = new ${table.javaObjectCamelName}();

		super.copyProperties(entity, form);

		Long recordCount = super.getFacade().get${table.javaObjectCamelName}Service().get${table.javaObjectCamelName}Count(entity);
		pager.init(Long.valueOf(recordCount), pager.getPageSize(), pager.getRequestPage());
		entity.getRow().setFirst(pager.getFirstRow());
		entity.getRow().setCount(pager.getRowCount());

		List<${table.javaObjectCamelName}> entityList = getFacade().get${table.javaObjectCamelName}Service().get${table.javaObjectCamelName}PaginatedList(entity);
		request.setAttribute("entityList", entityList);

		return mapping.findForward("list");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		saveToken(request);
		super.callPubMethod(request, response);
		return mapping.findForward("input");
	}

	public ActionForward view(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		super.callPubMethod(request, response);
		
		DynaBean dynaBean = (DynaBean) form;
		String id = (String) dynaBean.get("id");
		if (StringUtils.isBlank(id)) {
			this.saveError(request, "errors.parm", new String[] { id });
			return mapping.findForward("list");
		}
		${table.javaObjectCamelName} entity = new ${table.javaObjectCamelName}();
		//Long.valueOf(id);
		entity.setId(id);
		entity = getFacade().get${table.javaObjectCamelName}Service().get${table.javaObjectCamelName}(entity);

		super.copyProperties(dynaBean, entity);
		return mapping.findForward("view");
	}

	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (isCancelled(request)) {
			return list(mapping, form, request, response);
		}
		if (!isTokenValid(request)) {
			saveError(request, "errors.token");
			return list(mapping, form, request, response);
		}
		
		DynaBean dynaBean = (DynaBean) form;
		String id = (String) dynaBean.get("id");
		String mod_id = (String) dynaBean.get("mod_id");

		${table.javaObjectCamelName} entity = new ${table.javaObjectCamelName}();
		super.copyProperties(entity, form);

		if (StringUtils.isBlank(id)) {// insert
			String uuid=UUIDGenerator.generate();//产生新的UUID
			entity.setId(uuid);
			super.getFacade().get${table.javaObjectCamelName}Service().create${table.javaObjectCamelName}(entity);
			saveMessage(request, "entity.inserted");
		} else {// update
			${table.javaObjectCamelName} ${table.javaObjectCamelName?uncap_first} = new ${table.javaObjectCamelName}();
			${table.javaObjectCamelName?uncap_first}.setId(entity.getId());
			${table.javaObjectCamelName?uncap_first} = getFacade().get${table.javaObjectCamelName}Service().get${table.javaObjectCamelName}(${table.javaObjectCamelName?uncap_first});
			if (null != ${table.javaObjectCamelName?uncap_first}) {
				getFacade().get${table.javaObjectCamelName}Service().modify${table.javaObjectCamelName}(entity);
				saveMessage(request, "entity.updated");
			} else {
				saveError(request, "entity.missing");
			}
		}

		// the line below is added for pagination
		StringBuffer pathBuffer = new StringBuffer();
		pathBuffer.append(mapping.findForward("success").getPath());
		pathBuffer.append("&mod_id=" + mod_id);
		pathBuffer.append("&");
		pathBuffer.append(super.encodeSerializedQueryString(entity.getQueryString()));
		ActionForward forward = new ActionForward(pathBuffer.toString(), true);
		// end
		return forward;
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		saveToken(request);
		super.callPubMethod(request, response);

		DynaBean dynaBean = (DynaBean) form;
		String id = (String) dynaBean.get("id");

		if (StringUtils.isBlank(id)) {
			this.saveError(request, "errors.long", new String[] { id });
			return mapping.findForward("list");
		}

		${table.javaObjectCamelName} entity = new ${table.javaObjectCamelName}();
		//Long.valueOf(id);
		entity.setId(id);
		entity = super.getFacade().get${table.javaObjectCamelName}Service().get${table.javaObjectCamelName}(entity);
		if (null == entity) {
			saveMessage(request, "entity.missing");
			return mapping.findForward("list");
		}
		// the line below is added for pagination
		entity.setQueryString(super.serialize(request, "id", "method"));
		// end
		super.copyProperties(form, entity);
		return mapping.findForward("input");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DynaBean dynaBean = (DynaBean) form;

		String id = (String) dynaBean.get("id");
		String mod_id = (String) dynaBean.get("mod_id");
		String[] pks = (String[]) dynaBean.get("pks");

		if (!StringUtils.isBlank(id)) {
			${table.javaObjectCamelName} entity = new ${table.javaObjectCamelName}();
			//Long.valueOf(id);
		    entity.setId(id);
			super.getFacade().get${table.javaObjectCamelName}Service().remove${table.javaObjectCamelName}(entity);
			saveMessage(request, "entity.deleted");
		} else if (!ArrayUtils.isEmpty(pks)) {
			${table.javaObjectCamelName} entity = new ${table.javaObjectCamelName}();
			entity.getMap().put("pks", pks);
			super.getFacade().get${table.javaObjectCamelName}Service().remove${table.javaObjectCamelName}(entity);
			saveMessage(request, "entity.deleted");
		}
		// the line below is added for pagination
		StringBuffer pathBuffer = new StringBuffer();
		pathBuffer.append(mapping.findForward("success").getPath());
		pathBuffer.append("&mod_id=" + mod_id);
		pathBuffer.append("&");
		pathBuffer.append(super.encodeSerializedQueryString(super.serialize(request, "id", "pks", "method")));
		ActionForward forward = new ActionForward(pathBuffer.toString(), true);
		// end
		return forward;
	}

}