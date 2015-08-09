package jfws.gameplay.economy;

import jfws.gameplay.economy.resources.Resource;

public class Yield
{
	private Resource resource_;
	private double amount_per_unit_;
	
	public Yield(Resource resource, double amount_per_unit)
	{
		resource_ = resource;
		amount_per_unit_ = amount_per_unit;
	}
	
	public Resource getResource()
	{
		return resource_;
	}
	
	public double getAmountPerUnit()
	{
		return amount_per_unit_;
	}
	
	public double getAmount(double units)
	{
		return amount_per_unit_ * units;
	}
}
