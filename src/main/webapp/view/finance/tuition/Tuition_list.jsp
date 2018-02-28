<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学员缴费</title>

<%@ include file="/view/public/common.jspf" %>

</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">财务管理</a></li>
        <li>学员缴费</li>
    </ul>
</div>
<script type="text/javascript">
		function query(condition){
			$("#keyword").attr("name",condition.value);
		}
</script>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form class="form-horizontal" action="${pageContext.request.contextPath}/finance/tuition/list.action" method="post">
    <div class="col-sm-3" style="margin-left: 200px">
    	<select class="form-control  input-sm"  onchange="query(this)" name="condition">
    		<option value="">请选择</option>
        	<option value="studnetName">学员姓名</option>
            <option value="studentPaymentId">缴费单编号</option>
            <option value="className">学员班级</option>
        </select>
    </div>
    <div class="col-sm-3">
    	<input type="text"  class="form-control input-sm" id="keyword"/>
    </div>
    <input type="submit"   class="btn btn-danger"   value="查询"/>
    <a href="${pageContext.request.contextPath}/finance/tuition/beforeAdd.action" class="btn btn-success">添加</a>
    </form>
</div>

<div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			
		</button>
		<p align="center" style="color: red;">缴费管理-${info}</p>
	</div>	
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
	
     <display:table class="table table-condensed table-striped" name="list" pagesize="10" requestURI="${pageContext.request.contextPath}/finance/tuition/list.action">
    	<display:column property="studentPaymentId" title="缴费单编号"></display:column>
    	<display:column property="studnetName" title="学员姓名" href="${pageContext.request.contextPath}/finance/tuition/show.action" paramId="studentPaymentId" paramProperty="studentPaymentId"></display:column>
    	<display:column property="className" title="所在班级"></display:column>
    	<display:column property="studentPayment.paymentShouldAmount" title="应缴金额"></display:column>
    	<display:column property="studentPayment.paymentRealAmount" title="实缴金额"></display:column>
    	<display:column property="studentPayment.paymentDebtAmount" title="欠款"></display:column>
    	<display:column property="staffName" title="负责人员"></display:column>
    	<display:column property="studentPayment.paymentTime" title="缴费时间" format="{0,date,yyyy年MM月dd日}"></display:column>
    	<display:column href="${pageContext.request.contextPath}/finance/tuition/load.action" paramId="studentPaymentId" paramProperty="studentPaymentId" value="修改" title="修改"></display:column>
    	<display:column href="${pageContext.request.contextPath}/finance/tuition/delete.action" paramId="studentPaymentId" paramProperty="studentPaymentId" value="删除" title="删除"></display:column>
    	<!-- paramId="staffId" paramProperty="staffId" -->
    </display:table> 
          
    
</div>

</body>
</html>
