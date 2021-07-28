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
public class AssignedRequests extends HttpServlet {

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
            out.println("<title>Servlet AssignedRequests</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<FONTSIZE=+2><B>deliver the consignment,which  is paid</B></FONTSIZE>");
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
                String query="select * from makePayment";
                pst=(PreparedStatement) conn.prepareStatement(query);
                rs=pst.executeQuery();
                
                out.println("<table border=1 width=50% height=50%>");
                out.println("<center><tr><th>C_id</th><th>Money</th><th>PaymentStatus</th><th>destination</th></tr></center>");
                 while(rs.next()){
                    String id=rs.getString("consignmentId");
                    String m=rs.getString("Money");
                    String ps=rs.getString("PaymentStatus");
                    String d=rs.getString("destination");
                  
                    
                    out.println("<center><tr><td>"+id+"</td><td>"+m+"</td><td>"+ps+"</td><td>"+d+"</td></tr></center>");
                 }
                    
            }
            catch(Exception e){
                e.printStackTrace();
            }
            out.println("<a href=DeliverConsignment>proceedToDeliver</a><br/>");
            out.println("<a href=Driver.jsp>Home</a>");
            /*String status="Approved";
            try{
                Class.forName(driver);
                conn=(Connection) DriverManager.getConnection(url,userName,passWord);
                String query="select * from RequestDb where Status='"+status+"'";
                pst=(PreparedStatement) conn.prepareStatement(query);
                rs=pst.executeQuery();
                
                out.println("<table border=1 width=50% height=50%>");
                out.println("<center><tr><th>C_id</th><th>C_name</th><th>C_size</th><th>D_distance</th><th>Status</th><th>DeliveryStatus</th><th>Action</th></tr></center>");
                 while(rs.next()){
                    String id=rs.getString("C_id");
                    String n=rs.getString("C_name");
                    String si=rs.getString("C_size");
                    String d=rs.getString("D_distance");
                    String s=rs.getString("Status");
                    String ds=rs.getString("DeliveryStatus");
                    
                    out.println("<center><tr><td>"+id+"</td><td>"+n+"</td><td>"+si+"</td><td>"+d+"</td><td>"+s+"</td><td>"+ds+"</td><td><a href=Deliver?Cid="+id+">deliver</a></td></tr></center>");
                 }
                    
            }
            catch(Exception e){
                e.printStackTrace();
            }
           */
            
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
