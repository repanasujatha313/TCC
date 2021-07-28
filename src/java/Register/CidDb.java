/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class CidDb {

    public static boolean storeIntomakePayment(String cid, String did) {

        int c = 0;
        String p = "Not paid";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

       
        
        String url = "jdbc:mysql://localhost:3306/Transport";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String passWord = "rgukt123";
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url, userName, passWord);
            String s="insert into makePayment(consignmentId,Money,PaymentStatus,destination) values(?,?,?,?)";
            ps=(PreparedStatement) con.prepareStatement(s);
            ps.setString(1,cid);
            ps.setString(2,"0");
            ps.setString(3,p);
            ps.setString(4,did);
            c=ps.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CidDb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CidDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (c > 0) {
            return true;
        } else {
            return false;
        }
    }
}
