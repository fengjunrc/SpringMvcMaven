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
  
<body style="border:1px solid #ccc;">
  
   <form action="<%=basePath%>pageList.do" method="post" name="search" id="pageFormId">
      <!-- panel-success浅绿色 -->
      <div class="panel panel-info">
        <div class="panel-heading" id="divSearchTitle">
          <span class="glyphicon glyphicon-search"></span>搜索条件
          <span id="divSlide" class="glyphicon glyphicon-chevron-up" style="float: right;"></span>
        </div>
        <div class="panel-body" id="divSearch">
          <table class="Morinda-table">
            <tr class="Morinda-row">
              <td class="Morinda-label-td"> 用户名：
              </td>
              <td class="Morinda-field-td">
               	<input type="text" name="username" size="15" class="Morinda-text" value="${username}"
               	 maxlength="20" placeholder="请输入用户名"/>
              </td>
              <td colspan="2" style="text-align: center">
                <input type="submit" value="查询" class="btn btn-info" id="btnSearch">
                <input type="reset" value="清空" class="btn btn-info" id="btnClear">
              </td>
            </tr>
          </table>
        </div>
      </div>
    </form>
    
    <div class="panel panel-success">
   		<div class="panel-heading">
			<button class="btn btn-info"  id="btnDel">删除</button>
			<button class="btn btn-info"  id="btnUpdate">修改</button>
			<button class="btn btn-info"  id="btnAdd">添加</button>
   		</div>	
    		
     <div class="panel-body" id="table-container" style="padding:0px;">
	        <table class="table table-bordered table-striped">
	          <tr >
	            <th>编号</th>
	            <th>用户</th>
	            <th>密码</th>
	            <th>修改时间</th>
	            <!-- <th>操作</th> -->
	          </tr>
	          
	         <c:forEach var="user" items="${userList}" varStatus="st">
	          	<tr>
	           		<td>${st.count}</td>
	           		<td>${user.username }</td>
	           	  	<td>${user.password} </td>
	           		<td align="center">
	              <span>
	                <!-- data-target="#shwodialogModal"指向这个div data-toggle="modal"-->
	                <a href="javascript:void(0);" onclick="deleteUser('${user.id}');" id="deleteUser" 
	                  data-toggle="modal" data-target="#shwodialogModal"> 删除
	                </a>
	              </span>
	              <span><a href="javascript:void(0);" onclick="updateUser('${user.id}');">修改</a></span>
	            	</td>
	          </tr>
	        </c:forEach>
	      </table>
          	<ul class="pagination"> 
			    <li><a href="#">&laquo;</a></li> 
			    <li class="active"><a href="user/queryByPage">1</a></li> 
			    <li><a href="#">2</a></li> 
			    <li><a href="#">3</a></li> 
			    <li><a href="#">4</a></li> 
			    <li><a href="#">5</a></li> 
			    <li><a href="#">&raquo;</a></li> 
			</ul>

    	</div>
 	  </div>  
 	  
  
  <div class="modal fade" id="shwodialogModal" tabindex="-1" role="dialog" 
    aria-labelledby="modal-title-content" aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
          <h4 class="modal-title" id="modal-title-content"></h4>
        </div>
        <div class="modal-body" id="modal-body-content"></div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
          <button type="button" class="btn btn-primary">确认</button>
        </div>
      </div>
    </div>
   </div>
 
  </body>
</html>
