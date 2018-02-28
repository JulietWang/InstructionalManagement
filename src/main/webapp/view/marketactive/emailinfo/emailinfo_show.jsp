<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="../../../css/bootstrap.min.css">
<%@ include file="/view/public/common.jspf" %>
</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">营销管理</a></li>
        <li>邮件管理</li>
        <li>查看信息</li>
    </ul>
</div>

<form action="" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	 	<div class="row">
                <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">主题</label>
                <div class="col-sm-9">
                	<input type="text" name="emailTitle" value="${email.emailTitle}" class="form-control input-sm" placeholder="请输入主题"/>
                </div>
            </div>
      	  </div>
        </div>
        <div class="row">
                <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">发送人</label>
                <div class="col-sm-9">
                	<input type="text" name="staffName" value="${email.staffName}"  class="form-control input-sm" placeholder="请输入发送人"/>
                </div>
            </div>
       			 </div>
        </div>
    	<div class="row">
                <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">接收人</label>
                <div class="col-sm-9">
                	<input type="text" name="emailMan" value="${email.emailMan}"  class="form-control input-sm" placeholder="请输入接收人"/>
                </div>
            </div>
        </div>
        
        </div>
       
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">邮件地址</label>
                <div class="col-sm-9">
                	<input type="email" name="emailAddr"  value="${email.emailAddr}" class="form-control input-sm"  placeholder="请输入地址"/>
                </div>
            </div>
        
        </div>
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">邮件内容信息</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">邮件内容</label>
                <div class="col-sm-9">
                	<textarea class="form-control" name="emailContent">${email.emailContent}</textarea>
                </div>
            </div>
        
        </div>

    </div>
 	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">发送时间</label>
                <div class="col-sm-9">
                	 <p class="form-control-static">
                	 	<fmt:formatDate value="${email.emailTime}" pattern="yyyy年MM月dd日" type="both"/>
                	 </p>
                </div>
            </div>
        
        </div>

    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
              <a class="btn btn-warning" href="${pageContext.request.contextPath }/marketactive/emailinfo/list.action">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>
