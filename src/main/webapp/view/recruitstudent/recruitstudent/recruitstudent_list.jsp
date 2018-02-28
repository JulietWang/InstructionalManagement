<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<%@ include file="/view/public/common.jspf"%>
</head>

<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">招生管理</a></li>
			<li>招生线索</li>
		</ul>
	</div>
	<form class="form-inline"
		action="${pageContext.request.contextPath}/recruitstudent/studentpool/list_recruitstudent.action"
		method="post">
		<div class="row alert alert-info"
			style="margin: 0px; padding: 3px; text-align: center;">
			<div class="form-group">
				<input type="text" class="form-control" name="studentName"
					id="activename" placeholder="请输入学员姓名">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="activeName"
					id="activename" placeholder="请输入活动名称">
			</div>
			<input type="submit" class="btn btn-danger" value="查询" />
		</div>
	</form>
	<div class="row" style="padding: 15px; padding-top: 0px;">
		<display:table class="table  table-condensed table-striped"
			name="list" pagesize="10"
			requestURI="${pageContext.request.contextPath}/recruitstudent/studentpool/list_recruitstudent.action">
			<display:column property="studentInfo.studentId" title="编号"></display:column>
			<display:column property="staffName" title="负责人"></display:column>
			<display:column property="studentInfo.studentName"
				href="${pageContext.request.contextPath}/recruitstudent/studentpool/show.action"
				paramId="studentId" paramProperty="studentInfo.studentId" title="学生姓名"></display:column>
			<display:column property="studentInfo.studentTellphone" title="学生手机"></display:column>
			<display:column property="studentInfo.studentSchool" title="学校"></display:column>
			<display:column property="studentInfo.studentQq" title="qq"></display:column>
			<display:column property="studentInfo.studentState" title="意向"></display:column>
			<display:column property="studentInfo.studentDesc" title="描述"></display:column>
			<display:column property="activeName" title="活动名称"></display:column>
		</display:table>
	</div>
</body>
</html>
