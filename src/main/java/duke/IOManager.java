package duke;
import duke.Duke;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IOManager {

    public static void readFileContents(String filePath) throws FileNotFoundException {
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
            Duke.tasks.add(nextTask);
        }
    }

    public static void writeToFile(String filePath, String textToAppend) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(textToAppend);
        fw.close();
    }




}
