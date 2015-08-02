package jfws.gameplay.rules.tasks;

import jfws.gameplay.rules.tasks.TaskMgr;
import jfws.gameplay.rules.tasks.Task;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class TaskMgrTest
{
	static private String name_ = "Task0";
	static private TaskMgr task_mgr_;
	
	@Before
	public void setUp()
	{
		task_mgr_ = new TaskMgr();
	}
	
	// Task
	
	@Test
	public void testCreateTask()
	{
		Task task = task_mgr_.createTask(name_);
		
		assertNotNull(task);
		assertEquals(name_, task.getName());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateTaskWithNull()
	{
		task_mgr_.createTask(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateTaskWithEmptyString()
	{
		task_mgr_.createTask("");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateTaskTwice()
	{
		task_mgr_.createTask(name_);
		task_mgr_.createTask(name_);
	}
	
	@Test
	public void testGetTask()
	{
		Task task = task_mgr_.createTask(name_);
		
		assertEquals(task, task_mgr_.getTask(name_));
	}
	
	@Test
	public void testGetTaskWithWrongName()
	{
		assertNull(task_mgr_.getTask("Wrong Name"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetTaskWithNull()
	{
		task_mgr_.getTask(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetTaskWithEmptyString()
	{
		task_mgr_.getTask("");
	}
}