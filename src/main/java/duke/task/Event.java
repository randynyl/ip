package duke.task;

public class Event extends Task {
    private String details;
    private static final String EVENT_TAG = "[E]";

    public Event(String taskName, String details) {
        super(taskName);
        this.details = details;
    }

    @Override
    public String toString() {
        String eventDetails = " (at: " + details + ")";
        return EVENT_TAG + super.toString() + eventDetails;
    }

    @Override
    public String getTag() {
        return EVENT_TAG;
    }

    public String getDetails() {
        return details;
    }


}
