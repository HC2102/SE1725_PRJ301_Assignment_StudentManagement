/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbObject;

/**
 *
 * @author dange
 */
public class Test {
    String test_id;
    String Course_id;
    String test_name;
    int weight;

    public Test(String test_id, String Course_id, String test_name, int weight) {
        this.test_id = test_id;
        this.Course_id = Course_id;
        this.test_name = test_name;
        this.weight = weight;
    }
    public Test(){}
    public String getTest_id() {
        return test_id;
    }

    public void setTest_id(String test_id) {
        this.test_id = test_id;
    }

    public String getCourse_id() {
        return Course_id;
    }

    public void setCourse_id(String Course_id) {
        this.Course_id = Course_id;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Test{" + "test_id=" + test_id + ", Course_id=" + Course_id + ", test_name=" + test_name + ", weight=" + weight + '}';
    }
    
}
