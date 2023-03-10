<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login Page</title>
</head>
<body>

<h2>Welcome to the login page! ${name}</h2>

<pre>${incorrectPasswordResponse}</pre>

<form method="post">
    Name: <input type="text" name="name" required aria-required="true">
    Password: <input type="password" name="password" required aria-required="true">
    <input type="submit">
</form>

<br>


<br>

<button type="button">

    <a href="http://localhost:8080"> Go back to Home Page</a>
</button>


</body>
</html>