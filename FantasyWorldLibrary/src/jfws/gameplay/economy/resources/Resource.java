package jfws.gameplay.economy.resources;

public class Resource
{
	private String name_;
	private double space_per_unit_;
	
	public Resource(String name, double space_per_unit)
	{
		name_ = name;
		space_per_unit_ = space_per_unit;
	}
	
	public String getName()
	{
		return name_;
	}
	
	public double getSpacePerUnit()
	{
		return space_per_unit_;
	}
}
