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

/**
 *
 * @author student
 */
public class storeRequest {
    public static boolean storeIntoDb(String cid,String cname,String csize,String distance,String status,String deliver,String paymentStatus){
        int i=0,c=0;
        String p = "Not paid";
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        String url="jdbc:mysql://localhost:3306/Transport";
        String driver="com.mysql.jdbc.Driver";
        String userName="root";
        String passWord="rgukt123";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection(url,userName,passWord);
            String s="insert into RequestDb(C_id,C_name,C_size,D_distance,Status,DeliveryStatus,PaymentStatus)values(?,?,?,?,?,?,?)";
            ps=(PreparedStatement) con.prepareStatement(s);
            ps.setString(1,cid);
            ps.setString(2,cname);
            ps.setString(3,csize);
            ps.setString(4,distance);
            ps.setString(5,status);
            ps.setString(6,deliver);
            ps.setString(7, paymentStatus);
            i=ps.executeUpdate();
            
           
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        if(i>0){
            return true;
        }   
        else
            return false;
    }
}
