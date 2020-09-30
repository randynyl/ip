package duke;
import duke.command.Parser;
import duke.task.*;
import duke.ui.Ui;

import java.io.IOException;

public class Duke {

    static TaskList tasks;
    private static final String FILE_PATH = "data/duke.txt";

    public Duke(String filePath) {
        try {
            tasks = new TaskList(IOManager.getTasksFromFile(filePath));
        } catch (IOException e) {
            Ui.printFileErrorMessage(e);
            tasks = new TaskList();
        }
    }

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
    public static void main(String[] args) {
        new Duke(FILE_PATH).run();
    }

}
