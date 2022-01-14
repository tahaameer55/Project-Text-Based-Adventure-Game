# Project-Text-Based-Adventure-Game
This is a text-based adventure games that works similar to the following game called Zork (http://textadventures.co.uk/games/play/5zyoqrsugeopel3ffhz_vq).
The game has the following functionalities ----  

go: The go command moves the characters current location to the location in the DIRECTION that the user typed if it is a legal direction

look: The look command prints out items that are found at the current location

examine: The examine command allows the user to examine the items found in their current location

inventory: The inventory command prints a list of the item names that are currently stored in the character's inventory

take: The take command tries to find the matching item at the character's location, if a matching item is found the item is removed from the current location and added to the character's inventory

drop: The drop command tries to find the matching item in the character's inventory, if a mactching item is found, the item is removed from the character's inventory and added to the current location's items

quit: The quit command is used by the user to exit the game

# Implementation:
1) First I created an Item class that encapsulated information about the an item in the game namely the items name, type and description. I also added a public StringtoString() method returns a string containing the items information in the following format: Sandwich [Food]:a peanut butter and jelly sandwich

2) The second thing I did was to create a Location class. This class is used to encapsulate information about a single Location in the game. Each Location in the game is basically an object that stores its name, description, and a collection of Items that are found at this Location currently. To store the collection of items I used an ArrayList. I then added the methods of that class which are namely addItem(), hasItem(), getItem() -- this method takes a string as a paramter, getItem()--- that takes an integer index, numItems(), and fianlly a method called removeItem(). To further enhance my Location class I then modified the existing Location class so that each Location object has the ability to store pointers to adjacent Locations. I wanted to construct my game as a graph, so that each Location object will be a node (vertex) that stores connections(edges) to adjacent Location objects that the character can legally move to. To implement this I created a HashMap varaible to my Location class named connections. This HashMap associated a direction (eg. North) to a Location object. Each Location object has its own HashMap that maps a String to a Locations object address. I then added the methods canMove() and getLocation().

3) The third step was to create a ContainerItem class. A ContainerItem is a special type of Item with the additional capability to store Items inside of itself. ConatinerItem is a subclass of the Item class. I used the concept of inheritance, my ConatinerItem class currently has all fields/methods that my Item class has so I didnot re-implement those methods. ContainerItem additionally has the following methods addItem(), hasItem(), removeItem(). I also Overrided the toString() method from the Item class so that for the ContainerItems, it returns the ConatinerItens's (a) name, (b) type, (c) description, (d) a listing of the Item's name it conatins.

4) Finnaly I created the driver class. I created a static Location variable named currLocation, a static ContainerItem varaiable named myInventory and added a main() method to my driver class. I then assigned my currLocation variable to point at a new Location Object that I used to test my commands. I then created a Scanner object that reads its data from the standard  input stream(System.in). I then prompt the user to enter an command. The command can be any of the functionalities listed above. I then use a switch-case structure to jump to the appropriate cases for the commands listed above. 

# Tools Used
- Java - Object Oriented Programming - Encapsulation - Inheritance - ArrayLists - HashMaps - Switch-case statements
