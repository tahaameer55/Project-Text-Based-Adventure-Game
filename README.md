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

Implementation:
1) First I created an Item class that encapsulated information about the an item in the game namely the items name, type and description. I also added a public StringtoString() method returns a string containing the items information in the following format: Sandwich [Food]:a peanut butter and jelly sandwich
2) The second thing I did was to create a Location class. This class is used to encapsulate information about a single location in the game. Each location in the game is basically an object that stores its name, description, and a collection of Items that are found at this location currently. To store the collection of items I used an ArrayList. I then added the methods of that class which are namely addItem(), hasItem(), getItem() -- this method takes a string as a paramter, getItem()--- that takes an integer index, numItems(), and fianlly a method called removeItem(). The description of what these methods do is included in the comments  of the Location class
