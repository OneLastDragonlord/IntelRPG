import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Room {
    private String description;
    private HashMap<String, Room> exits;

    public Room(String description) {
        this.description = description;
        this.exits = new HashMap();
    }

    public void setExits(String direction, Room neighbor) {
        this.exits.put(direction, neighbor);
    }

    public String getDescription() {
        return this.description;
    }

    public String getLongDescription() {
        String var10000 = this.description;
        return "you are " + var10000 + ".\n" + this.getExitString();
    }

    public Room getExit(String direction) {
        return (Room)this.exits.get(direction);
    }

    public String getExitString() {
        String returnString = "Exits: ";
        Set<String> keys = this.exits.keySet();

        String exit;
        for(Iterator var3 = keys.iterator(); var3.hasNext(); returnString = returnString + " " + exit) {
            exit = (String)var3.next();
        }

        return returnString;
    }
}