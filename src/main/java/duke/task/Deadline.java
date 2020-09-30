package duke.task;

/**
 * Represents a task with both a description and a finish-by time
 */
public class Deadline extends Task {
    private String deadlineTime;
    private static String deadlineTag  = "[D]";

    /**
     * Constructor for the Deadline Class
     * @param taskName description of task.
     * @param deadlineTime time to finish task by
     */
    public Deadline(String taskName, String deadlineTime) {
        super(taskName);
        this.deadlineTime = deadlineTime;
    }

    /**
     * converts the Deadline object to a string for its details to be printed.
     * @return the string format of its tag, name and finish-by time
     */
    @Override
    public String toString() {
        String deadlineDetails = " (by: " + deadlineTime + ")";
        return deadlineTag + super.toString() + deadlineDetails;
    }

    /**
     * gets the deadline tag for identification of task type
     * @return the tag "[D]"
     */
    @Override
    public String getTag() {
        return deadlineTag;
    }

    /**
     * gets the finish-by time of the deadline.
     * @return the finish-by time.
     */
    public String getDetails() {
        return deadlineTime;
    }
}
