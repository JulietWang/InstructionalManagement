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
			<li>学员池</li>
		</ul>
	</div>
	<form
		action="${pageContext.request.contextPath}/recruitstudent/studentpool/list.action"
		method="post" class="form-inline">
		<div class="row alert alert-info"
			style="margin: 0px; padding: 3px; text-align: center;">

			<div class="form-group">
				<input type="text" class="form-control" name="studentName" id="activename" placeholder="请输入学员姓名">
			</div>
			<input type="submit" class="btn btn-danger" value="查询" /> 
			<a class="btn btn-success" href="${pageContext.request.contextPath}/recruitstudent/studentpool/loadAdd.action">添加学员</a>
		</div>
	</form>

	<!-- 提示信息区域 -->
	<div align="center">
		<div class="alert alert-warning"
			style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span>
			</button>
			<p align="center" style="color: red;">学生信息-${info}</p>
		</div>
	</div>

	<div class="row" style="padding: 15px; padding-top: 0px;">
		<display:table class="table  table-condensed table-striped"
			name="list" pagesize="10"
			requestURI="${pageContext.request.contextPath}/recruitstudent/studentpool/list.action">
			<display:column property="studentInfo.studentId" title="编号"></display:column>
			<display:column property="staffName" title="负责人"></display:column>
			<display:column property="studentInfo.studentName" href="${pageContext.request.contextPath}/recruitstudent/studentpool/show.action" 
			paramId="studentId" paramProperty="studentInfo.studentId" title="学生姓名"></display:column>
			<display:column property="studentInfo.studentTellphone" title="手机"></display:column>
			<display:column property="studentInfo.studentEmail" title="邮箱"></display:column>
			<display:column property="studentInfo.studentSchool" title="学校"></display:column>
			<display:column property="studentInfo.studentQq" title="qq"></display:column>
			<display:column property="studentInfo.studentParentsPhone" title="父母手机"></display:column>
			<display:column property="studentInfo.studentIspay" title="是否缴费"></display:column>
			<display:column property="studentInfo.studentState" title="意向"></display:column>
			<display:column property="studentInfo.studentDesc" title="描述"></display:column>
			<display:column
				href="${pageContext.request.contextPath }/recruitstudent/studentpool/loadUpdate.action"
				paramId="studentId" paramProperty="studentInfo.studentId" value="修改"
				title="修改"></display:column>
			<display:column
				href="${pageContext.request.contextPath }/recruitstudent/studentpool/updateMark.action"
				paramId="studentId" paramProperty="studentInfo.studentId"
				value="领取" title="领取学生"></display:column>
			<display:column
				href="${pageContext.request.contextPath }/recruitstudent/studentpool/delete.action"
				paramId="studentId" paramProperty="studentInfo.studentId" value="删除"
				title="删除"></display:column>
		</display:table>
	</div>
</body>
</html>
