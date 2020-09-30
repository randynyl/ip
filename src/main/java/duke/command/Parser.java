package duke.command;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.TaskList;
import duke.task.Todo;
import duke.ui.Ui;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Parser {
    public static void executeCommand(TaskList tasks) {
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
                executeDone(tasks, userInput);
                break;
            case "todo":
                executeTodo(tasks, userInput);
                break;
            case "deadline":
                executeDeadline(tasks, userInput);
                break;
            case "event":
                executeEvent(tasks, userInput);
                break;
            case "delete":
                executeDelete(tasks, userInput);
                break;
            default:
                Ui.printRetryMessage();
            }
            Ui.printLineBorder();
            userInput = in.nextLine();
            userCommand = userInput.split(" ")[0].toLowerCase();
        }
    }

    private static void executeDelete(TaskList tasks, String userInput) {
        try {
            tasks.deleteTask(userInput);
        } catch (Exception e) {
            Ui.printInvalidDeleteMessage();
        }
    }

    private static void executeEvent(TaskList tasks, String userInput) {
        try {
            Event newEvent = getEventFromInput(userInput);
            tasks.addTask(newEvent);
        } catch (IndexOutOfBoundsException e) {
            Ui.printInvalidEventMessage();
        }
    }

    private static void executeDeadline(TaskList tasks, String userInput) {
        try {
            Deadline newDeadline = getDeadlineFromInput(userInput);
            tasks.addTask(newDeadline);
        } catch (IndexOutOfBoundsException e) {
            Ui.printInvalidDeadlineMessage();
        } catch (DateTimeParseException e) {
            Ui.printInvalidTimeMessage();
        }
    }

    private static void executeTodo(TaskList tasks, String userInput) {
        try {
            Todo newTodo = getTodoFromInput(userInput);
            tasks.addTask(newTodo);
        } catch (IndexOutOfBoundsException e) {
            Ui.printInvalidTodoMessage();
        }
    }

    private static void executeDone(TaskList tasks, String userInput) {
        try {
            tasks.resolveTask(userInput);
        } catch (Exception e) {
            Ui.printInvalidDoneMessage();
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
