import java.util.Random; 
import java.util.ArrayList;

public class Discipline{

private static Random ran = new Random(); 

 public enum Disciplines{
   FREESTYLE, BUTTERFLY, BACKSTROKE, BREASTSTROKE, CRAWL
   }
 
 public ArrayList<String> getRandomDiscipline(){
   ArrayList <String> disciplineList = new ArrayList<>(); // creates an arrayList so that the enum can be converted to a String of the ArrayList
   Disciplines[] disciplines = Disciplines.values(); // gets all the values from the enum
   Disciplines randomDiscipline = disciplines[ran.nextInt(disciplines.length)]; // returns a random discipline 
   disciplineList.add(randomDiscipline.name()); // adds the name of the random discipline to the arrayList
   return disciplineList;
 
 }


}