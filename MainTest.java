import java.util.*;
import java.io.*;
public class MainTest{
      static ArrayList<Members> memberList = new ArrayList<Members>();
  public static void main(String[]args){
      Competitive competi = new Competitive();
      Add AddMemb = new Add();
      Active acti = new Active();
      Login login = new Login();
      AddMemb.addNames();
      AddMemb.add();
      competi.compe();
      acti.active();
      AddMemb.sort();
      System.out.println(memberList);
      //login.login();
      
  }
}