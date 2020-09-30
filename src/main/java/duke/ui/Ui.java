package duke.ui;

import duke.task.Task;

import java.util.ArrayList;

import static duke.ui.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static duke.ui.Messages.MESSAGE_TASK_DELETED;
import static duke.ui.Messages.MESSAGE_GOODBYE;
import static duke.ui.Messages.MESSAGE_WELCOME;
import static duke.ui.Messages.MESSAGE_TASK_ADDED;
import static duke.ui.Messages.MESSAGE_INVALID_DONE;
import static duke.ui.Messages.MESSAGE_INVALID_TODO;
import static duke.ui.Messages.MESSAGE_INVALID_DEADLINE;
import static duke.ui.Messages.MESSAGE_INVALID_EVENT;
import static duke.ui.Messages.MESSAGE_INVALID_DELETE;
import static duke.ui.Messages.MESSAGE_LIST_TASKS;
import static duke.ui.Messages.MESSAGE_LIST_TASKS_NONE;

public class Ui {

    public static final String TAB_SPACE = "\t";
    private static final String DIVIDER = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

    public static void printDeleteTaskMessage(Task task) {
        System.out.println(TAB_SPACE + MESSAGE_TASK_DELETED);
        System.out.println(TAB_SPACE + TAB_SPACE + task.toString());
    }

    public static void printRetryMessage() {
        System.out.println(TAB_SPACE + MESSAGE_INVALID_COMMAND_FORMAT);
    }

    public static void printLineBorder() {
        System.out.println(TAB_SPACE + DIVIDER);
    }

    public static void printGoodbye() {
        printLineBorder();
        System.out.println(TAB_SPACE + MESSAGE_GOODBYE);
        printLineBorder();
    }

    public static void printGreetings() {
        printLineBorder();
        System.out.println(MESSAGE_WELCOME);
        printLineBorder();
    }

    public static void printTaskCountMessage(ArrayList<Task> tasks) {
        String plural;
        if (tasks.size() == 1) {
            plural = "";
        } else {
            plural = "s";
        }
        System.out.printf(TAB_SPACE + "> Now you have " + tasks.size() + " task%s in the list.%n", plural);
    }

    public static void printAddedTaskMessage(Task task) {
        System.out.println(TAB_SPACE + MESSAGE_TASK_ADDED);
        System.out.println(TAB_SPACE + TAB_SPACE + task.toString());
    }

    public static void printInvalidDoneMessage() {
        System.out.println(TAB_SPACE + MESSAGE_INVALID_DONE);
    }

    public static void printInvalidTodoMessage() {
        System.out.println(TAB_SPACE + MESSAGE_INVALID_TODO);
    }

    public static void printInvalidDeadlineMessage() {
        System.out.println(TAB_SPACE + MESSAGE_INVALID_DEADLINE);
    }

    public static void printInvalidEventMessage() {
        System.out.println(TAB_SPACE + MESSAGE_INVALID_EVENT);
    }

    public static void printInvalidDeleteMessage() {
        System.out.println(TAB_SPACE + MESSAGE_INVALID_DELETE);
    }

    public static void printFileErrorMessage(Exception e) {
        System.out.print("Something went wrong: " + e.getMessage());
    }

    public static void printTaskDoneMessage(Task task) {
        System.out.println(TAB_SPACE + "> Excellent. This task shall be marked as done: "
                + System.lineSeparator() + TAB_SPACE + "  " + task.toString());
    }

    public static void printListTasksMessage(ArrayList<Task> tasks) {
        if (tasks.size() == 0) {
            System.out.println(TAB_SPACE + MESSAGE_LIST_TASKS_NONE);
        } else {
            System.out.println(TAB_SPACE + MESSAGE_LIST_TASKS);
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println("\t" + (i + 1) + "." + tasks.get(i).toString());
            }
        }
    }


}
