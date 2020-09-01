public class Event extends Task{
    private String details;

    public Event(String taskName, String details) {
        super(taskName);
        this.details = details;
    }

    @Override
    public String toString() {
        String eventTag = "[E]";
        String eventDetails = " (at: " + details + ")";
        return eventTag + super.toString() + eventDetails;
    }
}
