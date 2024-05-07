import java.util.*;
public class Login{
      Scanner scan = new Scanner(System.in);
      Trainer trainer = new Trainer();
      Chairman chairman = new Chairman();
      Cashier cashier = new Cashier();
      //logins for diffrent users. 
      String chairUser = "Chairman";
      String chairPass = "TheBoss";
      
      String cashUser = "Cashier";
      String cashPass = "Embezzler";
      
      String trainUser = "Trainer";
      String trainPass = "AsbjørnRiis";
      
      String username;
      String password;
     
   public void login(){
      do{
      System.out.println("Welcome to the system");
      System.out.println("login or stop?");
      String close = scan.nextLine();
      if(close.equals("stop")){
      break;
      }
      System.out.println("Type in username: ");
      username = scan.nextLine();
      System.out.println("Type in password: ");
      password = scan.nextLine();
         if(username.equals(chairUser) && password.equals(chairPass)){
            do{
            //chairman.//set metode fra chairman her. 
            
            /*System.out.println("Welcome Chairman");
            System.out.println("What would you like to do?");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            int input = scan.nextInt();
               
               switch(input){
               case 1:
               break; 
               
               case 2: 
               break;
               
               case 3: 
               break;
               
               case 4:
               break; 
               
               default: 
               break;
               }//Switch*/
            }while(true);
         }
         if(username.equals(cashUser) && password.equals(cashPass)){
            do{
            //cashier.//set metode fra cashier her. 
            
            /*System.out.println("Welcome Chashier");
            System.out.println("What would you like to do?");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            int input = scan.nextInt();
               
               switch(input){
               case 1:
               break; 
               
               case 2: 
               break;
               
               case 3: 
               break;
               
               case 4:
               break; 
               
               default: 
               break;
               }//Switch*/
            }while(true);
         }
        if(username.equals(trainUser) && password.equals(trainPass)){
            do{
            //trainer.//set metode fra træner her. 
            
            /*System.out.println("Welcome Trainer");
            System.out.println("What would you like to do?");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            int input = scan.nextInt();
               
               switch(input){
               case 1:
               break; 
               
               case 2: 
               break;
               
               case 3: 
               break;
               
               case 4:
               break; 
               
               default: 
               break;
               }//Switch*/
            }while(true);
         }
         else{
            System.out.println("Wrong username or password, Try again!");
         }
      }while((username!=trainUser && password != trainPass) || (username!= cashUser && password!=cashPass) && 
      (username!=chairUser && password!=chairPass));
   }

}