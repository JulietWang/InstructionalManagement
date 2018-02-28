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
        <li>课程表</li>
    </ul>
</div>
<form class="form-inline" action="${pageContext.request.contextPath}/classinfo/syllabusinfo/list.action" method="post">
<div class="row alert alert-info"  style="margin:0px; padding:3px;text-align: center;" >

     <div class="form-group">
        <input type="text" class="form-control" name="syllabusName" placeholder="请输入课程名字">
      </div>

    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <input type="button"   class="btn btn-success"     value="添加课程表" onClick="javascript:window.location='${pageContext.request.contextPath}/view/classinfo/syllabusinfo/syllabusinfo_add.jsp'"/>
    
    
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
    <display:table class="table table-condensed table-striped" name="list" pagesize="10" requestURI="${pageContext.request.contextPath }/classinfo/syllabusinfo/list.action">
   	<display:column property="syllabusId" title="编号"></display:column>
    	<display:column property="syllabusName" title="课程表名称" href="${pageContext.request.contextPath }/classinfo/syllabusinfo/show.action" paramId="syllabusId" paramProperty="syllabusId"></display:column>
    	<display:column property="syllabusYi" title="星期一"></display:column>
    	<display:column property="syllabusEr" title="星期二"></display:column>
    	<display:column property="syllabusSan" title="星期三"></display:column>
    	<display:column property="syllabusSi" title="星期四"></display:column>
    	<display:column property="syllabusWu" title="星期五"></display:column>
    	<display:column property="syllabusLiu" title="星期六"></display:column>
    	<display:column property="syllabusQi" title="星期天"></display:column>
    	<display:column href="${pageContext.request.contextPath }/classinfo/syllabusinfo/load.action" paramId="syllabusId" paramProperty="syllabusId" value="修改" title="修改"></display:column>
    	<display:column href="${pageContext.request.contextPath }/classinfo/syllabusinfo/delete.action" paramId="syllabusId" paramProperty="syllabusId" value="删除" title="删除"></display:column>
    </display:table>	
    
</div>
</form>
</body>
</html>
