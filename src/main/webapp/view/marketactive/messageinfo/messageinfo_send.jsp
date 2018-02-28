<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<%@ include file="/view/public/common.jspf"%>
</head>
	<script type="text/javascript">
	function choose() {
		var index=document.getElementById("s1").options.selectedIndex-1;
		var content=document.getElementById("s2").options[index].value;
		document.getElementById("s3").value=" ";
		document.getElementById("s3").value=content;
	}
	</script>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">营销管理</a></li>
			<li>短信管理</li>
			<li>发送信息</li>
		</ul>
	</div>

	<!-- 显示错误信息 -->
	<div align="center">
		<div class="alert alert-warning"
			style="margin: 0px; padding: 5px; width: 100%;display:${empty allErrors?'none':'block'} ">
			<c:forEach items="${allErrors}" var="e">
	 			${e.defaultMessage }<br />
			</c:forEach>
		</div>
		<div class="alert alert-warning"
			style="margin: 0px; padding: 5px; width: 100%; display:${empty error?'none':'block'}">
		${error}
		</div>
	</div>

	<form
		action="${pageContext.request.contextPath }/marketactive/messageinfo/add.action"
		class="form-horizontal">

		<h5 class="page-header alert-info"
			style="padding: 10px; margin: 0px; margin-bottom: 5px;">基本信息</h5>
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">模板</label>
					<div class="col-sm-9">
						<select name="" class="form-control input-sm" onchange="choose()" id="s1">
							<option>-请选择模板-</option>
							<c:forEach items="${list}" var="list">
								<option value="${list.templateId}">${list.templateTitle}</option>
							</c:forEach>
						</select>
						
						<select name="" class="form-control input-sm" style="display: none;" id="s2">
							<c:forEach items="${list}" var="list">
								<option value="${list.templateContent}"></option>
							</c:forEach>
						</select>
					</div>
				</div>

			</div>
		</div>

		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">发送人</label>
					<div class="col-sm-9">
						<input type="text" name="staffName" value="${msg.staffName}" class="form-control input-sm" />
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">接收人</label>
					<div class="col-sm-9">
						<input type="text" name="messageMan" value="${msg.messageMan}" class="form-control input-sm" />
					</div>
				</div>
			</div>

		</div>

		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">电话号码</label>
					<div class="col-sm-9">
						<input type="text" name="messagePhone" value="${msg.messagePhone}"
							class="form-control input-sm" />
					</div>
				</div>

			</div>


		</div>
		<h5 class="page-header alert-info"
			style="padding: 10px; margin: 0px; margin-bottom: 5px;">短信内容信息</h5>
		<div class="row">
			<div class="col-sm-10">
				<div class="form-group">
					<label class="col-sm-3 control-label">短信内容</label>
					<div class="col-sm-9">
						<textarea class="form-control" id="s3" name="messageContent">${msg.messageContent}</textarea>
					</div>
				</div>

			</div>

		</div>

		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="发送" /> <a
					class="btn btn-warning"
					href="${pageContext.request.contextPath }/marketactive/messageinfo/list.action">返回上一级</a>
			</div>
		</div>
	</form>

</body>
</html>
