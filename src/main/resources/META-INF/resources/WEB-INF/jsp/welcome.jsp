<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <h1> Welcome to ToDo Web App, ${name}</h1>

    <div><a href="list-todos"> Manage your Todos</a></div>
    <br>
    <button type="button">
        <a href="http://localhost:8080/todo/login"> Signout</a>
    </button>

    <script src="${pageContext.request.contextPath}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.6.3/jquery.min.js"></script>
</div>

<%@ include file="common/footer.jspf" %>
