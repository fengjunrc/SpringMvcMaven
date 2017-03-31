<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajaxFileUpload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@include file="/WEB-INF/views/include/base.jsp"%>
	<script type="text/javascript" src="js/ajaxfileupload.js"></script>
  </head>
  <script type="text/javascript">
  	 function ajaxFileUploadme(){
		//开始上传文件时显示一个图片,文件上传完成将图片隐藏
		//$("#loading").ajaxStart(function(){$(this).show();}).ajaxComplete(function(){$(this).hide();});
		$.ajaxFileUpload({
			url: "subject/fileUpload", //用于文件上传的服务器端请求地址
			secureuri:false,                       //是否启用安全提交,默认为false 
			fileElementId:'simpleUrl',       
			data:{name:"1"}  ,  
			dataType:'json',                      
			success:function(data, status){       
				alert(data.msg);
			},
			error:function(data, status, e){ 
				$('#result').html('图片上传失败，请重试！！');
			}
		});
  	}
  </script>
  <body>
    This is my JSP page. <br>
    
    <input type="file" id="simpleUrl" name="myfiles"></input>
   <button type="button" value="上传图片"  onclick="ajaxFileUploadme()"  >上传</button>
  </body>
</html>
