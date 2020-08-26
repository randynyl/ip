import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<String>();
        System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t> Good day, sire. I'm Percival");
        System.out.println("\t> How may I be of service?");
        System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();

        while (!"bye".equals(userInput)) {
            System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            if ("list".equals(userInput)) {
                System.out.println("\t> Here are your tasks, sire: ");
                for (int i=0; i<tasks.size(); i++) {
                    System.out.println("\t" + (i+1) + ". " + tasks.get(i));
                }
            } else {
                tasks.add(userInput);
                System.out.println("\t> added: " + userInput);
            }
            System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            userInput = in.nextLine();
        }

        System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t> Goodbye, sire. Fare thee well.");
        System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
