package duke.task;

import duke.command.DukeException;
import duke.ui.Ui;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Represents the collection of tasks that the user has entered.
 */
public class TaskList {
    private ArrayList<Task> tasks = new ArrayList<>();

    /**
     * Constructor of the class.
     * @param tasks Any tasks that have previously been entered and stored.
     */
    public TaskList(ArrayList<Task> tasks) {
        for (Task task : tasks) {
            this.tasks.add(task);
        }
    }

    /**
     * Default class constructor.
     * Called if no tasks are loaded.
     */
    public TaskList() {
    }

    /**
     * returns the array of tasks currently stored.
     * @return
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Deletes an existing task in the list.
     * @param userInput String number of the task representing its position in the list.
     * @throws DukeException User enters an integer of a non-existing list item.
     * @throws NumberFormatException User does not enter an integer.
     */
    public void deleteTask(String userInput)
            throws DukeException, NumberFormatException {
        int taskNumber = Integer.parseInt(userInput.split(" ")[1]);
        if (taskNumber > tasks.size()) {
            throw new DukeException();
        }
        Task taskToRemove = tasks.get(taskNumber-1);
        tasks.remove(taskNumber-1);
        Ui.printDeleteTaskMessage(taskToRemove);
        Ui.printTaskCountMessage(tasks);

    }

    /**
     * Completes a task inside the list.
     * @param userInput String number of the task representing its position in the list.
     * @throws DukeException User enters an integer of a non-existing list item.
     * @throws NumberFormatException User does not enter an integer.
     */
    public void resolveTask(String userInput)
            throws DukeException, NumberFormatException {
        int taskNumber = Integer.parseInt(userInput.split(" ")[1]);
        if (taskNumber > tasks.size()) {
            throw new DukeException();
        }
        Ui.printTaskDoneMessage(tasks.get(taskNumber - 1));
        tasks.get(taskNumber-1).markAsDone();
        Ui.printTaskDetails(tasks.get(taskNumber - 1));
    }

    /**
     * Prints all the tasks currently in the list.
     * Includes the task number, task tag, description of task and details, if any.
     */
    public void listTasks() {
        Ui.printListTasksMessage(tasks);
    }

    /**
     * Adds a task to the list.
     * @param task Task object to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
        Ui.printAddedTaskMessage(task);
        Ui.printTaskCountMessage(tasks);
    }

    public ArrayList<Task> findTasks(String stringToMatch) {
        ArrayList<Task> tasksFound = new ArrayList<>();
        for (Task task : getTasks()) {
            System.out.println(task.getTaskName().toLowerCase());
            System.out.println(stringToMatch.toLowerCase());
            if (task.getTaskName().toLowerCase().contains(stringToMatch.toLowerCase())) {
                tasksFound.add(task);
            }
        }
        return tasksFound;
    }
}
