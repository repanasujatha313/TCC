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
public class UpdateServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateServlet</title>");            
            out.println("</head>");
            out.println("<body>");
           
         
            Connection conn=null;
            PreparedStatement pst=null;
            ResultSet rs=null;
           
            
            String url="jdbc:mysql://localhost:3306/Transport";
            String driver="com.mysql.jdbc.Driver";
            String userName="root";
            String passWord="rgukt123";
            
            boolean i=false;
            String st="Approved";
            String ds="Not Delivered";
          
            try{
                Class.forName(driver);
                conn=(Connection) DriverManager.getConnection(url,userName,passWord);
                String query="select * from RequestDb where Status='"+st+"'and DeliveryStatus='"+ds+"'";
                pst=(PreparedStatement) conn.prepareStatement(query);
                rs=pst.executeQuery();
                
                out.println("<table border=1 width=50% height=50%>");
                out.println("<tr><th>Consignment id</th><th>Consignment name</th><th>Consignment size</th><th>Destination distance</th><th>Status</th><th>DeliveryStatus</th><th>preparePayment</th></tr>");
              
                while(rs.next()){
                  
                    String id=rs.getString("C_id");
                    //String name=rs.getString("C_name");
                    //String size=rs.getString("C_size");
                    String dist=rs.getString("D_distance");
                    //String st1=rs.getString("Status");
                    //String ds1=rs.getString("DeliveryStatus");
                   
                    /*out.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+size+"</td><td>"+dist+"</td><td>"+st1+"</td><td>"+ds1+"</td><td><a href=payment?Did="+dist+">proceed</a></td></tr>");*/
                    i=CidDb.storeIntomakePayment(id,dist);
                }
                if(i){
                    out.println("successful");
                   
                }
                else{
                    out.println("not successful");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            RequestDispatcher rd=request.getRequestDispatcher("PreparePayment");
            rd.forward(request, response);
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
