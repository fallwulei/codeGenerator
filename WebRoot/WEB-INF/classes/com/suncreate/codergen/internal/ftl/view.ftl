<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@ include file="/commons/pages/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>三十八所党建信息化系统</title>
<link rel="stylesheet" type="text/css" href="${ctx}/theme/css/global.css" />
</head>
<body>
<div class="right scroll">
  <div style="min-width:700px;">
    <div style="height:22px;"></div>
        <div class="position"><span></span><h2>当前位置：首页 > ${navString}</h2></div>
      	<div class="clear"></div>
		<div class="wrap11" style=" width:94%; margin:0 auto; padding-top:30px;">
            <div class="titleBg">
			<span></span>
              <ul class="ch">
                <li class="ch201" style="font-weight:bold; font-size:15px;">基本信息</li>
              </ul>
        </div>
		<div style="border:#D3D3D3 1px solid; border-top:none; padding-top:16px; padding-bottom:20px; background-color:#FFFFFF;">
	      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="INtab1" style="width:100%;">
	        <#list table.columnList as col>
			<tr class="INtr2">
		      <td width="18%" class="bt"><#if col.remarks??>${col.remarks}<#else>${col.column_name}</#if>${maohao}</td>
		      <td class="tabLeft6"><c:out value="${$}{fn:escapeXml(af.map.${col.column_name?lower_case})}" /></td>
		    </tr>
		    </#list>
	      </table>
       </div>
       <div style="width:180px; margin:0 auto; padding-top:26px;">
			<input type="button" name="back" value="返 回" class="button1" onclick="history.back();"/>
		</div>
     </div>
  </div>
</div>
<script type="text/javascript" src="${ctx}/commons/scripts/scrollbar.js" ></script>
</body>
</html>