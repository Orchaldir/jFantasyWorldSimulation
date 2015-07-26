package jfws.gameplay.rules.tasks;

import java.util.HashMap;
import java.util.Map;

public class TaskMgr
{
	private Map<String,Task> tasks_ = new HashMap<>();
	
	// Task
	
	public Task createTask(String name)
	{
		if(name == null)
			throw new IllegalArgumentException("Name is null!");
		else if(name.isEmpty())
			throw new IllegalArgumentException("Name is empty!");
		else if(tasks_.containsKey(name))
			throw new IllegalArgumentException("Task \"" + name + "\" already exists!");
		
		Task task = new Task(name);
		
		tasks_.put(name, task);
		
		return task;
	}
	
	public Task getTask(String name)
	{
		if(name == null)
			throw new IllegalArgumentException("Name is null!");
		else if(name.isEmpty())
			throw new IllegalArgumentException("Name is empty!");
		
		return tasks_.get(name);
	}
}
