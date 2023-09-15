<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jakarta EE - Login</title>
</head>
<body>
<h1>Jakarta EE - Login</h1>

<br/>
<a href="hello-servlet">Hello Servlet</a>
<br/>

${messageErreur}

<form method="GET" action="hello-servlet">
    <table>
        <tr>
            <td><label for="champPrenom">Prénom:</label></td>
            <td><input type="text" id="champPrenom" name="champPrenom"></td>
        </tr>
        <tr>
            <td><label for="champLogin">Login:</label></td>
            <td><input type="text" id="champLogin" name="champLogin"></td>
        </tr>
        <tr>
            <td><label for="champMotDePasse">Mot de passe:</label></td>
            <td><input type="password" id="champMotDePasse" name="champMotDePasse"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Login" name="action"></td>
        </tr>
    </table>
</form>
</body>
</html>