<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<%@include file="/WEB-INF/views/include/base.jsp"%>
  </head>
  
  <body style="background-color:#d0e4fe;">
  	<form class="form-horizontal" action="user/login" method="post" style="margin-top:120px">
	  <div class="form-group">
	    <label for="inputEmail3" class="col-sm-5 control-label">Email</label>
	    <div class="col-sm-3">
	      <input type="email" class="form-control"  placeholder="Email" name="username"  required>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="inputPassword3" class="col-sm-5 control-label">Password</label>
	    <div class="col-sm-3">
	      <input type="password" class="form-control" placeholder="Password" name="password" required>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-5 col-sm-10">
	      <div class="checkbox">
	        <label>
	          <input type="checkbox"> Remember me
	        </label>
	      </div>
	    </div>
	  </div>


<div class="switch switch-mini">
    <input type="checkbox" checked />
</div>
	  <div class="form-group">
		    <div class="col-sm-offset-5 col-sm-10">
		      <button type="submit" class="btn btn-default">Sign in</button>
		      <button type="reset" class="btn btn-default">reset</button>
		    </div>
	  </div>
	</form>
  </body>
</html>
