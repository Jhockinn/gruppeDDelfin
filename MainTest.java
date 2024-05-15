import java.util.*;
import java.io.*;
public class MainTest{
  public static void main(String[]args){
      Competition compet1 = new Competition();
      Competitive competi = new Competitive();
      Chairman AddMemb = new Chairman();
      Active acti = new Active();
      Login login = new Login();
      Memberlists lists = new Memberlists();
      lists.createFiles();
      AddMemb.addNames();
      AddMemb.add();
      acti.active(AddMemb.memberList);
      //System.out.println(AddMemb.memberList);
      //AddMemb.add2();
      //acti.active(AddMemb.memberList);
      //lists.writeToList(AddMemb.memberList);
      //competi.fileOrder(AddMemb.memberList);
      //lists.loadList();
      
      
      //lists.writeToList(AddMemb.memberList);
      //competi.compe(AddMemb.memberList);
      //AddMemb.sort();
      
      //System.out.println(AddMemb.memberList);
      //AddMemb.add2();
      //System.out.println(compet.youthCompetitors);
      //compet1.showYouthCompetitors();
      
      //AddMemb.addNewMember();
      //lists.viewList();
      //System.out.println(lists.memberList);
      //System.out.println(AddMemb.memberList);
      //login.login();
      //competi.fileOrder(AddMemb.memberList);
      
  }
}