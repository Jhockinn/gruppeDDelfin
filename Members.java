import java.util.*;
import java.io.*;
import java.time.*;

public class Members{
   //Stamoplysning 
   Random rand = new Random();
   Chairman main = new Chairman();
   private boolean restance;
   private int age; 
   private String name; 
   private boolean active; 
   private boolean competitor;
   private LocalTime time;
   private double price; 
   private boolean gender;
   private String discipline; 
   public int ID;
   int year = LocalDate.now().getYear(); 
     
   public Members(int age,String name){
      this.age = age;
      this.name = name;
      
   }
   
   // Setters and getters
   public void setAge(int birthYear){
      this.age = year - birthYear;
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
   public boolean getGender(){
      return gender;
   }
   
   public void setGender(boolean gender){
      this.gender = gender;
   }
   
   public int getID(){
      return ID;
   }
   
   public void setID(int ID){
      this.ID = ID;
   }
   public String getDiscipline(){
      return discipline;
   }
   public void setDiscipline(String discipline){
      this.discipline = discipline;
   }
   public void setRestance(boolean restance){
      this.restance = restance;
   }
   public boolean getRestance(){
      return restance;
   }
   public String toString(){
        return "[" + " ID: " + ID + ", Name: " + name + " Age: " + age + ", Gender: " + main.chooseGender(this) + ", Restance: "+ restance + ", Active: " + active + " Competitive: " + competitor + ", Discipline: " + discipline +" ]" + "\n";
   }
   public void restan(int memberPrice){
       
      if(price > memberPrice){
         setRestance(false); 
      }
      else{
         setRestance(true);
      }
   }
 }  

