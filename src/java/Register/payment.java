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
public class payment extends HttpServlet {

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
            out.println("<title>Servlet payment</title>");            
            out.println("</head>");
            out.println("<body>");
            String di=request.getParameter("Did");
            /*int l=di.length();
            int s1=di.indexOf("_");
            out.println(l);
            out.println(s1);
            StringBuffer s2=new StringBuffer("");
            while(s1<l-1){
                char c=di.charAt(s1+1);
                s2.append(c);
                s1++;
            }
            out.println(s2);
            String s3=s2.toString();*/
            Integer num=Integer.valueOf(di);
            //out.println(num);
            double dnum=(((num*2)/15)*150);
            int my=(int)dnum;
            String money=String.valueOf(my);
            out.println(money);
            /*boolean i1=false;
            out.println(i1);
            if(CidDb.storeIntomakePayment(di,s3)){
                    out.println("successful");
            }
            else{
                    out.println("not successful");
            }*/
            int i=0,x=0;
            Connection conn=null;
            PreparedStatement pst=null;
            ResultSet rs=null;
        
            String url="jdbc:mysql://localhost:3306/Transport";
            String driver="com.mysql.jdbc.Driver";
            String userName="root";
            String passWord="rgukt123";
             try{
                i=0;
                Class.forName(driver);
                conn=(Connection) DriverManager.getConnection(url,userName,passWord);
                pst=(PreparedStatement) conn.prepareStatement("update makePayment set Money=? where destination=?");
                pst.setString(1,money);
                pst.setString(2,di);
                pst.executeUpdate();
                i=1;
             
               /* if(i==1){
                    out.println("successful");
                    RequestDispatcher rd=request.getRequestDispatcher("UpdateServlet");
                    rd.forward(request, response);
                }
                else{
                    out.println("not successful");
                }*/
            }
            catch(Exception e){
                e.printStackTrace();
            }
            if(i==1){
                    out.println("successful");
                    /*RequestDispatcher rd=request.getRequestDispatcher("UpdateServlet");
                    rd.forward(request, response);*/
            }
            else{
                    out.println("not successful");
            }
            try{
                Class.forName(driver);
                conn=(Connection) DriverManager.getConnection(url,userName,passWord);
                String query="select * from makePayment";
                pst=(PreparedStatement) conn.prepareStatement(query);
                rs=pst.executeQuery();
                
                out.println("<table border=1 width=50% height=50%>");
                out.println("<tr><th>Consignment id</th><th>Money</th><th>PaymentStatus</th><th>destination</th></tr>");
              
                while(rs.next()){
                  
                    String id=rs.getString("consignmentId");
                    String name=rs.getString("Money");
                    String size=rs.getString("PaymentStatus");
                    String dest=rs.getString("destination");
                    out.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+size+"</td><td>"+dest+"</td></tr>");
                    
                }
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
            out.println("<a href=managerfun.jsp>Manager Functionalities</a><br/>");
            /*if(x==0){
                out.println(my);
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
