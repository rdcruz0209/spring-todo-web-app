<!doctype html>
<html lang="en">
    <head>
        <link href="${pageContext.request.contextPath}/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet"/>

        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Say Hello Page</title>
    </head>
    <body>
        <div class="container">
            <p>HELLO I AM A JSP VIEW PAGE WITH BODY - JSP</p>
            <p>Hello I am a view from JSP</p>
            <button type="button">
                <a href="http://localhost:8080"> Go back to Home Page</a>
            </button>

            <button type="button">
                <a href="http://localhost:8080/todo/login?name=Placeholder"> Login Page</a>
            </button>
            <%--<button type="button">--%>
            <%--    <a href="http://localhost:8080/todo/loginwithname?name=Placeholder"> Login Page with Name</a>--%>
            <%--</button>--%>
        </div>
        <script src="${pageContext.request.contextPath}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/webjars/jquery/3.6.3/jquery.min.js"></script>

    </body>
</html>