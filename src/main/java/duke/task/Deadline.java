package duke.task;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a task with both a description and a finish-by time
 */
public class Deadline extends Task {

    private LocalDate deadlineTime;
    private static final String DEADLINE_TAG = "[D]";

    /**
     * Constructor for the Deadline Class
     * @param taskName description of task.
     * @param deadlineTime time to finish task by
     */
    public Deadline(String taskName, String deadlineTime) throws DateTimeParseException {
        super(taskName);
        this.deadlineTime = LocalDate.parse(deadlineTime);
    }

    /**
     * converts the Deadline object to a string for its details to be printed.
     * @return the string format of its tag, name and finish-by time
     */
    @Override
    public String toString() {
        String deadlineDetails = " (by: " + getDetails() + ")";
        return DEADLINE_TAG + super.toString() + deadlineDetails;
    }

    /**
     * gets the deadline tag for identification of task type
     * @return the tag "[D]"
     */
    @Override
    public String getTag() {
        return DEADLINE_TAG;
    }

    /**
     * gets the finish-by time of the deadline.
     * @return the finish-by time.
     */
    public String getDetails() {
        return deadlineTime.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }
}
