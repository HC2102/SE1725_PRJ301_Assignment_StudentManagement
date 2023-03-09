/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbObject;

/**
 *
 * @author HE170417
 */
public class Major {
    private String ID,name,bio;

    public Major() {
    }

    public Major(String ID, String name, String bio) {
        this.ID = ID;
        this.name = name;
        this.bio = bio;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "Major{" + "ID=" + ID + ", name=" + name + ", bio=" + bio + '}';
    }
    
}
