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
    	<li><a href="#">班级管理</a></li>
        <li>班级信息</li>
    </ul>
</div>
<form class="form-inline" action="${pageContext.request.contextPath}/classinfo/classinfo/listCDSCS.action" method="post">
<div class="row alert alert-info"  style="margin:0px; padding:3px;text-align: center;" >

     <div class="form-group">
        <input type="text" class="form-control" name="className">
      </div>

    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <a href="${pageContext.request.contextPath}/classinfo/classinfo/loadCDSCS.action" class="btn btn-success">添加课程</a>
    
</div>

<div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			
		</button>
		<p align="center" style="color: red;">员工信息-${info}</p>
	</div>	
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
	<table class="table  table-condensed table-striped">
    </table>
     <display:table class="table table-condensed table-striped" name="list" pagesize="10" requestURI="${pageContext.request.contextPath }/classinfo/classinfo/listCDSCS.action">
    	<display:column property="classInfo.classId" title="编号"></display:column>
    	<display:column property="classInfo.className" title="班级名称"></display:column>
    	<display:column property="classInfo.classNumber" title="班级人数"></display:column>
    	<display:column property="classInfo.classStartTime" title="开班日期" format="{0,date,yyyy年MM月dd日}"></display:column>
    	<display:column property="classInfo.classEndTime" title="结束日期" format="{0,date,yyyy年MM月dd日}"></display:column>
    	<display:column href="${pageContext.request.contextPath}/classinfo/classinfo/loadCDSCS1.action" paramId="classId" paramProperty="classInfo.classId" value="修改" title="修改"></display:column>
    	<display:column href="${pageContext.request.contextPath}/classinfo/classinfo/delete.action" paramId="classId" paramProperty="classInfo.classId" value="删除" title="删除"></display:column>
    </display:table>
    
</div>
</form>
</body>
</html>
