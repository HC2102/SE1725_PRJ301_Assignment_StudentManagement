/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package outsideObject;

/**
 *
 * @author HE170417
 */
public class UserCommon {
    private String username;
    private String  name;
    private String  Address;
    private String  phonenumber;
    private String  email;

    public UserCommon() {
    }

    public UserCommon(String username, String name, String Address, String phonenumber, String email) {
        this.username = username;
        this.name = name;
        this.Address = Address;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserCommon{" + "username=" + username + ", name=" + name + ", Address=" + Address + ", phonenumber=" + phonenumber + ", email=" + email + '}';
    }
    
}
