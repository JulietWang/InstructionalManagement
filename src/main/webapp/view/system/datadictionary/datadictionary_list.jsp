<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib  uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>

<%@ include file="/view/public/common.jspf" %>

</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">系统管理</a></li>
        <li>数据字典</li>
    </ul>
</div>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form  action="${pageContext.request.contextPath}/system/datadictionary/list.action" method="post" class="form-horizontal">
    <div class="col-sm-3" style="margin-left: 250px">
    	<input type="text" name="dataType" class="form-control input-sm" placeholder="请输入数据类型"/>
    </div>
    <input type="submit" class="btn btn-danger" value="查询"/>
    <a class="btn btn-success"  href="${pageContext.request.contextPath}/view/system/datadictionary/datadictionary_add.jsp">添加</a>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
	
    <display:table class="table table-condensed table-striped" name="list" pagesize="10" requestURI="${pageContext.request.contextPath }/system/datadictionary/list.action">
    	<display:column property="dataId" title="数据编号"></display:column>
    	<display:column property="dataContent" title="数据名称"></display:column>
    	<display:column property="dataType" title="数据类型"></display:column>
    	<display:column property="dataDesc" title="内容详情"></display:column>
    	<display:column href="${pageContext.request.contextPath }/system/datadictionary/load.action" paramId="dataId" paramProperty="dataId" value="修改" title="修改"></display:column>
    	<display:column href="${pageContext.request.contextPath }/system/datadictionary/delete.action" paramId="dataId" paramProperty="dataId" value="删除" title="删除"></display:column>
    	
    </display:table>
</div>

</body>
</html>
