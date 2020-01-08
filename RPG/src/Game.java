public class Game {
    private Parser parser;
    private Room currentRoom;

    public Game() {
        this.createRooms();
        this.parser = new Parser();
    }

    private void createRooms()
    {
        Room throneRoom, courtyard, dungeon, labyrinth, battlefield, avalon;
        // create the rooms
        throneRoom = new Room("in the throne room of the knights of the round table. It feels glorious");
        courtyard = new Room("standing in the courtyard of the castle. Children are running all around you and are having fun");
        dungeon = new Room("in the lowest part of the castle. It looks like some sort of prison for something huge");
        labyrinth = new Room("facing the entrance of the labyrinth");
        battlefield = new Room("are entering the battlefield. A place where many battles have been fought, and will be fought");
        avalon = new Room("near the edge of lake Avalon");

        // initialise room exits
        throneRoom.setExits("down" , courtyard);

        courtyard.setExits("up", throneRoom);
        courtyard.setExits("east", battlefield);
        courtyard.setExits("down", dungeon);

        dungeon.setExits("up", courtyard);

        labyrinth.setExits("south", battlefield);

        battlefield.setExits("north", labyrinth);
        battlefield.setExits("south", avalon);
        battlefield.setExits("west", courtyard);

        avalon.setExits("north", battlefield);

        currentRoom = courtyard;  // start game outside

    }

    public void createObjects()
    {
        ObjectInRoom throneKey, excalibur, cup, object4, object5, object6;
        throneKey = new ObjectInRoom("A Key", "A key with markings that look like a crown");
        excalibur = new ObjectInRoom("A Sword", "A sword that looks to have been stuck in stone for a long time");
        cup = new ObjectInRoom("A cup", "A mysterious cup surrounded by a strong feeling of power");
    }

    public void play() {
        this.printWelcome();

        Command command;
        for(boolean finished = false; !finished; finished = this.processCommand(command)) {
            command = this.parser.getCommand();
        }

        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        this.printLocationInfo();
    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;
        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        } else {
            String commandWord = command.getCommandWord();
            if (commandWord.equals("help")) {
                this.printHelp();
            } else if (commandWord.equals("look")) {
                this.look();
            } else if (commandWord.equals("go")) {
                this.goRoom(command);
            } else if (commandWord.equals("sleep")) {
                this.sleep();
            } else if (commandWord.equals("quit")) {
                wantToQuit = this.quit(command);
            }

            return wantToQuit;
        }
    }

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println(this.parser.showCommands());
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
        } else {
            String direction = command.getSecondWord();
            Room nextRoom = this.currentRoom.getExit(direction);
            if (nextRoom == null) {
                System.out.println("There is no door!");
            } else {
                this.currentRoom = nextRoom;
                this.printLocationInfo();
            }

        }
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }

    private void printLocationInfo() {
        System.out.println(this.currentRoom.getLongDescription());
        System.out.println();
    }

    private void look() {
        System.out.println(this.currentRoom.getLongDescription());
    }

    private void sleep() {
        System.out.println("You slept for a year and are really awake now");
    }
}
