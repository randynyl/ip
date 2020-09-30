package duke.task;

public class Todo extends Task {
    private static final String TODO_TAG = "[T]";

    public Todo(String taskName) {
        super(taskName);
    }

    @Override
    public String toString() {
        return TODO_TAG + super.toString();
    }

    @Override
    public String getTag() {
        return TODO_TAG;
    }
}
