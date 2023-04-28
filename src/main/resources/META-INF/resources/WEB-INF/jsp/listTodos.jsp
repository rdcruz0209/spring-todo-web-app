<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">

    <h1> Your Todos are:</h1>
    <br>
    <table class="table">
        <thead>
            <tr>
                <%--                <th>id</th>--%>
                <%--                <th>Username</th>--%>
                <th>Description</th>
                <th>Target Date</th>
                <th>Is Done?</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${todos}" var="todo">
                <%--                todo in todos--%>
                <tr>
                        <%--                    <td>${todo.id}</td>--%>
                        <%--                    <td>${todo.username}</td>--%>
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
<%@include file="common/footer.jspf" %>
>