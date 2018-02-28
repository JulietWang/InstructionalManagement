<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib  uri="http://displaytag.sf.net" prefix="display" %>
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
        <li>考勤管理</li>
    </ul>
</div>
<script type="text/javascript">
		function query(condition){
			$("#keyword").attr("name",condition.value);
		}
</script>

<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form  action="${pageContext.request.contextPath}/transaction/transaction/list.action" method="post" class="form-horizontal">
    <div class="col-sm-3" style="margin-left: 200px">
    	<select class="form-control  input-sm" onchange="query(this)" name="condition">
        	<option value="">请选择</option>
        	<option value="attendanceId">班级编号</option>
            <option value="studentId">学生编号</option>
        </select>
    </div>
    <div class="col-sm-3">
    	<input type="text"  id="keyword"  class="form-control input-sm"/>
    </div>
    <input type="submit"   class="btn btn-danger"   value="查询"/>
    <input type="button"   class="btn btn-success"   value="添加" onClick="javascript:window.location='${pageContext.request.contextPath}/view/transaction/transaction/transaction_add.jsp'"/>
 </form>
</div>

<div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			
		</button>
		<p align="center" style="color: red;">考勤信息-${info}</p>
	</div>	
</div>


<div class="row" style="padding:15px; padding-top:0px; " align="right">
	<table class="table  table-condensed table-striped">
    </table>
    <display:table class="table table-condensed table-striped" name="list" pagesize="10" requestURI="${pageContext.request.contextPath }/transaction/transaction/list.action">
    	<display:column property="attendanceId" title="考勤编号"></display:column>
    	<display:column property="studentId" title="学生编号" href="${pageContext.request.contextPath }/transaction/transaction/show.action" paramId="attendanceId" paramProperty="attendanceId"></display:column>
    	<display:column property="attendanceDesc" title="描述"></display:column>
    	<display:column property="attendanceState" title="状态"></display:column>
    	<display:column property="attendanceTime" title="日期" format="{0,date,yyyy年MM月dd日}"></display:column>
    	<display:column property="attendanceRemark" title="备注"></display:column>
    	<display:column href="${pageContext.request.contextPath }/transaction/transaction/load.action" paramId="attendanceId" paramProperty="attendanceId" value="修改" title="修改"></display:column>
    	<display:column href="${pageContext.request.contextPath }/transaction/transaction/delete.action" paramId="attendanceId" paramProperty="attendanceId" value="删除" title="删除"></display:column>
    	
    </display:table>
    
    
</div>

</body>
</html>
