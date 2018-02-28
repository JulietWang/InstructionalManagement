<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>员工薪水</title>

<%@ include file="/view/public/common.jspf" %>

</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">财务管理</a></li>
        <li>员工薪水</li>
    </ul>
</div>
<script type="text/javascript">
		function query(condition){
			$("#keyword").attr("name",condition.value);
		}
</script>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form class="form-horizontal" action="${pageContext.request.contextPath}/finance/salary/list.action" method="post">
    <div class="col-sm-3" style="margin-left: 200px">
    	<select class="form-control  input-sm"  onchange="query(this)" name="condition">
    		<option value="">请选择</option>
        	<option value="staffName">领取者姓名</option>
            <option value="financeName">财务人员</option>
            <option value="staffSalaryOrderId">工资单编号</option>
        </select>
    </div>
    <div class="col-sm-3">
    	<input type="text"  class="form-control input-sm" id="keyword"/>
    </div>
    <input type="submit"   class="btn btn-danger"   value="查询"/>
    <a href="${pageContext.request.contextPath}/view/finance/salary/Salary_add.jsp" class="btn btn-success">添加</a>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
    <display:table class="table table-condensed table-striped" name="list" pagesize="10" requestURI="${pageContext.request.contextPath}/finance/salary/list.action">
    	<display:column property="staffSalaryOrderId" title="工资单编号"></display:column>
    	<display:column property="staffName" title="领取人员" href="${pageContext.request.contextPath}/finance/salary/show.action" paramId="staffSalaryOrderId" paramProperty="staffSalaryOrderId"></display:column>
    	<display:column property="financeName" title="财务人员"></display:column>
    	<display:column property="staffSalary.staffSalaryTotal" title="本月薪水"></display:column>
    	<display:column property="staffSalary.staffSalaryDeduct" title="扣除"></display:column>
    	<display:column property="staffSalary.staffSalaryReal" title="实际发放工资"></display:column>
    	<display:column property="staffSalary.staffSalaryIsused" title="是否已发"></display:column>
    	<display:column property="staffSalary.staffSalaryTime" title="领取时间" format="{0,date,yyyy年MM月dd日}"></display:column>
    	<display:column href="${pageContext.request.contextPath}/finance/salary/load.action" paramId="staffSalaryOrderId" paramProperty="staffSalaryOrderId" value="修改" title="修改"></display:column>
    	<display:column href="${pageContext.request.contextPath}/finance/salary/delete.action" paramId="staffSalaryOrderId" paramProperty="staffSalaryOrderId" value="删除" title="删除"></display:column>
    </display:table> 
</div>

</body>
</html>
