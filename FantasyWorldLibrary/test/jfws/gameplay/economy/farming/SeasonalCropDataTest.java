package jfws.gameplay.economy.farming;

import java.util.List;
import jfws.gameplay.rules.tasks.Task;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class SeasonalCropDataTest
{
	private Crop crop_ = new Crop("Crop");
	private Task task0_ = new Task("Task0");
	private Task task1_ = new Task("Task1");
	private SeasonalCropData crop_data_;
	
	@Before
	public void setUp()
	{
		crop_data_ = new SeasonalCropData(crop_);
	}
	
	@Test
	public void testGetCrop()
	{
		assertEquals(crop_, crop_data_.getCrop());
	}

	@Test
	public void testAddAndGetTasks()
	{
		crop_data_.addTask(task0_);
		List<Task> tasks = crop_data_.getTasks();
		
		assertNotNull(tasks);
		assertEquals(1, tasks.size());
		assertEquals(task0_, tasks.get(0));
	
		crop_data_.addTask(task1_);
		tasks = crop_data_.getTasks();
		
		assertNotNull(tasks);
		assertEquals(2, tasks.size());
		assertEquals(task0_, tasks.get(0));
		assertEquals(task1_, tasks.get(1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddTaskWithNull()
	{
		crop_data_.addTask(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddTaskTwice()
	{
		crop_data_.addTask(task0_);
		crop_data_.addTask(task0_);
	}
	
	@Test
	public void testGetNoTasks()
	{
		List<Task> tasks = crop_data_.getTasks();
		
		assertNotNull(tasks);
		assertEquals(0, tasks.size());
	}
}