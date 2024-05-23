import java.util.Random; 
import java.util.ArrayList;

public class Discipline{

private static Random ran = new Random(); 

// method for getting a random discipline
public ArrayList<String> getRandomDiscipline(){
ArrayList <String> disciplines = new ArrayList<>();
disciplines.add("FREESTYLE"); 
disciplines.add("BUTTERFLY"); 
disciplines.add("BACKSTROKE"); 
disciplines.add("BREASTSTROKE"); 

int randomIndex = ran.nextInt(disciplines.size());  
   ArrayList<String> randomDiscipline = new ArrayList<>();
   randomDiscipline.add(disciplines.get(randomIndex));

return randomDiscipline; 

   }
}