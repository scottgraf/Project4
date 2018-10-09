<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="model.Item" %><%--
  Created by IntelliJ IDEA.
  User: mgreen14
  Date: 9/27/18
  Time: 8:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Scott's Essential Oils - Catalog</title>
    <link rel="stylesheet" href="./css/theStyle.css">
</head>
<body>
<div id="container">
    <center>
    <div id="rcornerstop">
        <h2>Scott's Essential Oils</h2>
        <div class="topnav">
            <a href="index.jsp">Home</a>
            <a href="cat.go">Catalog</a>
            <a href="cart.go">Shopping Cart</a>
        </div>
        <br>
    </div>
    </center>
    <center>
    <div id="rcorners">
        <h3>Catalog</h3>
        <center>
        <form action="cartplace.go">
            <table>
                <%
                    List recs = (List) request.getAttribute("catalog");
                    Iterator it = recs.iterator();
                    while (it.hasNext()) {
                        // Notice we're outputting some HTML. Is that a good idea?
                        // Also, notice we do not cast the object returned by the
                        // iterator to a String. Why?
                        Item item = (Item) it.next();
                        out.print("<tr><td><img src='" + item.getImage() + "' height='100'></td><td>" + item.getName() + "</td><td>$" + item.getPrice() + "</td><td>Add to Cart<input type='checkbox' name='cartItem' value=" + item.getProductNumber()+ "></td></tr>");
                    }
                %>

            </table>
            <br>
            <input type="submit" value="Purchase">
        </form>
        </center>
    </div>
    </center>
</div>
</body>
</html>
