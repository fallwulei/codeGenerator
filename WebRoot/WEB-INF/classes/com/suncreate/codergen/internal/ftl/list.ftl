<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ include file="/commons/pages/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>三十八所党建信息化系统</title>
<link href="${ctx}/theme/fontIcon/fontIcon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/theme/css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/commons/scripts/jquery.js"></script>
<script type="text/javascript" src="${ctx}/commons/scripts/validator.js"></script>
<script type="text/javascript" src="${ctx}/commons/scripts/scrollbar.js" ></script>
<script type="text/javascript" src="${ctx}/commons/scripts/rowEffect.js" ></script>
<script type="text/javascript">//<![CDATA[
$(document).ready(function(){
	$("#btn_submit").click(function(){
	    document.forms[0].submit();
	});
});
//]]></script>
</head>
<body>
<div class="right scroll">
  <div style="min-width:700px;">
    <div style="height:22px;"></div>
    <div class="scroll">
      <div class="position"><span></span><h2>当前位置：首页 > ${navString}</h2></div>
	  <div style="border:#D3D3D3 1px solid; padding-top:16px; padding-bottom:20px; background-color:#FFFFFF; width:94%; margin:0 auto; margin-bottom:14px; margin-top:20px;">
	      <html-el:form action="/${table.javaObjectCamelName}">
	      <html-el:hidden property="mod_id" styleId="mod_id" />
		      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="INtab1" style="width:100%;">
		        <tr class="INtr1">
		          <td align="right">XX</td>
				  <td class="tabLeft6">
				  	<input name="text322" type="text" value="" class="INinput2" style="width:60%;"/>
				  </td>
		          <td class="tabLeft6">
		          	<div style=" margin:0 auto; padding-top:0px;">
				   		<input type="button" name="Submit" value="提 交" class="button1" id="btn_submit"/>
				   	</div>
				  </td>
		        </tr>
			   </table>
	       </html-el:form>
      </div>
	 <div style="width:94%; margin:0 auto;">
		<input type="button" name="Submit" value="新增" class="button1" 
		onclick="location.href='${table.javaObjectCamelName}.do?method=add&mod_id=${$}{af.map.mod_id}';"/>
	  </div>
      
     <table align="center" width="95%" border="0" cellspacing="1" cellpadding="0" class="tab1">
      <tr class="tr0">
        <th width="5%" nowrap="nowrap">${xuhao}</th>
        <#list table.columnList as col>
	    <th nowrap="nowrap"><#if col.remarks??>${col.remarks}<#else>${col.column_name}</#if></th>
        </#list>
        <th nowrap="nowrap">${caozuo}</th>
      </tr>
      <c:forEach var="cur" items="${$}{entityList}" varStatus="vs">
        <tr class="tr1">
          <td align="center">${$}{af.map.pager.pageSize *( af.map.pager.currentPage - 1) + vs.count}</td>
          <#list table.columnList as col>
	      <td>${$}{cur.${col.column_name?lower_case}}</td>
          </#list>
          <td align="center">
          	<div class="opt1">
          	    <%--权限控制 <logic-el:match name="popedom" value=",1,"> --%>
		    	<a href="javascript:void(0);" class="opt102" onclick="doNeedMethod(null, '${table.javaObjectCamelName}.do', 'view', 'id=${$}{cur.id}&mod_id=${$}{af.map.mod_id}')"></a>
		    	<a href="javascript:void(0);" class="opt103" onclick="confirmUpdate(null, '${table.javaObjectCamelName}.do', 'id=${$}{cur.id}&mod_id=${$}{af.map.mod_id}&' + ${$}('#bottomPageForm').serialize())"></a>
		    	<a href="javascript:void(0);" class="opt101" onclick="confirmDelete(null, '${table.javaObjectCamelName}.do', 'id=${$}{cur.id}&mod_id=${$}{af.map.mod_id}&' + ${$}('#bottomPageForm').serialize())"></a>
	    	</div>
          </td>
        </tr>
        <c:if test="${$}{vs.last eq true}">
          <c:set var="i" value="${$}{vs.count}" />
        </c:if>
      </c:forEach>
      <c:forEach begin="${$}{i}" end="${$}{af.map.pager.pageSize - 1}">
      <tr class="tr1">
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <#list table.columnList as col>
        <td>&nbsp;</td>
       </#list>
      </tr>
     </c:forEach>
    </table>
            
      <div class="Fy">
        <form id="bottomPageForm" name="bottomPageForm" method="post" action="${table.javaObjectCamelName}.do">
          <table width="600" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td height="40" align="center" valign="middle">
              	<script type="text/javascript" src="${$}{ctx}/commons/scripts/pager.js">;</script>
                <script type="text/javascript">
		            var pager = new Pager(document.bottomPageForm, ${$}{af.map.pager.recordCount}, ${$}{af.map.pager.pageSize}, ${$}{af.map.pager.currentPage});
		            pager.addHiddenInputs("method", "list");
		            pager.addHiddenInputs("mod_id", "${$}{fn:escapeXml(af.map.mod_id)}");
		            <#list table.columnList as col>
		            pager.addHiddenInputs("${col.column_name?lower_case}", "${$}{fn:escapeXml(af.map.${col.column_name?lower_case})}");
		            </#list>
		            document.write(pager.toString());
               </script>
            </td>
            </tr>
          </table>
        </form>
      </div>
  </div>
</div>
</body>
</html>
