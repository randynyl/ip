public class Deadline extends Task{
    private String deadline;

    public Deadline(String taskName, String deadline) {
        super(taskName);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        String deadlineTag = "[D]";
        String deadlineDetails = " (by: " + deadline + ")";
        return deadlineTag + super.toString() + deadlineDetails;
    }
}
