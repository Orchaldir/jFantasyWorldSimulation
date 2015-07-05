package jfws.gameplay.economy;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaskTest
{
	private String name_;
	private Task task_ = new Task(name_);

	@Test
	public void testGetName()
	{
		assertEquals(name_, task_.getName());
	}
}