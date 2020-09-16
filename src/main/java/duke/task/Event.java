package duke.task;

import duke.task.Task;

public class Event extends Task {
    private String details;
    private static String eventTag = "[E]";

    public Event(String taskName, String details) {
        super(taskName);
        this.details = details;
    }

    @Override
    public String toString() {
        String eventDetails = " (at: " + details + ")";
        return eventTag + super.toString() + eventDetails;
    }

    @Override
    public String getTag() {
        return eventTag;
    }

    public String getDetails() {
        return details;
    }


}
