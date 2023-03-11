<!doctype html>
<html lang="en">
    <head>
        <link href="${pageContext.request.contextPath}/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet"/>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Welcome Page</title>
    </head>
    <body>
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
    </body>
</html>