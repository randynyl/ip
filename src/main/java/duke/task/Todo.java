package duke.task;

import duke.task.Task;

public class Todo extends Task {
    private String todoTag;

    public Todo(String taskName) {
        super(taskName);
        todoTag = "[T]";
    }

    @Override
    public String toString() {
        return todoTag + super.toString();
    }
}
