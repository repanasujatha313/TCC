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
public class UpdatePayment extends HttpServlet {

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
            out.println("<title>Servlet UpdatePayment</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String id=request.getParameter("id");
            String m=request.getParameter("money");
            
            int i=0;
           
           // out.println(id);
            //out.println(m);
            Connection conn=null;
            PreparedStatement pst=null;
            ResultSet rs=null;
        
            String url="jdbc:mysql://localhost:3306/Transport";
            String driver="com.mysql.jdbc.Driver";
            String userName="root";
            String passWord="rgukt123";
             try{
                Class.forName(driver);
                conn=(Connection) DriverManager.getConnection(url, userName,passWord);
                pst=(PreparedStatement) conn.prepareStatement("select * from makePayment where consignmentId=?");
                pst.setString(1,id);
                rs=pst.executeQuery();
               while( rs.next())
               {    
                    String money;
                    money=rs.getString("Money");
                    if(m.compareTo(money)==0){
                            i=1;
                    }
                    else
                    {
                        i=0;
                    }
               }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            if(i==1){
                try{
                    Class.forName(driver);
                    conn=(Connection) DriverManager.getConnection(url, userName,passWord);
                    String query="update makePayment set PaymentStatus=? where consignmentId=?";
                    pst=(PreparedStatement) conn.prepareStatement(query);
                    pst.setString(1, "paid");
                    pst.setString(2, id);
                    pst.executeUpdate();
                    out.println("done");
                    out.println("Payment Successful..");
                  }
                  catch(Exception e){
                    e.printStackTrace();
                 }
                try{
                    Class.forName(driver);
                    conn=(Connection) DriverManager.getConnection(url, userName,passWord);
                    String query="update RequestDb set PaymentStatus=? where C_id=?";
                    pst=(PreparedStatement) conn.prepareStatement(query);
                    pst.setString(1, "paid");
                    pst.setString(2, id);
                    pst.executeUpdate();
                    out.println("done");
                    out.println("Payment Successful..");
                  }
                  catch(Exception e){
                    e.printStackTrace();
                 }
            }
            else{
                out.println("payment not successful,so please pay valid amount");
            }
            
            /*try{
                Class.forName(driver);
                conn=(Connection) DriverManager.getConnection(url, userName,passWord);
                String q="select * from makePayment where consignmentId='"+id+"'";
                pst=(PreparedStatement) conn.prepareStatement(q);
                rs=pst.executeQuery();
                
                String money=rs.getString("Money");
                   
               if(m.compareTo(money)==0){
                            //out.println("sdfghjkh");
                            i=1;
                            /*RequestDispatcher rd=request.getRequestDispatcher("UpdateServlet");
                            request.setAttribute("Cid",id);
                            rd.forward(request,response);
                           
                }
                else
                {
                            /*RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
                            rd.forward(request,response);
                            out.println("Payment not successful..");
                }
               
            }
            catch(Exception e){
                e.printStackTrace();
            }*/
            //out.println(id);
           
               
            
            out.println("<a href=Sender.jsp>Home</a>");
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
