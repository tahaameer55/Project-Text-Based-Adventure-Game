import java.util.ArrayList;
import java.util.ListIterator;

public class ContainerItem extends Item
{
    private ArrayList <Item> items;  // Stores Item objects at the location

    public ContainerItem(String name, String type, String description)
    {
        super(name, type, description);
        items = new ArrayList<>();
    }

    public void addItem (Item item_container)
    {
        //System.out.println(item_container.getName()+ " Found in addItem........");
        if(item_container != null)
          items.add(item_container);
    }
    public boolean hasItem(String name)
    {
        Item next_Item;

        ListIterator<Item> litr = null;
        litr = items.listIterator();

        while(litr.hasNext())
        {
            next_Item = litr.next();
            if(next_Item.getName().equalsIgnoreCase(name))
            {
                return true;
            }
        }
        return false; 
    }

    public Item removeItem(String name)
    {
        Item next_Item;
        int index_ = 0;

        ListIterator<Item> litr = null;
        litr = items.listIterator();

        while(litr.hasNext())
        {
            next_Item = litr.next();
            if(next_Item.getName().equalsIgnoreCase(name))
            {   
                items.remove(index_);
                return next_Item;
            }
            index_++;
        }
        return null; 
        
    }

    @Override
    public String toString()
    {
        int index_;
        String myString_;
        myString_ =  getName() + " [" + getType() + "]" + ":" + getDescription() + "\n";
        
        for(index_ = 0; index_ < items.size(); index_++)
        {
          myString_ = myString_+ "+"+items.get(index_).getName() + "\n";
        }
        
        return myString_;
    }

    // Method to print out Item names for the inventory command
    public String ItemstoString()
    {
        int index_;
        String myString_ = "";
        for(index_ = 0; index_ < items.size(); index_++)
        {
          myString_ = myString_+ "+"+items.get(index_).getName() + "\n";
        }
        
        return myString_;
    }

}
