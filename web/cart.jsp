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
    <title>Scott's Essential Oils - Cart</title>
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
        <h3>Shopping Cart</h3>

        <form action="bill.go">
            <table>
                <%
                    List recs = (List) request.getAttribute("catalog");
                    Iterator it = recs.iterator();
                    double total = 0;
                    while (it.hasNext()) {
                        Item item = (Item) it.next();
                        out.print("<tr class='purch'><td> " + item.getName() + " </td><td>" +
                                String.format("$%3.2f",item.getPrice()) + "</td></tr>");
                        total+=item.getPrice();
                    }
                    out.print("<tr class='total' ><td>Total:</td><td>" +
                            String.format("$%3.2f",total) + "</td></tr>");
                %>
            </table>
            <br>
            <input type="submit" value="Complete Order">
        </form>

    </div>
    </center>
</div>
</body>
</html>
