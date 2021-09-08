/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicMain;

/**
 *
 * @author maxaj
 */
public class Student {
    private String fName, lName;
    private int id, age, attend;
   
   //Student Object constructor overloaded with inputs for all private varibles
   public Student(int sid, String f, String l, int a, int att){
      id = sid;
      fName = f;
      lName = l;
      age = a;
      attend = att;
   }

   //Returns private String fName
    public String getfName() {
        return fName;
    }

    //Returns private String lName
    public String getlName() {
        return lName;
    }

    //Returns private int id
    public int getId() {
        return id;
    }
 
    //Returns private int age
    public int getAge() {
        return age;
    }

    //Returns private int attend
    public int getAttend() {
        return attend;
    }

    //Sets the private String fName to the given String
    public void setfName(String fName) {
        this.fName = fName;
    }

     //Sets the private String lName to the given String
    public void setlName(String lName) {
        this.lName = lName;
    }

     //Sets the private int age to the given Integer
    public void setAge(int age) {
        this.age = age;
    }

     //Sets the private int attend to the given Integer
    public void setAttend(int attend) {
        
        this.attend = attend;
    }
    
    

    
   
    @Override
    //Returns a String describing the Student object
   public String toString(){
       //return id + " " + fName + " " + lName + ": u" + age + " " + attend;
       return id + ", " + fName + ", " + lName + ", " + age + ", " + attend; 
   } 
   
//   public String toStringPopulate(){
//        
//   }
 
    
}
