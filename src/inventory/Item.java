package inventory;

public class Item
{
    String name;
    int type;
    int quantity;

    public Item(String name, int type, int quantity)
    {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }

    void itemFunction(int type, int quantity, int aStats[])
    {
        //Checks if the item can be used
        if (quantity == 0)
        {
            //Do nothing
        } else {
            //Item Usage
            switch(type)
            {
                //HP Restore
                case 0:

                    break;

                    //this shouldn't happen
                default:
                    System.out.println("Error: Invalid Item Type");
                    break;
            }
        }
    }
}
