public class CommandWords {
    private static final String[] validCommands = new String[]{"go", "quit", "help", "look", "sleep"};

    public CommandWords() {
    }

    public boolean isCommand(String aString) {
        for(int i = 0; i < validCommands.length; ++i) {
            if (validCommands[i].equals(aString)) {
                return true;
            }
        }

        return false;
    }

    public String showAll() {
        String returnString = "";
        String[] var2 = validCommands;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String command = var2[var4];
            returnString = returnString + command + " ";
        }

        return returnString;
    }
}
