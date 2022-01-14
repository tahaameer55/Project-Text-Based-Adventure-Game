import java.util.Scanner;

public class Driver
{
public static Location currLocation; // Creating a static location variable
public static ContainerItem myInventory = new ContainerItem("Backpack", "BackPackItems", "Backpack used to carry my books"); // Creating a static ConatainerItem varaible

    public static void main(String args [])
    {
      String user_input; 
       Item i4 = null;
       Item temp_Item = null;
       ContainerItem temp_Container_Item = null; // New temp for Project 3
       int index_; 

      createWorld();
      
      Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
      System.out.println("Zork version 3.0 by Taha Ameer");
      System.out.println("All rights reserved - you may play this game forever ");
      System.out.println("");
      

      // Infinite loop
      while (true)
      {   
          System.out.print("Enter command: ");
          user_input = myScanner.nextLine();
          String userInput = (user_input);
          String[] input_ = userInput.split(" ");
          
          // Start of switch
          switch(input_ [0])
          {
            case "look":
            {
              System.out.println(currLocation.getName_()+ " - "+currLocation.getDescription_());
              for(index_ = 0; index_ < currLocation.numItems(); index_++)
              {
                System.out.println("+"+currLocation.getItem(index_).getName());
              }

              break;
            }

            case "examine":
            {
             if(input_.length > 1)
             { 
               i4 = currLocation.getItem(input_[1]);
               if(i4 != null)
                {
                  System.out.println(i4.toString());
                }
                else
                {
                  System.out.println("Cannot find that item");
                }

             }
             else
             {
               System.out.println("You did not tell me an item you want to examine");
             }

              break;
            }

            case "go":  // New case one for Checkpoint 2
            {
              if(input_.length > 1)
             { 
              
               if(input_[1].equalsIgnoreCase("North"))
                {
                  System.out.println("User wants to go North");
                  if(currLocation.canMove("North"))
                   currLocation = currLocation.getLocation("North");
                  else
                   System.out.println("Nothing found on North side for current location: "+currLocation.getName_());
       
                }
                else if (input_[1].equalsIgnoreCase("South"))
                 {
                    System.out.println("User wants to go South");
                    if(currLocation.canMove("South"))
                   currLocation = currLocation.getLocation("South");
                  else
                   System.out.println("Nothing found on South side for current location: "+currLocation.getName_());
                 }
                else if (input_[1].equalsIgnoreCase("East"))
                {
                  System.out.println("User wants to go East");
                  if(currLocation.canMove("East"))
                   currLocation = currLocation.getLocation("East");
                  else
                   System.out.println("Nothing found on East side for current location: "+currLocation.getName_());
                }
                else if (input_[1].equalsIgnoreCase("West"))
                {
                  System.out.println("User wants to go West");
                  if(currLocation.canMove("West"))
                   currLocation = currLocation.getLocation("West");
                  else
                   System.out.println("Nothing found on West side for current location: "+currLocation.getName_());
                }
                else
                {
                  System.out.println("That is an invalid direction");
                }

             }
             else
             {
               System.out.println("You did not tell me the direction you want to go to");
             }

              break;

            } // end of go

            case "inventory":  // Case Number two for Checkpoint 2
            {
              if(myInventory != null) 
                System.out.println(myInventory.ItemstoString());
              else
                System.out.println("Inventory is null nothing to print"+ "\n");
              
              break;
            
            } // end of inventory

            case "take":  // Take Case modified for Checkpoint 3
            {
            if(input_.length == 1)
            {
              System.out.println("Nothing to take. Incorrect syntax" +"\n");
            }
            else if(input_.length == 2)
            {
              if(currLocation.getItem(input_[1]) != null)
              {
                temp_Item = currLocation.removeItem(input_[1]);
                myInventory.addItem(temp_Item);
              }
              else
                System.out.println("Cannot find that item here " + "\n");
            }
              else if(input_.length == 3)
              {
                System.out.println("Nothing to take from. Please specify a Container item" +"\n");
              }
              else if(input_.length == 4)
              { 
                if(input_[2].equalsIgnoreCase("from"))
                {              
                  if(currLocation.hasItem(input_[3])) // Looking for the right conatiner
                  { 
                    temp_Container_Item = (ContainerItem) currLocation.getItem(input_[3]);
                    temp_Item = temp_Container_Item.removeItem(input_[1]);
                    if(temp_Item != null)
                    { 
                      System.out.println("Found "+input_[1]+ " in container "+input_[3]+". It has been added to Inventory");
                      myInventory.addItem(temp_Item);
                    }
                    else
                    {
                      System.out.println("Found the container "+input_[3]+ " But it doesnot have item "+input_[1]);
                    }
                  }
                  else
                   { 
                     System.out.println("Cannot find the Container "+input_[3]);
                   }
                }
                else
                {
                  System.out.println("I do not understand "+input_[2]+ " When from is expected");   
                }
                

              }
              break;


          }// end of take 
          case"put": // New case for checkpoint 3
          {
            if(input_.length == 1)
            {
              System.out.println("Nothing to put. Incorrect syntax" +"\n");
            }
            else if(input_.length == 2)
            {
              System.out.println("Incomplete command.");
              
            }
            else if(input_.length == 3)
            {
                System.out.println("Incomplete command. Please specify a ContainerItem" +"\n");
            }
            else if(input_.length == 4)
            {
              if(myInventory.hasItem(input_[1]))
              {  
                System.out.println("Item has been removed from Inventory and added to ContainerItem");
                if(currLocation.hasItem(input_[3]))
                {
                  temp_Item = myInventory.removeItem(input_[1]);
                  temp_Container_Item = (ContainerItem) currLocation.getItem(input_[3]);
                  temp_Container_Item.addItem(temp_Item);
                }
                else
                {
                  System.out.println("This ContainerItem not found at the location");
                }

              }
              else
              {
                System.out.println("This item not found in inventory"+"\n");
              }
            }

            break;
          }//end of put
            

            case"drop":  // Case number four for Checkpoint 2
            {
              if(input_.length > 1)
              {
                if(myInventory.hasItem(input_[1]))
                {
                  temp_Item = myInventory.removeItem(input_[1]);
                  currLocation.addItem(temp_Item);
                }
                else
                  System.out.println("Cannot find that item in my inventory" + "\n");
              }
               else
                  System.out.println("Nothing to drop. Please specify an item" +"\n");

              break;
            } // end of drop

            case "help":   // Case number five for Checkpoint 2
            {
              System.out.println("go: The go command moves the characters current location to the location in the DIRECTION that user typed if it is a legal direction");
              System.out.println("look: The look command prints out items that are found at the current location");
              System.out.println("examine: The examine command allows the user to examine the items found in their current location");
              System.out.println("inventory: The inventory command prints a list of the item names that are currently stored in the character's inventory");
              System.out.println("take: The take command tries to find the matching item at the character's location, if a matching item is found the item is removed from the current location and added to the character's inventory");
              System.out.println("drop: The drop command tries to find the matching item in the character's inventory, if a mactching item is found, the item is removed from the character's inventory and added to the current location's items");
              System.out.println("quit: The quit command is used by the user to exit the game");

              break;

            } // end of help

            case "quit":
            {
              System.exit(0);
              break;
            }

            default:
            {
              System.out.println("I don't know how to do that");
            }

          }// end of switch
                   
      } // end of infinite loop
    
    
    }

