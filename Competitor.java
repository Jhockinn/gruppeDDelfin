import java.util.*;

public class Competitor{

String name; 
int age; 
ArrayList<String> discipline; 

   public Competitor(int age,String name, ArrayList<String> discipline){
      this.age = age; 
      this.name = name;  
      this.discipline = discipline; 
   }

   public Competitor(int age,String name){
      this.age=age; 
      this.name=name; 
     
   }

   // getters & setters 
   public void setAge(int age){
      this.age = age;
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

 
   public void setDiscipline(ArrayList<String> discipline){
      this.discipline = discipline;  
   }

   public ArrayList<String> getDiscipline() {
      return discipline; 
   }
}