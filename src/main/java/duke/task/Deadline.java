package duke.task;

import duke.task.Task;

public class Deadline extends Task {
    private String deadlineTime;
    private static String deadlineTag  = "[D]";

    public Deadline(String taskName, String deadlineTime) {
        super(taskName);
        this.deadlineTime = deadlineTime;
    }

    @Override
    public String toString() {
        String deadlineDetails = " (by: " + deadlineTime + ")";
        return deadlineTag + super.toString() + deadlineDetails;
    }

    @Override
    public String getTag() {
        return deadlineTag;
    }

    public String getDetails() {
        return deadlineTime;
    }
}
