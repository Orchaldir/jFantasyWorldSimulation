package jfws.gameplay.economy.farming;

import java.util.ArrayList;
import java.util.List;
import jfws.gameplay.economy.resources.ResourceTransfer;
import jfws.gameplay.economy.resources.Resource;

public class Crop
{
	private String name_;
	
	private ResourceTransfer seed_;
	private ArrayList<ResourceTransfer> yield_ = new ArrayList<>();
	
	private ArrayList<SeasonalCropData> seasons_ = new ArrayList<>();
	
	public Crop(String name)
	{
		name_ = name;
	}
	
	public String getName()
	{
		return  name_;
	}
	
	// seed
	
	public ResourceTransfer setSeed(Resource resource, double amount_per_unit)
	{
		if(resource == null)
			throw new IllegalArgumentException("Resource is null!");
		else if(amount_per_unit >= 0.0)
			throw new IllegalArgumentException("Amount per Unit must be smaller than 0!");
		
		seed_ = new ResourceTransfer(resource, amount_per_unit);
		
		return seed_;
	}
	
	public ResourceTransfer getSeed()
	{
		return seed_;
	}
	
	// yield
	
	public ResourceTransfer addYield(Resource resource, double amount_per_unit)
	{
		if(resource == null)
			throw new IllegalArgumentException("Resource is null!");
		else if(amount_per_unit <= 0.0)
			throw new IllegalArgumentException("Amount per Unit must be greater than 0!");
		
		ResourceTransfer yield = new ResourceTransfer(resource, amount_per_unit);
		
		yield_.add(yield);
		
		return yield;
	}
	
	public List<ResourceTransfer> getYieldList()
	{
		return yield_;
	}
	
	// seasons
	
	public SeasonalCropData addSeason()
	{
		SeasonalCropData season = new SeasonalCropData(this);
		
		seasons_.add(season);
		
		return season;
	}
	public List<SeasonalCropData> getSeasons()
	{
		return seasons_;
	}
}
