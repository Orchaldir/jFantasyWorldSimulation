package jfws.gameplay.economy.farming;

import java.util.List;
import jfws.gameplay.economy.Yield;
import jfws.gameplay.economy.resources.Resource;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class CropTest
{
	private String name_ = "Crop0";
	private Resource resource_ = new Resource("Resource0", 2.0);
	private double amount_per_unit_ = 10.0;
	private Yield yield_ = new Yield(resource_, amount_per_unit_);
	private Crop crop_;
	
	@Before
	public void setUp()
	{
		crop_ = new Crop(name_);
	}

	@Test
	public void testGetName()
	{
		assertEquals(name_, crop_.getName());
	}

	@Test
	public void testAddYield()
	{
		Yield yield = crop_.addYield(resource_, amount_per_unit_);
		
		assertNotNull(yield);
		assertEquals(resource_, yield.getResource());
		assertEquals(amount_per_unit_, yield.getAmountPerUnit(), 0.001);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddYieldWithNull()
	{
		crop_.addYield(null, amount_per_unit_);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddYieldWithNegativeAmount()
	{
		crop_.addYield(resource_, -1.0);
	}

	@Test
	public void testGetYieldList()
	{
		Yield yield = crop_.addYield(resource_, amount_per_unit_);
		
		List<Yield> list = crop_.getYieldList();
		
		assertNotNull(list);
		assertEquals(1, list.size());
		assertEquals(yield, list.get(0));
	}
}