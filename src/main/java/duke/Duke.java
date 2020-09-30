package duke;
import duke.command.Parser;
import duke.task.*;
import duke.ui.Ui;

import java.io.IOException;

/**
 * Main class of the program
 * to allow users to track various sorts of tasks
 */
public class Duke {

    static TaskList tasks;
    private static final String FILE_PATH = "data/duke.txt";

    /**
     * Constructor to load previously stored tasks, if any.
     * If no previously stored tasks, a new task list will be created.
     *
     * @param filePath string path of file to load and store task information
     */
    public Duke(String filePath) {
        try {
            tasks = new TaskList(IOManager.getTasksFromFile(filePath));
        } catch (IOException e) {
            Ui.printFileErrorMessage(e);
            tasks = new TaskList();
        }
    }

    /**
     * Begins interaction with user to simulate a virtual assistant
     */
    public void run() {
        Ui.printGreetings();
        Parser.executeCommand(tasks);
        try {
            IOManager.writeToFile(FILE_PATH);
        } catch (IOException e) {
            Ui.printFileErrorMessage(e);
        }
        Ui.printGoodbye();
    }

    /**
     * Main function to call the start of the program.
     */
    public static void main(String[] args) {
        new Duke(FILE_PATH).run();
    }

}
