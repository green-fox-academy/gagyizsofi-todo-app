package todoApp;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ListAll {
  public static void listTasks() {
    Path todoTxt = Paths.get("assets/todo.txt");
    ArrayList<String> tasksRead = new ArrayList<>();

    try {
      tasksRead.addAll(Files.readAllLines(todoTxt));
    } catch (java.nio.file.NoSuchFileException e) {
      System.out.print("");
    } catch (Exception f) {
      f.printStackTrace();
    }

    if (tasksRead.size() == 0) {
      System.out.println("No todos for today! :)");
    } else {
      printAllTasks(tasksRead);
    }
  }

  public static void printAllTasks(ArrayList<String> a) {
    String checked;

    for (int i = 1; i < a.size(); i += 2) {
      if (a.get(i - 1).equals("U")) {
        checked = "[ ] ";
      } else {
        checked = "[x] ";
      }

      String cleanedTask = (((i / 2) + 1) + " - ");
      cleanedTask = checked + cleanedTask + a.get(i);
      System.out.println(cleanedTask);
    }
  }
}
