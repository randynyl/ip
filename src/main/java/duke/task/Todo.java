package duke.task;

/**
 * Represents a basic task with only a description
 * and no additional details
 */
public class Todo extends Task {
    private static final String TODO_TAG = "[T]";

    /**
     * Constructor of the To-do class.
     * @param taskName The description of the to-do task.
     */
    public Todo(String taskName) {
        super(taskName);
    }

    /**
     * converts the Task object to a string for its details to be printed.
     * @return the string format of its tag and name.
     */
    @Override
    public String toString() {
        return TODO_TAG + super.toString();
    }

    /**
     * gets the to-do tag for identification of task type
     * @return the tag "[T]"
     */
    @Override
    public String getTag() {
        return TODO_TAG;
    }
}
