<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--import jstl core using tagLib--%>
<%--tagLib is how we can implement imports in jsp files--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--this taglib import is for spring form tag library used for FBO - form backing object --%>
<!doctype html>
<html lang="en">
    <head>
        <link href="${pageContext.request.contextPath}/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet"/>

        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Add New Todo Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Enter Todo Details</h1>
            
            <%--@elvariable id="todo" type="com.webapplicationprojects.springboot.todowebapp.todo.Todo"--%>
            <form:form method="post" modelAttribute="todo">
                Description: <form:input type="text" path="description" required="required" name="description"/>
                <input type="submit" class="btn btn-success"/>
            </form:form>
        </div>
        <script src="${pageContext.request.contextPath}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/webjars/jquery/3.6.3/jquery.min.js"></script>
    </body>
</html>