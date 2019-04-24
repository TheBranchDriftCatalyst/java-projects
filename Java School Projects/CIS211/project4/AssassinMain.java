package project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class AssassinMain {

	public static void main(String[] args) throws FileNotFoundException {
Scanner console = new Scanner(System.in);
System.out.println("Welcome to the CSE211 Assassin Manager");
System.out.println();
System.out.print("What name file do you want to use this time? ");
String fileName = console.nextLine();

Scanner input = new Scanner(new File(fileName));
Set names = new TreeSet(String.CASE_INSENSITIVE_ORDER);
List names2 = new ArrayList();
while (input.hasNextLine()) {
String name = input.nextLine().trim();
if ((name.length() > 0) && (!names.contains(name))) {
names.add(name);
names2.add(name);
}
}
if (yesTo(console, "Do you want the names shuffled?")) {
Collections.shuffle(names2);
}

List names3 = Collections.unmodifiableList(names2);
String[] names4 = new String[0];
names4 = (String[])names3.toArray(names4);
AssassinManager manager = new AssassinManager(names4);
System.out.println();
while (!manager.gameOver()) {
oneKill(console, manager);
}

System.out.println("Game was won by " + manager.winner());
System.out.println("Final graveyard is as follows:");
manager.printGraveyard();
  }

  public static void oneKill(Scanner console, AssassinManager manager)
  {
   System.out.println("Current kill ring:");
     manager.printKillRing();
   System.out.println("Current graveyard:");
     manager.printGraveyard();
     System.out.println();
     System.out.print("next victim? ");
    String name = console.nextLine().trim();
    if (manager.graveyardContains(name))
       System.out.println(name + " is already dead.");
     else if (!manager.killRingContains(name))
      System.out.println("Unknown person.");
    else
      manager.kill(name);
    System.out.println();
  }

  public static boolean yesTo(Scanner console, String prompt)
  {
    while (true)
    {
      System.out.print(prompt + " (y/n)? ");
      String response = console.nextLine().trim().toLowerCase();
     if (response.equals("y"))
         return true;
       if (response.equals("n")) {
        return false;
      }
     System.out.println("Please answer y or n.");
    }
  }
}

