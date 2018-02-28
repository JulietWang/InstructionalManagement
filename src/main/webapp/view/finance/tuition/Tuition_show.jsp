<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib  uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>

<%@ include file="/view/public/common.jspf" %>

</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">财务管理</a></li>
        <li>学员缴费</li>
        <li>缴费单详情</li>
    </ul>
</div>

<form action="" class="form-horizontal">
   	
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">缴费单编号</label>
                <div class="col-sm-9">
                	<p class="form-control-static">${studentPayment.paymentId}</p>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">学员编号</label>
                <div class="col-sm-9">
                	<p class="form-control-static">${studentPayment.studentId}</p>
                </div>
            </div>
        </div>

    </div>
    <!-- 开始2 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">员工编号</label>
                <div class="col-sm-5">
                	<p class="form-control-static">${studentPayment.staffId}</p>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">缴费方式</label>
                <div class="col-sm-4">
                	<p class="form-control-static">${studentPayment.paymentMenthod}</p>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束2 -->
    <!-- 开始3 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">应缴金额</label>
                <div class="col-sm-6">
                	<p class="form-control-static">${studentPayment.paymentShouldAmount}</p>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">实缴金额</label>
                <div class="col-sm-9">
               <p class="form-control-static">${studentPayment.paymentRealAmount}</p>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束3 -->
        <!-- 开始4 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">优惠金额</label>
                <div class="col-sm-9">
                	 <p class="form-control-static">${studentPayment.paymentDiscountAmount}</p>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">欠款</label>
                <div class="col-sm-9">
                 <p class="form-control-static">${studentPayment.paymentDebtAmount}</p>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束4 -->
    <!-- 开始4 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">缴费时间</label>
                <div class="col-sm-9">
                	  <p class="form-control-static">${studentPayment.paymentTime}</p>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">缴费情况</label>
                <div class="col-sm-9">
               	 <p class="form-control-static">${studentPayment.paymentSitutation}</p>
                </div>
            </div>
        </div>
    </div>
   
    <!-- 结束6 -->   
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">备注信息</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">备注</label>
                <div class="col-sm-9">
                		<p class="form-control-static">${studentPayment.paymentRemark}</p>
                </div>
            </div>
        
        </div>

   	<div class="row">
    	<div class="col-sm-5 col-sm-offset-4">
          	<a href="${pageContext.request.contextPath }/finance/tuition/load.action?studentPaymentId=${studentPayment.paymentId}" class="btn btn-success" >修改</a>
            <input  type="reset" class="btn  btn-danger" value="删除"/>
            <a href="${pageContext.request.contextPath }/finance/tuition/list.action" class="btn btn-waring" >返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>
