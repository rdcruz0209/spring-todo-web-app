<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <h1> Welcome to ToDo Web App, ${username}</h1>

    <div><a href="todo/list-todos"> Manage your Todos</a></div>
    <br>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.6.3/jquery.min.js"></script>
</div>

<%@ include file="common/footer.jspf" %>
