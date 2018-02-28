<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学员缴费</title>

<%@ include file="/view/public/common.jspf"%>

</head>

<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">财务管理</a></li>
			<li>学员缴费</li>
			<li>缴费单修正</li>
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
		action="${pageContext.request.contextPath}/finance/tuition/update.action"
		class="form-horizontal">
		<h5 class="page-header alert-info"
			style="padding: 10px; margin: 0px; margin-bottom: 5px;">基本信息</h5>
		<div class="row">
			<input type="hidden" value="${studentPayment.paymentId}"
				name="paymentId" readonly="readonly" class="form-control input-sm" />
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">学员编号</label>
					<div class="col-sm-5">
						<input type="text" name="studentId"
							value="${studentPayment.studentId}" class="form-control input-sm" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">员工编号</label>
					<div class="col-sm-5">
						<input type="text" name="staffId"
							value="${studentPayment.staffId}" class="form-control input-sm"
							placeholder="请输入员工编号" />
					</div>
				</div>
			</div>
		</div>
		<!-- 开始2 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">缴费方式</label>
					<div class="col-sm-9">
						<select class="form-control input-sm" name="paymentMenthod" >
                        	<option value="-1">请选择缴费方式</option>
                        	<c:forEach items="${dataList}" var="data">
                			<option value="${data.dataContent}"  ${data.dataContent==studentPayment.paymentMenthod?'selected':'' }>${data.dataContent}</option>
                		</c:forEach>
                        </select>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">应缴金额</label>
					<div class="col-sm-6">
						<input type="text" name="paymentShouldAmount"
							value="${studentPayment.paymentShouldAmount}"
							class="form-control input-sm" placeholder="请输入应缴金额" />
					</div>
				</div>
			</div>
		</div>
		<!-- 结束2 -->
		<!-- 开始3 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">实缴金额</label>
					<div class="col-sm-6">
						<input type="text" name="paymentRealAmount"
							value="${studentPayment.paymentRealAmount}"
							class="form-control input-sm" placeholder="请输入实缴金额" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">优惠金额</label>
					<div class="col-sm-6">
						<input type="text" name="paymentDiscountAmount"
							value="${studentPayment.paymentDiscountAmount}"
							class="form-control input-sm" placeholder="请输入优惠金额" />
					</div>
				</div>
			</div>
		</div>
		<!-- 结束3 -->
		<!-- 开始4 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">欠款</label>
					<div class="col-sm-6">
						<input type="text" name="paymentDebtAmount"
							value="${studentPayment.paymentDebtAmount}"
							class="form-control input-sm" placeholder="请输入欠款" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">缴费时间</label>
					<div class="col-sm-9">
						<input type="text" name="paymentTime"
							value="<fmt:formatDate value="${studentPayment.paymentTime}" pattern="yyyy-MM-dd"/>"
							onclick="WdatePicker()" readonly="readonly" pattern="yyyy-MM-dd"
							class="form-control input-sm" placeholder="请输入缴费时间" />
					</div>
				</div>
			</div>
		</div>
		<!-- 结束4 -->
		<!-- 开始4 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">缴费情况</label>
					<div class="col-sm-9">
						<textarea class="form-control" name="paymentSitutation">${studentPayment.paymentSitutation}</textarea>
					</div>
				</div>
			</div>
		</div>

		<!-- 结束6 -->
		<h5 class="page-header alert-info"
			style="padding: 10px; margin: 0px; margin-bottom: 5px;">备注信息</h5>
		<div class="row">
			<div class="col-sm-10">
				<div class="form-group">
					<label class="col-sm-3 control-label">备注</label>
					<div class="col-sm-9">
						<textarea class="form-control" name="paymentRemark">${studentPayment.paymentRemark}</textarea>
					</div>
				</div>

   
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>
            <a class="btn  btn-danger" href="${pageContext.request.contextPath }/finance/tuition/list.action">取消</a>
        </div>
    </div>
</form>
		
</body>
</html>
