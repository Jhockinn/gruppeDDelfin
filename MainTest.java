import java.util.*;
import java.io.*;
public class MainTest{
  public static void main(String[]args){
      Competitive competi = new Competitive();
      Add AddMemb = new Add();
      Active acti = new Active();
      Login login = new Login();
      AddMemb.addNames();
      AddMemb.add();
      competi.compe(AddMemb.memberList);
      acti.active(AddMemb.memberList);
      AddMemb.sort();
      System.out.println(AddMemb.memberList);
      AddMemb.addNewMember();
      System.out.println(AddMemb.memberList);
      //login.login();
      
  }
}