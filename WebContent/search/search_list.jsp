<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="search.*,java.util.ArrayList" %>
<%String path=request.getContextPath();
ArrayList<WorkInfo> list=(ArrayList<WorkInfo>)session.getAttribute("worksList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>检索结果页面</title>
</head>
<body>
<table class="altrowstable" id="alternatecolor">
			<tr>
				<th height="25" colspan="7"  align="center" width=800px>
					搜索结果列表
				</th>
			</tr>
			<tr >
				<td>标题</td>
				<td>作者</td>
				<td>内容</td>
				<td>简介</td>
				<td>类型</td>
		    </tr>
		    <%for(int i=0;i<list.size();i++){ %>
		    <tr >
				<td><%=list.get(i).getTitle()%></td>
				<td><%=list.get(i).getWriterName()%></td>
				<td><%=list.get(i).getContent()%></td>
				<td><%=list.get(i).getSummary()%></td>
				<td><%=list.get(i).getTypes()%></td>	  				
		    </tr>
		    <%} %>
</table>
</body>
</html>