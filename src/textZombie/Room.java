package textZombie;

import java.util.Vector;

public class Room {

    private String name;
    private String description;
    private Vector<Exit> exits;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Room()
    {
	this.name = "Rat's Tavern";
	this.description = "You find yourself in a run down tavern. The walls are covered in rat pelts from the large sewer rats the locals hunt. The putrid smell of the decaying pelts burns your nostrils. The boisterous crowd in the tavern are in a constant state of drunkenness. Behind the bar you see good Ol' Frank the bar tender.";
	exits = new Vector();
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Room(String name)
    {
	this.name = name;
	this.description = "You don't know where you are... You look around and find that you are in the middle of a large feild. There is a tree about ten feet from you but beyond that there is a large expanse of plains in all directions.";
	exits = new Vector();
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Room(String name, String description)
    {
	this.name = name;
	this.description = description;
	exits = new Vector();
    }

    public void setName(String name)
    {
	this.name = name;
    }
    
    public String getName()
    {
	return this.name;
    }
    
    public void setDescription(String description)
    {
	this.description = description;
    }
    
    public String getDescription()
    {
	return this.description;
    }

    public void addExit(Exit exit)
    {
	exits.addElement(exit);
    }

    public void removeExit(Exit exit)
    {
	if (exits.contains(exit))
	    exits.removeElement(exit);
    }

    @SuppressWarnings("rawtypes")
    public Vector getExits()
    {
	return (Vector) exits.clone();
    }
}
