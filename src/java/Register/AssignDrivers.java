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
public class AssignDrivers extends HttpServlet {

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
            out.println("<title>Servlet AssignDrivers</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<FONT SIZE=+2><b><center>Assign the Corresponding Vehicle....!</FONT></b></center><br/><br/>");
            String did=request.getParameter("Did");
            out.println("Driver id="+did);
            out.println("<br>Ex:if Driver id is 'tccdriver1',then Vehicle name is 'TcVehicle1'");
            Connection con=null;
            PreparedStatement ps=null;
            ResultSet rs=null;
            
            String url="jdbc:mysql://localhost:3306/Transport";
            String driver="com.mysql.jdbc.Driver";
            String userName="root";
            String passWord="rgukt123";
            try{
                Class.forName(driver);
                con=(Connection) DriverManager.getConnection(url,userName,passWord);
                 ps=(PreparedStatement) con.prepareStatement("update driverDb set Status=? where id=?");
                 ps.setString(1, "unavailabe");
                 ps.setString(2,did);
                 ps.executeUpdate(); 
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
            int i=0;
            try{
                Class.forName(driver);
                con=(Connection) DriverManager.getConnection(url,userName,passWord);
                
                ps=(PreparedStatement) con.prepareStatement("select * from VehiclesDb;");
                rs=ps.executeQuery();
                
                out.println("<table border=1 width=50% height=50%>");
                out.println("<tr><th>VehicleName</th><th>Number</th><th>Status</th><th>Action</th></tr>");
                 while(rs.next()){
                    String n=rs.getString("VehicleName");
                    String id=rs.getString("Number");
                    String s=rs.getString("Status");
                     
                    
                    out.println("<tr><td>"+n+"</td><td>"+id+"</td><td>"+s+"</td><td><a href=AssignVehicles?Vid="+id+">Assign</a><br></td></tr>");
                
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
