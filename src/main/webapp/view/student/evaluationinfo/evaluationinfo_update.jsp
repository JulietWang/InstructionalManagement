<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib  uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<%@ include file="/view/public/common.jspf" %>
</head>
	<!-- 显示错误信息 -->
	<div align="center">
		<div class="alert alert-warning"
			style="margin: 0px; padding: 5px; width: 100%;display:${empty allErrors?'none':'block'} ">
			<c:forEach items="${allErrors}" var="error">
			 	${error.defaultMessage }<br />
			</c:forEach>
		</div>
	</div>
<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">学员管理</a></li>
        <li>修改评价</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath}/student/evaluationinfo/update.action" method="post" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">评价编号</label>
                <div class="col-sm-9">
                	<input type="text" value="${evaluationInfo.evaluationId }" name="evaluationId" readonly="readonly" class="form-control input-sm" placeholder="请输入评价编号"/>
                </div>
            </div>
        
        </div>
        
    <div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">学员姓名</label>
                <div class="col-sm-9">
                	<input type="text"  value="${evaluationInfo.studentId }" name="studentId"  class="form-control input-sm" placeholder="请输入学员编号"/>
                </div>
            </div>
        
        </div>

    </div>
    
    <div class="row">
    
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">主题</label>
                <div class="col-sm-9">
                	<input type="text" value="${evaluationInfo.evaluationTile}" name="evaluationTile" class="form-control input-sm" placeholder="请输入主题"/>
                </div>
            </div>
        </div>
    
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">课程名称</label>
                <div class="col-sm-9">
               			<input type="text" value="${evaluationInfo.evaluationCourse}" name="evaluationCourse" class="form-control input-sm" placeholder="请输入课程名称"/>
                </div>
            </div>
        </div>
    

    </div>
        <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">评价时间</label>
                <div class="col-sm-9">
               			<input type="text" value="${evaluationInfo.evaluationTime}" name="evaluationTime"  onclick="WdatePicker()" readonly="readonly" class="form-control input-sm" placeholder="请输入评价时间"/>
                </div>
            </div>
        </div>
        
	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">教师</label>
                <div class="col-sm-9">
               		 <input type="text" value="${evaluationInfo.evaluationTeacher}" name="evaluationTeacher" class="form-control input-sm" placeholder="请输入教师"/>
                </div>
            </div>
        
        </div>

    </div>

 
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">评价内容</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">评价内容</label>
                <div class="col-sm-9">
                	<textarea value="${evaluationInfo.evaluationContent}" name="evaluationContent" class="form-control">${evaluationInfo.evaluationContent}</textarea>
                </div>
            </div>
        
        </div>

    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>

              <a class="btn btn-warning" href="${pageContext.request.contextPath }/student/evaluationinfo/list.action">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>
