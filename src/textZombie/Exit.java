package textZombie;

public class Exit {
    // Numerical codes
    public static final int UNDEFINED = 0;
    public static final int NORTH = 1;
    public static final int SOUTH = 2;
    public static final int EAST = 3;
    public static final int WEST = 4;
    public static final int UP = 5;
    public static final int DOWN = 6;
    public static final int NORTHEAST = 7;
    public static final int NORTHWEST = 8;
    public static final int SOUTHEAST = 9;
    public static final int SOUTHWEST = 10;
    public static final int IN = 11;
    public static final int OUT = 12;

    // String codes
    public static final String[] dirName =
    { "UNDEFINED", "NORTH", "SOUTH", "EAST", "WEST", "UP", "DOWN", "NORTHEAST", "NORTHWEST",
	    "SOUTHEAST", "SOUTHWEST", "IN", "OUT" };

    public static final String[] shortDirName =
    { "NULL", "N", "S", "E", "W", "U", "D", "NE", "NW", "SE", "SW", "I", "O" };

    // Member variables
    private Room leadsTo = null;
    @SuppressWarnings("unused")
    private int direction;

    // Full name of direction eg SOUTHEAST
    private String directionName;

    // Shortened version of direction eg SE
    private String shortDirectionName;

    // Default constructor
    public Exit()
    {
	this.direction = Exit.UNDEFINED;
	this.leadsTo = null;
	this.directionName = dirName[UNDEFINED];
	this.shortDirectionName = shortDirName[UNDEFINED];
    }

    // Full constructor
    public Exit(int direction, Room leadsTo)
    {
	this.direction = direction;

	// Assign direction names
	if (direction <= dirName.length)
	    directionName = dirName[direction];
	if (direction <= shortDirName.length)
	    shortDirectionName = shortDirName[direction];

	// Assign location
	this.leadsTo = leadsTo;
    }

    // toString method
    public String toString()
    {
	return directionName;
    }

    // Assigns direction name
    public void setDirectionName(String dirname)
    {
	this.directionName = dirname;
    }

    // Returns direction name
    public String getDirectionName()
    {
	return this.directionName;
    }

    // Assigns short direction name
    public void setShortDirectionName(String shortName)
    {
	this.shortDirectionName = shortName;
    }

    // Returns short direction name
    public String getShortDirectionName()
    {
	return this.shortDirectionName;
    }

    // Assigns location
    public void setLeadsTo(Room leadsTo)
    {
	this.leadsTo = leadsTo;
    }

    // Returns location
    public Room getLeadsTo()
    {
	return this.leadsTo;
    }

}
