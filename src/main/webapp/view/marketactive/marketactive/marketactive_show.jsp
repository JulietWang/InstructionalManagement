<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<%@ include file="/view/public/common.jspf"%>
</head>

<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">营销管理</a></li>
			<li>营销活动</li>
			<li>修改活动</li>
		</ul>
	</div>

	<!-- 显示错误信息 -->
	<div align="center">
		<div class="alert alert-warning"
			style="margin: 0px; padding: 5px; width: 100%;display:${empty allErrors?'none':'block'} ">
			<c:forEach items="${allErrors}" var="error">
		 	${error.defaultMessage }<br />
			</c:forEach>
			<div>${error}</div>
		</div>
	</div>

	<form class="form-horizontal">
		<h5 class="page-header alert-info"
			style="padding: 10px; margin: 0px; margin-bottom: 5px;">基本信息</h5>
		<div class="row">
			<input type="hidden" name="activeId" value="${active.activeId}"
				class="form-control input-sm" />
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">活动名称</label>
					<div class="col-sm-9">
						<input type="text" name="activeName" value="${active.activeName}"
							class="form-control input-sm" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">姓名</label>
					<div class="col-sm-9">
						<input type="text" name="staffName" value="${active.staffName}"
							class="form-control input-sm" />
					</div>
				</div>
			</div>
		</div>
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">开始时间</label>
					<div class="col-sm-9">
						<input type="text" name="activeStart"
							value="<fmt:formatDate value="${active.activeStart}" pattern="yyyy-MM-dd" type="both"/>"
							onclick="WdatePicker()" readonly="readonly"
							class="form-control input-sm" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">活动状态</label>
					<div class="col-sm-5">
						<select name="activeState" class="form-control input-sm">
							<option value="0" ${active.activeState=='0'?'selected':''}>准备中</option>
							<option value="1" ${active.activeState=='1'?'selected':''}>开始</option>
							<option value="2" ${active.activeState=='2'?'selected':''}>进行中</option>
							<option value="3" ${active.activeState=='3'?'selected':''}>已结束</option>
						</select>
					</div>
				</div>
			</div>
		</div>
		<!--结束 -->
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">结束时间</label>
					<div class="col-sm-9">
						<input type="text" name="activeEnd"
							value="<fmt:formatDate value="${active.activeEnd }" pattern="yyyy-MM-dd" type="both"/>"
							onclick="WdatePicker()" readonly="readonly"
							class="form-control input-sm" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">活动类型</label>
					<div class="col-sm-5">
						<select name="activeType" class="form-control input-sm">
							<option value="0" ${active.activeType=='0'?'selected':''}>现场交流
							</option>
							<option value="1" ${active.activeType=='1'?'selected':''}>会议</option>
							<option value="2" ${active.activeType=='2'?'selected':''}>其他</option>

						</select>
					</div>
				</div>
			</div>
		</div>
		<!--结束 -->
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">成本预算</label>
					<div class="col-sm-6">
						<input type="text" name="activeCosteEstimate"
							value="${active.activeCosteEstimate}"
							class="form-control input-sm" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">实际成本</label>
					<div class="col-sm-6">
						<input type="text" name="activeCoste"
							value="${active.activeCoste}" class="form-control input-sm" />
					</div>
				</div>
			</div>
		</div>
		<!--结束 -->
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">预期反应</label>
					<div class="col-sm-6">
						<select class="form-control input-sm" name="activeRefectEstimate"
							placeholder="请输入预期反应">
							<option value="0"
								${active.activeRefectEstimate=='0'?'selected':''}>好</option>
							<option value="1"
								${active.activeRefectEstimate=='1'?'selected':''}>非常好</option>
							<option value="2"
								${active.activeRefectEstimate=='2'?'selected':''}>非常非常的好</option>
						</select>
					</div>

				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">预期学员</label>
					<div class="col-sm-6">
						<input type="text" name="activeStudent"
							value="${active.activeStudent}" class="form-control input-sm" />
					</div>
				</div>
			</div>
		</div>
		<!--结束 -->
		<h5 class="page-header alert-info"
			style="padding: 10px; margin: 0px; margin-bottom: 5px;">描述信息</h5>
		<div class="row">
			<div class="col-sm-10">
				<div class="form-group">
					<label class="col-sm-3 control-label">描述信息</label>
					<div class="col-sm-9">
						<textarea name="activeContent" class="form-control">${active.activeContent}</textarea>
					</div>
				</div>
			</div>

		</div>

		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<a class="btn btn-warning"
					href="${pageContext.request.contextPath}/marketactive/marketactive/list.action">返回上一级</a>
			</div>
		</div>
	</form>

</body>
</html>
