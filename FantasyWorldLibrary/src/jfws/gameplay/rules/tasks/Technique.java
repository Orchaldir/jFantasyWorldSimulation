package jfws.gameplay.rules.tasks;

public class Technique
{
	private String name_;
	private Task task_;
	private double time_per_unit_;
	
	public Technique(String name, Task task, double time_per_unit)
	{
		name_ = name;
		task_ = task;
		time_per_unit_ = time_per_unit;
	}
	
	public String getName()
	{
		return name_;
	}
	
	public Task getTask()
	{
		return task_;
	}
	
	public double getTimePerUnit()
	{
		return time_per_unit_;
	}
	
	public double getTime(double units)
	{
		if(units <= 0.0)
			throw new IllegalArgumentException("Units must be greater than 0!");
		
		return time_per_unit_ * units;
	}
}
