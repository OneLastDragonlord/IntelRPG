import java.util.Scanner;

public class Parser {
    private CommandWords commands = new CommandWords();
    private Scanner reader;

    public Parser() {
        this.reader = new Scanner(System.in);
    }

    public Command getCommand() {
        String word1 = null;
        String word2 = null;
        System.out.print("> ");
        String inputLine = this.reader.nextLine();
        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }

        return this.commands.isCommand(word1) ? new Command(word1, word2) : new Command((String)null, word2);
    }

    public String showCommands() {
        return this.commands.showAll();
    }
}
