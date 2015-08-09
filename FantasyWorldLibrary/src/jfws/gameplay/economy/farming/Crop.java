package jfws.gameplay.economy.farming;

import java.util.ArrayList;
import java.util.List;
import jfws.gameplay.economy.Yield;
import jfws.gameplay.economy.resources.Resource;

public class Crop
{
	private String name_;
	private ArrayList<Yield> yield_list_ = new ArrayList<>();
	
	public Crop(String name)
	{
		name_ = name;
	}
	
	public String getName()
	{
		return  name_;
	}
	
	public Yield addYield(Resource resource, double amount_per_unit)
	{
		if(resource == null)
			throw new IllegalArgumentException("Resource is null!");
		else if(amount_per_unit <= 0.0)
			throw new IllegalArgumentException("Amount per Unit must be greater than 0!");
		
		Yield yield = new Yield(resource, amount_per_unit);
		
		yield_list_.add(yield);
		
		return yield;
	}
	
	public List<Yield> getYieldList()
	{
		return yield_list_;
	}
}
