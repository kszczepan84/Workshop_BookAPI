<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 14.05.2021
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Book</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/books/add">

    <label>
        ISBN
        <input type="text" name="isbn">
    </label>
    <label>
        Title
        <input type="text" name="title">
    </label>
    <label>
        Author
        <input type="text" name="author">
    </label>
    <label>
        Publisher
        <input type="text" name="publisher">
    </label>
    <label>
        Type
        <input type="text" name="type">
    </label>

    <button type="submit">Zatwierdź</button>

</form>

</body>
</html>
