<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your schedule</title>
</head>
<body>

<form action="/login.do" method="post">
<p><font color="red">${errorMessage}</font></p>

Enter your name <input type="text" name="name"> 
Enter your password <input type="password" name="password"> 
<input type="submit" value="login">
</form>
</body>
</html>