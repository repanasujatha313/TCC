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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author student
 */
public class ApproveRequests extends HttpServlet {

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
            out.println("<title>Servlet ApproveRequests</title>");            
            out.println("</head>");
            out.println("<body>");
           
            out.println("<FONT SIZE=+2><b><center>Assigning the Drivers....!</FONT></b></center><br/><br/>");
            
            String cid=request.getParameter("Cid");
            
            Connection conn=null;
            PreparedStatement pst=null;
            ResultSet rs=null;
            int i=0;
            String url="jdbc:mysql://localhost:3306/Transport";
            String driver="com.mysql.jdbc.Driver";
            String userName="root";
            String passWord="rgukt123";
            
           
            try{
                Class.forName(driver);
                conn=(Connection) DriverManager.getConnection(url,userName,passWord);
                pst=(PreparedStatement) conn.prepareStatement("update RequestDb set Status=? where C_id=?");
                pst.setString(1, "Approved");
                pst.setString(2,cid);
                pst.executeUpdate(); 
             
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
            try{
                Class.forName(driver);
                conn=(Connection) DriverManager.getConnection(url,userName,passWord);
                
                pst=(PreparedStatement) conn.prepareStatement("select * from driverDb;");
                rs=pst.executeQuery();
                
                out.println("<table border=1 width=50% height=50%>");
                out.println("<center><tr><th>Driver id</th><th>Driver name</th><th>Driver password</th><th>Status</th><th>Action</th></tr></center>");
                 while(rs.next()){
                    String id=rs.getString("id");
                    String n=rs.getString("name");
                    String p=rs.getString("password");
                    String a=rs.getString("Status");
                    
                    out.println("<center><tr><td>"+id+"</td><td>"+n+"</td><td>"+p+"</td><td>"+a+"</td><td><a href=AssignDrivers?Did="+id+">Assign</a><br/></td></tr></center>");
                   
                 }
            }
            catch(Exception e){
                e.printStackTrace();
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
