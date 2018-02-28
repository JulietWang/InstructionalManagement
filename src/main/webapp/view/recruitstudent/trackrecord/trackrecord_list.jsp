<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<li>跟踪记录</li>
		</ul>
	</div>
	<form class="form-inline" action="${pageContext.request.contextPath }/recruitstudent/trackrecord/list.action" method="post">
		<div class="row alert alert-info" style="margin: 0px; padding: 3px;text-align: center;">
			<div class="form-group">
				<input type="text" class="form-control" name="studentName" id="activename" placeholder="请输入学员姓名">
			</div>
			<input type="submit" class="btn btn-danger" value="查询" /> <a
				class="btn btn-success" href="${pageContext.request.contextPath}/recruitstudent/trackrecord/loadAdd.action">添加记录</a>
		</div>
	</form>
	
	<!-- 提示信息区域 -->
	<div align="center">
		<div class="alert alert-warning"
			style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span>
			</button>
			<p align="center" style="color: red;">追踪记录信息-${info}</p>
		</div>
	</div>

	<div class="row" style="padding: 15px; padding-top: 0px;">
		<display:table class="table  table-condensed table-striped"
			name="list" pagesize="10"
			requestURI="${pageContext.request.contextPath}/recruitstudent/trackrecord/list.action">
			<display:column property="trackRecordInfo.trackRecordId" title="编号"></display:column>
			<display:column property="studentName"  href="${pageContext.request.contextPath}/recruitstudent/studentpool/show.action" 
			paramId="studentId" paramProperty="trackRecordInfo.studentId" title="学员姓名"></display:column>
			<display:column property="trackRecordInfo.trackRecordTitle" title="主题"></display:column>
			<display:column property="trackRecordInfo.trackRecordContent" title="具体内容"></display:column>
			<display:column property="trackRecordInfo.trackRecordTime" title="联系时间" format="{0,date,yyy年MM月dd日}"></display:column>
			<display:column property="trackRecordInfo.enrollment" title="意向状态"></display:column>
			<display:column property="trackRecordInfo.nextRecordTime" title="下次联系时间" format="{0,date,yyy年MM月dd日}"></display:column>
			<display:column
				href="${pageContext.request.contextPath }/recruitstudent/trackrecord/loadUpdate.action"
				paramId="trackRecordId" paramProperty="trackRecordInfo.trackRecordId" value="修改"
				title="修改"></display:column>
			<display:column
				href="${pageContext.request.contextPath }/recruitstudent/trackrecord/delete.action"
				paramId="trackRecordId" paramProperty="trackRecordInfo.trackRecordId" value="删除"
				title="删除"></display:column>
		</display:table>
	
	</div>

</body>
</html>
