package duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    private LocalDate deadlineTime;
    private static final String DEADLINE_TAG = "[D]";

    public Deadline(String taskName, String deadlineTime) throws DateTimeParseException {
        super(taskName);
        this.deadlineTime = LocalDate.parse(deadlineTime);
    }

    @Override
    public String toString() {
        String deadlineDetails = " (by: " + getDetails() + ")";
        return DEADLINE_TAG + super.toString() + deadlineDetails;
    }

    @Override
    public String getTag() {
        return DEADLINE_TAG;
    }

    public String getDetails() {
        return deadlineTime.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }
}
