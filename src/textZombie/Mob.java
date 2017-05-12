package textZombie;

public abstract class Mob {

    public String name;
    public String description;
    public Inventory inv;
    
    public void setName(String name)
    {
	this.name = name;
    }
    
    public String getName()
    {
	return name;
    }
    
    public void setDescription(String description)
    {
	this.description = description;
    }
    
    public String getDescription()
    {
	return description;
    }
    
    
}
