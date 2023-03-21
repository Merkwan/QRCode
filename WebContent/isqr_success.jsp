<%--
  Created by IntelliJ IDEA.
  User: 66
  Date: 2020/5/12
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
<%=request.getAttribute("nickname")==null? "":request.getAttribute("nickname")%>
<%=request.getAttribute("qrresult")==null? "":request.getAttribute("qrresult")%>
</div>
