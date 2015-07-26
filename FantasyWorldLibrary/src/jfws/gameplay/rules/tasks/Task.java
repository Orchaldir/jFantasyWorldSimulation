package jfws.gameplay.rules.tasks;

import java.util.HashMap;
import java.util.Map;

public class Task
{
	private String name_;
	private Map<String,Technique> techniques_ = new HashMap<>();
	
	public Task(String name)
	{
		name_ = name;
	}
	
	public String getName()
	{
		return name_;
	}
	
	public Technique createTechnique(String name, double time_per_unit)
	{
		if(name == null)
			throw new IllegalArgumentException("Name is null!");
		else if(name.isEmpty())
			throw new IllegalArgumentException("Name is empty!");
		else if(time_per_unit <= 0.0)
			throw new IllegalArgumentException("Time per Unit msut be greater 0!");
		else if(techniques_.containsKey(name))
			throw new IllegalArgumentException("Technique \"" + name + "\" already exists!");
		
		Technique technique = new Technique(name, this, time_per_unit);
		
		techniques_.put(name, technique);
		
		return technique;
	}
	
	public Technique getTechnique(String name)
	{
		if(name == null)
			throw new IllegalArgumentException("Name is null!");
		else if(name.isEmpty())
			throw new IllegalArgumentException("Name is empty!");
		
		return techniques_.get(name);
	}
}
