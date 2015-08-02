package jfws.gameplay.economy.resources;

import jfws.gameplay.rules.tasks.TaskMgr;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ResourceMgrTest
{
	private String name_ = "Resource0";
	private double space_per_unit_ = 2.0;
	static private ResourceMgr resource_mgr_;
	
	@Before
	public void setUp()
	{
		resource_mgr_ = new ResourceMgr();
	}
	
	@Test
	public void testCreateResource()
	{
		Resource resource = resource_mgr_.createResource(name_, space_per_unit_);
		
		assertNotNull(resource);
		assertEquals(name_, resource.getName());
		assertEquals(space_per_unit_, resource.getSpacePerUnit(), 0.01);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateResourceWithNull()
	{
		resource_mgr_.createResource(null, space_per_unit_);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateResourceWithEmptyString()
	{
		resource_mgr_.createResource("", space_per_unit_);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateResourceTwice()
	{
		resource_mgr_.createResource(name_, space_per_unit_);
		resource_mgr_.createResource(name_, space_per_unit_);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateResourceWithNegativeSpace()
	{
		resource_mgr_.createResource(name_, -1.0);
	}
	
	@Test
	public void testGetResource()
	{
		Resource resource = resource_mgr_.createResource(name_, space_per_unit_);
		
		assertEquals(resource, resource_mgr_.getResource(name_));
	}
	
	@Test
	public void testGetResourceWithWrongName()
	{
		assertNull(resource_mgr_.getResource("Wrong Name"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetResourceWithNull()
	{
		resource_mgr_.getResource(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetResourceWithEmptyString()
	{
		resource_mgr_.getResource("");
	}
}