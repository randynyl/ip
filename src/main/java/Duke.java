import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<Task>();
        printGreetings();
        executeCommand(tasks);
        printGoodbye();
    }

    private static void executeCommand(ArrayList<Task> tasks) {
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        String userCommand = userInput.split(" ")[0];
        while (!"bye".equals(userCommand)) {
            printLineBorder();
            switch (userCommand) {
            case "list":
                listTasks(tasks);
                break;
            case "done":
                try {
                    resolveTask(tasks, userInput);
                } catch (Exception e) {
                    System.out.println("\t> Please enter an existing task number to complete!");
                }
                break;
            case "todo":
                try {
                    Todo newTodo = getTodoFromInput(userInput);
                    addTask(tasks, newTodo);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("\t> Pardon me my lord but the description of a todo mustn't be empty!");
                }
                break;
            case "deadline":
                try {
                    Deadline newDeadline = getDeadlineFromInput(userInput);
                    addTask(tasks, newDeadline);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("\t> Sire, please ensure you have the deadline name and time separated with '/by'");
                }
                break;
            case "event":
                try {
                    Event newEvent = getEventFromInput(userInput);
                    addTask(tasks, newEvent);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("\t> Sire, please ensure you have the event name and time separated with '/at'");
                }
                break;
            default:
                printRetryMessage();
            }
            printLineBorder();
            userInput = in.nextLine();
            userCommand = userInput.split(" ")[0];
        }
    }

    private static void printRetryMessage() {
        System.out.println("\t> Ohhh my sire please give me a valid command");
    }

    private static void printLineBorder() {
        System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private static Event getEventFromInput(String userInput) throws IndexOutOfBoundsException {
        String[] eventComponents = userInput.split("event | /at ");
        String eventName = eventComponents[1];
        String eventDetails = eventComponents[2];
        Event newEvent = new Event(eventName, eventDetails);
        return newEvent;
    }

    private static Deadline getDeadlineFromInput(String userInput) throws IndexOutOfBoundsException {
        String[] deadlineComponents = userInput.split("deadline | /by ");
        String taskName = deadlineComponents[1];
        String taskDeadline = deadlineComponents[2];
        Deadline newDeadline = new Deadline(taskName, taskDeadline);
        return newDeadline;
    }

    private static Todo getTodoFromInput (String userInput) throws IndexOutOfBoundsException {
        String taskName = userInput.split(" ", 2)[1];
        Todo newTodo = new Todo(taskName);
        return newTodo;
    }

    private static void resolveTask(ArrayList<Task> tasks, String userInput)
            throws DukeException, NumberFormatException {
        int taskNumber = Integer.parseInt(userInput.split(" ")[1]);
        if (taskNumber > tasks.size()) {
            throw new DukeException();
        }
        tasks.get(taskNumber-1).markAsDone();
        System.out.println("\t> Excellent. This task shall be marked as done: \n\t  "
                + tasks.get(taskNumber - 1).toString());
    }

    private static void listTasks(ArrayList<Task> tasks) {
        System.out.println("\t> Here are your tasks, sire: ");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("\t" + (i+1) + "." + tasks.get(i).toString());
        }
    }

    private static void printGoodbye() {
        printLineBorder();
        System.out.println("\t> Goodbye, sire. Fare thee well.");
        printLineBorder();
    }

    private static void printGreetings() {
        printLineBorder();
        System.out.println("\t> Good day, sire, Percival at your disposal.");
        System.out.println("\t> How may I be of service?");
        printLineBorder();
    }

    private static void addTask(ArrayList<Task> tasks, Task task) {
        tasks.add(task);
        printAddedTaskMessage(task);
        printTaskCountMessage(tasks);
    }

    private static void printTaskCountMessage(ArrayList<Task> tasks) {
        String plural = (tasks.size() == 1) ? "" : "s";
        System.out.printf("\t> Now you have " + tasks.size() + " task%s in the list.%n", plural);
    }

    private static void printAddedTaskMessage(Task task) {
        System.out.println("\t> Very well. This task has been added: ");
        System.out.println("\t\t" + task.toString());
    }
}
