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
public class SalaryStatus extends HttpServlet {

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
            out.println("<title>Servlet SalaryStatus</title>");            
            out.println("</head>");
            out.println("<body>");
            
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
                ps=(PreparedStatement) con.prepareStatement("select * from SalaryDb");
                rs=ps.executeQuery();
                
                out.println("<table border=1 width=50% height=50%>");
                out.println("<tr><th>DriverId</th><th>SalaryOfCurrentMonth</th></tr>");
                 while(rs.next()){
                    String v=rs.getString("Driverid");
                    String n=rs.getString("SalaryOfCurrentMonth");
                    out.println("<tr><td>"+v+"</td><td>"+n+"</td></tr>");
                    
                }  
            }
            catch(Exception e){
                e.printStackTrace();
            }
            out.println("<a href=Driver.jsp>home</a>");
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
