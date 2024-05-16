import java.util.*;
import java.io.*;
public class MainTest{
  public static void main(String[]args){
      Chairman AddMemb = new Chairman();
      Active acti = new Active();
      Login login = new Login();
      Memberlists lists = new Memberlists();
      lists.createFiles();
      AddMemb.addNames();
      lists.loadList();
      AddMemb.add(lists.memberList);
      AddMemb.addNewMember(lists.memberList);
      lists.viewList();
  }
}