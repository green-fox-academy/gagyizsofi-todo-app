package todoApp;

import java.nio.file.*;
import java.util.ArrayList;

import static todoApp.AddNew.overwriteTaskList;
import static todoApp.Remove.*;

public class Check {

  public static void checkIndexSwitch (String[] taskArray) {
    boolean isNr = isNumeric(taskArray[1]);

    if (!isNr) {
      System.out.println("Unable to check: index is not a number");
    } else {
      int nr = Integer.parseInt(taskArray[1]);
      int listLength = howlong();
      if ((nr == 0) || (nr > listLength)) {
        System.out.println("Unable to check: index is out of bound");
      } else {
        listCheck(taskArray);
      }
    }
  }

  public static void listCheck(String[] taskArray) {
    Path todoTxt = Paths.get("assets/todo.txt");
    ArrayList<String> tasksRead = new ArrayList<>();

    try {
      tasksRead.addAll(Files.readAllLines(todoTxt));
    } catch (Exception f) {
      f.printStackTrace();
    }

    tasksRead.set(((Integer.valueOf(taskArray[1]) * 2) - 2), "C");

    overwriteTaskList(tasksRead);
  }
}


