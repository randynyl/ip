package duke.task;

import duke.task.Task;

public class Deadline extends Task {
    private String deadlineTime;
    private String deadlineTag;

    public Deadline(String taskName, String deadlineTime) {
        super(taskName);
        this.deadlineTime = deadlineTime;
        deadlineTag = "[D]";
    }

    @Override
    public String toString() {
        String deadlineDetails = " (by: " + deadlineTime + ")";
        return deadlineTag + super.toString() + deadlineDetails;
    }
}
