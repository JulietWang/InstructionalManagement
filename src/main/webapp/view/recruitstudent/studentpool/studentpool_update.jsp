<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<%@ include file="/view/public/common.jspf"%>
</head>

<script type="text/javascript">
	function jsGetAge() {
		document.getElementById("studentAge").value = null;
		var returnAge;
		var strBirthday = document.getElementById("studentBirthday").value;
		var strBirthdayArr = strBirthday.split("-");
		var birthYear = strBirthdayArr[0];
		d = new Date();
		var nowYear = d.getYear();
		if (nowYear == birthYear) {
			returnAge = 0;//同年 则为0岁  
		} else {
			returnAge = nowYear - birthYear + 1900; //年之差 ;
		}
		if (returnAge < birthYear) {
			document.getElementById("studentAge").value = returnAge;
		}

	}
</script>


<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">招生管理</a></li>
			<li>学员池</li>
			<li>修改学员信息</li>
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
		action="${pageContext.request.contextPath}/recruitstudent/studentpool/update.action"
		class="form-horizontal">
		<h5 class="page-header alert-info"
			style="padding: 10px; margin: 0px; margin-bottom: 5px;">基本信息</h5>
		<div class="row">
			<input type="hidden" name="studentId"
				value="${studentInfo.studentId }" class="form-control input-sm" />
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">负责人编号(名字)</label>
					<div class="col-sm-9">
						<select name="staffId" class="form-control input-sm">
							<option></option>
							<c:forEach items="${stafflist }" var="staff">
								<option value="${staff.staffId}"
									${staff.staffId==studentInfo.staffId?'selected':'' }>${staff.staffName }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">学生姓名</label>
					<div class="col-sm-9">
						<input type="text" name="studentName"
							value="${studentInfo.studentName }" class="form-control input-sm" />
					</div>
				</div>
			</div>
		</div>
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">性别</label>
					<div class="col-sm-4">
						<select name="studentSex" class="form-control input-sm">
							<option></option>
							<option ${studentInfo.studentSex=='男'?'selected':''}>男</option>
							<option ${studentInfo.studentSex=='女'?'selected':''}>女</option>
						</select>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">年龄</label>
					<div class="col-sm-5">
						<input type="text" name="studentAge" readonly="readonly"
							value="${studentInfo.studentAge }" id="studentAge"
							class="form-control input-sm" />
					</div>
				</div>
			</div>
		</div>
		<!--结束 -->
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">手机号码</label>
					<div class="col-sm-9">
						<input type="text" name="studentTellphone"
							value="${studentInfo.studentTellphone }"
							class="form-control input-sm" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">电子邮件</label>
					<div class="col-sm-9">
						<input type="text" name="studentEmail"
							value="${studentInfo.studentEmail }"
							class="form-control input-sm" />
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
						<input type="text" name="studentIdcard"
							value="${studentInfo.studentIdcard }"
							class="form-control input-sm" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">家庭地址</label>
					<div class="col-sm-9">
						<input type="text" name="studentAddress"
							value="${studentInfo.studentAddress }"
							class="form-control input-sm" />
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
						<input type="text" name="studentBirthday" id="studentBirthday"
							value="<fmt:formatDate value="${studentInfo.studentBirthday }" type="both" pattern="yyyy-MM-dd"/>"
							onclick="WdatePicker()" onfocus="jsGetAge()" readonly="readonly"
							class="form-control input-sm" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">所在院校</label>
					<div class="col-sm-9">
						<input type="text" name="studentSchool"
							value="${studentInfo.studentSchool }"
							class="form-control input-sm" />
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
						<input type="text" name="studentQq"
							value="${studentInfo.studentQq }" class="form-control input-sm" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">家长姓名</label>
					<div class="col-sm-9">
						<input type="text" name="studentParentsName"
							value="${studentInfo.studentParentsName }"
							class="form-control input-sm" />
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
						<input type="text" name="studentPro"
							value="${studentInfo.studentPro }" class="form-control input-sm" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">家长电话</label>
					<div class="col-sm-9">
						<input type="text" name="studentParentsPhone"
							value="${studentInfo.studentParentsPhone }"
							class="form-control input-sm" />
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
						<input type="text" name="studentProCity"
							name="studentParentsPhone" value="${studentInfo.studentProCity }"
							class="form-control input-sm" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">意向状态</label>
					<div class="col-sm-6">
						<select name="studentState" class="form-control input-sm">
							<option ${studentInfo.studentState=='无意向'?'selected':''}>无意向</option>
							<option ${studentInfo.studentState=='意向低'?'selected':''}>意向低</option>
							<option ${studentInfo.studentState=='意向中'?'selected':''}>意向中</option>
							<option ${studentInfo.studentState=='意向高'?'selected':''}>意向高</option>
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
					<label class="col-sm-3 control-label">学生类型</label>
					<div class="col-sm-6">
						<select name="studentType" class="form-control input-sm">
							<option ${studentInfo.studentType=='全额自费'?'selected':''}>全额自费</option>
							<option ${studentInfo.studentType=='部分自费'?'selected':''}>部分自费</option>
							<option ${studentInfo.studentType=='全额免费'?'selected':''}>全额免费</option>
						</select>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">是否付款</label>
					<div class="col-sm-9">
						<input type="text" name="studentIspay"
							value="${studentInfo.studentIspay }"
							class="form-control input-sm" />
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
						<textarea class="form-control" name="studentDesc">${studentInfo.studentDesc }</textarea>
					</div>
				</div>
			</div>
		</div>

		<h5 class="page-header alert-info"
			style="padding: 10px; margin: 0px; margin-bottom: 5px;">账号信息</h5>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-sm-3 control-label">账号</label>
				<div class="col-sm-9">
					<input type="text" name="studentNumber"
						value="${studentInfo.studentNumber}" class="form-control input-sm" />
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-sm-3 control-label">密码</label>
				<div class="col-sm-9">
					<input type="password" name="studentPassword"
						value="${studentInfo.studentPassword}"
						class="form-control input-sm" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="修改" /> <a
					class="btn btn-warning"
					href="${pageContext.request.contextPath }/recruitstudent/studentpool/list.action">返回上一级</a>
			</div>
		</div>
	</form>

</body>
</html>
