<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
			<li>查看学生信息</li>
		</ul>
	</div>

	<form action="" class="form-horizontal">
		<h5 class="page-header alert-info"
			style="padding: 10px; margin: 0px; margin-bottom: 5px;">基本信息</h5>
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">学生编号</label>
					<div class="col-sm-9">
						<p class="form-control-static">${studentInfo.studentId }</p>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">学生姓名</label>
					<div class="col-sm-9">
						<p class="form-control-static">${studentInfo.studentName }</p>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">性别</label>
					<div class="col-sm-4">
						<p class="form-control-static">${studentInfo.studentSex }</p>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">年龄</label>
					<div class="col-sm-5">
						<p class="form-control-static">${studentInfo.studentAge }</p>
					</div>
				</div>
			</div>
		</div>
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">手机号码</label>
					<div class="col-sm-9">
						<p class="form-control-static">${studentInfo.studentTellphone }</p>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">电子邮件</label>
					<div class="col-sm-9">
						<p class="form-control-static">${studentInfo.studentEmail }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束 -->
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">身份证</label>
					<div class="col-sm-9">
						<p class="form-control-static">${studentInfo.studentIdcard }</p>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">家庭地址</label>
					<div class="col-sm-9">
						<p class="form-control-static">${studentInfo.studentAddress }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束 -->
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">出生日期</label>
					<div class="col-sm-9">
						<fmt:formatDate value="${studentInfo.studentBirthday }"
							pattern="yyyy年MM月dd日" type="both" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">所在院校</label>
					<div class="col-sm-9">
						<p class="form-control-static">${studentInfo.studentSchool }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束 -->
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">QQ号码</label>
					<div class="col-sm-9">
						<p class="form-control-static">${studentInfo.studentQq }</p>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">家长姓名</label>
					<div class="col-sm-9">
						<p class="form-control-static">${studentInfo.studentParentsName }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束 -->
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">省份</label>
					<div class="col-sm-9">
						<p class="form-control-static">${studentInfo.studentPro }</p>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">家长电话</label>
					<div class="col-sm-9">
						<p class="form-control-static">${studentInfo.studentParentsPhone }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束 -->
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">城市</label>
					<div class="col-sm-9">
						<p class="form-control-static">${studentInfo.studentProCity }</p>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">意向状态</label>
					<div class="col-sm-6">
						<p class="form-control-static">${studentInfo.studentState }</p>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">学生类型</label>
					<div class="col-sm-6">
						<p class="form-control-static">${studentInfo.studentType }</p>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">是否付款</label>
					<div class="col-sm-9">
						<p class="form-control-static">${studentInfo.studentIspay }</p>
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
						<p class="form-control-static">${studentInfo.studentDesc }</p>
					</div>
				</div>
			</div>
		</div>
		<h5 class="page-header alert-info"
			style="padding: 10px; margin: 0px; margin-bottom: 5px;">账号信息</h5>
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">账号</label>
					<div class="col-sm-9">
						<p class="form-control-static">${studentInfo.studentNumber}</p>
					</div>
				</div>

			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">密码</label>
					<div class="col-sm-9">
						<p class="form-control-static">${studentInfo.studentPassword}</p>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<a
					href="${pageContext.request.contextPath }/recruitstudent/studentpool/loadUpdate.action?studentId=${studentInfo.studentId}"
					class="btn btn-success">修改</a> <a
					href="${pageContext.request.contextPath }/recruitstudent/studentpool/delete.action?studentId=${studentInfo.studentId}"
					class="btn btn-success">删除</a> <a
					href="${pageContext.request.contextPath }/recruitstudent/studentpool/list.action"
					class="btn btn-waring">返回上一级</a>
			</div>
		</div>
	</form>

</body>
</html>
