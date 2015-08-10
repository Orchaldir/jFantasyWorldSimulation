package jfws.gameplay.economy.farming;

import java.util.HashMap;
import java.util.Map;

public class CropMgr
{
	private Map<String,Crop> crops_ = new HashMap<>();
	
	public Crop createCrop(String name)
	{
		if(name == null)
			throw new IllegalArgumentException("Name is null!");
		else if(name.isEmpty())
			throw new IllegalArgumentException("Name is empty!");
		else if(crops_.containsKey(name))
			throw new IllegalArgumentException("Crop \"" + name + "\" already exists!");
		
		Crop resource = new Crop(name);
		
		crops_.put(name, resource);
		
		return resource;
	}
	
	public Crop getCrop(String name)
	{
		if(name == null)
			throw new IllegalArgumentException("Name is null!");
		else if(name.isEmpty())
			throw new IllegalArgumentException("Name is empty!");
		
		return crops_.get(name);
	}
}
