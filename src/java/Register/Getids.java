/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author student
 */
public class Getids extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Getids</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            
            
            
            out.println(request.getAttribute("Cid"));
            out.println(request.getAttribute("Did"));
            out.println(request.getAttribute("Vid"));
            /*int i=0;
            Connection con=null;
            PreparedStatement ps=null;
            ResultSet rs=null;
        
            String url="jdbc:mysql://localhost:3306/Transport";
            String driver="com.mysql.jdbc.Driver";
            String userName="root";
            String passWord="rgukt123";
            try{
                Class.forName("com.mysql.jdbc.Driver");
                con=(Connection) DriverManager.getConnection(url,userName,passWord);
                String s="insert into DeliveryStatus(Cid,Did,Vid,Status)values(?,?,?,?)";
                ps=(PreparedStatement) con.prepareStatement(s);
                ps.setString(1,cid);
                ps.setString(2,did);
                ps.setString(3,vid);
                ps.setString(4,"notDelivered");
            
                i=ps.executeUpdate();
            
            }
            catch(Exception e){
                e.printStackTrace();
            }
            if(i>0){
                out.println("Successful");
            }
            else
                out.println("not Successful");*/
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
