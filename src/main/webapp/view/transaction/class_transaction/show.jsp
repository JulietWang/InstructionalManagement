<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib  uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>

<%@ include file="/view/public/common.jspf" %>

</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">教务管理</a></li>
        <li>教室管理</li>
        <li>查看事务信息</li>
    </ul>
</div>

<form action="" class="form-horizontal">
   	
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>

    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">班级事务编号</label>
                <div class="col-sm-9">
                	<p class="form-control-static">${classTransactionInfo.classTransactionId}</p>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">班级编号</label>
                <div class="col-sm-9">
                	<p class="form-control-static">${classTransactionInfo.classId}</p>
                </div>
            </div>
        </div>


    <!-- 开始2 -->
	
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">主题</label>
                <div class="col-sm-5">
                	<p class="form-control-static">${classTransactionInfo.classTransactionTile}</p>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">内容</label>
                <div class="col-sm-9">
                	 <p class="form-control-static">
                	 	<p class="form-control-static">${classTransactionInfo.classTransactionContent}</p>
                	 </p>
                </div>
            </div>
        </div>

    <!-- 结束2 -->
    <!-- 开始2 -->

    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">组织人</label>
                <div class="col-sm-5">
                	<p class="form-control-static">${classTransactionInfo.classTransactionPerson}</p>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">备注</label>
                <div class="col-sm-9">
                	 <p class="form-control-static">
                	 	<p class="form-control-static">${classTransactionInfo.classTransactionRemar}</p>
                	 </p>
                </div>
            </div>
        </div>
   
    <!-- 结束2 -->
   
       
   
    
   

       

   	<div class="row">
    	<div class="col-sm-5 col-sm-offset-4">
<%--           <a href="${pageContext.request.contextPath }/transaction/class_transaction/load.action?classroomId=${classroomInfo.classroomId}" class="btn btn-success" >修改</a> --%>
<%--         	<a href="${pageContext.request.contextPath }/transaction/class_transaction/delete.action?classroomId=${classroomInfo.classroomId}" class="btn btn-success" >删除</a> --%>
        	<a href="${pageContext.request.contextPath }/transaction/class_transaction/list.action" class="btn btn-waring" >返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>
