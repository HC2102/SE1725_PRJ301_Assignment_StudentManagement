/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbObject;

/**
 *
 * @author dange
 */
public class Admin {
    String admin_username;
    String admin_name;
    String admin_Address;
    String admin_phonenumber;
    String admin_email;

    public Admin(String admin_username, String admin_name, String admin_Address, String admin_phonenumber, String admin_email) {
        this.admin_username = admin_username;
        this.admin_name = admin_name;
        this.admin_Address = admin_Address;
        this.admin_phonenumber = admin_phonenumber;
        this.admin_email = admin_email;
    }
    public Admin(){}

    public String getAdmin_username() {
        return admin_username;
    }

    public void setAdmin_username(String admin_username) {
        this.admin_username = admin_username;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_Address() {
        return admin_Address;
    }

    public void setAdmin_Address(String admin_Address) {
        this.admin_Address = admin_Address;
    }

    public String getAdmin_phonenumber() {
        return admin_phonenumber;
    }

    public void setAdmin_phonenumber(String admin_phonenumber) {
        this.admin_phonenumber = admin_phonenumber;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    @Override
    public String toString() {
        return "Admin{" + "admin_username=" + admin_username + ", admin_name=" + admin_name + ", admin_Address=" + admin_Address + ", admin_phonenumber=" + admin_phonenumber + ", admin_email=" + admin_email + '}';
    }
    
}
