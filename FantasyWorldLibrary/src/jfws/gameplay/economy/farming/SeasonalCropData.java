package jfws.gameplay.economy.farming;

import java.util.ArrayList;
import java.util.List;
import jfws.gameplay.rules.tasks.Task;

public class SeasonalCropData
{
	private Crop crop_;
	private ArrayList<Task> tasks_ = new ArrayList<>();
	
	public SeasonalCropData(Crop crop)
	{
		crop_ = crop;
	}
	
	public Crop getCrop()
	{
		return crop_;
	}
	
	public void addTask(Task task)
	{
		if(task == null)
			throw new IllegalArgumentException("Task is null!");
		else if(tasks_.contains(task))
			throw new IllegalArgumentException("Task \"" + task.getName() + "\" already added!");
		
		tasks_.add(task);
	}
	
	public List<Task> getTasks()
	{
		return tasks_;
	}
}
