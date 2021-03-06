<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib  uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    	<li><a href="${pageContext.request.contextPath}/classinfo/classinfo/listCDSCS.action">班级管理</a></li>
        <li>添加班级</li>
    </ul>
</div>
<div align="center">
		<div class="alert alert-warning"
			style="margin: 0px; padding: 5px; width: 100%;display:${empty allErrors?'none':'block'} ">
			<c:forEach items="${allErrors}" var="error">
			 	${error.defaultMessage }<br />
			</c:forEach>
		</div>
	</div>
<form action="${pageContext.request.contextPath}/classinfo/classinfo/add.action" method="post" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	
      <input type="hidden" name="classId" readonly="readonly" class="form-control input-sm" />
          
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">班级名称</label>
                <div class="col-sm-9">
                	<input type="text" name="className" value="${classInfo.className }" class="form-control input-sm" />
                </div>
            </div>
        </div>

    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">开班日期</label>
                <div class="col-sm-9">
               			<input type="text" name="classStartTime" value="${classInfo.classStartTime }" onclick="WdatePicker()" readonly="readonly" class="form-control input-sm" />
                </div>
            </div>
        </div>
    </div>
    
    <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">结束日期</label>
                <div class="col-sm-9">
               		 <input type="text" name="classEndTime" value="${classInfo.classEndTime }" onclick="WdatePicker()" readonly="readonly" class="form-control input-sm" />
                </div>
            </div>
        
        </div>

    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">班级人数</label>
                <div class="col-sm-9">
               			<input type="text" name="classNumber" value="${classInfo.classNumber }" class="form-control input-sm" />
                </div>
            </div>
        </div>
    </div>
        <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">教师</label>
                <div class="col-sm-9">
               		 <select name="staffId" class="form-control input-sm">
               		 	<option></option>
                     	<c:forEach var="staff" items="${teacherList}">
                     		<option value="${staff.staffId}" ${staff.staffId==classInfo.staffId?'selected':''}>${staff.staffName}</option>
                     	</c:forEach>
                     </select>
                </div>
            </div>

        </div>

    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">学科</label>
                <div class="col-sm-9">
               	   <select name="disciplineId" class="form-control input-sm">
               	   <option></option>
                     	<c:forEach var="discipline" items="${disciplineInfoList}">
                     		<option value="${discipline.disciplineId}" ${discipline.disciplineId==classInfo.disciplineId?'selected':''}>${discipline.disciplineName}</option>
                     	</c:forEach>
                     </select>
                </div>
            </div>
        </div>
    </div>
        <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">课程表</label>
                <div class="col-sm-9">
               		 <select name="syllabusId" class="form-control input-sm">
               		 <option></option>
                     	<c:forEach var="syllabus" items="${syllabusInfoList}">
                     		<option value="${syllabus.syllabusId}" ${syllabus.syllabusId==classInfo.syllabusId?'selected':''} >${syllabus.syllabusName}</option>
                     	</c:forEach>
                     </select>
                </div>
            </div>

        </div>

    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">教室</label>
                <div class="col-sm-9">
               	   <select name="classroomId" class="form-control input-sm">
               	   <option></option>
                     	<c:forEach var="classroom" items="${classroomInfoList}">
                     		<option value="${classroom.classroomId}">${classroom.classroomName}</option>
                     	</c:forEach>
                     </select>
                </div>
            </div>
        </div>
    </div>
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">描述</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">描述</label>
                <div class="col-sm-9">
                	<textarea class="form-control" name="classDesc">${classInfo.classDesc }</textarea>
                </div>
            </div>
        
        </div>

    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>

              <a class="btn btn-warning" href="${pageContext.request.contextPath}/classinfo/classinfo/listCDSCS.action">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>
