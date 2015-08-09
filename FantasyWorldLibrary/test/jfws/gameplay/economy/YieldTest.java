package jfws.gameplay.economy;

import jfws.gameplay.economy.resources.Resource;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class YieldTest
{
	private Resource resource_ = new Resource("Resource0", 2.0);
	private double amount_per_unit_ = 10.0;
	private double units_ = 30.0;
	private Yield yield_;
	
	@Before
	public void setUp()
	{
		yield_ = new Yield(resource_, amount_per_unit_);
	}

	@Test
	public void testGetResource()
	{
		assertEquals(resource_, yield_.getResource());
	}

	@Test
	public void testGetAmountPerUnit()
	{
		assertEquals(amount_per_unit_, yield_.getAmountPerUnit(), 0.001);
	}

	@Test
	public void testGetAmount()
	{
		double amount = amount_per_unit_ * units_;
		
		assertEquals(amount, yield_.getAmount(units_), 0.001);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetAmountWithNegativeUnits()
	{
		yield_.getAmount(-1.0);
	}
}