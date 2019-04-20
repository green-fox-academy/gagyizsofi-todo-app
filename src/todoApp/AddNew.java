package todoApp;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class AddNew {

  public static void taskToDo(String[] taskArray) {
    ArrayList<String> task = new ArrayList<>();
    Path todoTxt = Paths.get("assets/todo.txt");

    task.add("U");
    task.add(taskArrayToString(taskArray));

    try {
      Files.write(todoTxt, task, StandardOpenOption.APPEND);
    } catch (java.nio.file.NoSuchFileException e) {
      overwriteTaskList(task);
    } catch (Exception f) {
      f.printStackTrace();
    }
  }

  public static void overwriteTaskList(ArrayList<String> task) {
    Path todoTxt = Paths.get("assets/todo.txt");
    try {
      Files.write(todoTxt, task);
    } catch (Exception a) {
      a.printStackTrace();
    }
  }

  public static String taskArrayToString(String[] a) {
    String taskToReturn = "";
    for (int i = 1; i < a.length; i++) {
      taskToReturn = taskToReturn + " " + (a[i]);
    }
    taskToReturn = taskToReturn.substring(1);
    return taskToReturn;
  }
}
