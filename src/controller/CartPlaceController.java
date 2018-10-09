package controller;

import model.Item;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class CartPlaceController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Enumeration paramNames = request.getParameterNames();
        String paramName;
        String theOrder = "";

        //read cookie if it exists and assign theOrder to the value

        Cookie cookie = null;
        Cookie[] cookies = null;
        // Get an array of Cookies associated with the this domain
        cookies = request.getCookies();
        PrintWriter out = response.getWriter();
        if( cookies != null ) {
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                out.print(cookie.getValue());
                if (cookie.getName().equals("cartItem")) {
                    theOrder = cookie.getValue() + ",";
                }
            }
        }

        //
        while(paramNames.hasMoreElements()) {
            paramName = (String)paramNames.nextElement();
            if(paramName.equals("cartItem")) {
                String[] paramValues = request.getParameterValues(paramName);
                // Read single valued data
                if (paramValues.length == 1) {
                    String paramValue = paramValues[0];
                    if (paramValue.length() == 0)
                        theOrder += "Empty Cart";
                    else
                        theOrder += paramValue;
                } else {
                    for (int i = 0; i < paramValues.length; i++) {
                        theOrder += paramValues[i] + ",";
                    }
                    theOrder = theOrder.substring(0, theOrder.length() - 1);
                }
            }
        }
        Cookie items = new Cookie("cartItem", theOrder);
        // Set expiry date after 24 Hrs for both the cookies.
        items.setMaxAge(60*60*24);
        response.addCookie( items );

        String site = new String("index.jsp");
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site);
    }
}
