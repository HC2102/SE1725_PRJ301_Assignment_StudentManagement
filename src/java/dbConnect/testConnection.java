/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbConnect;
import java.sql.*;
/**
 *
 * @author HE170417
 */
public class testConnection {
    //bam shift f6 de chay file
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        try{
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if(con!=null){
                System.out.println("Connection success");
            }else{
                System.out.println("Connection failed");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
