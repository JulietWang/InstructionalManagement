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
			<li><a
				href="${pageContext.request.contextPath }/classinfo/classroominfo/list.action">班级管理</a></li>
			<li>教室名称</li>
			<li>修改教室</li>
		</ul>
	</div>

	<form
		action="${pageContext.request.contextPath}/classinfo/classroominfo/update.action"
		method="post" class="form-horizontal">

		<h5 class="page-header alert-info"
			style="padding: 10px; margin: 0px; margin-bottom: 5px;">基本信息</h5>
		<div class="row">
			
		<input type="hidden" value="${classroomInfo.classroomId}"
							name="classroomId" class="form-control input-sm"/>
				
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">教室名称</label>
					<div class="col-sm-9">
						<input type="text" value="${classroomInfo.classroomName}"
							name="classroomName" class="form-control input-sm"
							placeholder="请输入教室名称" />
					</div>
				</div>
			</div>

			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">容纳人数</label>
					<div class="col-sm-9">
						<input type="text" value="${classroomInfo.classroomMax}"
							name="classroomMax" class="form-control input-sm"
							placeholder="请输入容纳人数" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">设备信息</label>
					<div class="col-sm-9">
						<input type="text" value="${classroomInfo.classroomInfo}"
							name="classroomInfo" class="form-control input-sm"
							placeholder="请输入设备信息" />
					</div>
				</div>

			</div>

		</div>

		<h5 class="page-header alert-info"
			style="padding: 10px; margin: 0px; margin-bottom: 5px;">备注</h5>
		<div class="row">
			<div class="col-sm-10">
				<div class="form-group">
					<label class="col-sm-3 control-label">备注</label>
					<div class="col-sm-9">
						<textarea class="form-control" name="classroomRemark">${classroomInfo.classroomRemark}</textarea>
					</div>
				</div>

			</div>

		</div>

		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="保存" /> <a
					class="btn btn-warning"
					href="${pageContext.request.contextPath }/classinfo/classroominfo/list.action">返回上一级</a>
			</div>
		</div>
	</form>

</body>
</html>
