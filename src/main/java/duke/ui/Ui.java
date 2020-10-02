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
import static duke.ui.Messages.MESSAGE_INVALID_DEADLINE_TIME;
import static duke.ui.Messages.MESSAGE_INVALID_EVENT;
import static duke.ui.Messages.MESSAGE_INVALID_DELETE;
import static duke.ui.Messages.MESSAGE_LIST_TASKS;
import static duke.ui.Messages.MESSAGE_LIST_TASKS_NONE;
import static duke.ui.Messages.MESSAGE_FOUND_TASKS_NONE;
import static duke.ui.Messages.MESSAGE_FOUND_TASKS;
import static duke.ui.Messages.MESSAGE_INVALID_FIND;

public class Ui {

    public static final String TAB_SPACE = "\t";
    private static final String DIVIDER = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

    /**
     * Prints the message confirming task deletion.
     * @param task Task that was deleted.
     */
    public static void printDeleteTaskMessage(Task task) {
        System.out.println(TAB_SPACE + MESSAGE_TASK_DELETED);
        System.out.println(TAB_SPACE + TAB_SPACE + task.toString());
    }

    /**
     * Prints the message informing user that the entered command was invalid
     * and allow user to re-enter a command.
     */
    public static void printRetryMessage() {
        System.out.println(TAB_SPACE + MESSAGE_INVALID_COMMAND_FORMAT);
    }

    /**
     * Prints the line borders signifying the start and end
     * of an output message block.
     */
    public static void printLineBorder() {
        System.out.println(TAB_SPACE + DIVIDER);
    }

    /**
     * Prints the farewell message to the user
     * upon exit of the program.
     */
    public static void printGoodbye() {
        printLineBorder();
        System.out.println(TAB_SPACE + MESSAGE_GOODBYE);
        printLineBorder();
    }

    /**
     * Prints the greetings message to the user
     * on the start of the program.
     */
    public static void printGreetings() {
        printLineBorder();
        System.out.println(MESSAGE_WELCOME);
        printLineBorder();
    }

    /**
     * Prints a message indicating the number of tasks currently
     * in the task list.
     * @param tasks The list of existing tasks.
     */
    public static void printTaskCountMessage(ArrayList<Task> tasks) {
        String plural;
        if (tasks.size() == 1) {
            plural = "";
        } else {
            plural = "s";
        }
        System.out.printf(TAB_SPACE + "> Now you have " + tasks.size() + " task%s in the list.%n", plural);
    }

    /**
     * Prints a message confirming that a task has been added.
     * @param task Task that was just added.
     */
    public static void printAddedTaskMessage(Task task) {
        System.out.println(TAB_SPACE + MESSAGE_TASK_ADDED);
        System.out.println(TAB_SPACE + TAB_SPACE + task.toString());
    }

    /**
     * Prints a message informing the user that the done command was invalid.
     */
    public static void printInvalidDoneMessage() {
        System.out.println(TAB_SPACE + MESSAGE_INVALID_DONE);
    }

    /**
     * Prints a message informing the user that the to-do command was invalid.
     */
    public static void printInvalidTodoMessage() {
        System.out.println(TAB_SPACE + MESSAGE_INVALID_TODO);
    }

    /**
     * Prints a message informing the user that the deadline command was invalid.
     */
    public static void printInvalidDeadlineMessage() {
        System.out.println(TAB_SPACE + MESSAGE_INVALID_DEADLINE);
    }

    /**
     * Prints a message informing the user that
     * the deadline time entered was invalid.
     */
    public static void printInvalidTimeMessage() {
        System.out.println(TAB_SPACE + MESSAGE_INVALID_DEADLINE_TIME);
    }

    /**
     * Prints a message informing the user that the event command was invalid.
     */
    public static void printInvalidEventMessage() {
        System.out.println(TAB_SPACE + MESSAGE_INVALID_EVENT);
    }

    /**
     * Prints a message informing the user that the delete command was invalid.
     */
    public static void printInvalidDeleteMessage() {
        System.out.println(TAB_SPACE + MESSAGE_INVALID_DELETE);
    }

    /**
     * Prints a message informing the user that
     * a saved file was could not be loaded.
     */
    public static void printFileErrorMessage(Exception e) {
        System.out.println("Could not find saved file.");
    }

    /**
     * Prints a message confirming that a task has been marked as complete.
     * @param task Task that was just marked complete.
     */
    public static void printTaskDoneMessage(Task task) {
        if (task.isDone()) {
            System.out.println(TAB_SPACE + "> This task has already been completed!");
        } else {
            System.out.println(TAB_SPACE + "> Excellent. This task shall be marked as done: ");
        }
    }

    /**
     * Prints the string format of a task's description and details, if any.
     * @param task
     */
    public static void printTaskDetails(Task task) {
        System.out.println(TAB_SPACE + "  " + task.toString());
    }

    /**
     * Prints the strings of all the tasks currently in the list.
     * @param tasks Tasks that currently exist in the task list.
     */
    public static void printListTasksMessage(ArrayList<Task> tasks) {
        if (tasks.size() == 0) {
            System.out.println(TAB_SPACE + MESSAGE_LIST_TASKS_NONE);
        } else {
            System.out.println(TAB_SPACE + MESSAGE_LIST_TASKS);
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(TAB_SPACE + (i + 1) + "." + tasks.get(i).toString());
            }
        }
    }

    public static void printFoundTasksMessage(ArrayList<Task> tasksFound) {
        if (tasksFound.size() == 0) {
            System.out.println(TAB_SPACE + MESSAGE_FOUND_TASKS_NONE);
        } else {
            System.out.println(TAB_SPACE + MESSAGE_FOUND_TASKS);
            for (int i = 0; i < tasksFound.size(); i++) {
                System.out.println(TAB_SPACE + (i + 1) + "." + tasksFound.get(i).toString());
            }
        }
    }

    public static void printInvalidFindMessage() {
        System.out.println(TAB_SPACE + MESSAGE_INVALID_FIND);
    }




}
