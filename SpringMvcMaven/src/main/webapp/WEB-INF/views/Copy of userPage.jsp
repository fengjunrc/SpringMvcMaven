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
  
<body>
  
	<style type="text/css">  
		#queryDiv {  
		 margin-right: auto;  
		 margin-left: auto;  
		 width:600px;  
		}  
		#textInput {  
		 margin-top: 10px;  
		}  
		#tableResult {  
		 margin-right: auto;  
		 margin-left: auto;  
		 width:600px;  
		}  
		td {  
		 width:150px  
		}  
	</style>  
</head>  
<body>  
    <div id = "queryDiv">  
        <input id = "textInput" type="text" placeholder="请输入用户名" >  
        <button id = "queryButton" class="btn btn-primary" type="button">查询</button>  
    </div>  
    <form id="form1">  
        <table class="table table-bordered" id = 'tableResult'>  
            <caption>查询用户结果</caption>  
            <thead>  
                <tr>  
                    <th>序号</th>  
                    <th>用户名</th>  
                    <th>密码</th>  
                    <th>用户邮箱</th>  
                </tr>  
            </thead>  
            <tbody id="tableBody">  
            </tbody>  
        </table>  
        <!-- 底部分页按钮 -->  
        <div id="bottomTab"></div>  
    </form>  
    <script type='text/javascript'>      
        var PAGESIZE = 10;  
        var options = {    
            currentPage: 1,  //当前页数  
            totalPages: 10,  //总页数，这里只是暂时的，后头会根据查出来的条件进行更改  
            size:"normal",    
            alignment:"center",    
            itemTexts: function (type, page, current) {    
                switch (type) {    
                    case "first":    
                        return "第一页";    
                    case "prev":    
                        return "前一页";    
                    case "next":    
                        return "后一页";    
                    case "last":    
                        return "最后页";    
                    case "page":    
                        return  page;    
                }                   
            },    
            onPageClicked: function (e, originalEvent, type, page) {    
                var userName = $("#textInput").val(); //取内容  
                buildTable(userName,page,PAGESIZE);//默认每页最多10条  
            }    
        }    
  
        //生成表格  
        function buildTable(userName,pageNumber,pageSize) {  
             var url = "queryByPage"; //请求的网址  
             var reqParams = {'userName':userName, 'pageNumber':pageNumber,'pageSize':pageSize};//请求数据  
             $(function () {     
                  $.ajax({  
                        type:"POST",  
                        url:url,  
                        data:reqParams,  
                        async:false,  
                        dataType:"json",  
                        success: function(data){  
                            if(data.isError == false) {  
                           // options.totalPages = data.pages;  
                        var newoptions = {    
                        currentPage: 1,  //当前页数  
                        totalPages: data.pages==0?1:data.pages,  //总页数  
                        size:"normal",    
                        alignment:"center",    
                        itemTexts: function (type, page, current) {    
                        switch (type) {    
                            case "first":    
                            return "第一页";    
                            case "prev":    
                            return "前一页";    
                            case "next":    
                            return "后一页";    
                            case "last":    
                            return "最后页";    
                        case "page":    
                        return  page;    
                }                   
            },    
            onPageClicked: function (e, originalEvent, type, page) {    
                var userName = $("#textInput").val(); //取内容  
                buildTable(userName,page,PAGESIZE);//默认每页最多10条  
            }    
         }                           
         $('#bottomTab').bootstrapPaginator("setOptions",newoptions); //重新设置总页面数目  
         var dataList = data.dataList;  
         $("#tableBody").empty();//清空表格内容  
         if (dataList.length > 0 ) {  
             $(dataList).each(function(){//重新生成  
                    $("#tableBody").append('<tr>');  
                    $("#tableBody").append('<td>' + this.id + '</td>');  
                    $("#tableBody").append('<td>' + this.username + '</td>');  
                    $("#tableBody").append('<td>' + this.password + '</td>');  
                    $("#tableBody").append('<td>' + this.email + '</td>');  
                    $("#tableBody").append('</tr>');  
                    });    
                    } else {                                  
                          $("#tableBody").append('<tr><th colspan ="4"><center>查询无数据</center></th></tr>');  
                    }  
                    }else{  
                          alert(data.errorMsg);  
                            }  
                      },  
                        error: function(e){  
                           alert("查询失败:" + e);  
                        }  
                    });  
               });  
        }  
          
        //渲染完就执行  
        $(function() {  
              
            //生成底部分页栏  
            $('#bottomTab').bootstrapPaginator(options);       
              
            buildTable("",1,10);//默认空白查全部  
              
            //创建结算规则  
            $("#queryButton").bind("click",function(){  
                var userName = $("#textInput").val();     
                buildTable(userName,1,PAGESIZE);  
            });  
        });  
    </script>  
</body>  
</html>
