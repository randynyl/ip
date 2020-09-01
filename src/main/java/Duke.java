import java.util.ArrayList;
import java.util.Arrays;
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
                    System.out.println("\t" + (i+1) + "." + tasks.get(i).toString());
                }
            } else if ("done".equals(userCommand)) {
                int taskNumber = Integer.parseInt(userInput.split(" ")[1]);
                tasks.get(taskNumber - 1).markAsDone();
                System.out.println("\t> Excellent. This task shall be marked as done: \n\t  "
                        + tasks.get(taskNumber - 1).toString());
            } else if ("todo".equals(userCommand)) {
                String taskName = userInput.split(" ", 2)[1];
                Todo newTodo = new Todo(taskName);
                addTask(tasks, newTodo);
            } else if ("deadline".equals(userCommand)) {
                String[] deadlineComponents = userInput.split("deadline | /by ");
                String taskName = deadlineComponents[1];
                String taskDeadline = deadlineComponents[2];
                Deadline newDeadline = new Deadline(taskName, taskDeadline);
                addTask(tasks, newDeadline);
            } else if ("event".equals(userCommand)) {
                String[] eventComponents = userInput.split("event | /at ");
                String eventName = eventComponents[1];
                String eventDetails = eventComponents[2];
                Event newEvent = new Event(eventName, eventDetails);
                addTask(tasks, newEvent);
            }
            System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            userInput = in.nextLine();
            userCommand = userInput.split(" ")[0];
        }
        System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t> Goodbye, sire. Fare thee well.");
        System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private static void addTask(ArrayList<Task> tasks, Task task) {
        tasks.add(task);
        printAddedTaskMessage(task);
        printTaskCountMessage(tasks);
    }

    private static void printTaskCountMessage(ArrayList<Task> tasks) {
        if (tasks.size() == 1) {
            System.out.println("\t> Now you have " + tasks.size() + " task in the list.");
        } else {
            System.out.println("\t> Now you have " + tasks.size() + " tasks in the list.");
        }

    }

    private static void printAddedTaskMessage(Task task) {
        System.out.println("\t> Very well. This task has been added: ");
        System.out.println("\t\t" + task.toString());
    }
}
