package duke.task;

public abstract class Task {
    private String taskName;
    private boolean isDone;

    public Task(String taskName) {
        this.taskName = taskName;
        isDone = false;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void markAsDone() {
        if (isDone == true) {
            System.out.println("This task has already been completed!");
        }
        isDone = true;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    public String getStatusBinary() {
        return (isDone ? "1" : "0");
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + getTaskName();
    }
    public abstract String getTag();
    public String getDetails() {
        return null;
    }
}

