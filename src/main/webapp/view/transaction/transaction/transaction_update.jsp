<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
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
    	<li><a href="#">教务管理</a></li>
        <li>考勤管理</li>
        <li>修改考勤</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath }/transaction/transaction/update.action" class="form-horizontal">
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>
            <a href="${pageContext.request.contextPath }/transaction/transaction/list.action" class="btn btn-success">返回上一级</a>
        </div>
    </div>
     <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	
                	<input type="hidden" value="${attendanceInfo.attendanceId }" name="attendanceId" readonly="readonly" class="form-control input-sm" placeholder="请输入编号"/>
    
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">学生编号</label>
                <div class="col-sm-9">
                	<input type="text" name="studentId" value="${attendanceInfo.studentId }" class="form-control input-sm" placeholder="请输入学生编号"/>
                </div>
            </div>
        </div>

    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">日期</label>
                <div class="col-sm-9">
                	<input type="text" name="attendanceTime" value="<fmt:formatDate value="${attendanceInfo.attendanceTime}" type="both" pattern="yyyy-MM-dd"/>" onclick="WdatePicker()" readonly="readonly" class="form-control input-sm" placeholder="请输入日期"/>
                </div>
            </div>
        
        </div>
    </div>
   
    
        <!-- 开始4 -->
	<div class="row">
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">描述</label>
                <div class="col-sm-9">
                <input type="text" name="attendanceDesc"  value="${attendanceInfo.attendanceDesc}" class="form-control input-sm" placeholder="请输入描述"/>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束4 -->
    
    
  
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">备注信息</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">备注</label>
                <div class="col-sm-9">
                	<textarea class="form-control" name="attendanceRemark"> ${attendanceInfo.attendanceRemark} </textarea>
                </div>
            </div>
        
        </div>

    </div>
       
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>
           	 <a href="${pageContext.request.contextPath }/transaction/transaction/list.action" class="btn btn-success">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>