    static void createWorld()  // Made for Checkpoint 2
    {

      Location room = new Location("Room", "This is Taha's room");
      Location kitchen = new Location("Kitchen", "This is Taha's kitchen");
      Location hallway = new Location("Hallway", "This is the hallway leading to Taha's room");
      Location Studyroom = new Location("Studyroom", "This is Taha's studyroom");
     // Adding ContainerItems for Project Checkpoint 3
      ContainerItem drawer = new ContainerItem("Drawer", "object", "This is a drawer");
      ContainerItem box = new ContainerItem("Box", "object", "This is a box");
      


      // Each room connects to a central hallway, room to its north, kitchen to its west, and studyroom to its south
      hallway.connect("North", room);
      room.connect("South", hallway);

      hallway.connect("South", Studyroom );
      Studyroom.connect("North", hallway);

      hallway.connect("West", kitchen);
      kitchen.connect("East", hallway);

      Item i2 = new Item("Pizza", "Food", "a scrumptious and delicious pizza");
      Item i3 = new Item("Burger", "Food", "a rather big and juicy burger");
      Item i5 = new Item("Table", "Room", "Taha puts his books on the table");
      Item i6 = new Item("Perfume", "Room", "Taha always uses his perfume before going out");
      Item i7 = new Item("Vase", "hallway", "There is a vase in the hallway");
      Item i8 = new Item("FamilyProtrait", "hallway", "There is a FamilyProtrait in the hallway");
      Item i9 = new Item("CHEMBOOK", "Studyroom", "There is a chemistry book in Taha's Studyroom");
      Item i10 = new Item("Pen", "Studyroom", "There is a Pen in Taha's Studyroom");
      Item i11 = new Item("Book", "Object", "This is a book for Computer Science");
      Item i12 = new Item("Stapler", "Object", "This is a stapler");
      
      // Starting items inside containers Checkpoint 3
      drawer.addItem(i11);  
      box.addItem(i12);
    
      room.addItem(i5);
      room.addItem(i6);
      kitchen.addItem(i2);
      kitchen.addItem(i3);
      hallway.addItem(i7);
      hallway.addItem(i8);
      Studyroom.addItem(i9);
      Studyroom.addItem(i10);

      room.addItem(drawer);  // Adding ContainerItem to different locations Checkpoint 3
      hallway.addItem(box);
      

      currLocation = hallway;

    }
  
  } // end of create world