package jfws.gameplay.economy;

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
	
	String getName()
	{
		return name_;
	}
	
	Task getTask()
	{
		return task_;
	}
	
	double getTimePerUnit()
	{
		return time_per_unit_;
	}
	
	double getTime(double units)
	{
		return time_per_unit_ * units;
	}
}
