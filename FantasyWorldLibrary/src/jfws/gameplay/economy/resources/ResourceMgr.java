package jfws.gameplay.economy.resources;

import java.util.HashMap;
import java.util.Map;

public class ResourceMgr
{
	private Map<String,Resource> resources_ = new HashMap<>();
	
	public Resource createResource(String name, double space_per_unit)
	{
		if(name == null)
			throw new IllegalArgumentException("Name is null!");
		else if(name.isEmpty())
			throw new IllegalArgumentException("Name is empty!");
		else if(resources_.containsKey(name))
			throw new IllegalArgumentException("Resource \"" + name + "\" already exists!");
		else if(space_per_unit <= 0.0)
			throw new IllegalArgumentException("Space per Unit must be greater than 0!");
		
		Resource resource = new Resource(name, space_per_unit);
		
		resources_.put(name, resource);
		
		return resource;
	}
	
	public Resource getResource(String name)
	{
		if(name == null)
			throw new IllegalArgumentException("Name is null!");
		else if(name.isEmpty())
			throw new IllegalArgumentException("Name is empty!");
		
		return resources_.get(name);
	}
}
