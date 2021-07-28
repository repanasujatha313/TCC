/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class Logindao {
    public static boolean storeInto(String name,String email,String password,String phone){
    
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
            String s="insert into RegistrationTable(name,email,password,phone)values(?,?,?,?)";
            ps=(PreparedStatement) con.prepareStatement(s);
            ps.setString(1,name);
            ps.setString(2,email);
            ps.setString(3,password);
            ps.setString(4,phone);
            
            i=ps.executeUpdate();
            
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Logindao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Logindao.class.getName()).log(Level.SEVERE, null, ex);
       }
        if(i>0)
            return true;
        else
            return false;
            
    }
    /*public static boolean validate(String name,String email,String password,String phone) {
        boolean status=false;
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
            
            pst=(PreparedStatement) conn.prepareStatement("select * from RegistrationTable where name=? and email=? and password=? and phone=?");
            pst.setString(1,name);
            pst.setString(2,email);
            pst.setString(3,password);
            pst.setString(4,phone);
            
            rs=pst.executeQuery();
            status=rs.next();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Logindao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Logindao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(conn != null){
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(pst != null){
                try{
                    pst.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
        if(rs != null){
            try{
                rs.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
        return status;
    }*/

    
}
