package duke.task;

import duke.task.Task;

public class Event extends Task {
    private String details;
    private String eventTag;

    public Event(String taskName, String details) {
        super(taskName);
        this.details = details;
        eventTag = "[E]";
    }

    @Override
    public String toString() {
        String eventDetails = " (at: " + details + ")";
        return eventTag + super.toString() + eventDetails;
    }
}
