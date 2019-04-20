package todoApp;
import static todoApp.AddNew.taskToDo;
import static todoApp.Check.checkIndexSwitch;
import static todoApp.Check.listCheck;
import static todoApp.ListAll.listTasks;
import static todoApp.Remove.listRemoveIndexSwitch;

public class todo {
  public static void main(String[] args) {

    switch (Math.min(args.length, 2)) {
      case 0:
        printUsage();
        return;
      case 1:
        case1(args[0]);
        return;
      default:
        caseDefault(args);
    }
  }

  public static void printUsage() {
    System.out.println();
    System.out.println("Command Line Todo application");
    System.out.println("=============================");
    System.out.println();
    System.out.println("Command line arguments:");
    System.out.println(" -l   Lists all the tasks");
    System.out.println(" -a   Adds a new task");
    System.out.println(" -r   Removes a task");
    System.out.println(" -c   Completes a task");
  }

  public static void case1(String a) {
    switch (a) {
      case "-l":
        listTasks();
        return;
      case "-a":
        System.out.println("Unable to add: no task provided");
        return;
      case "-r":
        System.out.println("Unable to remove: no index provided");
        return;
      case "-c":
        System.out.println("Unable to check: no index provided");
        return;
      default:
        System.out.println("Unsupported argument.");
    }
  }

  public static void caseDefault(String[] a) {
    switch (a[0]) {
      case "-a":
        taskToDo(a);
        return;
      case "-r":
        listRemoveIndexSwitch(a);
        return;
      case "-c":
        checkIndexSwitch(a);
        return;
      default:
        System.out.println("Unsupported argument");
        printUsage();
    }
  }
}
