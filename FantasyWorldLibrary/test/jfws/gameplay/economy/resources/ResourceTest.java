package jfws.gameplay.economy.resources;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ResourceTest
{
	private String name_ = "Resource0";
	private double space_per_unit_ = 2.0;
	private Resource resource_;
	
	@Before
	public void setUp()
	{
		resource_ = new Resource(name_, space_per_unit_);
	}
	
	@Test
	public void testGetName()
	{
		assertEquals(name_, resource_.getName());
	}

	@Test
	public void testGetSpacePerUnit()
	{
		assertEquals(space_per_unit_, resource_.getSpacePerUnit(), 0.01);
	}
}