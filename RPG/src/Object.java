import java.util.Arrays;


public class Object
{
    private String objectDescription;
    private String objectName;


    /**
     * Constructor voor objects van class Item
     */
    public Object (String objectName, String objectDescription) {
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
