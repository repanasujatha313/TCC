/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register;
import java.sql.*;
/**
 *
 * @author student
 */
public class UserDatabase {
   
        Connection con;
        public UserDatabase(Connection con){
            this.con=con;
        }
        public boolean saveUser(user user){
            
            boolean set=false;
            try{
               
                String query="insert into Registration_Table(name,email,password,phone_number)values(?,?,?,?)";

                PreparedStatement pt=con.prepareStatement(query);
                pt.setString(1,user.getName());
                pt.setString(2, user.getEmail());
                pt.setString(3, user.getPassword());
                pt.setString(4,user.getPhone());

                pt.executeUpdate();
                set=true;

            }
            catch(Exception e){
                e.printStackTrace();
            }
            return set;
    }   
}
