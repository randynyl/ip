package duke.task;

/**
 * Abstract class that can be inherited by either a Task, Event or Deadline.
 */
public abstract class Task {
    private String taskName;
    private boolean isDone;

    /**
     * Constructor of the Task abstract class.
     * @param taskName Description of task.
     */
    public Task(String taskName) {
        this.taskName = taskName;
        isDone = false;
    }

    /**
     * Getter for task name.
     * @return Name of the task.
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * Setter for task name.
     * @param taskName New name of the task.
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * Marks task as completed.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Checks if the task has been completed.
     * @return True if the task has been marked as completed.
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Gets the icon of the task in ASCII representing if it has been completed.
     * @return the tick symbol if task has been completed, a cross symbol if it has not.
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    /**
     * Gets the binary string completion status of the task.
     * @return 1 if task has been completed, 0 if it has not.
     */
    public String getStatusBinary() {
        return (isDone ? "1" : "0");
    }

    /**
     * Converts the Task object to a string for its details to be printed.
     * @return The string format details of the Task.
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + getTaskName();
    }

    /**
     * returns a tag specific to the type of Task
     * @return the tag of the respective type of task.
     */
    public abstract String getTag();

    /**
     * Gets the additional details respective to the task, if any.
     * @return a string format of the details of the task.
     */
    public String getDetails() {
        return null;
    }
}

