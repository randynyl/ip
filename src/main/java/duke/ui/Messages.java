package duke.ui;

import static duke.ui.Ui.TAB_SPACE;

public class Messages {

    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "> Ohhh my sire please give me a valid command";
    public static final String MESSAGE_TASK_DELETED = "> Very Well. Your task has been removed:";
    public static final String MESSAGE_GOODBYE = "> Goodbye, sire. Fare thee well.";
    public static final String MESSAGE_WELCOME = TAB_SPACE + "> Good day, sire, Percival at your disposal."
            + System.lineSeparator() + TAB_SPACE + "> How may I be of service?";
    public static final String MESSAGE_TASK_ADDED = "> Very well. This task has been added: ";
    public static final String MESSAGE_INVALID_DONE = "> Please enter an existing task number to complete!";
    public static final String MESSAGE_INVALID_TODO =
            "> Pardon me my lord but the description of a todo mustn't be empty!";
    public static final String MESSAGE_INVALID_DEADLINE =
            "> Sire, please ensure you have the deadline name and time separated with '/by'";
    public static final String MESSAGE_INVALID_EVENT =
            "> Sire, please ensure you have the event name and time separated with '/at'";
    public static final String MESSAGE_INVALID_DELETE = "> Please enter an existing task number to delete!";
    public static final String MESSAGE_LIST_TASKS = "> Here are your tasks, sire: ";
    public static final String MESSAGE_LIST_TASKS_NONE = "> You currently have no tasks, sire!";
    public static final String MESSAGE_FOUND_TASKS_NONE = "> No tasks found milord!";
    public static final String MESSAGE_FOUND_TASKS = "> Here are the matching tasks in your wondrous list:";
    public static final String MESSAGE_INVALID_FIND = "> Please enter a string to match your tasks with!";
}
