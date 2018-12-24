<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<title>messagelist</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>

	<input id="basePath" type="hidden" value="<%=basePath%>" />

	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1>消息列表</h1>
			</div>
		</div>

		<!-- 表格  -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<tr>
						<th class="width150">标题</th>
						<th class="width250">时间</th>
					</tr>
					<c:forEach items="${messageList}" var="message">
						<tr>
							<td>${message.title}</td>
							<td><fmt:formatDate value="${message.date}"
									pattern="yyyy-MM-dd" /></td>
							<td>
								<input type="submit" value="修改" class="btn_modify" onclick="location.href='${path}/messagelist/queryById?id=${message.id}';" />
								<input type="button" value="删除" class="btn_delete" onclick="if (!confirm('您确定要删除选中的记录吗？')) {return;} location.href='${path}/messagelist/delete?id=${message.id}';" />
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
