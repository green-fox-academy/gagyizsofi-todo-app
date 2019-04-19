package todoApp;
import java.nio.file.*;
import java.util.ArrayList;

public class TaskToDo {
  boolean done;
  ArrayList<String> task = new ArrayList<>();

  public TaskToDo(String[] taskArray) {
    Path todoTxt = Paths.get("assets/todo.txt");

    this.task.add("F");
    this.task.add(taskArrayToString(taskArray));

    try {
      Files.write(todoTxt, task, StandardOpenOption.APPEND);
    } catch (java.nio.file.NoSuchFileException e) {
        try {
          Files.write(todoTxt, task);
        } catch (Exception a) {
          System.out.println();
        }
    } catch (java.io.IOException f) {
      f.printStackTrace();
    }
  }

  public static String taskArrayToString(String[] a) {
    String taskToReturn = "";
    for (int i = 1; i < a.length ; i++) {
      taskToReturn = taskToReturn + " " + (a[i]);
    }
    taskToReturn = taskToReturn.substring(1);
    return taskToReturn;
  }

 /* public boolean isDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }

  public ArrayList<String> getTask() {
    return task;
 */

}

