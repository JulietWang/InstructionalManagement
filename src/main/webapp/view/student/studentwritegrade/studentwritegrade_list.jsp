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
    	<li><a href="#">学员管理</a></li>
        <li>学生成绩</li>
    </ul>
</div>
<form class="form-inline" action="${pageContext.request.contextPath}/student/studentwritegrade/list.action" method="post">
<div class="row alert alert-info"  style="margin:0px; padding:3px;text-align: center;" >

     <div class="form-group">
        <input type="text" name="studentName" class="form-control"  placeholder="请输入学员姓名">
      </div>

    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <a  class="btn btn-success"  href="${pageContext.request.contextPath}/view/student/studentwritegrade/studentwritegrade_add.jsp">添加学员成绩</a>
    
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
	<table class="table  table-condensed table-striped">          
    </table>
     <display:table class="table table-condensed table-striped" name="list" pagesize="10" requestURI="${pageContext.request.contextPath }/student/studentwritegrade/list.action">
    	<display:column property="studentWriteGrade.writeGradeId" title="成绩编号"></display:column>
    	<display:column property="studentName" title="学员姓名" ></display:column>
    	<display:column property="staffName" title="监考人和阅卷人"></display:column>
    	<display:column property="studentWriteGrade.writeGradeSubject" title="科目"></display:column>
    	<display:column property="studentWriteGrade.writeGrade" title="成绩"></display:column>
    	<display:column property="studentWriteGrade.writeGradeTime" title="考试时间" format="{0,date,yyyy年MM月dd日}"></display:column>
    	<display:column property="studentWriteGrade.writeGradeNote" title="备注"></display:column>
    	<display:column href="${pageContext.request.contextPath }/student/studentwritegrade/load.action" paramId="writeGradeId" paramProperty="studentWriteGrade.writeGradeId" value="修改" title="修改"></display:column>
    	<display:column href="${pageContext.request.contextPath }/student/studentwritegrade/delete.action" paramId="writeGradeId" paramProperty="studentWriteGrade.writeGradeId" value="删除" title="删除"></display:column>
    	
    </display:table>
</div>
</form>
</body>
</html>
