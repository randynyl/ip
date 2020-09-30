package duke;
import duke.task.*;
import duke.ui.Ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    protected static TaskList tasks;
    private static final String FILE_PATH = "data/duke.txt";
    public static void main(String[] args) {
        Ui.printGreetings();
        try {
            tasks = new TaskList(IOManager.getTasksFromFile(FILE_PATH));
        } catch (IOException e) {
            System.out.print("Something went wrong: " + e.getMessage());
        }
        executeCommand(tasks);
        try {
            IOManager.writeToFile(FILE_PATH);
        } catch (IOException e) {
            System.out.print("Something went wrong: " + e.getMessage());
        }
        Ui.printGoodbye();
    }

    private static void executeCommand(TaskList tasks) {
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        String userCommand = userInput.split(" ")[0].toLowerCase();
        while (!"bye".equals(userCommand)) {
            Ui.printLineBorder();
            switch (userCommand) {
            case "list":
                tasks.listTasks();
                break;
            case "done":
                try {
                    tasks.resolveTask(userInput);
                } catch (Exception e) {
                    System.out.println("\t> Please enter an existing task number to complete!");
                }
                break;
            case "todo":
                try {
                    Todo newTodo = getTodoFromInput(userInput);
                    tasks.addTask(newTodo);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("\t> Pardon me my lord but the description of a todo mustn't be empty!");
                }
                break;
            case "deadline":
                try {
                    Deadline newDeadline = getDeadlineFromInput(userInput);
                    tasks.addTask(newDeadline);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("\t> Sire, please ensure you have the deadline name and time separated with '/by'");
                }
                break;
            case "event":
                try {
                    Event newEvent = getEventFromInput(userInput);
                    tasks.addTask(newEvent);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("\t> Sire, please ensure you have the event name and time separated with '/at'");
                }
                break;
            case "delete":
                try {
                    tasks.deleteTask(userInput);
                } catch (Exception e) {
                    System.out.println("\t> Please enter an existing task number to delete!");
                }
                break;
            default:
                Ui.printRetryMessage();
            }
            Ui.printLineBorder();
            userInput = in.nextLine();
            userCommand = userInput.split(" ")[0];
        }
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

}
