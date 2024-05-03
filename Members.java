import java.util.*;
import java.io.*;
import java.time.*;

public class Members{
   //Stamoplysning 
   private int age = 0; 
   private String name; 
   private boolean active; 
   private boolean competitor;
   private LocalTime time;
   private double price; 
   
   public Members(int age,String name,double price){
      this.age = age;
      this.name = name;
      this.price = price; 
      
   }
   public void setAge(int age){
      this.name = name;
   }
   
   public int getAge(){
      return age;
   }
 
   
   public void setName(String name){
      this.name = name;
   }
   
   public String getName(){
      return name;
   }
   
   public void setActive(boolean activ){
      this.active = activ;
   }
   
   public boolean getActive(){
      return active;
   }
   
   public void setCompetitor(boolean comp){
      this.competitor = comp;
   }
   
   public boolean getCompetitor(){
      return competitor;
   }
   
   public void setTime(LocalTime time){
      this.time = time;
   }
   
   public LocalTime getTime(){
      return time;
   }

   public void setPrice(double price){
      this.price = price;
   }
   
   public double getPrice(){
      return price;
   }
   
   public String toString(){
        return "age: " + age + " name: " + name + " Price: "+ price+ "\n";
   }


}