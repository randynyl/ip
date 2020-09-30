package duke.task;

/**
 * Represents an upcoming task with both a description
 * and further details such as time or place.
 */
public class Event extends Task {
    private String details;
    private static final String EVENT_TAG = "[E]";

    /**
     * Constructor for the Event Class
     * @param taskName description of task.
     * @param details time or place of event
     */
    public Event(String taskName, String details) {
        super(taskName);
        this.details = details;
    }

    /**
     * converts the Event object to a string for its details to be printed.
     * @return the string format of its tag, name and details.
     */
    @Override
    public String toString() {
        String eventDetails = " (at: " + details + ")";
        return EVENT_TAG + super.toString() + eventDetails;
    }

    /**
     * gets the event tag for identification of task type
     * @return the tag "[E]"
     */
    @Override
    public String getTag() {
        return EVENT_TAG;
    }

    /**
     * gets the details of the event.
     * @return the event's details.
     */
    public String getDetails() {
        return details;
    }


}
