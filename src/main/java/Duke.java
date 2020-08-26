import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<Task>();
        System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t> Good day, sire, Percival at your disposal.");
        System.out.println("\t> How may I be of service?");
        System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        String userCommand = userInput.split(" ")[0];
        while (!"bye".equals(userCommand)) {
            System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            if ("list".equals(userCommand)) {
                System.out.println("\t> Here are your tasks, sire: ");
                for (int i=0; i<tasks.size(); i++) {
                    System.out.println("\t" + (i+1) + "." + tasks.get(i).getTaskDetails());
                }
            } else if ("done".equals(userCommand)) {
                int taskNumber = Integer.parseInt(userInput.split(" ")[1]);
                tasks.get(taskNumber - 1).markAsDone();
                System.out.println("\t> Very well. This task shall be marked as done: \n\t  "
                        + tasks.get(taskNumber - 1).getTaskDetails());
            } else {
                Task newTask = new Task(userInput);
                tasks.add(newTask);
                System.out.println("\t> added: " + userInput);
            }
            System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            userInput = in.nextLine();
            userCommand = userInput.split(" ")[0];
        }
        System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t> Goodbye, sire. Fare thee well.");
        System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
