package jfws.gameplay.economy.farming;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class CropMgrTest
{
	private String name_ = "Crop0";
	static private CropMgr crop_mgr_;
	
	@Before
	public void setUp()
	{
		crop_mgr_ = new CropMgr();
	}
	
	@Test
	public void testCreateCrop()
	{
		Crop resource = crop_mgr_.createCrop(name_);
		
		assertNotNull(resource);
		assertEquals(name_, resource.getName());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateCropWithNull()
	{
		crop_mgr_.createCrop(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateCropWithEmptyString()
	{
		crop_mgr_.createCrop("");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateCropTwice()
	{
		crop_mgr_.createCrop(name_);
		crop_mgr_.createCrop(name_);
	}
	
	@Test
	public void testGetCrop()
	{
		Crop resource = crop_mgr_.createCrop(name_);
		
		assertEquals(resource, crop_mgr_.getCrop(name_));
	}
	
	@Test
	public void testGetCropWithWrongName()
	{
		assertNull(crop_mgr_.getCrop("Wrong Name"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetCropWithNull()
	{
		crop_mgr_.getCrop(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetCropWithEmptyString()
	{
		crop_mgr_.getCrop("");
	}
}