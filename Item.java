public class Item 
{
    // Member Variables
    private String name;
    private String type;
    private String description;

    // Constructor

    public Item(String name, String type, String description)
    {
      this.name = name;
      this.type = type;
      this.description = description;
    }

    // Getters also knows as acessors for the 3 methods

    public String getName()
    {
        return name;
    }

    public String getType()
    {
        return type;
    }

    public String getDescription()
    {
        return description;
    }

    // Setters also known as mutators for the 3 methods

    public void setName(String name)
    {
        this.name = name;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
    
    //Method public String toString()

    public String toString()
    {
        return name+" ["+type+"]"+":"+description;
    }
















}
