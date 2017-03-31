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
	
	<!--引入CSS-->
	<link rel="stylesheet" type="text/css" href="css/webuploader.css">
	
	<!--引入JS-->
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<!--引入JS-->
	<script type="text/javascript" src="js/webuploader.js"></script>
		
  </head>
  <script type="text/javascript">
	/*  function uploadM() {  
	     var formData = new FormData($( "#uploadForm" )[0]);  
	     $.ajax({  
	          url: 'upload' ,  
	          type: 'POST',  
	          data: formData,  
	          async: false,  
	          cache: false,  
	          contentType: false,  
	          processData: false,  
	          success: function (returndata) {  
	              alert(returndata);  
	          },  
	          error: function (returndata) {  
	              alert(returndata);  
	          }  
	     });  
	}   */
  	
	  	// 初始化Web Uploader
		var uploader = WebUploader.create({
		    // 选完文件后，是否自动上传。
		    auto: true,
		    // swf文件路径
		    swf:  '/js/Uploader.swf',
		    // 文件接收服务端。
		    server: 'http://webuploader.duapp.com/server/fileupload.php',
		    // 选择文件的按钮。可选。
		    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
		    pick: '#filePicker',
		    // 只允许选择图片文件。
		    accept: {
		        title: 'Images',
		        extensions: 'gif,jpg,jpeg,bmp,png',
		        mimeTypes: 'image/*'
		    }
		});
  </script>
<!--   <body>
 	<form id= "uploadForm" enctype="multipart/form-data">  
  	  	<input id="file" type="file"/>
    	<button id="upload" type="button" onclick="uploadM();">upload</button>
	</form> -->
	
	<!-- web uploader -->
	<div id="uploader-demo">
	    <!--用来存放item-->
	    <div id="fileList" class="uploader-list"></div>
	    <div id="filePicker">选择图片</div>
	</div>
  </body>
</html>
