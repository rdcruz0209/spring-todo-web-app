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
        <title>Todo List Page</title>
    </head>
    <body>
        <div class="container">
            <h1> Your Todos are:</h1>
            <br>
            <table class="table">
                <thead>
                    <tr>
                        <th>id</th>
                        <%--                        <th>User</th>--%>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Is Done?</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <td>${todo.id}</td>
                                <%--                            <td>${todo.username}</td>--%>
                            <td>${todo.description}</td>
                            <td>${todo.targetDate}</td>
                            <td>${todo.status}</td>

                                <%--                        <td>${fn:replace(todo.isDone, "true", "Yes")}</td>--%>
                                <%--                            isDone variable not working in jsp files jstl naming convention--%>
                            <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
                            <td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <a href="add-todo" class="btn btn-success">Add Todo</a>
        </div>
        <script src="${pageContext.request.contextPath}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/webjars/jquery/3.6.3/jquery.min.js"></script>
    </body>
</html>