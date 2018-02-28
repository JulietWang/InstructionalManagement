<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib  uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
	<%@ include file="/view/public/common.jspf" %>
</head>

<script type="text/javascript">
		function click(){
			document.getElementById("name").value=" ";
		}
		
		function change(){
			document.getElementById("activestate").options[0].selected;
		}
</script>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">营销管理</a></li>
        <li>营销活动</li>
    </ul>
</div>
<div class="row alert alert-info"  style="margin:0px; padding:3px;text-align: center;" >
<form class="form-inline"  action="${pageContext.request.contextPath }/marketactive/marketactive/list.action">
     <div class="form-group">
        <input type="text" class="form-control"  name="activeName"  id="name" placeholder="请输入活动名称"  onfocus="change()">
      </div>
      <div class="form-group">
		 <select  class="form-control" id="activestate"  name="activeState" onfocus="click()">
            <option value="">活动状态</option>
            <option value="0">准备中</option>
            <option value="1">开始</option>
            <option value="2">进行中</option>
            <option value="3">已结束</option>
         </select>	
      </div>
    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <a  class="btn btn-success"  href="${pageContext.request.contextPath}/view/marketactive/marketactive/marketactive_add.jsp">添加活动</a>
    </form>
</div>
<div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			
		</button>
		<p align="center" style="color: red;">活动信息-${info}</p>
	</div>	
</div>


<div class="row" style="padding:15px; padding-top:0px; " align="right">
	<table class="table  table-condensed table-striped">
    </table>
    <display:table class="table table-condensed table-striped" name="list" pagesize="10" requestURI="${pageContext.request.contextPath }/marketactve/marketactive/list.action">
    	<display:column property="activeName" title="活动名称"  href="${pageContext.request.contextPath }/marketactive/marketactive/show.action" paramId="activeId" paramProperty="activeId"></display:column>
    	<display:column property="activeState" title="活动状态"  decorator="com.guigu.marketactive.transfor.Transfor"></display:column>
    	<display:column property="activeType" title="活动类型"   decorator="com.guigu.marketactive.transfor.TransforType"></display:column>
    	<display:column property="activeContent" title="活动描述"> </display:column>
    	<display:column href="${pageContext.request.contextPath }/marketactive/marketactive/load.action" paramId="activeId" paramProperty="activeId" value="修改" title="修改"></display:column>
    	<display:column href="${pageContext.request.contextPath }/marketactive/marketactive/delete.action" paramId="activeId" paramProperty="activeId" value="删除" title="删除"></display:column>
    </display:table>
    
</div>

</body>
</html>
