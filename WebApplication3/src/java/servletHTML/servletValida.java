/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletHTML;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kemry
 */


public class servletValida extends HttpServlet {

    

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String claveSesion = "";
        String usSesion = "";

        base DatB = null;
        
        response.setContentType("text/html");
        HttpSession sesion = request.getSession();
        String titulo = null;
        claveSesion = (String) sesion.getAttribute("claveSesion");
        usSesion = (String) sesion.getAttribute("usSesion");

        try {
            DatB = new base();
            DatB.conecta();
            ResultSet res = DatB.query("select * from usuario where us='" + usSesion + "' and pas='" + claveSesion + "';");

            if (res.next()) {
                titulo = "llave correcta continua la sesion";
            }else{
                titulo = "llave incorrecta inicie nuevamente sesion";
            }

            DatB.cierra();
            
        } catch (SQLException ex) {
            
            Logger.getLogger(servletValida.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter out = response.getWriter();
        out.println("¿Continua la Sesion y es valida?: " + titulo);
        out.println("<br>");
        out.println("ID de la sesi&oacute;n JSESSIONID: " + sesion.getId());

    }

}
