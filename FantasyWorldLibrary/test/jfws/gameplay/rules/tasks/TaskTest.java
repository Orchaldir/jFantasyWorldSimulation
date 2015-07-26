package jfws.gameplay.rules.tasks;

import jfws.gameplay.rules.tasks.Technique;
import jfws.gameplay.rules.tasks.Task;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class TaskTest
{
	private String name_ = "Task0";
	private Task task_;
	private String technique0_name_ = "Technique0";
	private double technique0_time_ = 10.0;
	
	@Before
	public void setUp()
	{
		task_ = new Task(name_);
	}

	@Test
	public void testGetName()
	{
		assertEquals(name_, task_.getName());
	}

	@Test
	public void testCreateTechnique()
	{
		Technique technique0 = task_.createTechnique(technique0_name_, technique0_time_);
		
		assertNotNull(technique0);
		assertEquals(technique0_name_, technique0.getName());
		assertEquals(technique0_time_, technique0.getTimePerUnit(), 0.1);
		assertEquals(task_, technique0.getTask());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateTechniqueWithNull()
	{
		task_.createTechnique(null, technique0_time_);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateTechniqueWithEmptyString()
	{
		task_.createTechnique("", technique0_time_);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateTechniqueWithNegativeTime()
	{
		task_.createTechnique(technique0_name_, -1.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateTechniqueTwice()
	{
		task_.createTechnique(technique0_name_, technique0_time_);
		task_.createTechnique(technique0_name_, technique0_time_);
	}

	@Test
	public void testGetTechnique()
	{
		Technique technique0 = task_.createTechnique(technique0_name_, technique0_time_);
		
		assertEquals(technique0, task_.getTechnique(technique0_name_));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetTechniqueWithNull()
	{
		task_.getTechnique(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetTechniqueWithEmptyString()
	{
		task_.getTechnique("");
	}
}