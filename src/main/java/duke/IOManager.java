package duke;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles the loading and storing of the tasks to a file.
 */
public class IOManager {

    private static final String FILE_PATH = "data/duke.txt";

    /**
     * Reads an existing file of previously stored tasks.
     * @param filePath Path of the file in the directory.
     * @return The list of tasks that was previously stored.
     * @throws FileNotFoundException No existing file is found.
     */
    public static ArrayList<Task> readFileContents(String filePath) throws FileNotFoundException {
        ArrayList<Task> tasks = new ArrayList<>();
        File f = new File(filePath);
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            Task nextTask;
            String[] taskComponents = s.nextLine().split(" \\| ");
            String taskTag = taskComponents[0];
            String taskComplete = taskComponents[1];
            String taskName = taskComponents[2];
            switch(taskTag) {
            case "[T]":
                nextTask = new Todo(taskComponents[2]);
                break;
            case "[D]":
                String deadlineDetails = taskComponents[3];
                nextTask = new Deadline(taskName, deadlineDetails);
                break;
            case "[E]":
                String eventDetails = taskComponents[3];
                nextTask = new Event(taskName, eventDetails);
                break;
            default:
                throw new IllegalStateException("Unexpected task tag: " + taskTag);
            }
            if ("1".equals(taskComplete)) {
                nextTask.markAsDone();
            }
            tasks.add(nextTask);
        }
        return tasks;
    }


    /**
     * Writes the current list of tasks to the file to be saved.
     * @param filePath Path of the file to be stored in the directory.
     * @throws IOException File could not be saved.
     */
    public static void writeToFile(String filePath) throws IOException {
        StringBuilder textToWrite = new StringBuilder();
        for (Task task : Duke.tasks.getTasks()) {
            textToWrite.append(task.getTag()).append(" | ").append(task.getStatusBinary()).append(" | ").append(task.getTaskName());
            if (task instanceof Event || task instanceof Deadline) {
                textToWrite.append(" | ").append(task.getDetails());
            }
            textToWrite.append(System.lineSeparator());
        }
        FileWriter fw = new FileWriter(filePath);
        fw.write(String.valueOf(textToWrite));
        fw.close();
    }

    /**
     * Retrieves the tasks from a previously saved file.
     * If no previously saved file, creates a new file for future tasks
     * to be saved in.
     * @param filePath Path of file in the directory.
     * @return The list of tasks that was previously stored.
     * @throws IOException Error loading file.
     */
    public static ArrayList<Task> getTasksFromFile(String filePath) throws IOException {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            tasks.addAll(readFileContents(filePath));
        } catch (FileNotFoundException e) {
            File f = new File(filePath);
//            File folder = new File("data");
//            folder.mkdir();
            f.createNewFile();
        }
        return tasks;
    }
}
