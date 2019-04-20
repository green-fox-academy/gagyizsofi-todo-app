package todoApp;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static todoApp.AddNew.overwriteTaskList;

public class Remove {

  public static void listRemoveIndexSwitch(String[] taskArray) {
    boolean isNr = isNumeric(taskArray[1]);

    if (!isNr) {
      System.out.println("Unable to remove: index is not a number");
    } else {
      int nr = Integer.parseInt(taskArray[1]);
      int listLength = howlong();
      if ((nr == 0) || (nr > listLength)) {
        System.out.println("Unable to remove: index is out of bound");
      } else {
        listRemove(taskArray);
      }
    }
  }

  public static boolean isNumeric(String str) {
    try {
      Integer.parseInt(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public static int howlong() {
    Path todoTxt = Paths.get("assets/todo.txt");
    ArrayList<String> tasksRead = new ArrayList<>();

    try {
      tasksRead.addAll(Files.readAllLines(todoTxt));
    } catch (Exception f) {
      f.printStackTrace();
    }

    return tasksRead.size() / 2;
  }

  public static void listRemove(String[] taskArray) {
    Path todoTxt = Paths.get("assets/todo.txt");
    ArrayList<String> tasksRead = new ArrayList<>();

    try {
      tasksRead.addAll(Files.readAllLines(todoTxt));
    } catch (Exception f) {
      f.printStackTrace();
    }

    tasksRead.remove((Integer.valueOf(taskArray[1]) * 2) - 2);
    tasksRead.remove((Integer.valueOf(taskArray[1]) * 2) - 2);

    overwriteTaskList(tasksRead);
  }
}
