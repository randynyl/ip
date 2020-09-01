public class Todo extends Task{
    public Todo(String taskName) {
        super(taskName);
    }

    @Override
    public String toString() {
        String taskTag = "[T]";
        return taskTag + super.toString();
    }
}
