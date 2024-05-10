import java.util.*;
import java.io.*;
import java.time.format.*;
import java.time.*;

public class Competitive{
   Members memm = new Members(1, "Pete");
   Chairman chair = new Chairman();
   Random rand = new Random();
   Scanner scan = new Scanner(System.in);
   File file; 
   int count = -1;
   ArrayList<String> disci = new ArrayList<String>(); 
   public Competitive(){
   disci.add("Butterfly");
   disci.add("Freestyle");
   disci.add("Backstroke");
   disci.add("Breaststroke");
   }
   // Change boolean value at random 
   public void compe(ArrayList<Members> list){
      for(Members members : list){
         int random1 = rand.nextInt(1,10);
            if(random1>5){
               members.setCompetitor(false);
            }
            else{
               int random2 = rand.nextInt(0,4);
               members.setCompetitor(true);
               members.setDiscipline(disci.get(random2));
            }
      }
   }
   public void fileOrder(ArrayList<Members> list) {
        try {
            File file = new File("Trainer.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file, true);
            Scanner reader = new Scanner(file);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String dkDate = LocalDate.now().format(formatter);
            System.out.println("Write discipline");
            String discip = scan.nextLine();            
            writer.write("Discipline: [" + discip + "]\n");
            writer.write("Today's date: [" + dkDate + "]\n");
            writer.write("ID    Name      Time \n"); 
            if(reader.hasNextLine()){
               count++;
               writer.write(list.get(count).getName());
            }
            writer.close();
            } catch (Exception e) {
            e.printStackTrace();
        }

}}
