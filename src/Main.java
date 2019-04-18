import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    switch (Math.min(args.length, 2)) {
      case 0:
        System.out.println();
        System.out.println("Command Line Todo application");
        System.out.println("=============================");
        System.out.println();
        System.out.println("Command line arguments:");
        System.out.println(" -l   Lists all the tasks");
        System.out.println(" -a   Adds a new task");
        System.out.println(" -r   Removes a task");
        System.out.println(" -c   Completes an task");
        return;
      case 1:
        System.out.println("this is where functionality will come later :)");
        return;
//        System.out.println("\""+ args + "\" is not recognized as a command.");
      case 2:
        System.out.println("too many arguments");
        return;
    }
  }
}
