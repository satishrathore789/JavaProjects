<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form</title>
<body bgcolor="#FFF1F0" text="#000000">
<center>

<form  action="Search" method="post">
    <table cellspacing="5" cellpadding="5" border="1">
        <tr>
            <td align="right">Name:</td>
            <td><input type="text" name="NewFirstName" pattern="[a-z]{1,15}"></td>
        </tr>
        <tr>
            <td align="right">Email Address:</td>
            <td><input type="text" name="EmailAddress" pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,63}$" ></td>
        </tr>
        <tr>
            <td align="right">Phone Number:</td>
            <td><input type="text" name="Phone Number" pattern="[0-9][0-9]{9}"></td>
        </tr>
    </table>
    <input type="submit" value="Search">
</form>
</center>
</body>
</html>