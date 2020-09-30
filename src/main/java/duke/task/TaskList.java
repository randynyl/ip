package duke.task;

import duke.command.DukeException;
import duke.ui.Ui;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks = new ArrayList<>();

    public TaskList(ArrayList<Task> tasks) {
        for (Task task : tasks) {
            this.tasks.add(task);
        }
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
        Ui.printTaskDoneMessage(tasks.get(taskNumber - 1));
    }

    public void listTasks() {
        Ui.printListTasksMessage(tasks);
    }

    public void addTask(Task task) {
        tasks.add(task);
        Ui.printAddedTaskMessage(task);
        Ui.printTaskCountMessage(tasks);
    }
}
