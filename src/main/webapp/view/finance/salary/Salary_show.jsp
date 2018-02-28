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
        <li>员工薪水</li>
        <li>员工薪水详情</li>
    </ul>
</div>

<form action="" class="form-horizontal">
   	
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">工资单编号</label>
                <div class="col-sm-9">
                	<p class="form-control-static">${staffSalaryOrder.staffSalaryOrderId}</p>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">领取人</label>
                <div class="col-sm-9">
                	<p class="form-control-static">${staffSalaryOrder.staffName}</p>
                </div>
            </div>
        </div>

    </div>
    <!-- 开始2 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">发放人员</label>
                <div class="col-sm-5">
                	<p class="form-control-static">${staffSalaryOrder.financeName}</p>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">是否已发</label>
                <div class="col-sm-4">
                	<p class="form-control-static">${staffSalaryOrder.staffSalary.staffSalaryIsused}</p>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束2 -->
    <!-- 开始3 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">本月薪水</label>
                <div class="col-sm-6">
                	<p class="form-control-static">${staffSalaryOrder.staffSalary.staffSalaryTotal}</p>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">实际发放工资</label>
                <div class="col-sm-9">
               <p class="form-control-static">${staffSalaryOrder.staffSalary.staffSalaryReal}</p>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束3 -->
        <!-- 开始4 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">扣除</label>
                <div class="col-sm-9">
                	 <p class="form-control-static">${staffSalaryOrder.staffSalary.staffSalaryDeduct}</p>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">领取日期</label>
                <div class="col-sm-9">
                 <p class="form-control-static">${staffSalaryOrder.staffSalary.staffSalaryTime}</p>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束4 -->
    <!-- 开始4 -->
	
   
    <!-- 结束6 -->   
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">备注信息</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">备注</label>
                <div class="col-sm-9">
                		<p class="form-control-static">${staffSalaryOrder.staffSalary.remark}</p>
                </div>
            </div>
        
        </div>

   	<div class="row">
    	<div class="col-sm-5 col-sm-offset-4">
          	<a href="${pageContext.request.contextPath }/finance/salary/load.action?staffSalaryOrderId=${staffSalaryOrder.staffSalaryOrderId}" class="btn btn-success" >修改</a>
          	<a href="${pageContext.request.contextPath }/finance/salary/delete.action?staffSalaryOrderId=${staffSalaryOrder.staffSalaryOrderId}" class="btn btn-danger" >删除</a>
            <a href="${pageContext.request.contextPath }/finance/salary/list.action" class="btn btn-waring" >返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>
