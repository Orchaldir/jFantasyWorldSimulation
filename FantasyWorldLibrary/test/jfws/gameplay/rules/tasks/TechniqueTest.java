package jfws.gameplay.rules.tasks;

import jfws.gameplay.rules.tasks.Technique;
import jfws.gameplay.rules.tasks.Task;
import org.junit.Test;
import static org.junit.Assert.*;

public class TechniqueTest
{
	private String name_ = "Technique0";
	private Task task_ = new Task("Task0");
	private double time_per_unit_ = 2.5;
	private Technique technique_ = new Technique(name_, task_, time_per_unit_);
	
	@Test
	public void testGetName()
	{
		assertEquals(name_, technique_.getName());
	}
	
	@Test
	public void testGetTask()
	{
		assertEquals(task_, technique_.getTask());
	}

	@Test
	public void testGetTimePerUnit()
	{
		assertEquals(time_per_unit_, technique_.getTimePerUnit(), 0.001);
	}
	
	@Test
	public void testGetTime()
	{
		double units = 10.0;
		double time = units * time_per_unit_;
		assertEquals(time, technique_.getTime(units), 0.001);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetTimeWithNegativeUnits()
	{
		technique_.getTime(-1.0);
	}
}