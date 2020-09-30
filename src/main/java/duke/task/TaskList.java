package duke.task;

import duke.command.DukeException;
import duke.ui.Ui;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks.addAll(tasks);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }


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

    public void resolveTask(String userInput)
            throws DukeException, NumberFormatException {
        int taskNumber = Integer.parseInt(userInput.split(" ")[1]);
        if (taskNumber > tasks.size()) {
            throw new DukeException();
        }
        tasks.get(taskNumber-1).markAsDone();
        System.out.println("\t> Excellent. This task shall be marked as done: \n\t  "
                + tasks.get(taskNumber - 1).toString());
    }

    public void listTasks() {
        System.out.println("\t> Here are your tasks, sire: ");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("\t" + (i+1) + "." + tasks.get(i).toString());
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
        Ui.printAddedTaskMessage(task);
        Ui.printTaskCountMessage(tasks);
    }
}
