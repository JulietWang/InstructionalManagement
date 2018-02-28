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
        <li>查询学员</li>
    </ul>
</div>
<form action="${pageContext.request.contextPath}/student/student/list.action" method="post" class="form-inline">
<div class="row alert alert-info"  style="margin:0px; padding:3px;text-align: center;" >

     <div class="form-group">
        <input type="text" name="studentName" class="form-control" id="activename" placeholder="请输入学员姓名">
      </div>

    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <a  class="btn btn-success"  href="${pageContext.request.contextPath }/view/student/student/student_add.jsp">添加学员</a>
    
</div>

<div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			
		</button>
		<p align="center" style="color: red;">学员信息-${info}</p>
	</div>	
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
	<table class="table  table-condensed table-striped">  	                   
    </table>
     <display:table class="table table-condensed table-striped" name="list" pagesize="10" requestURI="${pageContext.request.contextPath }/student/student/list.action">
    	<display:column property="studentInfo.studentId" title="学员编号"></display:column>
    	<display:column property="studentInfo.studentName" title="学员姓名" href="${pageContext.request.contextPath }/student/student/show.action" paramId="studentId" paramProperty="studentInfo.studentId"></display:column>
    	<display:column property="staffName" title="负责人"></display:column>
    	<display:column property="className" title="班级"></display:column>
    	<display:column property="studentInfo.studentAge" title="学员年龄"></display:column>
    	<display:column property="studentInfo.studentTellphone" title="学员电话"></display:column>
    	<display:column property="studentInfo.studentEmail" title="学员邮箱"></display:column>
    	<display:column property="studentInfo.studentBirthday" title="出生日期" format="{0,date,yyyy年MM月dd日}"></display:column>
    	<display:column property="studentInfo.studentPro" title="省份"></display:column>
    	<display:column href="${pageContext.request.contextPath }/student/student/load.action" paramId="studentId" paramProperty="studentInfo.studentId" value="修改" title="修改"></display:column>
    	<display:column href="${pageContext.request.contextPath }/student/student/delete.action" paramId="studentId" paramProperty="studentInfo.studentId" value="删除" title="删除"></display:column>
    	
    </display:table>
</div>
</form>
</body>
</html>
