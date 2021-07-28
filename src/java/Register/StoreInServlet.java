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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author student
 */
public class StoreInServlet extends HttpServlet {

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
            out.println("<title>Servlet StoreInServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            int i=0;
            String n=request.getParameter("uname");
            String e=request.getParameter("email");
            String p=request.getParameter("pwd");
            String ph=request.getParameter("phno");
            
             if(Logindao.storeInto(n,e,p,ph)){
                 i=1;
               /*out.println(n);
                out.println(e);
                 out.println(p);
                  out.println(ph);*/
               
            }
       
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        
        String url="jdbc:mysql://localhost:3306/Transport";
        String driver="com.mysql.jdbc.Driver";
        String userName="root";
        String passWord="rgukt123";
        
        try{
            Class.forName(driver);
            conn=(Connection) DriverManager.getConnection(url,userName,passWord);
            
            pst=(PreparedStatement) conn.prepareStatement("select * from RegistrationTable where email=?;");
            pst.setString(1,e);
            rs=pst.executeQuery();
            
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>Name</th><th>Email</th><th>Password</th><th>Phone</th></tr>");
             while(rs.next()){
                String name=rs.getString("name");
                String email=rs.getString("email");
                String password=rs.getString("password");
                String phone=rs.getString("phone");
                out.println("<tr><td>"+name+"</td><td>"+email+"</td><td>"+password+"</td><td>"+phone+"</td></tr>");
            }
             
             out.println("</table>");
             out.println("you registered successfully to TCC");
             out.println("<a href=index.jsp>home</a>");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Logindao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Logindao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
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
        
       // response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
          /* //fetch data from registration page
            String n=request.getParameter("uname");
            String e=request.getParameter("email");
            String p=request.getParameter("pwd");
            String ph=request.getParameter("phno");
            
            
          if(Logindao.storeInto(n,e,p,ph)){
               out.println(n);
                out.println(e);
                 out.println(p);
                  out.println(ph);
               
            }
            if(Logindao.validate(n, e, p, ph)){
                RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
                rd.forward(request,response);
            }
            else{
                out.print("<p style=\"color:red\">Sorry username or password error</p>");
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                rd.include(request,response);
            }*/
            out.close();
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
