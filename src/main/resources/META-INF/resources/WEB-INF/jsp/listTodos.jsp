<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--import jstl core using tagLib--%>
<%--tagLib is how we can implement imports in jsp files--%>

<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Todo List Page</title>
    </head>
    <body>
        <div>Welcome to TodoWebApp, ${name}.</div>
        <hr>
        <h1> Your Todos are:</h1>
        <br>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>Is Done?</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.id}</td>
                        <td>${todo.description}</td>
                        <td>${todo.targetDate}</td>
                        <td>${todo.status}</td>
                            <%--                        <td>${fn:replace(todo.isDone, "true", "Yes")}</td>--%>


                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>