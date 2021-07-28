/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register;

/**
 *
 * @author student
 */
public class user {
  
    String name;
    String email;
    String password;
    String phone;
    
    public user(){
        
    }
    public user(String name,String email,String password,String phone){
        this.name=name;
        this.email=email;
        this.password=password;
        this.phone=phone;
    }
    public user(String email,String password,String phone){
        this.email=email;
        this.password=password;
        this.phone=phone;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
}
