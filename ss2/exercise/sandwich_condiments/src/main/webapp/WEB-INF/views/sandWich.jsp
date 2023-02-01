<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 1/31/2023
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>converter</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>


<div class="container">
    <form  action="/converter" >
        <div ><h1>Sandwich Condiments</h1></div>
        <input name="condiment" type="checkbox" value="Lettuce">Lettuce
        <input name="condiment" type="checkbox" value="Tomato">Tomato
        <input name="condiment" type="checkbox" value="Mustard">Mustard
        <input name="condiment" type="checkbox" value="Sprouts">Sprouts
        <button type="submit"></button>
    </form>
</div>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
