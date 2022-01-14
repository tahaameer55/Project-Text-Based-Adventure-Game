import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;

public class Location 
{
    // Member Variables
    private String name_;
    private String description_; 
    private ArrayList <Item> myList;  // Stores Item objects at the location
    private HashMap <String,Location> connections; // Maps a string to a location object address. 

    // Constructor 
    public Location(String name_, String description_)
    {
        this.name_ = name_;
        this.description_ = description_;
        myList = new ArrayList<>();
        connections = new HashMap<String,Location>(); // Intializng the HashMap
    }

    // Getters/acessors
    public String getName_()
    {
        return name_;
    }

    public String getDescription_()
    {
        return description_;
    }

    // Setters/mutators
    public void setName_(String name_)
    {
       this.name_ = name_;
    }

    public void setDesccription_(String description_)
    {
        this.description_ = description_;
    }

    // Methods
    public boolean addItem(Item item_)
    {
        return myList.add(item_);     
    }

    public boolean hasItem(String name_)
    {   
        ListIterator<Item> litr = null;
        litr = myList.listIterator();

        while(litr.hasNext())
        {
            if(litr.next().getName().equalsIgnoreCase(name_))
            {
                return true;
            }
        }
        return false;
    }

    public Item getItem(String name_)
    {
        Item next_Item;

        ListIterator<Item> litr = null;
        litr = myList.listIterator();

        while(litr.hasNext())
        {
            next_Item = litr.next();
            if(next_Item.getName().equalsIgnoreCase(name_))
            {
                return next_Item;
            }
        }
        return null;   

    }

    public Item getItem(int index_)
    {
        if (index_ < numItems())
        {
          return myList.get(index_);
        }
        else
        {
            return null;
        }

    }

    public int numItems()
    {
        return myList.size();   
    }

    public Item removeItem(String name_)
    {
        Item next_Item;
        int index_ = 0;

        ListIterator<Item> litr = null;
        litr = myList.listIterator();

        while(litr.hasNext())
        {
            next_Item = litr.next();
            if(next_Item.getName().equalsIgnoreCase(name_))
            {   
                myList.remove(index_);
                return next_Item;
            }
            index_++;
        }
        return null;   

    }// End of function remove()
   
   
    // Adding a print function to test my methods

    public void printLocation()
    {
        Item next_Item;

        ListIterator<Item> litr = null;
        
        System.out.println("");
        System.out.println("Printing items in location = "+this.name_+" which has no items = "+this.numItems());

        litr = myList.listIterator();

       
        while(litr.hasNext())
        {   
            next_Item = litr.next();
            System.out.println("name is = "+next_Item.getName()+ " Type is = "+next_Item.getType()+" Item description is = "+next_Item.getDescription());       
       
        }
         

    }

    // Project 2 Method Start

    public void connect(String name_c, Location location_c)
    {
         connections.put(name_c, location_c);
    }
    
    public boolean canMove(String name_c)
    {
       if (connections.containsKey(name_c))
         return true;
       else
         return false;    
    }

    public Location getLocation(String name_c)
    {
       return (connections.get(name_c)); 
    }
















































}



