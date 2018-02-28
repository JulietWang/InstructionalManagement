<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<li><a href="#">教务管理</a></li>
			<li>班级管理</li>
			<li>修改班级</li>
		</ul>
	</div>
	<!-- 显示错误信息 -->
	<div align="center">
		<div class="alert alert-warning"
			style="margin: 0px; padding: 5px; width: 100%;display:${empty allErrors?'none':'block'} ">
			<c:forEach items="${allErrors}" var="error">
			 	${error.defaultMessage }<br />
			</c:forEach>
		</div>
	</div>
	<form
		action="${pageContext.request.contextPath }/transaction/class_transaction/update.action"
		class="form-horizontal">

		<h5 class="page-header alert-info"
			style="padding: 10px; margin: 0px; margin-bottom: 5px;">基本信息</h5>
		<div class="row">

			<input type="hidden" value="${classroomInfo.classroomId }"
				name="classroomId" readonly="readonly" class="form-control input-sm" />

			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">班级名称</label>
					<div class="col-sm-9">
						<input type="text" name="classroomName"
							value="${classroomInfo.classroomName }"
							class="form-control input-sm" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">容纳人数</label>
					<div class="col-sm-9">
						<input type="text" name=classroomMax
							value="${classroomInfo.classroomMax }"
							class="form-control input-sm" />
					</div>
				</div>

			</div>

		</div>



		<!-- 开始4 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">设备信息</label>
					<div class="col-sm-9">
						<input type="text" name="classroomInfo"
							value="${classroomInfo.classroomInfo}"
							class="form-control input-sm" />
					</div>
				</div>
			</div>
		</div>
		<!-- 结束4 -->



		<h5 class="page-header alert-info"
			style="padding: 10px; margin: 0px; margin-bottom: 5px;">备注信息</h5>
		<div class="row">
			<div class="col-sm-10">
				<div class="form-group">
					<label class="col-sm-3 control-label">备注</label>
					<div class="col-sm-9">
						<textarea class="form-control" name="classroomRemark"> ${classroomInfo.classroomRemark} </textarea>
					</div>
				</div>

			</div>

		</div>

		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="保存" /> <a
					href="${pageContext.request.contextPath }/transaction/class_transaction/list.action"
					class="btn btn-success">返回上一级</a>
			</div>
		</div>
	</form>

</body>
</html>
