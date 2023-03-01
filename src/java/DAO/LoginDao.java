/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Login.LoginBeans;
import dbConnect.DBContext;
import java.sql.*;
/**
 *
 * @author HE170417
 */
public class LoginDao {
    public String  authenticateUser(LoginBeans loginbean){
        DBContext db = new DBContext();
        String userName = loginbean.getUserName();
        String password = loginbean.getPassword();
        Connection con  = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String userNameDB, passwordDB,roleDB = "";
        try{
            con = db.getConnection();
            statement = con.createStatement(); // prepare for statement
            // take the user table
            resultSet = statement.executeQuery("select User_name, User_Password, Role_ID from User");
            //check the table to find the user name and password
            while(resultSet.next()){
                userNameDB = resultSet.getString("User_name");
                passwordDB = resultSet.getString("User_Password");
                roleDB = resultSet.getString("Role_ID");
                if(userName.equals(userNameDB)&&password.equals(passwordDB)&&roleDB.equals("0")){
                    return "Admin";
                }
                if(userName.equals(userNameDB)&&password.equals(passwordDB)&&roleDB.equals("1")){
                    return "Student";
                }
                if(userName.equals(userNameDB)&&password.equals(passwordDB)&&roleDB.equals("2")){
                    return "Teacher";
                }
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "Invalid user role";
                
    }
}
