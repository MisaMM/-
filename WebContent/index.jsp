<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path = request.getContextPath();
%>
<%@ page import="search.*,java.util.ArrayList" %>
<%SearchDB sdb = new SearchDB();
	String type = request.getParameter("types");
	String search = request.getParameter("search");
	String pages = request.getParameter("pages");
	if(pages==null)
		pages="1";
	ArrayList<WorkInfo> list = new ArrayList<WorkInfo>();
	if(search!=null)
	{
		list=(ArrayList<WorkInfo>)session.getAttribute("worksList");
	}
	else{
		if(type==null)
	 		list=sdb.GetAll();
		else
		{	switch(type){
			case "1":
				list=sdb.SearchByType("诗歌");
				break;
			case "2":
				list=sdb.SearchByType("散文");
				break;
			case "3":
				list=sdb.SearchByType("小说");
				break;
				}
		}
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="css/css.css" rel="stylesheet" type="text/css" />
<link href="css/reset.min.css" rel="stylesheet" type="text/css" />
<title>论坛主页</title>
</head>
<body>
<div class="nav clear">
<p class = "title">论坛交流系统</p>
<ul class="clear">
<li><a href="index.jsp">首页</a></li>
<li><a href="">登陆</a></li>
<li><a href="">注册</a></li>
</ul>
</div>

<div class="search1">
<div>
<form name="frm" method="post" action="<%=path%>/SearchAction">
<input type="text" class="txtingput" name="text" value="">
<button type="submit" class="txtbutton"  onclick="return check();">检索</button>
<div>
<label><input name="search_type" type="radio" value="内容" checked>内容</label> 
<label><input name="search_type" type="radio" value="作者" >作者</label>
</div>
</form>
</div>
</div >

<center>
<div class="nav1 clear">
<ul class="clear">
<li><a href="index.jsp">全部</a></li>
<li><a href="index.jsp?types=1">诗歌</a></li>
<li><a href="index.jsp?types=2">散文</a></li>
<li><a href="index.jsp?types=3">小说</a></li>
</ul>
</div>
</center>


<%for(int i=(Integer.valueOf(pages)-1)*4;i<list.size();i++){ %>
<div class="div-inline">
<img src="img/180.jpg" height="65" width="50" />
</div>
<div class="work-title">
<a href=""><%=list.get(i).getTitle()%></a>
<span><%=list.get(i).getWriterName()%></span>
<span>|</span>
<span><%=list.get(i).getTypes()%></span>
<p><%=list.get(i).getSummary()%></p>	  				
</div>
<% if(i>=Integer.valueOf(pages)*4-1 )break;}%>

<center>
<div class="pages">
<a href="index.jsp?pages=1">1</a>
<a href="index.jsp?pages=2">2</a>
<a href="index.jsp?pages=3">3</a>
<a href="index.jsp?pages=4">4</a>
<a href="index.jsp?pages=5">5</a>
</div>
</center>


</body>
</html>

<script language="JavaScript">
function check(){
	if(frm.内容.value==""||frm.内容.value==null)
	{
		alert("搜索内容不能为空！");
		frm.内容.focus();
		return false;
	}
	return true;
}

</script>