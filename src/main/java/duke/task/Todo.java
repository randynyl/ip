package duke.task;

import duke.task.Task;

public class Todo extends Task {
    private static String todoTag = "[T]";

    public Todo(String taskName) {
        super(taskName);
    }

    @Override
    public String toString() {
        return todoTag + super.toString();
    }

    @Override
    public String getTag() {
        return todoTag;
    }
}
