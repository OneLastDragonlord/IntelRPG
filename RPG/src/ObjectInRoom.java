import java.util.Arrays;


public class ObjectInRoom
{
    // instance variables - vervang deze door jouw variabelen
    private String objectDescription;
    private String objectName;


    /**
     * Constructor voor objects van class Item
     */
    public ObjectInRoom (String objectName, String objectDescription) {
        this.objectName = objectName;
        this.objectDescription = objectDescription;
    }

    public String getObjectName()
    {
        return objectName;
    }

    public String getObjectDescription()
    {
        return objectDescription;
    }
}