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
public class checkWork extends HttpServlet {

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
            out.println("<title>Servlet checkWork</title>");            
            out.println("</head>");
            out.println("<body>");
           
            String did=request.getParameter("id");
            String vid=request.getParameter("vname");
            String av="Available";
            String status="Approved";
            
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
                String query="select * from driverDb where id= '"+did+"'";
                pst=(PreparedStatement) conn.prepareStatement(query);
                rs=pst.executeQuery();
                rs.next();
                
                String id=rs.getString("id");
                String n=rs.getString("name");
                String p=rs.getString("password");
                String a=rs.getString("Status");
                //out.println(a);
                //out.println(av);
                if(av.compareTo(a)==0)
                {
                    out.println("<FONTSIZE=+2>work is not assigned</FONTSIZE><br/>");
                    out.println("<B><a href=Driver.jsp>proceed</a></B>");
                }
                else{
                    out.println("<FONTSIZE=+2>work is assigned for you</FONTSIZE><br/>");
                    out.println("<B><a href=DeliverConsignment>proceed</a></B>");
                }
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
            /*try{
                Class.forName(driver);
                conn=(Connection) DriverManager.getConnection(url,userName,passWord);
                pst=(PreparedStatement) conn.prepareStatement("update driverDb set Status=? where id=?");
                pst.setString(1, "Available");
                pst.setString(2,did);
                pst.executeUpdate(); 
                i=1;
             
            }
            catch(Exception e){
                e.printStackTrace();
            }
            if(i==1){
                out.println("Successful");
            }
            else{
                 out.println("not Successful");
            }
            int c=0;
            try{
                Class.forName(driver);
                conn=(Connection) DriverManager.getConnection(url,userName,passWord);
                pst=(PreparedStatement) conn.prepareStatement("update VehiclesDb set Status=? where VehicleName=?");
                pst.setString(1, "Available");
                pst.setString(2,vid);
                pst.executeUpdate(); 
                c=1;
             
            }
            catch(Exception e){
                e.printStackTrace();
            }
            //if(c==1){
                out.println("Successful");
            }
            else{
                 out.println("not Successful");
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
