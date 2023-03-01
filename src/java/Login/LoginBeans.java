/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

/**
 *
 * @author HE170417
 */
public class LoginBeans {
    private String userName;
    private String password;
    //constructor
    public LoginBeans() {
    }

    public LoginBeans(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    //getter setter
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //toString

    @Override
    public String toString() {
        return "LoginBeans{" + "userName=" + userName + ", password=" + password + '}';
    }
    
    
}
