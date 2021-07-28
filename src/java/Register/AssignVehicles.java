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
public class AssignVehicles extends HttpServlet {

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
            out.println("<title>Servlet AssignVehicles</title>");            
            out.println("</head>");
            out.println("<body>");
          
            
            String vid=request.getParameter("Vid");
            int i=0;
          
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
                 ps=(PreparedStatement) con.prepareStatement("update VehiclesDb set Status=? where Number=?");
                 ps.setString(1, "unavailabe");
                 ps.setString(2,vid);
                 ps.executeUpdate(); 
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
            try{
                Class.forName(driver);
                con=(Connection) DriverManager.getConnection(url,userName,passWord);
                 ps=(PreparedStatement) con.prepareStatement("select * from RequestDb;");
                 rs=ps.executeQuery();
                 
                out.println("<table border=1 width=50% height=50%>");
                out.println("<tr><th>C_id</th><th>C_name</th><th>C_size</th><th>D_distance</th><th>Status</th><th>DeliveryStatus</th></tr>");
                 while(rs.next()){
                    String id=rs.getString("C_id");
                    String n=rs.getString("C_name");
                    String si=rs.getString("C_size");
                    String d=rs.getString("D_distance");
                    String st=rs.getString("Status");
                    String ds=rs.getString("DeliveryStatus");
                    out.println("<tr><td>"+id+"</td><td>"+n+"</td><td>"+si+"</td><td>"+d+"</td><td>"+st+"</td><td>"+ds+"</td></tr>");
                    i=1;
                }  
            }
            catch(Exception e){
                e.printStackTrace();
            }
            if(i==1){
                out.println("request approved successfully..");
                out.println("<a href=ViewRequests>back</a>");
            }
            /*try{
                Class.forName(driver);
                con=(Connection) DriverManager.getConnection(url,userName,passWord);
                 ps=(PreparedStatement) con.prepareStatement("select * from VehiclesDb;");
                 rs=ps.executeQuery();
                 
                out.println("<table border=1 width=50% height=50%>");
                out.println("<tr><th>Vehicle name</th><th>Number</th><th>Status</th></tr>");
                 while(rs.next()){
                    String n=rs.getString("VehicleName");
                    String id=rs.getString("Number");
                    String s=rs.getString("Status");
                    
                    out.println("<tr><td>"+n+"</td><td>"+id+"</td><td>"+s+"</td></tr>");
                    
                }  
            }
            catch(Exception e){
                e.printStackTrace();
            }*/
            
            
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
