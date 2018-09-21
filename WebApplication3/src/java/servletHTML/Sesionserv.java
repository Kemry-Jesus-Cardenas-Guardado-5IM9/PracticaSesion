/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Kemry
 */
package servletHTML;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Sesionserv extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomb;
        String apell;
        nomb = request.getParameter("nom");
        apell = request.getParameter("ape");

        HttpSession sesion = request.getSession();
        sesion.setAttribute("usSesion", nomb);
        sesion.setAttribute("claveSesion", apell);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<a href=\"/PSesiones/cat.jsp\"> Link al catalogo del carrito  </a>");
        out.println("<br>");
        out.println("ID de la sesi&oacute;n: " + sesion.getId());
    }

}