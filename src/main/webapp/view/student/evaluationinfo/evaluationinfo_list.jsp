<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib  uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>

<%@ include file="/view/public/common.jspf" %>


</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">学员管理</a></li>
        <li>学员评价</li>
    </ul>
</div>
<form action="${pageContext.request.contextPath}/student/evaluationinfo/list.action" metod="post" class="form-inline">
<div class="row alert alert-info"  style="margin:0px; padding:3px;text-align: center;" >

     <div class="form-group">
        <input type="text" name="evaluationTile" class="form-control" id="activename" placeholder="请输入主题">
      </div>

    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <a  class="btn btn-success"  href="${pageContext.request.contextPath}/view/student/evaluationinfo/evaluationinfo_add.jsp">添加评价</a>
    
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
	<table class="table  table-condensed table-striped">                   
    </table>
    
     <display:table class="table table-condensed table-striped" name="aaa" pagesize="10" requestURI="${pageContext.request.contextPath}/student/evaluationinfo/list.action">
    	<display:column property="evaluationInfo.evaluationId" title="编号"></display:column>
    	<display:column property="studentInfo.studentName" title="学员姓名" ></display:column>
    	<display:column property="evaluationInfo.evaluationTile" title="主题"></display:column>
    	

    	<display:column property="evaluationInfo.evaluationContent" title="评价内容"></display:column>
    	<display:column property="evaluationInfo.evaluationCourse" title="课程名称"></display:column>
    	<display:column property="evaluationInfo.evaluationTeacher" title="教师"></display:column>
    	<display:column property="evaluationInfo.evaluationTime" title="评价时间" format="{0,date,yyyy年MM月dd日}"></display:column>
    	<display:column href="${pageContext.request.contextPath}/student/evaluationinfo/load.action"  paramId="evaluationId" paramProperty="evaluationInfo.evaluationId" value="修改" title="修改"></display:column>
    	<display:column href="${pageContext.request.contextPath}/student/evaluationinfo/delete.action" paramId="evaluationId" paramProperty="evaluationInfo.evaluationId" value="删除" title="删除"></display:column>
    	
    </display:table>
</div>
</form>
</body>
</html>
