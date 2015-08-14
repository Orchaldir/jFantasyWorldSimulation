package jfws.gameplay.economy.farming;

import java.util.List;
import jfws.gameplay.economy.resources.ResourceTransfer;
import jfws.gameplay.economy.resources.Resource;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class CropTest
{
	private String name_ = "Crop0";
	private Resource resource_ = new Resource("Resource0", 2.0);
	private double amount_per_unit_ = 10.0;
	private ResourceTransfer yield_ = new ResourceTransfer(resource_, amount_per_unit_);
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
	
	// seed
	
	@Test
	public void testSetSeed()
	{
		ResourceTransfer seed = crop_.setSeed(resource_, -amount_per_unit_);
		
		assertNotNull(seed);
		assertEquals(resource_, seed.getResource());
		assertEquals(-amount_per_unit_, seed.getAmountPerUnit(), 0.001);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetSeedWithNull()
	{
		crop_.setSeed(null, amount_per_unit_);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetSeedWithPostiveAmount()
	{
		crop_.setSeed(resource_, 1.0);
	}

	@Test
	public void testGetSeed()
	{
		ResourceTransfer seed = crop_.setSeed(resource_, -amount_per_unit_);
		
		assertEquals(seed, crop_.getSeed());
	}
	
	// yield

	@Test
	public void testAddYield()
	{
		ResourceTransfer yield = crop_.addYield(resource_, amount_per_unit_);
		
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
		ResourceTransfer yield = crop_.addYield(resource_, amount_per_unit_);
		
		List<ResourceTransfer> list = crop_.getYieldList();
		
		assertNotNull(list);
		assertEquals(1, list.size());
		assertEquals(yield, list.get(0));
	}
	
	// seasons

	@Test
	public void testAddSeason()
	{
		SeasonalCropData crop_data = crop_.addSeason();
		
		assertNotNull(crop_data);
		assertEquals(crop_, crop_data.getCrop());
	}

	@Test
	public void testGetSeasons()
	{
		SeasonalCropData crop_data0 = crop_.addSeason();
		List<SeasonalCropData> seasons = crop_.getSeasons();
		
		assertNotNull(seasons);
		assertEquals(1, seasons.size());
		assertEquals(crop_data0, seasons.get(0));
		
		SeasonalCropData crop_data1 = crop_.addSeason();
		seasons = crop_.getSeasons();
		
		assertNotNull(seasons);
		assertEquals(2, seasons.size());
		assertEquals(crop_data0, seasons.get(0));
		assertEquals(crop_data1, seasons.get(1));
	}
	
	@Test
	public void testGetNoSeasons()
	{
		List<SeasonalCropData> seasons = crop_.getSeasons();
		
		assertNotNull(seasons);
		assertEquals(0, seasons.size());
	}
}